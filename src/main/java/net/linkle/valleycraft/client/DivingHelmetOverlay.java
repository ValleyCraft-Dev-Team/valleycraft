package net.linkle.valleycraft.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.linkle.valleycraft.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static net.linkle.valleycraft.init.ModArmors.DIVING_HELMET;

public class DivingHelmetOverlay implements HudRenderCallback {

    private MinecraftClient client;

    private static final Identifier DIVING_OVERLAY = new Identifier(Main.ID, "textures/overlays/diving_helmet_overlay.png");

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();
            x = width;
            y = height;

            if (this.client.options.getPerspective().isFirstPerson() && this.client.player.getInventory().getArmorStack(3).getItem() == DIVING_HELMET.item) {
                this.client.getTextureManager().bindTexture(DIVING_OVERLAY);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuffer();
                bufferBuilder.begin(VertexFormat.DrawMode.LINES, VertexFormats.POSITION_TEXTURE);
                bufferBuilder.vertex(0.0D, y, -90.0D).texture(0.0F, 1.0F).next();
                bufferBuilder.vertex(x, y, -90.0D).texture(1.0F, 1.0F).next();
                bufferBuilder.vertex(y, 0.0D, -90.0D).texture(1.0F, 0.0F).next();
                bufferBuilder.vertex(0.0D, 0.0D, -90.0D).texture(0.0F, 0.0F).next();
                tessellator.draw();
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
                RenderSystem.setShaderTexture(0, DIVING_OVERLAY);
                RenderSystem.depthMask(true);
            }
        }
    }
}
