package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.LeadItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class RopeBlock extends ChainBlock {
    public RopeBlock(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient && state.get(AXIS) == Direction.Axis.Y) {
            ItemStack itemStack = player.getStackInHand(hand);
            return itemStack.isOf(Items.LEAD) ? ActionResult.SUCCESS : ActionResult.PASS;
        } else {
            return LeadItem.attachHeldMobsToBlock(player, world, pos);
        }
    }
}
