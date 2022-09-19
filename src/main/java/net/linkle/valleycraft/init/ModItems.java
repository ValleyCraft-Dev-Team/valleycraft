package net.linkle.valleycraft.init;

import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import static net.linkle.valleycraft.init.ModGroups.INGREDIENTS;

public class ModItems {

    public static final Item GLOOM_BERRY = new AliasedBlockItem(ModBlocks.GLOOM_BERRY, itemSettings().food(FoodComponents.GLOW_BERRIES).group(INGREDIENTS));
    public static final Item SALT = new Item(itemSettings());
    
    public static void initialize() {
        Reg.register("gloom_berry", GLOOM_BERRY);
        Reg.register("salt", SALT);
        
        TieredFoodItems.initialize();
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(INGREDIENTS);
    }
}
