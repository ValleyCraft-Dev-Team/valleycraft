package net.linkle.valleycraft.tool.sword.special;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;

import java.util.List;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class BrokenSeagerCutlassItem
extends SwordItem
implements EnchantmentHandler {
    public BrokenSeagerCutlassItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(BOOKS));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.valley.broken.tooltip").formatted(Formatting.GRAY));
    }

    //Make the sword accept Impaling
    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.IMPALING);
    }
}
