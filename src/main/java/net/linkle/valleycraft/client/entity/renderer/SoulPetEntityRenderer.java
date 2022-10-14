package net.linkle.valleycraft.client.entity.renderer;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.renderer.BillboardRenderer;
import net.linkle.valleycraft.util.Util;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;

public class SoulPetEntityRenderer extends EntityRenderer<Entity> {
    
    private static final Identifier TEXTURE = Main.makeId("textures/entity/souls/soul_pet.png");
    private static final RenderLayer LAYER = RenderLayer.getEntityCutout(TEXTURE);
    
    private static final float W = 16/32f;
    private static final float H = 16/80f;
    
    private final BillboardRenderer billboard = new BillboardRenderer();

    public SoulPetEntityRenderer(Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(Entity var1) {
        return TEXTURE;
    }

    @Override
    public void render(Entity entity, float yaw, float delta, MatrixStack matrices, VertexConsumerProvider provider, int light) {
        float tick = entity.age+delta;
        int overlay = OverlayTexture.DEFAULT_UV;
        
        // start animation
        float scale = smooth(Math.min(tick/40f, 1f));
        scale = MathHelper.lerp(0.75f, scale, 1f);
        billboard.setScale(scale);
        
        // barks animation
        float val = bob(entity.age, 70, 5, delta);
        val = Math.max(bob(entity.age, 77, 5, delta), val);
        var uv = getOffset(entity.age>>1, val > 0);
        
        // floating up
        float floatUp = smooth(MathHelper.clamp(tick / 40f, 0, 1));
        float offset = MathHelper.lerp(floatUp, -1f, 0f);
        
        // final animation (warbling)
        float strength = 0;
        if (tick > 6*20) {
            strength = Math.max(tick-(float)(6*20), 0f) / 20f;
            strength = Util.pow(strength, 6); // can go pass the value of 1
            float wave = MathHelper.sin(tick*0.722f);
            overlay = OverlayTexture.getUv(Math.min(strength, 1f) * 0.7f, false);
            billboard.setScale(1+(wave*strength*0.7f), 1-(wave*strength*0.5f));
        }
        
        matrices.push();
        matrices.translate(0.0, offset + 0.08f, 0.0);
        
        offset = (MathHelper.sin(tick*0.2f)*0.03f)*(1f-Math.min(strength*2f, 1f));
        billboard.setOffset(-0.5f/16f, (val*0.085f)+offset-0.08f);
        billboard.setUV(uv.x, uv.x+W, uv.y, uv.y+H);
        billboard.render(provider.getBuffer(LAYER), matrices.peek(), LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
        matrices.pop();
        super.render(entity, yaw, delta, matrices, provider, light);
    }
    
    private static float bob(int age, int offset, int ticks, float delta) {
        int pos = age-offset;
        if (pos > 0 && pos < ticks) {
            return MathHelper.sin((((pos+delta) * MathHelper.PI) / (float)ticks));
        }
        return 0;
    }
    
    private static float smooth(float a) {
        return a * a * a * (a * (a * 6 - 15) + 10);
    }
    
    private static Vec2f getOffset(int index, boolean openMouth) {
        int idx = index%8;
        idx = switch (idx) {
        case 0 -> 0;
        case 1 -> 1;
        case 2 -> 2;
        case 3 -> 3;
        case 4 -> 4;
        case 5 -> 3;
        case 6 -> 2;
        case 7 -> 1;
        default -> 0;
        };
        return OFFSETS[openMouth?1:0][MathHelper.clamp(idx, 0, 4)];
    }
    
    private static final Vec2f[][] OFFSETS = new Vec2f[2][5];
    
    static {
        for (int i = 0; i < 5; i++) {
            OFFSETS[0][i] = new Vec2f(0, i/5f);
            OFFSETS[1][i] = new Vec2f(0.5f, i/5f);
        }
    }
}
