package net.linkle.valleycraft.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class RopeVerticalBlock extends BlockWithWater implements RopeBlockExt {
    
    public static final BooleanProperty KNOT = BooleanProperty.of("knot");
    
    protected static final VoxelShape SHAPE = createCuboidShape(6.5, 0, 6.5, 9.5, 16, 9.5);
    protected static final VoxelShape SHAPE_KNOT = VoxelShapes.union(createCuboidShape(6.5, 2, 6.5, 9.5, 16, 9.5), createCuboidShape(6, 3, 6, 10, 7, 10)) ;

    public RopeVerticalBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    protected BlockState newDefaultState() {
        return super.newDefaultState().with(KNOT, false);
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        pos = pos.up();
        var upState = world.getBlockState(pos);
        if (upState.getBlock() instanceof RopeVerticalBlock) {
            return true;
        }
        return upState.isSideSolid(world, pos, Direction.DOWN, SideShapeType.CENTER);
    }
    
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(KNOT) ? SHAPE_KNOT : SHAPE;
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            world.createAndScheduleBlockTick(pos, this, 1);
        }
        return toState(world, state, pos);
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return toState(ctx.getWorld(), super.getPlacementState(ctx), ctx.getBlockPos());
    }
    
    protected static BlockState toState(WorldAccess world, BlockState state, BlockPos pos) {
        pos = pos.down();
        var downState = world.getBlockState(pos);
        return state.with(KNOT, !(downState.getBlock() instanceof RopeVerticalBlock) && !downState.isSideSolid(world, pos, Direction.UP, SideShapeType.CENTER));
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(KNOT));
    }

    @Override
    public boolean isVertical() {
        return true;
    }
}
