package net.linkle.valleycraft.tool.knife.special;

import net.linkle.valleycraft.init.ModGroups;
import net.linkle.valleycraft.tool.knife.KnifeBase;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class CoralDaggerItem
extends KnifeBase {
    public CoralDaggerItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Item.Settings().group(ModGroups.VC_TOOLS).rarity(Rarity.RARE));
    }

    //Make the coral dagger accept Impaling
    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.IMPALING);
    }
}
