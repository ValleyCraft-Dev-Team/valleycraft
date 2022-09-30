package net.linkle.valleycraft.client;

import java.util.ArrayList;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.block.entity.WispLanternRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.Vector4f;

@Environment(EnvType.CLIENT)
public class Sprites {
    
    private static final ArrayList<Identifier> TEXS = new ArrayList<>();
    
    static void intialize() {
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlas, registry) -> TEXS.forEach(registry::register));
        
        register(WispLanternRenderer.VEX_TEXTURE);
    }
    
    /** Register the sprite.
     * @param texturePath of your textures mod folder. */
    private static void register(String texturePath) {
        register(Main.makeId(texturePath));
    }
    
    /** Register the sprite. */
    private static void register(Identifier id) {
        TEXS.add(id);
    }
    
    /** Register the sprite. */
    private static void register(SpriteIdentifier id) {
        register(id.getTextureId());
    }

    public static SpriteIdentifier create(String id) {
        return new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, Main.makeId(id));
    }
    
    public static void renderBillboard(VertexConsumer consumer, Camera camera, MatrixStack.Entry matrix, float size, float roll, int light, int overlay) {
        var camRot = camera.getRotation();
        
        Vec3f[] verts = new Vec3f[]{new Vec3f(-1, -1, 0), new Vec3f(-1, 1, 0), new Vec3f(1, 1, 0), new Vec3f(1, -1, 0)};
        Vector4f[] fVerts = new Vector4f[4];
        for (int i = 0; i < 4; ++i) {
            Vec3f vert = verts[i];
            var quat = camera.getHorizontalPlane().getDegreesQuaternion(roll);
            quat.hamiltonProduct(camRot);
            vert.rotate(quat);
            vert.scale(size);
            fVerts[i] = new Vector4f(vert);
            fVerts[i].transform(matrix.getPositionMatrix());
        }
        
        
        Vec3f nor = new Vec3f(0, 1, 0);
        nor.transform(matrix.getNormalMatrix());
        float uMin = 0.005f;
        float uMax = 0.995f;
        float vMin = 0.005f;
        float vMax = 0.995f;
        consumer.vertex(fVerts[0].getX(), fVerts[0].getY(), fVerts[0].getZ(), 1, 1, 1, 1, uMax, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(fVerts[1].getX(), fVerts[1].getY(), fVerts[1].getZ(), 1, 1, 1, 1, uMax, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(fVerts[2].getX(), fVerts[2].getY(), fVerts[2].getZ(), 1, 1, 1, 1, uMin, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(fVerts[3].getX(), fVerts[3].getY(), fVerts[3].getZ(), 1, 1, 1, 1, uMin, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
    }
}
