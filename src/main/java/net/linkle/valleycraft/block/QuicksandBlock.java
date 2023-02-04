package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class QuicksandBlock extends FallingBlock {
    public QuicksandBlock(Settings settings) {
        super(settings);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(0.25D, 0.05000000074505806D, 0.25D));
        entity.damage(DamageSource.IN_WALL, 1.0F);
    }
}
