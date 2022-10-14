package net.linkle.valleycraft.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.Vector4f;

/** Rendering Utilities 
 * 
 * @author AndEditor7 */
@Environment(EnvType.CLIENT)
public class Renderer {
    
    static MinecraftClient client() {
        return MinecraftClient.getInstance();
    }
    
    static final Vector4f[] quadVec4f() {
        final float a = 0.5f;
        return new Vector4f[]{new Vector4f(-a, -a, 0, 1), new Vector4f(-a, a, 0, 1), new Vector4f(a, a, 0, 1), new Vector4f(a, -a, 0, 1)};
    }
    
    static final Vec3f[] quadVec3f() {
        final float a = 0.5f;
        return new Vec3f[]{new Vec3f(-a, 0, -a), new Vec3f(-a, 0, a), new Vec3f(a, 0, a), new Vec3f(a, 0, -a)};
    }
    
    /** Copied from {@link ModelPart#rotate(MatrixStack)} */
    public static void multiply(ModelPart part, MatrixStack matrices) {
        matrices.translate(part.pivotX / 16.0f, part.pivotY / 16.0f, part.pivotZ / 16.0f);
        if (part.roll != 0.0f) {
            matrices.multiply(Vec3f.POSITIVE_Z.getRadialQuaternion(part.roll));
        }
        if (part.yaw != 0.0f) {
            matrices.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(part.yaw));
        }
        if (part.pitch != 0.0f) {
            matrices.multiply(Vec3f.POSITIVE_X.getRadialQuaternion(part.pitch));
        }
        if (part.xScale != 1.0f || part.yScale != 1.0f || part.zScale != 1.0f) {
            matrices.scale(part.xScale, part.yScale, part.zScale);
        }
    }
}
