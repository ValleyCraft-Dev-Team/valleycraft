package net.linkle.valleycraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class AppleLeavesBlock extends LeavesBlock implements Fertilizable {
    
    private static final float GROW_CHANCE = 0.15f;
    
    public static final BooleanProperty APPLES = BooleanProperty.of("apples");

    public AppleLeavesBlock() {
        super(Settings.copy(Blocks.OAK_LEAVES));
        setDefaultState(getDefaultState().with(APPLES, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(APPLES);
    }
    
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return super.hasRandomTicks(state) || !state.get(APPLES);
    }
    
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextFloat() < GROW_CHANCE && !state.get(APPLES)) {
            grow(world, random, pos, state);
        }
        super.randomTick(state, world, pos, random);
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(APPLES)) {
            var random = world.random;
            Block.dropStack(world, pos, hit.getSide(), new ItemStack(Items.APPLE, MathHelper.nextInt(random, 1, 2)));
            world.playSound(null, pos, SoundEvents.BLOCK_CAVE_VINES_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, random.nextFloat(0.8f, 1.2f));
            world.setBlockState(pos, state.with(APPLES, false), Block.NOTIFY_LISTENERS);
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean bool) {
        return !state.get(APPLES);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(APPLES, true), Block.NOTIFY_LISTENERS);
    }
}
