package net.linkle.valleycraft.tool.sword.special;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class CaveFisherSwordItem
extends SwordItem
implements EnchantmentHandler {
    public CaveFisherSwordItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(BOOKS).rarity(Rarity.UNCOMMON));
    }

    //Make the sword accept Impaling
    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.IMPALING);
    }
}
