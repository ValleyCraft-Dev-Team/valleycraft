package net.linkle.valleycraft.item;

import net.linkle.valleycraft.extension.ServerPlayerEntityExt;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ReturnItem extends PortalTotemBase {
    public ReturnItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack, World world, LivingEntity user, Hand hand) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (!world.isClient) {

            if (user.hasVehicle()) {
                user.stopRiding();
            }

            if (user instanceof PlayerEntity) {
                ((PlayerEntity)user).getItemCooldownManager().set(this, 20);
                BlockPos pos = ((ServerPlayerEntityExt)user).getWaypointPos();
                if (pos != null) {
                    user.teleport(pos.getX(), pos.getY()+1, pos.getZ(), true);
                    world.emitGameEvent(user,GameEvent.TELEPORT, pos);
                } else {
                    user.sendMessage(Text.translatable("text.valleycraft.waypoint.waypoint_not_set"));
                }
            }
        }
        return UseAction.BLOCK;
    }
}