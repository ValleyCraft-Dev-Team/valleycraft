package net.linkle.valleycraft.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class WallCandelabraBlock extends AbstractCandelabraBlock {
    
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    
    static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(5, 3, 8, 11, 14, 16);
    static final VoxelShape SHAPE_EAST  = Block.createCuboidShape(0, 3, 5, 8,  14, 11);
    static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(5, 3, 0, 11, 14, 8);
    static final VoxelShape SHAPE_WEST  = Block.createCuboidShape(8, 3, 5, 16, 14, 11);
    
    private static final double OFFSET = 3/16d;
    static final List<Vec3d> OFFSETS_NORTH = List.of(new Vec3d(0.5, 1, 0.5+OFFSET));
    static final List<Vec3d> OFFSETS_EAST  = List.of(new Vec3d(0.5-OFFSET, 1, 0.5));
    static final List<Vec3d> OFFSETS_SOUTH = List.of(new Vec3d(0.5, 1, 0.5-OFFSET));
    static final List<Vec3d> OFFSETS_WEST  = List.of(new Vec3d(0.5+OFFSET, 1, 0.5));
    
    public WallCandelabraBlock() {
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
        case SOUTH -> SHAPE_SOUTH;
        case EAST -> SHAPE_EAST;
        case WEST -> SHAPE_WEST;
        default -> SHAPE_NORTH;
        };
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return switch (state.get(FACING)) {
        case SOUTH -> OFFSETS_SOUTH;
        case EAST -> OFFSETS_EAST;
        case WEST -> OFFSETS_WEST;
        default -> OFFSETS_NORTH;
        };
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var facing = ctx.getSide();
        if (facing.getAxis().isVertical()) return null;
        return super.getPlacementState(ctx).with(FACING, facing);
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        var facing = state.get(FACING).getOpposite();
        var secondPos = pos.offset(facing);
        return world.getBlockState(secondPos).isSideSolidFullSquare(world, secondPos, facing.getOpposite());
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }
    
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
}