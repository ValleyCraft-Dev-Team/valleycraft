package net.linkle.valleycraft.tool.pickaxes;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;

public class RustyPickaxeItem
extends PickaxeItem
implements EnchantmentHandler {
    public RustyPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(BOOKS));
    }
}
