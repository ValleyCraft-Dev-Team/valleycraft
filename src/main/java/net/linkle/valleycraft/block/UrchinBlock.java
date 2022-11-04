package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class UrchinBlock extends BlockWithWater {
    protected static final VoxelShape SHAPE = createCuboidShape(5, 0, 5, 11, 6, 11);

    public UrchinBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof WaterCreatureEntity ||
                entity instanceof GuardianEntity ||
                entity instanceof AxolotlEntity)) {
            entity.damage(DamageSource.CACTUS, 2.0F);
        }
    }
}