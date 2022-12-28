package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class OxidizableMediumCandelabraBlock extends AbstractOxidizableCandelabraBlock {

    public OxidizableMediumCandelabraBlock(OxidationLevel level) {
        super(level, 7);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return MediumCandelabraBlock.SHAPE;
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return MediumCandelabraBlock.OFFSETS;
    }
}