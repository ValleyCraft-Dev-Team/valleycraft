package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TableBlock extends BlockWithWater {
    protected static final VoxelShape TABLE_SHAPE = Block.createCuboidShape(0, 13, 0, 16, 16, 16);
    protected static final VoxelShape LEG_1_SHAPE = Block.createCuboidShape(1 ,0, 1, 3, 13, 3);
    protected static final VoxelShape LEG_2_SHAPE = LEG_1_SHAPE.offset(12/16d, 0, 0);
    protected static final VoxelShape LEG_3_SHAPE = LEG_1_SHAPE.offset(0, 0, 12/16d);
    protected static final VoxelShape LEG_4_SHAPE = LEG_1_SHAPE.offset(12/16d, 0, 12/16d);
    protected static final VoxelShape SHAPE = VoxelShapes.union(TABLE_SHAPE, LEG_1_SHAPE, LEG_3_SHAPE, LEG_4_SHAPE, LEG_2_SHAPE);

    public TableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
