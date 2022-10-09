package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class BurntTorchBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 2, 13);
    
    private VoxelShape shape = SHAPE;

    public BurntTorchBlock(Settings settings) {
        super(settings);
    }
    
    public BurntTorchBlock shape(double min, double max) {
        shape = Block.createCuboidShape(min, 0, min, max, 2, max);
        return this;
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }
    
    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx).getOpposite();
    }
}