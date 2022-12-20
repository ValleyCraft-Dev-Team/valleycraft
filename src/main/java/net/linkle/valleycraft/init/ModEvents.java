package net.linkle.valleycraft.init;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.linkle.valleycraft.interfaces.PreventDestroy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

/**
 * This class is where you register your listeners. When creating a new method for it to be registered, the method should be
 * named [event's class name]_[event's method name]. Check {@link ModEvents#initialize}
 */
public class ModEvents {

    public static void initialize() {
        // Here's the registering method field - this is where you put your registry like below.
        // You will get an idea from it. Explaining codes is too hard for me - AndEditor7
        AttackEntityCallback.EVENT.register(ModEvents::AttackEntityCallback_interact);
    }

    /** see {@link AttackEntityCallback} */
    private static ActionResult AttackEntityCallback_interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        var stack = player.getStackInHand(hand);
        if (stack.getItem() instanceof PreventDestroy && !PreventDestroy.isUsable(stack)) {
            return ActionResult.FAIL;
        }
        return ActionResult.PASS;
    }
}
