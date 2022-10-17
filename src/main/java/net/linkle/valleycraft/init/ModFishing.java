package net.linkle.valleycraft.init;

import net.linkle.valleycraft.util.Reg;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundEvents;

public enum ModFishing implements ItemConvertible {
    ZOD_BUCKET(new EntityBucketItem(ModEntityType.ZOD, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1)));

    public static void initialize() {
        //raw items are registered in IngredientFoodItems
        //cooked items are fully registered in RegularFoodItems or TieredFoodItems
    }
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    
    /** @param register the item */
    ModFishing(Item item) {
        this.item = Reg.register(name().toLowerCase(), item);
    }
    
    @Override
    public Item asItem() {
        return item;
    }
}
