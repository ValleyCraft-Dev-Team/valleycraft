package net.linkle.valleycraft.block;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BushBlock extends ModPlantBlock implements Fertilizable {
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = Properties.AGE_3;
    
    private VoxelShape shape0 = createCuboidShape(3, 0, 3, 13, 8, 13);
    private VoxelShape shape1 = createCuboidShape(2, 0, 2, 14, 13, 14);
    private VoxelShape shape2 = createCuboidShape(1, 0, 1, 15, 16, 15);
    private VoxelShape shape3 = createCuboidShape(1, 0, 1, 15, 16, 15);
    private SoundEvent sound = SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES;

    public BushBlock(Settings settings) {
        super(settings);
        setDefaultState(stateManager.getDefaultState().with(AGE, 0));
    }
    
    public BushBlock ground(Predicate<BlockState> predicate) {
        super.ground(predicate);
        return this;
    }
    
    /** Set pick sound. */
    public BushBlock pickSound(SoundEvent sound) {
        this.sound = sound;
        return this;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(AGE)) {
        case 0 -> shape0;
        case 1 -> shape1;
        case 2 -> shape2;
        case 3 -> shape3;
        default -> super.getOutlineShape(state, world, pos, context);
        };
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) < MAX_AGE;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (i < 3 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            world.setBlockState(pos, (BlockState)state.with(AGE, i + 1), NOTIFY_LISTENERS);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);
        boolean mature = age == MAX_AGE;
        if (!mature && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        }
        if (age > 1) {
            Random random = world.random;
            int amount = random.nextInt(1, 2) + (mature ? 1 : 0);
            BushBlock.dropStack(world, pos, new ItemStack(this, amount));
            world.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0f, random.nextFloat(0.8f, 1.2f));
            world.setBlockState(pos, state.with(AGE, 1), NOTIFY_LISTENERS);
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < MAX_AGE;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int newAge = Math.min(MAX_AGE, state.get(AGE) + 1);
        world.setBlockState(pos, state.with(AGE, newAge), NOTIFY_LISTENERS);
    }
    
    /** Use a different block shape */
    public BushBlock AloeShape() {
        shape0 = createCuboidShape(4, 0, 4, 12, 6, 12);
        shape1 = createCuboidShape(4, 0, 4, 12, 6, 12);
        shape2 = createCuboidShape(3, 0, 3, 13, 7, 13);
        shape3 = createCuboidShape(2, 0, 2, 14, 9, 14);
        return this;
    }
}
