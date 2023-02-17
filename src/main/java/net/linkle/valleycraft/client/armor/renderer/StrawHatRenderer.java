package net.linkle.valleycraft.client.armor.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.linkle.valleycraft.client.renderer.QuadRenderer;
import net.linkle.valleycraft.client.renderer.Renderer;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

@Environment(EnvType.CLIENT)
public class StrawHatRenderer implements ArmorRenderer {
    
    /** A texture which contains a straw hat texture. */
    private static final Identifier TEXTURE = new Identifier("textures/entity/villager/profession/farmer.png");
    
    private final ModelPart hatModel;
    private final QuadRenderer hatRim;
    
    {
        var root = new ModelData().getRoot();
        root.addChild("hat", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0f, -9.0f, -4.0f, 8.0f, 10.0f, 8.0f, new Dilation(0.5f)), ModelTransform.NONE);
        hatModel = root.createPart(64, 64);
        
        float size = 16/64f;
        float u = 31/64f;
        float v = 48/64f;
        hatRim = new QuadRenderer(Direction.DOWN, u+size, u, v+size, v);
    }
    
    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack,
            LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        var consumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(TEXTURE), false, stack.hasGlint());
        hatModel.copyTransform(contextModel.getHead());
        hatModel.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV);
        
        matrices.push();
        Renderer.multiply(contextModel.getHead(), matrices);
        matrices.translate(0, -5/16f, 0);
        hatRim.render(consumer, matrices.peek(), light);
        matrices.pop();
    }
}
