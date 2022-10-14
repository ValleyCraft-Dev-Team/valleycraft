package net.linkle.valleycraft.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.Vector4f;

/**
 * The quad renderer with transformations. 
 * It might need fixing. Like, is the direction facing is correct?
 * 
 * @author AndEditor7
 */
@Environment(EnvType.CLIENT)
public class QuadRenderer implements Renderable {

    public float uMin, uMax = 1, vMin, vMax = 1;
    public float r = 1, g = 1, b = 1, a = 1;

    private final Direction facing;
    private final Vec3f[] verts;

    public QuadRenderer(Direction facing) {
        this.facing = facing;
        verts = Renderer.quadVec3f();
        var quat = facing.getRotationQuaternion();
        for (var vert : verts) {
            vert.rotate(quat);
        }
    }

    public QuadRenderer(Direction facing, float uMin, float uMax, float vMin, float vMax) {
        this(facing);
        setUV(uMin, uMax, vMin, vMax);
    }

    public void scaleOffset(float offset) {
        uMin += offset;
        vMin += offset;
        uMax -= offset;
        vMax -= offset;
    }

    public void setUV(float uMin, float uMax, float vMin, float vMax) {
        this.uMin = uMin;
        this.uMax = uMax;
        this.vMin = vMin;
        this.vMax = vMax;
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

    @Override
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
}