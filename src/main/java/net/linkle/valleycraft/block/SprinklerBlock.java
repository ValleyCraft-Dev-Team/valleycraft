package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModParticles;
import net.linkle.valleycraft.init.ModSounds;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class SprinklerBlock extends Block {
    
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty FILLED = BooleanProperty.of("filled");
    
    protected static final VoxelShape SHAPE;

    public SprinklerBlock() {
        super(Settings.of(Material.METAL, MapColor.STONE_GRAY).strength(3.0f).sounds(BlockSoundGroup.STONE).nonOpaque());
        setDefaultState(stateManager.getDefaultState().with(POWERED, false).with(FILLED, false));
    }
    
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }
        var powered = state.get(POWERED);
        if (powered != world.isReceivingRedstonePower(pos)) {
            if (powered) {
                world.createAndScheduleBlockTick(pos, this, 4);
            } else {
                world.setBlockState(pos, state.cycle(POWERED), Block.NOTIFY_LISTENERS);
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(POWERED) && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, state.cycle(POWERED), Block.NOTIFY_LISTENERS);
        }
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        var stack = player.getStackInHand(hand);
        var item = stack.getItem();
        if (item == Items.WATER_BUCKET && !state.get(FILLED)) { // fill sprinkler
            if (!world.isClient) {
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.BUCKET)));
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.with(FILLED, true));
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return ActionResult.success(world.isClient);
        } if (item == Items.BUCKET && state.get(FILLED)) { // empty sprinkler
            if (!world.isClient) {
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.WATER_BUCKET)));
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.with(FILLED, false));
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(POWERED, FILLED);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(POWERED) && state.get(FILLED)) {
            double x = pos.getX()+0.5;
            double y = pos.getY()+0.75;
            double z = pos.getZ()+0.5;
            if (random.nextFloat() < 0.1f) {
                world.playSound(x, y, z, ModSounds.SPRINKLER.sound, SoundCategory.BLOCKS, 0.4f, 1.0f, false);
            }
            for (int i = 0; i < 6; i++) {
                double speed = MathHelper.nextDouble(random, 0.2, 0.5);
                double angle = random.nextDouble() * Math.PI*2.0;
                double sin = Math.sin(angle);
                double cos = Math.cos(angle);
                world.addParticle(ModParticles.SPRINKLE, x+(sin*0.2), y, z+(cos*0.2), sin*speed, 0.2, cos*speed);
            }
        }
    }
    
    static {
        var base = createCuboidShape(0, 0, 0, 16, 6, 16);
        var head = createCuboidShape(4, 6, 4, 12, 12, 12);
        SHAPE = VoxelShapes.union(base, head);
    }
}
