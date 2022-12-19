package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.BookStackVoxelShapes;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BookStackBlock extends HorizontalBlock {
    protected VoxelShape shape;

    public BookStackBlock(VoxelShape shape, Settings settings) {
        super(settings);
        this.shape = shape;
    }

    public BookStackBlock(Settings settings) {
        this(BookStackVoxelShapes.BLOCK_SHAPE_0, settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }
}
