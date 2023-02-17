package net.linkle.valleycraft.client.trinket.renderer;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.linkle.valleycraft.Main;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BodyRenderer implements TrinketRenderer {
    
    private static final ModelPart BODY;
    
    private final Identifier texture;
    
    /** @param texture file name in valleycraft/textures/models/trinket/body */
    public BodyRenderer(String texture) {
        this.texture = Main.makeId("textures/models/trinket/body/"+texture+".png");
    }
    
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
            MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity,
            float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw,
            float headPitch) {
        if (entity instanceof AbstractClientPlayerEntity player) {
            var model = (PlayerEntityModel<AbstractClientPlayerEntity>)contextModel;
            var consumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(texture), false, stack.hasGlint());
            BODY.copyTransform(model.body);
            BODY.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV);
        }
    }
    
    static {
        var model = BipedEntityModel.getModelData(new Dilation(0.3f), 0);
        BODY = TexturedModelData.of(model, 64, 32).createModel().getChild(EntityModelPartNames.BODY);
    }
}
