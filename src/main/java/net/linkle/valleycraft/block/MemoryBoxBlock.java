package net.linkle.valleycraft.block;

import net.linkle.valleycraft.block.entity.CrateBlockEntity;
import net.linkle.valleycraft.block.entity.MemoryBoxEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class MemoryBoxBlock extends HorizontalContainerBlock {
    static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 8, 15);

    public MemoryBoxBlock(Settings settings) {
        super(settings);
    }
    
    @Override @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MemoryBoxEntity(pos, state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
