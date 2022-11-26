package net.linkle.valleycraft.tool.knife.special;

import net.linkle.valleycraft.tool.knife.KnifeBase;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;

public class CoralDaggerItem
extends KnifeBase {
    public CoralDaggerItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Item.Settings().group(BOOKS).rarity(Rarity.RARE));
    }

    //Make the coral dagger accept Impaling
    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.IMPALING);
    }
}
