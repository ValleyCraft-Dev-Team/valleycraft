package net.linkle.valleycraft.block;

import java.util.Map;

import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;

public class RainCollectorBlock extends AbstractCauldronBlock {
    
    public static final float CHANCE = 0.1f;

    public static final VoxelShape RAYCAST_SHAPE = createCuboidShape(2, 2, 2, 14, 16, 14);
    public static final VoxelShape OUTLINE_SHAPE = VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(), RAYCAST_SHAPE, BooleanBiFunction.ONLY_FIRST);
            
    public RainCollectorBlock(Settings settings) {
        super(settings, Map.of());
    }
    
    public static boolean canFill(World world) {
        return world.getRandom().nextFloat() < CHANCE;
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.isOf(Items.WATER_BUCKET)) {
            if (!world.isClient) {
                Item item = stack.getItem();
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.BUCKET)));
                //player.incrementStat(Stats.FILL_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, ModBlocks.LEVELED_RAIN_COLLECTOR.getState().with(LeveledCauldronBlock.LEVEL, 3));
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return ActionResult.success(world.isClient);
        }
        if (stack.isOf(Items.POTION)) {
            if (PotionUtil.getPotion(stack) != Potions.WATER) {
                return ActionResult.PASS;
            }
            if (!world.isClient) {
                Item item = stack.getItem();
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                //player.incrementStat(Stats.USE_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, ModBlocks.LEVELED_RAIN_COLLECTOR.getState());
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPE;
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return RAYCAST_SHAPE;
    }

    @Override
    public boolean isFull(BlockState state) {
        return false;
    }

    @Override
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN && canFill(world)) {
            world.setBlockState(pos, ModBlocks.LEVELED_RAIN_COLLECTOR.getState());
            world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, pos);
        }
    }

    @Override
    protected boolean canBeFilledByDripstone(Fluid fluid) {
        return true;
    }

    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {
        if (fluid == Fluids.WATER) {
            BlockState blockState = Blocks.WATER_CAULDRON.getDefaultState();
            world.setBlockState(pos, blockState);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
            world.syncWorldEvent(WorldEvents.POINTED_DRIPSTONE_DRIPS_WATER_INTO_CAULDRON, pos, 0);
        }
    }
}
