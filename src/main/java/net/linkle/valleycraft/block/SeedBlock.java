package net.linkle.valleycraft.block;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class SeedBlock extends Block implements Fertilizable {

    public static final int MAX_AGE = 2;
    public static final IntProperty AGE = Properties.AGE_2;

    private static final VoxelShape SMALL_SHAPE = Block.createCuboidShape(3, 0, 3, 13, 8, 13);
    private static final VoxelShape LARGE_SHAPE = Block.createCuboidShape(1, 0, 1, 15, 16, 15);
    
    private final Block sapling;

    public SeedBlock(Block sapling) {
        super(Settings.copy(sapling));
        setDefaultState(stateManager.getDefaultState().with(AGE, 0));
        this.sapling = sapling;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(AGE) == MAX_AGE ? LARGE_SHAPE : SMALL_SHAPE;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) < MAX_AGE;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = state.get(AGE);
        if (age < MAX_AGE && random.nextInt(3) == 0 && world.getLightLevel(pos.up()) >= 9) {
            var newState = getGrowState(state);
            world.setBlockState(pos, newState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(newState));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return random.nextFloat() < 0.6f;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, getGrowState(state), Block.NOTIFY_LISTENERS);
    }
    
    private BlockState getGrowState(BlockState state) {
        final int age = state.get(AGE)+1;
        return age > MAX_AGE ? sapling.getDefaultState() : state.with(AGE, age);
    }
}
