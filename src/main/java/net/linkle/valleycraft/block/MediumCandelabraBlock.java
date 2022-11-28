package net.linkle.valleycraft.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MediumCandelabraBlock extends AbstractCandelabraBlock implements Waterloggable {

    static final VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5, 11, 16, 11);
    static final List<Vec3d> OFFSETS = List.of(new Vec3d(0.5, 18/16d, 0.5));
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState var1) {
        return OFFSETS;
    }
    
}