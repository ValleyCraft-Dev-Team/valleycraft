package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class LanternHangerBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(7, 0, 7, 9, 9, 9);

    public LanternHangerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    
    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx).getOpposite();
    }
}