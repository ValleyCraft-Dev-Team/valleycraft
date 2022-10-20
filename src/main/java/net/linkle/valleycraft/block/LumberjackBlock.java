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

public class LumberjackBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape AXE_SHAPE = Block.createCuboidShape(4, 8, 4, 14, 10, 12);
    protected static final VoxelShape BLOCK_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 8, 16);
    protected static final VoxelShape SHAPE = VoxelShapes.union(AXE_SHAPE, BLOCK_SHAPE);

    public LumberjackBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    
    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx);
    }
}