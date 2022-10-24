package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.Util;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Iterator;

public class RushBlock extends SugarCaneBlock implements Waterloggable {
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape SHAPE;
    public static final IntProperty AGE;

    public RushBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(WATERLOGGED, Util.inWater(ctx));
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }

    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isAir(pos.up())) {
            int i;
            for(i = 1; world.getBlockState(pos.down(i)).isOf(this); ++i) {
            }

            if (i < 4) {
                int j = (Integer)state.get(AGE);
                if (j == 15) {
                    world.setBlockState(pos.up(), this.getDefaultState());
                    world.setBlockState(pos, (BlockState)state.with(AGE, 0), 4);
                } else {
                    world.setBlockState(pos, (BlockState)state.with(AGE, j + 1), 4);
                }
            }
        }

    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            world.createAndScheduleBlockTick(pos, this, 1);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        if (blockState.isOf(this)) {
            return true;
        } else {
            if (blockState.isIn(BlockTags.DIRT) || blockState.isOf(Blocks.SAND) || blockState.isOf(Blocks.RED_SAND)) {
                BlockPos blockPos = pos.down();
                Iterator var6 = Direction.Type.HORIZONTAL.iterator();

                while(var6.hasNext()) {
                    Direction direction = (Direction)var6.next();
                    BlockState blockState2 = world.getBlockState(blockPos.offset(direction));
                    FluidState fluidState = world.getFluidState(blockPos.offset(direction));
                    if (fluidState.isIn(FluidTags.WATER) || blockState2.isOf(Blocks.FROSTED_ICE)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE});
        builder.add(WATERLOGGED);
    }

    static {
        AGE = Properties.AGE_15;
        SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    }
}
