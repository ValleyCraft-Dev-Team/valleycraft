package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ModTargetBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(1, 2, 2, 15, 16, 9);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(1, 2, 7, 15, 16, 14);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(7, 2, 1, 14, 16, 15);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(2, 2, 1, 9, 16, 15);

    public ModTargetBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx).getOpposite();
    }
}
