package net.linkle.valleycraft.client.block.entity;

import java.util.function.Function;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.entity.WaypointBlockEntity;
import net.linkle.valleycraft.client.Sprites;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;

public class WaypointRenderer implements BlockEntityRenderer<WaypointBlockEntity> {

    public static final SpriteIdentifier TEXTURE = Sprites.create("entity/block/shattered_pearl_entity");
    
    public static final EntityModelLayer LAYER = new EntityModelLayer(Main.makeId("pearl"), "main");
    
    private final ModelPart pearlModel;
    private final ModelPart portalModel;
    
    public WaypointRenderer(Context context) {
        var model = context.getLayerModelPart(LAYER);
        pearlModel = model.getChild("pearl");
        portalModel = model.getChild("portal");
    }
    
    public static TexturedModelData getModelData() {
        var data = new ModelData();
        data.getRoot().addChild("pearl", ModelPartBuilder.create().uv(0, 0).cuboid(-4, -4, -4, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.NONE);
        data.getRoot().addChild("portal", ModelPartBuilder.create().uv(0, 16).cuboid(-3, -3, -3, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.NONE);
        return TexturedModelData.of(data, 32, 32);
    }
    
    @Override
    public void render(WaypointBlockEntity entity, float delta, MatrixStack matrix, VertexConsumerProvider provider, int light, int overlay) {
        float tick = entity.getTick(delta);
        matrix.push();
        matrix.translate(0.5, 0.5+Math.sin(tick*0.1)*0.03, 0.5);
        
        matrix.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(entity.getYaw(delta)));
        matrix.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(entity.getPitch(delta)));
        
        pearlModel.rotate(matrix);
        var consumer = getConsumer(provider, RenderLayer::getEntityCutoutNoCull);
        pearlModel.render(matrix, consumer, light, overlay);
        consumer = getConsumer(provider, RenderLayer::getEntityTranslucentCull);
        portalModel.render(matrix, consumer, light, overlay);
        matrix.pop();
    }
    
    private VertexConsumer getConsumer(VertexConsumerProvider provider, Function<Identifier, RenderLayer> function) {
        return TEXTURE.getSprite().getTextureSpecificVertexConsumer(provider.getBuffer(function.apply(TEXTURE.getAtlasId())));
    }
}
