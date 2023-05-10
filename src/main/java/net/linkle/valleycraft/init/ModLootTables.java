package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.loot.LootBuilder;
import net.linkle.valleycraft.util.loot.LootTableHelper;
import net.linkle.valleycraft.util.loot.LootUtils;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.data.server.ChestLootTableGenerator;
import net.minecraft.data.server.EntityLootTableGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext.EntityTarget;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.util.Identifier;

public class ModLootTables {
    
    public static final Identifier WATER_STRAINER = register("water_strainer/loot");
    
    private static final EntityPredicate.Builder NEEDS_ENTITY_ON_FIRE = EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true).build());
    
    public static void initialize() {
        entities();
        chests();
        blocks();
    }
    
    /** {@link EntityLootTableGenerator} for codes. */
    private static void entities() {
        /* Injecting the glow squid with squid sucker loot Example:
        LootBuilder builder = LootBuilder.create();
        builder.rolls(1).with(ItemEntry.builder(MiscItems.SQUID_SUCKER)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );

        LootTableHelper.appendLoot(EntityType.SQUID.getLootTableId(), builder);
        */
        
        LootBuilder builder;
        
        // allay
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.LIFE_GEM)
            .conditionally(RandomChanceLootCondition.builder(0.25f))
        );
        LootTableHelper.appendLoot(EntityType.ALLAY.getLootTableId(), builder);
        
        // bat
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BAT_WING)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
        );
        LootTableHelper.appendLoot(EntityType.BAT.getLootTableId(), builder);
        
        // blaze
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.LIFE_GEM)
            .conditionally(RandomChanceLootCondition.builder(0.15f))
        );
        LootTableHelper.appendLoot(EntityType.BLAZE.getLootTableId(), builder);
        
        // cat
        builder = LootBuilder.create().rolls(0, 1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_HEART).weight(3));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_LIVER).weight(5));
        LootTableHelper.appendLoot(EntityType.CAT.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        LootTableHelper.appendLoot(EntityType.CAT.getLootTableId(), builder);
        
        // cave spider
        builder = LootBuilder.create().rolls(0, 1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_HEART).weight(3));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_LIVER).weight(5));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_CAVE_MAGGOT).weight(7));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_SILVERFISH).weight(7));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_ABYSSWATCHER).weight(5));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BAT_WING).weight(5));
        LootTableHelper.appendLoot(EntityType.CAVE_SPIDER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_TRIPE));
        LootTableHelper.appendLoot(EntityType.CAVE_SPIDER.getLootTableId(), builder);
        
        // chicken
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.METAL_FEATHER)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
            .conditionally(RandomChanceLootCondition.builder(0.25f))
        );
        LootTableHelper.appendLoot(EntityType.CHICKEN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_LIVER)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
        );
        LootTableHelper.appendLoot(EntityType.CHICKEN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        );
        LootTableHelper.appendLoot(EntityType.CHICKEN.getLootTableId(), builder);
        
        // cow
        builder = LootBuilder.create().rolls(0, 1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_HEART).weight(3));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_LIVER).weight(5));
        LootTableHelper.appendLoot(EntityType.COW.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        LootTableHelper.appendLoot(EntityType.COW.getLootTableId(), builder);
        
        // donkey
        builder = LootBuilder.create().rolls(0, 1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_HEART).weight(3));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_LIVER).weight(5));
        LootTableHelper.appendLoot(EntityType.COW.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        LootTableHelper.appendLoot(EntityType.DONKEY.getLootTableId(), builder);
        
        // drowned (still WIP)
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.LIFE_GEM)
            .conditionally(RandomChanceLootCondition.builder(0.25f))
        );
        LootTableHelper.appendLoot(EntityType.DROWNED.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.MONSTER_HEART).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.MONSTER_GUTS).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.MONSTER_LIVER).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_LIVER).weight(3)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(Items.SEAGRASS).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5));
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(8));
        LootTableHelper.appendLoot(EntityType.DROWNED.getLootTableId(), builder);

        //LootBuilder builder_warden = LootBuilder.create();
        //builder_warden.rolls(1).with(ItemEntry.builder(ItemsModded.WARDEN_ANTLER)
        //        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 2)))
        //);
        //builder_warden.rolls(1).with(ItemEntry.builder(ItemsModded.LIFE_GEM)
        //        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 3)))
        //);
        //LootTableHelper.appendLoot(EntityType.WARDEN.getLootTableId(), builder_warden);
        //
        //LootBuilder builder_ender_dragon = LootBuilder.create();
        //builder_ender_dragon.rolls(1).with(ItemEntry.builder(ItemsModded.DRAGON_TOOTH)
        //        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        //);
        //builder_ender_dragon.rolls(1).with(ItemEntry.builder(FoodIngredients.ENDER_DRAGON_EYE)
        //        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
        //);
        //builder_ender_dragon.rolls(1).with(ItemEntry.builder(FoodIngredients.ENDER_DRAGON_GLAND)
        //        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
        //);
        //builder_ender_dragon.rolls(1).with(ItemEntry.builder(FoodIngredients.RAW_ENDERMITE)
        //        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8, 24)))
        //);
        //builder_ender_dragon.rolls(1).with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_HEART)
        //        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 1)))
        //);
        //builder_ender_dragon.rolls(1).with(ItemEntry.builder(ItemsModded.LIFE_GEM)
        //        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6, 6)))
        //);
        //LootTableHelper.appendLoot(EntityType.ENDER_DRAGON.getLootTableId(), builder_ender_dragon);

    }

    /** {@link ChestLootTableGenerator} for codes. */
    private static void chests() {
        //Inject all three mermaid weapons into the large ocean ruin loot table
        /*
        LootTableHelper.appendLoot(LootTables.UNDERWATER_RUIN_BIG_CHEST,
            LootBuilder.create().rolls(1)
            .with(WeaponsAndTools.MERMAIDS_SWORD)
            .with(WeaponsAndTools.MERMAIDS_SPEAR)
            .with(WeaponsAndTools.CORAL_DAGGER)
            //Only 9 in 10 large ocean ruin chests will contain a mermaid weapon
            .conditionally(RandomChanceLootCondition.builder(0.91f))
        ); */
    }

    /** {@link BlockLootTableGenerator} for codes. */
    private static void blocks() {
        
        // When we need to add an item to multiple loot tables, like fiber or worms,
        // first we make a "loot builder" and store it in a variable,
        // then we call it for all of the blocks we want to drop the item.

        //Create fiber loot builder and apply it to grass and tall grass
        /* 
        LootBuilder builder = LootBuilder.create()
            .rolls(1).with(MiscItems.PLANT_FIBER)
            .withCondition(new MatchToolLootCondition(LootUtils.tag(VItemTags.SICKLES))
        );

        LootTableHelper.appendLoot(Blocks.GRASS.getLootTableId(), builder);
        LootTableHelper.appendLoot(Blocks.TALL_GRASS.getLootTableId(), builder);
        */
    }
    
    private static Identifier register(String id) {
        return Main.makeId(id);
    }
}
