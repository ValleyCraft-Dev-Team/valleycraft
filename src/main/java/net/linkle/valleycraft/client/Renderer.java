package net.linkle.valleycraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.Vector4f;

/** Rendering Utilities */
@Environment(EnvType.CLIENT)
@SuppressWarnings("resource")
public class Renderer {

    public static void billboard(VertexConsumer consumer, MatrixStack.Entry matrix, float size, float roll, int light, int overlay) {
        var camera = client().gameRenderer.getCamera();
        var camRot = camera.getRotation();
        
        Vector4f[] verts = quad();
        for (int i = 0; i < 4; ++i) {
            var vert = verts[i];
            var quat = camera.getHorizontalPlane().getDegreesQuaternion(roll);
            quat.hamiltonProduct(camRot);
            vert.set(vert.getX()*size, vert.getY()*size, vert.getZ()*size, 1);
            vert.rotate(quat);
            //
            vert.transform(matrix.getPositionMatrix());
        }
        
        Vec3f nor = new Vec3f(0, 1, 0);
        nor.transform(matrix.getNormalMatrix());
        float uMin = 0.005f;
        float uMax = 0.995f;
        float vMin = 0.005f;
        float vMax = 0.995f;
        consumer.vertex(verts[0].getX(), verts[0].getY(), verts[0].getZ(), 1, 1, 1, 1, uMax, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[1].getX(), verts[1].getY(), verts[1].getZ(), 1, 1, 1, 1, uMax, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[2].getX(), verts[2].getY(), verts[2].getZ(), 1, 1, 1, 1, uMin, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[3].getX(), verts[3].getY(), verts[3].getZ(), 1, 1, 1, 1, uMin, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
    }
    
    public static void quad(VertexConsumer consumer, MatrixStack.Entry matrix, int light, int overlay) {
        var verts = quad();
        for (var vert : verts) {
            vert.transform(matrix.getPositionMatrix());
        }
        var nor = new Vec3f(0, 0, 1);
        nor.transform(matrix.getNormalMatrix());
        float uMin = 0.005f;
        float uMax = 0.995f;
        float vMin = 0.005f;
        float vMax = 0.995f;
        consumer.vertex(verts[0].getX(), verts[0].getY(), verts[0].getZ(), 1, 1, 1, 1, uMax, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[1].getX(), verts[1].getY(), verts[1].getZ(), 1, 1, 1, 1, uMax, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[2].getX(), verts[2].getY(), verts[2].getZ(), 1, 1, 1, 1, uMin, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[3].getX(), verts[3].getY(), verts[3].getZ(), 1, 1, 1, 1, uMin, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
    }
    
    public static void rotate(ModelPart part, MatrixStack matrices) {
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
    }

    private static MinecraftClient client() {
        return MinecraftClient.getInstance();
    }
    
    private static final Vector4f[] quad() {
        return new Vector4f[]{new Vector4f(-1, -1, 0, 1), new Vector4f(-1, 1, 0, 1), new Vector4f(1, 1, 0, 1), new Vector4f(1, -1, 0, 1)};
    }
    
    /** The quad renderer. Might need fixing */
    public static class Quad {
        
        public float uMin;
        public float uMax;
        public float vMin;
        public float vMax;
        
        public float r=1, g=1, b=1, a=1;
        
        private final Direction facing;
        private final Vec3f[] verts;
        
        public Quad(Direction facing) {
            this(facing, 0.005f, 0.995f, 0.005f, 0.995f);
        }
        
        public Quad(Direction facing, float uMin, float uMax, float vMin, float vMax) {
            this.facing = facing;
            this.uMin = uMin;
            this.uMax = uMax;
            this.vMin = vMin;
            this.vMax = vMax;
            
            verts = quad();
            var quat = facing.getRotationQuaternion();
            for (var vert : verts) {
                vert.rotate(quat);
            }
        }
        
        public void setRGB(float r, float g, float b) {
            setRGBA(r, g, b, a);
        }
        
        public void setRGBA(float r, float g, float b, float a) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }
        
        public void render(VertexConsumer consumer, MatrixStack.Entry matrix, int light, int overlay) {
            var verts = new Vector4f[4];
            for (int i = 0; i < 4; i++) {
                verts[i] = new Vector4f(this.verts[i]);
                verts[i].transform(matrix.getPositionMatrix());
            }
            var nor = facing.getUnitVector();
            nor.transform(matrix.getNormalMatrix());
            consumer.vertex(verts[0].getX(), verts[0].getY(), verts[0].getZ(), r, g, b, a, uMax, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
            consumer.vertex(verts[1].getX(), verts[1].getY(), verts[1].getZ(), r, g, b, a, uMax, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
            consumer.vertex(verts[2].getX(), verts[2].getY(), verts[2].getZ(), r, g, b, a, uMin, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
            consumer.vertex(verts[3].getX(), verts[3].getY(), verts[3].getZ(), r, g, b, a, uMin, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        }
        
        private static final Vec3f[] quad() {
            return new Vec3f[]{new Vec3f(-1, 0, -1), new Vec3f(-1, 0, 1), new Vec3f(1, 0, 1), new Vec3f(1, 0, -1)};
        }
    }
}
