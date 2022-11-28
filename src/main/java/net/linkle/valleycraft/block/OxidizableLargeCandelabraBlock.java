package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class OxidizableLargeCandelabraBlock extends AbstractOxidizableCandelabraBlock {
    
    public static final EnumProperty<Axis> AXIS = Properties.HORIZONTAL_AXIS;
    
    public OxidizableLargeCandelabraBlock(OxidationLevel level) {
        super(level, 10);
        setDefaultState(getDefaultState().with(AXIS, Axis.Z));
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(AXIS)) {
        case X -> LargeCandelabraBlock.SHAPE_X;
        default -> LargeCandelabraBlock.SHAPE_Z;
        };
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return switch (state.get(AXIS)) {
        case X -> LargeCandelabraBlock.OFFSETS_X;
        default -> LargeCandelabraBlock.OFFSETS_Z;
        };
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(AXIS, ctx.getPlayerFacing().getAxis());
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(AXIS);
    }
    
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90: 
            case CLOCKWISE_90: {
                switch (state.get(AXIS)) {
                    case X: {
                        return state.with(AXIS, Direction.Axis.Z);
                    }
                    case Z: {
                        return state.with(AXIS, Direction.Axis.X);
                    }
                default: break;
                }
                return state;
            }
        default: break;
        }
        return state;
    }
}