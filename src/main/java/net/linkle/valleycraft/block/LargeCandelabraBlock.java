package net.linkle.valleycraft.block;

import java.util.List;

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
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class LargeCandelabraBlock extends AbstractCandelabraBlock {
    
    public static final EnumProperty<Axis> AXIS = Properties.HORIZONTAL_AXIS;

    static final VoxelShape SHAPE_X = VoxelShapes.union(createCuboidShape(5, 0, 5, 11, 16, 11), createCuboidShape(5, 5, 0, 11, 14, 5), createCuboidShape(5, 5, 11, 11, 14, 16));
    static final VoxelShape SHAPE_Z = VoxelShapes.union(createCuboidShape(5, 0, 5, 11, 16, 11), createCuboidShape(0, 5, 5, 5, 14, 11), createCuboidShape(11, 5, 5, 16, 14, 11));
    
    static final List<Vec3d> OFFSETS_X = List.of(new Vec3d(0.5, 18/16d, 0.5), new Vec3d(8/16d, 1, 3/16d), new Vec3d(8/16d, 1, 13/16d));
    static final List<Vec3d> OFFSETS_Z = List.of(new Vec3d(0.5, 18/16d, 0.5), new Vec3d(3/16d, 1, 8/16d), new Vec3d(13/16d, 1, 8/16d));
    
    public LargeCandelabraBlock() {
        super(10);
        setDefaultState(getDefaultState().with(AXIS, Axis.Z));
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(AXIS)) {
        case X -> SHAPE_X;
        default -> SHAPE_Z;
        };
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return switch (state.get(AXIS)) {
        case X -> OFFSETS_X;
        default -> OFFSETS_Z;
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