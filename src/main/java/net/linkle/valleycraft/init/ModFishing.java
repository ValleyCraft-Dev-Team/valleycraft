package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.entity.EntityType.SLIME;

public enum ModFishing implements ItemEnum {
    STONEROLLER_MINNOW_BUCKET(new EntityBucketItem(ModEntityType.STONEROLLER_MINNOW.type(), Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1))),
    ABYSSWATCHER_BUCKET(new EntityBucketItem(ModEntityType.ABYSSWATCHER.type(), Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1))),
    RED_PORGY_BUCKET(new EntityBucketItem(ModEntityType.RED_PORGY.type(), Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1))),
    SARDINE_BUCKET(new EntityBucketItem(ModEntityType.SARDINE.type(), Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1))),
    PERCH_BUCKET(new EntityBucketItem(ModEntityType.PERCH.type(), Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1))),

    //TODO fix zod eyes they look dumb
    ZOD_BUCKET(new EntityBucketItem(ModEntityType.ZOD.type(), Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1))),
    BONEFIN_BUCKET(new EntityBucketItem(ModEntityType.BONEFIN.type(), Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().group(ModGroups.VC_ITEMS).maxCount(1)));

    //TODO add Flounder? or 1.1?
    public static void initialize() {
        //raw items are registered in IngredientFoodItems
        //cooked items are fully registered in RegularFoodItems or TieredFoodItems
    }
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    // @param register the item
    ModFishing(Item item) {
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
