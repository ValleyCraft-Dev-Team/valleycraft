package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class WagonWheelBlock extends DirectionBlockWithWater {
    protected static final VoxelShape EAST_SHAPE;
    protected static final VoxelShape WEST_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape NORTH_SHAPE;
    protected static final VoxelShape UP_SHAPE;
    protected static final VoxelShape DOWN_SHAPE;

    public WagonWheelBlock(Settings settings) {
        super(settings);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            case UP -> UP_SHAPE;
            case DOWN -> DOWN_SHAPE;
        };
    }

    static {
        UP_SHAPE = Block.createCuboidShape(0, 13, 0, 16, 16, 16);
        DOWN_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 3, 16);
        NORTH_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 3);
        SOUTH_SHAPE = Block.createCuboidShape(0, 0, 13, 16, 16, 16);
        EAST_SHAPE = Block.createCuboidShape(13, 0, 0, 16, 16, 16);
        WEST_SHAPE = Block.createCuboidShape(0, 0, 0, 3, 16, 16);
    }
}
