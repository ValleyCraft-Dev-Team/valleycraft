package net.linkle.valleycraft.item;

import org.jetbrains.annotations.Nullable;

import net.linkle.valleycraft.extension.ServerPlayerEntityExt;
import net.linkle.valleycraft.init.ModBlocks;
import net.linkle.valleycraft.network.ServerNetwork;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ReturnItem extends ModItem {
    
    public static final String WAYPOINT_NOT_SET = "text.valleycraft.waypoint.waypoint_not_set";
    public static final String WAYPOINT_FAILED = "text.valleycraft.waypoint.waypoint_failed";
    
    public ReturnItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity player = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        if (player instanceof ServerPlayerEntity serverPlayer) {
            Criteria.CONSUME_ITEM.trigger(serverPlayer, stack);
        }

        if (player != null) {
            player.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }

        return stack.isEmpty() ? ItemStack.EMPTY : stack;
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            BlockPos pos = ((ServerPlayerEntityExt)user).getWaypointPos();
            if (pos != null) {
                
                pos = getTeleportPos(world, pos);
                if (pos == null) {
                    user.sendMessage(Text.translatable(WAYPOINT_FAILED));
                    return TypedActionResult.fail(stack);
                }
                
                if (user.hasVehicle()) {
                    user.stopRiding();
                }
                
                if (user.teleport(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5, true)) {
                    user.getItemCooldownManager().set(this, 30);
                    ServerNetwork.sendFloatingItem((ServerPlayerEntity)user, stack);
                    world.playSound(null, pos.getX()+0.5, user.getY()+0.5, user.getZ()+0.5, SoundEvents.BLOCK_PORTAL_TRAVEL, user.getSoundCategory(), 0.3f, 1f);
                    world.emitGameEvent(GameEvent.TELEPORT, pos, GameEvent.Emitter.of(user));
                    return ItemUsage.consumeHeldItem(world, user, hand);
                } else {
                    user.sendMessage(Text.translatable(WAYPOINT_FAILED));
                }
            } else {
                user.sendMessage(Text.translatable(WAYPOINT_NOT_SET));
            }
        }
        return TypedActionResult.fail(stack);
    }
    
    @Nullable
    private static BlockPos getTeleportPos(World world, BlockPos pos) {
        if (world.getBlockState(pos).isOf(ModBlocks.WAYPOINT.block)) {
            for (var face : Direction.values()) {
                if (face == Direction.DOWN) continue;
                BlockPos offset = pos.offset(face);
                var state = world.getBlockState(offset);
                if (!state.getMaterial().blocksMovement()) {
                    return offset;
                }
            }
        }
        return null;
    }
}