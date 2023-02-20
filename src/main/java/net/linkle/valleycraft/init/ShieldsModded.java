package net.linkle.valleycraft.init;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum ShieldsModded implements ItemEnum {
    //Vanilla Stats: 336 durability cooldownticks 10 enchantability 15 repairitem iron_ingot
    BUCKLER(new FabricShieldItem(new FabricItemSettings().maxDamage(224).group(Groups.VC_TOOLS), 3*20, 15, Items.IRON_INGOT));

    public static void initialize() {

    }

    public final Item item;
    public final Identifier id;

    ShieldsModded(Item item) {
        this.item = Registry.register(Registry.ITEM, id = Main.makeId(name().toLowerCase()), item);
    }

    @Override
    public Item asItem() {
        return item;
    }

    @Override
    public Identifier getId() {
        return id;
    }
}
