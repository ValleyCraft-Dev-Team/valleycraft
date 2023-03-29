package net.linkle.valleycraft.block;

import net.minecraft.block.*;
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

public class OxidizableWallCandelabraBlock extends AbstractOxidizableCandelabraBlock {
    
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    
    public OxidizableWallCandelabraBlock(OxidationLevel level) {
        super(level, 6);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
        case SOUTH -> WallCandelabraBlock.SHAPE_SOUTH;
        case EAST -> WallCandelabraBlock.SHAPE_EAST;
        case WEST -> WallCandelabraBlock.SHAPE_WEST;
        default -> WallCandelabraBlock.SHAPE_NORTH;
        };
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return switch (state.get(FACING)) {
        case SOUTH -> WallCandelabraBlock.OFFSETS_SOUTH;
        case EAST -> WallCandelabraBlock.OFFSETS_EAST;
        case WEST -> WallCandelabraBlock.OFFSETS_WEST;
        default -> WallCandelabraBlock.OFFSETS_NORTH;
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