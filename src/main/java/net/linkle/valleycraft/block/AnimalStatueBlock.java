package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class AnimalStatueBlock extends HorizontalWithWaterBlock{
    protected static final VoxelShape BASE_PLATE_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 1, 16);
    protected static final VoxelShape STATUE_SHAPE = Block.createCuboidShape(1, 1, 1, 15, 15, 15);
    protected static final VoxelShape SHAPE = VoxelShapes.union(STATUE_SHAPE, BASE_PLATE_SHAPE);

    public AnimalStatueBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> SHAPE;
            case SOUTH -> SHAPE;
            case WEST -> SHAPE;
            case EAST ->  SHAPE;
            default -> SHAPE;
        };
    }
}
