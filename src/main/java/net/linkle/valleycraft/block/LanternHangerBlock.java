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

public class LanternHangerBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(6.5, 0, 6.5, 9.5, 9, 9.5);
    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(SHAPE, Block.createCuboidShape(6.5, 7, 6.5, 9.5, 9, 16));
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(SHAPE, Block.createCuboidShape(6.5, 7, 0, 9.5, 9, 9.5));
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(SHAPE,  Block.createCuboidShape(6.5, 7, 6.5, 16, 9, 9.5));
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(SHAPE,  Block.createCuboidShape(0, 7, 6.5, 9.5, 9, 9.5));

    public LanternHangerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
        case EAST -> EAST_SHAPE;
        case SOUTH -> SOUTH_SHAPE;
        case WEST -> WEST_SHAPE;
        default -> NORTH_SHAPE;
        };
    }
    
    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return getSideElseUserFacing(ctx);
    }
}