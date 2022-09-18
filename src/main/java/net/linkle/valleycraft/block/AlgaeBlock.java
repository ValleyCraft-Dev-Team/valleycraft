package net.linkle.valleycraft.block;

import java.util.ArrayList;
import java.util.Random;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class AlgaeBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 1.5, 16);

    /** */
    private static final float GROW_CHANCE = 0.1f;
    /** */
    private static final int GROW_SIZE = 50;
    /** */
    private static final int CHECK_RANGE = 16;

    public AlgaeBlock() {
        this(settings());
    }

    public AlgaeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextFloat() < GROW_CHANCE) {
            BlockPos placePos = canGrow(world, pos, random);
            if (placePos != null) {
                world.setBlockState(placePos, getDefaultState(), Block.NOTIFY_LISTENERS);
            }
        }
    }
    
    @Nullable
    private BlockPos canGrow(ServerWorld world, BlockPos pos, Random random) {
        var loop = BlockPos.iterate(pos.getX()-2, pos.getY(), pos.getZ()-2, pos.getX()+2, pos.getY(), pos.getZ()+2);
        var array = new ArrayList<BlockPos>(10);
        for (BlockPos p : loop) {
            var state = world.getBlockState(p);
            if (state.isAir() && world.getFluidState(p.down()).getFluid() == Fluids.WATER) {
                array.add(p.toImmutable());
            }
        }
        
        if (array.isEmpty()) {
            return null;
        }
        
        loop = BlockPos.iterate(pos.getX()-CHECK_RANGE, pos.getY(), pos.getZ()-CHECK_RANGE, pos.getX()+CHECK_RANGE, pos.getY(), pos.getZ()+CHECK_RANGE);
        int amount = 0;
        for (BlockPos p : loop) {
            if (world.getBlockState(p).isOf(this)) {
                amount++;
                if (amount > GROW_SIZE) {
                    return null;
                }
            }
        }
        
        return Util.getRandom(array, random);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);
        FluidState fluidState2 = world.getFluidState(pos.up());
        return (fluidState.getFluid() == Fluids.WATER || floor.getMaterial() == Material.ICE)
                && fluidState2.getFluid() == Fluids.EMPTY;
    }

    public static Settings settings() {
        return Settings.copy(Blocks.LILY_PAD).ticksRandomly().noCollision().mapColor(MapColor.PALE_GREEN);
    }
}
