package net.linkle.valleycraft.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

/**
 * The billboard renderer with transformations.
 * 
 * @author AndEditor7
 */
@Environment(EnvType.CLIENT)
public class BillboardRenderer implements Renderable {

    /** Uses Degree (Not Radial) */
    public float roll;
    public float xOffset, yOffset;
    public float xScale=1, yScale=1;
    public float uMin, uMax=1, vMin, vMax=1;
    public float r=1, g=1, b=1, a=1;

    public BillboardRenderer() {
    }

    public BillboardRenderer(float uMin, float uMax, float vMin, float vMax) {
        setUV(uMin, uMax, vMin, vMax);
    }

    /** Shrink UV coordinates with offset.
     *  Typically used for fixing the texture UV. */
    public void shinkOffset(float offset) {
        uMin += offset;
        vMin += offset;
        uMax -= offset;
        vMax -= offset;
    }

    public void setRollDeg(float roll) {
        this.roll = roll;
    }

    public void setRollRad(float roll) {
        this.roll = roll * MathHelper.DEGREES_PER_RADIAN;
    }

    public void setScale(float scale) {
        setScale(scale, scale);
    }

    public void setScale(float xScale, float yScale) {
        this.xScale = xScale;
        this.yScale = yScale;
    }

    public void setOffset(float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void setUV(float uMin, float uMax, float vMin, float vMax) {
        this.uMin = uMin;
        this.uMax = uMax;
        this.vMin = vMin;
        this.vMax = vMax;
    }

    /** Set color for this billboard (value of 0.0f to 1.0f. Leaves the alpha value unchanged) */
    public void setColor(float r, float g, float b) {
        setColor(r, g, b, a);
    }

    /** Set color for this billboard (value of 0.0f to 1.0f) */
    public void setColor(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    @Override
    @SuppressWarnings("resource")
    public void render(VertexConsumer consumer, MatrixStack.Entry matrix, int light, int overlay) {
        var camera = Renderer.client().gameRenderer.getCamera();
        var quat = camera.getRotation();

        if (Math.abs(roll) > 0.001f) {
            var q = camera.getHorizontalPlane().getDegreesQuaternion(roll);
            q.hamiltonProduct(quat);
            quat = q;
        }

        var verts = Renderer.quadVec4f();
        for (int i = 0; i < 4; ++i) {
            var vert = verts[i];
            vert.set((vert.getX() + xOffset) * xScale, (vert.getY() + yOffset) * yScale, vert.getZ(), 1);
            vert.rotate(quat);
            vert.transform(matrix.getPositionMatrix());
        }

        var nor = new Vec3f(0, 1, 0);
        nor.transform(matrix.getNormalMatrix());
        consumer.vertex(verts[0].getX(), verts[0].getY(), verts[0].getZ(), r, g, b, a, uMax, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[1].getX(), verts[1].getY(), verts[1].getZ(), r, g, b, a, uMax, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[2].getX(), verts[2].getY(), verts[2].getZ(), r, g, b, a, uMin, vMin, overlay, light, nor.getX(), nor.getY(), nor.getZ());
        consumer.vertex(verts[3].getX(), verts[3].getY(), verts[3].getZ(), r, g, b, a, uMin, vMax, overlay, light, nor.getX(), nor.getY(), nor.getZ());
    }
}