package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.init.ModBlockEntityType;
import net.linkle.valleycraft.util.Util;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WaypointBlockEntity extends BlockEntity {
    
    // Use the dubug mode with code hotswap so you can change variables without restarting the game.
    private static final float ROTATION_DURATION = 25;
    private static final int TICK_INTERVAL = 17;
    
    private short ticks = (short) (Short.MIN_VALUE + Util.RANDOM.nextInt(2000));
    private short offset = ticks;
    private float thePitch, theYaw;
    private float targetPitch, targetYaw;
    
    public WaypointBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.WAYPOINT_ENTITY, pos, state);
    }
    
    public static void clientTick(World world, BlockPos pos, BlockState state, WaypointBlockEntity entity) {
        entity.clientTick((ClientWorld)world, pos, state);
    }

    private void clientTick(ClientWorld world, BlockPos pos, BlockState state) {
        ticks++;
        var random = world.random;
        
        if (world.isPlayerInRange(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 24)) {
            if ((ticks&3) == 0)  {
                double size = 1.6; 
                double xPos = pos.getX() + 0.5 + MathHelper.nextDouble(random, -size, size);
                double yPos = pos.getY() + 2.0 + (random.nextDouble()*2.5);
                double zPos = pos.getZ() + 0.5 + MathHelper.nextDouble(random, -size, size);
                world.addParticle(ParticleTypes.ENCHANT, xPos, yPos, zPos, 0, -4.5, 0);
            }
        }
        
        if ((ticks%TICK_INTERVAL) == 0) {
            var pi = MathHelper.HALF_PI;
            offset = ticks;
            
            thePitch = targetPitch;
            theYaw = targetYaw;
            
            thePitch = modAngle(thePitch);
            theYaw = modAngle(theYaw);
            targetPitch = modAngle(targetPitch);
            targetYaw = modAngle(targetYaw);
            
            if (random.nextBoolean()) {
                targetPitch += random.nextBoolean() ? pi : -pi;
            } else {
                targetYaw += random.nextBoolean() ? pi : -pi;
            }
        }
    }
    
    public float getTick(float tickDelta) {
        return ticks + tickDelta;
    }
    
    public float getPitch(float tickDelta) {
        float value = getTick(tickDelta) - (float)offset;
        float delta = MathHelper.clamp(value / ROTATION_DURATION, 0f, 1f);
        return lerp(delta, thePitch, targetPitch);
    }
    
    public float getYaw(float tickDelta) {
        float value = getTick(tickDelta) - (float)offset;
        float delta = MathHelper.clamp(value / ROTATION_DURATION, 0f, 1f);
        return lerp(delta, theYaw, targetYaw);
    }
    
    private static float modAngle(float angle) {
        while (angle < -MathHelper.PI) {
            angle += MathHelper.TAU;
        }
        while (angle >= MathHelper.PI) {
            angle -= MathHelper.TAU;
        }
        return angle;
    }
    
    private static float lerp(float delta, float start, float end) {
        return MathHelper.lerp(delta * delta * (3 - 2 * delta), start, end);
    }
}
