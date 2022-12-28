package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class RopeHorizontalBlock extends BlockWithWater implements RopeBlockExt {
    
    public static final EnumProperty<Direction.Axis> AXIS = Properties.HORIZONTAL_AXIS;
    
    protected static final VoxelShape Z_SHAPE = Block.createCuboidShape(6.5, 6.5, 0.0, 9.5, 9.5, 16.0);
    protected static final VoxelShape X_SHAPE = Block.createCuboidShape(0.0, 6.5, 6.5, 16.0, 9.5, 9.5);

    public RopeHorizontalBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected BlockState newDefaultState() {
        return super.newDefaultState().with(AXIS, Direction.Axis.X);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(AXIS) == Direction.Axis.X ? X_SHAPE : Z_SHAPE;
    }
    
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90: 
            case CLOCKWISE_90: {
                return switch (state.get(AXIS)) {
                    case Z -> state.with(AXIS, Direction.Axis.Z);
                    case X -> state.with(AXIS, Direction.Axis.X);
                    default -> state;
                };
            }
            default: return state;
        }
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(AXIS));
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var axis = ctx.getSide().getAxis();
        if (axis.isVertical()) return null; 
        return super.getPlacementState(ctx).with(AXIS, axis);
    }

    @Override
    public boolean isVertical() {
        return false;
    }
}
