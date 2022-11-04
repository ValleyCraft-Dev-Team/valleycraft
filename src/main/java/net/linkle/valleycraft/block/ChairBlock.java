package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ChairBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 8, 13);
    protected static final VoxelShape NORTH_BACK_SHAPE = Block.createCuboidShape(3, 0, 12, 13, 19, 14);
    protected static final VoxelShape WEST_BACK_SHAPE = Block.createCuboidShape(12, 0, 3, 14, 19, 13);
    protected static final VoxelShape SOUTH_BACK_SHAPE = Block.createCuboidShape(3, 0, 2, 13, 19, 4);
    protected static final VoxelShape EAST_BACK_SHAPE = Block.createCuboidShape(2, 0, 3, 4, 19, 13);
    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(SHAPE, NORTH_BACK_SHAPE);
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(SHAPE, SOUTH_BACK_SHAPE);
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(SHAPE, WEST_BACK_SHAPE);
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(SHAPE, EAST_BACK_SHAPE);

    public ChairBlock(Settings settings) {
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
