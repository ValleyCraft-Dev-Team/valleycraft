package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class GrateBlock extends BlockWithWater {
    public static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 16, 14);
    public static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);

    public GrateBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
    
    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0f;
    }
}
