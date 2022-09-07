package net.linkle.floracore.init;

import net.linkle.floracore.util.Reg;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ModItems {

    public static final Item GLOOM_BERRY = new AliasedBlockItem(ModBlocks.GLOOM_BERRY, itemSettings().food(FoodComponents.GLOW_BERRIES).group(ItemGroup.FOOD));
    
    public static void initialize() {
        Reg.register("gloom_berry", GLOOM_BERRY);
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(ModGroups.FLORA_GROUP);
    }
}
