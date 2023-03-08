package net.linkle.valleycraft.client.armor.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.renderer.Renderer;
import net.minecraft.client.model.*;
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

public class CowPokeHatRenderer implements ArmorRenderer {

    private static final Identifier TEXTURE = Main.makeId("textures/entity/clothes/cowpoke_hat.png");
    
    private final ModelPart model;
    
    {
        var root = new ModelData().getRoot();
        root.addChild("hat", ModelPartBuilder.create().uv(0, 0).cuboid(-4, -9, -4, 8, 4, 8, new Dilation(0.5f)), ModelTransform.NONE);
        root.addChild("rim", ModelPartBuilder.create().uv(15, 33).cuboid(-4, -9, -4, 12, 3, 14, new Dilation(0.5f)), ModelTransform.NONE);
        model = root.createPart(64, 64);
    }
    
    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack,
            LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        var root = new ModelData().getRoot();
        root.addChild("hat", ModelPartBuilder.create().uv(0, 0).cuboid(-4, -9, -4, 8, 4, 8, new Dilation(0.5f)), ModelTransform.NONE);
        root.addChild("rim", ModelPartBuilder.create().uv(15, 33).cuboid(-4, -9, -4, 12, 3, 14, new Dilation(0.5f)), ModelTransform.NONE);
        var model = root.createPart(64, 64);
        
        var consumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(TEXTURE), false, stack.hasGlint());
        model.copyTransform(contextModel.getHead());
        model.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV);
    }

}
