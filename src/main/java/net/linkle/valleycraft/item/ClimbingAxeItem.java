package net.linkle.valleycraft.item;

import net.linkle.valleycraft.extension.LivingEntityExt;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;

public class ClimbingAxeItem extends ToolItem {
    
    /** The lower the value, the quicker the item takes damage. */
    private static final int TICK_DAMAGE = 12;
    
    public ClimbingAxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && world.getServer().getTicks()%TICK_DAMAGE == 0 && 
            !entity.isOnGround() && entity instanceof LivingEntity living) {
            var livingExt = (LivingEntityExt)living;
            if(livingExt.isAxeClimbing() && livingExt.isYmoved()) {
                var hand = living.getMainHandStack().getItem() instanceof ClimbingAxeItem ? Hand.MAIN_HAND : Hand.OFF_HAND;
                var axe = hand == Hand.MAIN_HAND ? living.getMainHandStack() : living.getOffHandStack();
                axe.damage(1, living, e -> {
                    living.sendEquipmentBreakStatus(hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                });
            }
        }
    }
}
