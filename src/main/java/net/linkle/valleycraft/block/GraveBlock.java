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

public class GraveBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0,0, 1, 16, 16, 4);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0, 0, 12, 16, 16, 15);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(1, 0, 0, 4, 16, 16);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(12, 0, 0, 15, 16, 16);

    public GraveBlock(Settings settings) {
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
        return super.getFacing(ctx);
    }
}
