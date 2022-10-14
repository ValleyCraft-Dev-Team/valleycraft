package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModParticles;
import net.linkle.valleycraft.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
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
    
    public static final BooleanProperty SPRINKLING = BooleanProperty.of("sprinkling");
    
    protected static final VoxelShape SHAPE;

    public SprinklerBlock() {
        super(Settings.of(Material.METAL, MapColor.STONE_GRAY).strength(3.0f).sounds(BlockSoundGroup.STONE).nonOpaque());
        setDefaultState(stateManager.getDefaultState().with(SPRINKLING, false));
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        var stack = player.getStackInHand(hand);
        var item = stack.getItem();
        if (item == Items.WATER_BUCKET && !state.get(SPRINKLING)) { // fill sprinkler
            if (!world.isClient) {
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.BUCKET)));
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.with(SPRINKLING, true));
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return ActionResult.success(world.isClient);
        } if (item == Items.BUCKET && state.get(SPRINKLING)) { // empty sprinkler
            if (!world.isClient) {
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.WATER_BUCKET)));
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, state.with(SPRINKLING, false));
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
        builder.add(SPRINKLING);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(SPRINKLING)) {
            double x = pos.getX()+0.5;
            double y = pos.getY()+0.75;
            double z = pos.getZ()+0.5;
            if (random.nextFloat() < 0.1f) {
                world.playSound(x, y, z, ModSounds.SPRINKLER, SoundCategory.BLOCKS, 0.4f, 1.0f, false);
            }
            for (int i = 0; i < 6; i++) {
                double speed = MathHelper.nextDouble(random, 0.2, 0.5);
                double angle = random.nextDouble() * Math.PI*2.0;
                double sin = Math.sin(angle);
                double cos = Math.cos(angle);
                world.addParticle(ModParticles.SPRINKLE, x+(sin*0.2f), y, z+(cos*0.2f), sin*speed, 0.2, cos*speed);
            }
        }
    }
    
    static {
        var base = createCuboidShape(0, 0, 0, 16, 6, 16);
        var head = createCuboidShape(4, 6, 4, 12, 12, 12);
        SHAPE = VoxelShapes.union(base, head);
    }
}
