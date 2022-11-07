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
import net.minecraft.util.math.Vec3f;

public class TalismanRenderer implements TrinketRenderer {
    
    private static final ModelPart BODY = TexturedModelData.of(BipedEntityModel.getModelData(Dilation.NONE, 0), 64, 32).createModel().getChild(EntityModelPartNames.BODY);
    
    private final Identifier texture;
    
    /** @param texture file name in valleycraft/textures/models/trinket */
    public TalismanRenderer(String texture) {
        this.texture = Main.makeId("textures/models/trinket/"+texture+".png");
    }
    
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
            MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity,
            float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw,
            float headPitch) {
        if (entity instanceof AbstractClientPlayerEntity player) {
            var model = (PlayerEntityModel<AbstractClientPlayerEntity>)contextModel;
            var consumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(texture), false, stack.hasGlint());
            
            float scale = 0.3f;
            BODY.copyTransform(model.body);
            BODY.scale(new Vec3f(scale, scale, scale));
            BODY.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV);
        }
    }
}
