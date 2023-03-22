package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class LadleBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0, 0, 0, 5, 6, 5);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(11, 0, 11, 16, 6, 16);
    protected static final VoxelShape WEST_SHAPE  = Block.createCuboidShape(0, 0, 11, 5, 6, 16);
    protected static final VoxelShape EAST_SHAPE  = Block.createCuboidShape(11, 0, 0, 16, 6, 5);

    public LadleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var state = super.getPlacementState(ctx);
        
        var pos = ctx.getHitPos();
        if (MathHelper.approximatelyEquals(pos.y, Math.round(pos.y))) {
            var x = MathHelper.fractionalPart(pos.x);
            var z = MathHelper.fractionalPart(pos.z);
            
            final Direction face;
            if (x < 0.5) face = z > 0.5 ? Direction.WEST : Direction.NORTH;
            else face = z > 0.5 ? Direction.SOUTH : Direction.EAST;
            state = state.with(FACING, face);
        }
        
        return state;
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (canPlaceAt(state, world, pos)) {
            return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
        }
        return Blocks.AIR.getDefaultState();
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(BlockTags.CAULDRONS);
    }

    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx).getOpposite();
    }
}
