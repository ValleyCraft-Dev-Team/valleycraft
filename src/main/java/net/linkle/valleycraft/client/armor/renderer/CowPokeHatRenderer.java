package net.linkle.valleycraft.client.armor.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.renderer.QuadRenderer;
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
import net.minecraft.util.math.Direction;

public class CowPokeHatRenderer implements ArmorRenderer {

    private static final Identifier TEXTURE = Main.makeId("textures/entity/clothes/cowpoke_hat.png");
    
    private final ModelPart modelHat;
    private final QuadRenderer hatRim, hatRim1, hatRim2;
    
    {
        var root = new ModelData().getRoot();
        root.addChild("hat", ModelPartBuilder.create().uv(0, 0).cuboid(-4, -9, -4, 8, 4, 8, new Dilation(0.5f)), ModelTransform.NONE);
        modelHat = root.createPart(32, 32);
        
        float u = 1/32f;
        float v = 13/32f;
        hatRim = new QuadRenderer(Direction.DOWN, u+(12/32f), u, v+(14/32f), v);
        
        u = 1/32f;
        v = 28/32f;
        hatRim1 = new QuadRenderer(Direction.WEST, u+(12/32f), u, v, v+(3/32f));
        hatRim2 = new QuadRenderer(Direction.EAST, u+(12/32f), u, v, v+(3/32f));
    }
    
    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack,
            LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        var consumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(TEXTURE), false, stack.hasGlint());
        modelHat.copyTransform(contextModel.getHead());
        modelHat.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV);
        
        matrices.push();
        Renderer.multiply(contextModel.getHead(), matrices);
        matrices.translate(0, -4.5f/16f, 0);
        matrices.scale(13.5f/16f, 1, 15.5f/16f);
        hatRim.render(consumer, matrices.peek(), light);
        matrices.pop();
        
        matrices.push();
        Renderer.multiply(contextModel.getHead(), matrices);
        matrices.translate(6.75f/16f, -6f/16f, 0);
        matrices.scale(13.3f/16f, 3/16f, 13.3f/16f);
        hatRim1.render(consumer, matrices.peek(), light);
        matrices.pop();
        
        matrices.push();
        Renderer.multiply(contextModel.getHead(), matrices);
        matrices.translate(-6.75f/16f, -6f/16f, 0);
        matrices.scale(13.3f/16f, 3/16f, 13.3f/16f);
        hatRim2.render(consumer, matrices.peek(), light);
        matrices.pop();
    }

}
