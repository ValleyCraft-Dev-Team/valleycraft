package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BookStackBlock extends HorizontalBlock {
    protected VoxelShape shape;

    public BookStackBlock(VoxelShape shape) {
        super(Settings.of(Material.DECORATION).strength(0.2f).nonOpaque());
        this.shape = shape;
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }
}
