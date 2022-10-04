package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WagonWheelTableBlock extends BlockWithWater {
    protected static final VoxelShape SHAPE = VoxelShapes.union(createCuboidShape(0, 9, 0, 16, 16, 16), createCuboidShape(4, 0, 4, 12, 9, 12));

    public WagonWheelTableBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
