package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.Tier1Normal;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;

import static net.linkle.valleycraft.init.ModGroups.TIERED_DISHES;

public class ModFishing {
    public static final Item ZOD_BUCKET = new EntityBucketItem(ModEntityType.ZOD, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1));
    public static final Item ZOD = new Tier1Normal(settings().group(ModGroups.INGREDIENTS), 5, 2, StatusEffects.HUNGER);

    public static void initialize() {
        //raw items are registered in IngredientFoodItems
        //cooked items are fully registered in RegularFoodItems or TieredFoodItems
        //buckets
        Reg.register("zod_bucket", ZOD_BUCKET);
    }
    private static Item.Settings settings() {
        return new Item.Settings().group(TIERED_DISHES);
    }
}
