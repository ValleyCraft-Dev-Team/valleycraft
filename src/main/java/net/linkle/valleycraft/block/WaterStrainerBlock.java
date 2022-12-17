package net.linkle.valleycraft.block;

import java.util.List;

import net.linkle.valleycraft.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class WaterStrainerBlock extends BlockWithWater {
    
    public static final float CHANCE = 0.05f;
    
    public static final BooleanProperty FULL = BooleanProperty.of("full");
    
    public WaterStrainerBlock() {
        super(Settings.of(Material.WOOD).strength(0.5f).nonOpaque().sounds(BlockSoundGroup.SCAFFOLDING));
    }
    
    @Override
    protected BlockState newDefaultState() {
        return super.newDefaultState().with(FULL, false);
    }
    
    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(WATERLOGGED);
    }
    
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextFloat() < CHANCE && !state.get(FULL)) {
            world.setBlockState(pos, state.with(FULL, true), Block.NOTIFY_LISTENERS);
        }
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var state = super.getPlacementState(ctx);
        return state;
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world instanceof ServerWorld server && state.get(FULL)) {
            getLoots(server).forEach(s -> dropStack(world, pos, hit.getSide(), s));
            state = state.with(FULL, false);
            world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));
        }
        return state.get(FULL) ? ActionResult.success(world.isClient) : ActionResult.PASS;
    }
    
    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack) {
        super.afterBreak(world, player, pos, state, blockEntity, stack);
        if (world instanceof ServerWorld server && state.get(FULL)) {
            getLoots(server).forEach(s -> dropStack(world, pos, s));
        }
    }
    
    protected List<ItemStack> getLoots(ServerWorld world) {
        var builder = new LootContext.Builder(world);
        var lootTable = world.getServer().getLootManager().getTable(ModLootTables.WATER_STRAINER);
        return lootTable.generateLoot(builder.build(LootContextTypes.EMPTY));
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FULL));
    }
}
