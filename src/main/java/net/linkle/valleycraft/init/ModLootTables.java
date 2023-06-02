package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.tags.ModItemTags;
import net.linkle.valleycraft.util.loot.LootBuilder;
import net.linkle.valleycraft.util.loot.LootTableHelper;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.data.server.ChestLootTableGenerator;
import net.minecraft.data.server.EntityLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.context.LootContext.EntityTarget;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetPotionLootFunction;
import net.minecraft.loot.function.SetStewEffectLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.predicate.NumberRange.IntRange;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
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
        lifeGem(builder, 0.25f);
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
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.BLAZE.getLootTableId(), builder);
        
        // cat
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.CAT.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.CAT.getLootTableId(), builder);
        
        // cave spider
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
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
        
        // creeper
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.CREEPER_HEAD));
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.075f, 0.01f));
        LootTableHelper.appendLoot(EntityType.CREEPER.getLootTableId(), builder);
        
        // cow
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.COW.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.COW.getLootTableId(), builder);
        
        // donkey
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.DONKEY.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.DONKEY.getLootTableId(), builder);
        
        // drowned
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.25f);
        LootTableHelper.appendLoot(EntityType.DROWNED.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        monster(builder);
        builder.with(ItemEntry.builder(Items.SEAGRASS).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        bones(builder);
        LootTableHelper.appendLoot(EntityType.DROWNED.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.CLOTH)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        );
        builder.with(FoodRegular.HARDTACK);
        builder.with(FoodIngredients.ONION);
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.015f, 0.01f));
        LootTableHelper.appendLoot(EntityType.DROWNED.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(BlocksNatural.HEAD_DROWNED_STEVE);
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.075f, 0.01f));
        LootTableHelper.appendLoot(EntityType.DROWNED.getLootTableId(), builder);
        
        // elder guardian
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.25f);
        LootTableHelper.appendLoot(EntityType.ELDER_GUARDIAN.getLootTableId(), builder);
        
        // enderman
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.ENDERMAN.getLootTableId(), builder);
        
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        bones(builder);
        LootTableHelper.appendLoot(EntityType.ENDERMAN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_ENDERMAN_EYE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.with(ItemEntry.builder(FoodIngredients.RAW_ENDERMITE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.conditionally(KilledByPlayerLootCondition.builder());
        LootTableHelper.appendLoot(EntityType.ENDERMAN.getLootTableId(), builder);
        
        // endermite
        builder = LootBuilder.create().rolls(1);
        builder.with(FoodIngredients.RAW_ENDERMITE);
        LootTableHelper.appendLoot(EntityType.ENDERMITE.getLootTableId(), builder);
        
        // evoker
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.EVOKER.getLootTableId(), builder);
        
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5));
        LootTableHelper.appendLoot(EntityType.EVOKER.getLootTableId(), builder);
        
        // fox
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.FOX.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_CANID)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4), false)) 
            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.FOX.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.FOX.getLootTableId(), builder);
        
        // frog
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4), false)) 
        );
        LootTableHelper.appendLoot(EntityType.FROG.getLootTableId(), builder);
        
        // glow squid
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_GLOWSQUID_TENTACLE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
        );
        LootTableHelper.appendLoot(EntityType.GLOW_SQUID.getLootTableId(), builder);
        
        // goat
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.GOAT.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.GOAT.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(0, 1);
        builder.with(Items.WHITE_WOOL);
        LootTableHelper.appendLoot(EntityType.GOAT.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.MUTTON)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
                .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
                .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
        );
        LootTableHelper.appendLoot(EntityType.GOAT.getLootTableId(), builder);
        
        // guardian
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.GUARDIAN.getLootTableId(), builder);
        
        // hoglin
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.HOGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.HOGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.PIG_HIDE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 3), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.HOGLIN.getLootTableId(), builder);
        
        // horse
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.HORSE.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.HORSE.getLootTableId(), builder);
        
        // husk
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.HUSK.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        monster(builder);
        builder.with(ItemEntry.builder(Items.SAND).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.HUSK.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.HUSK.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.GOLD_INGOT);
        builder.with(FoodRegular.CORN_BREAD);
        builder.with(FoodIngredients.PURIFIED_WATER);
        builder.with(FoodRegular.HARDTACK);
        builder.with(FoodIngredients.FIRE_PEPPER);
        builder.with(FoodIngredients.ONION);
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.15f, 0.01f));
        LootTableHelper.appendLoot(EntityType.HUSK.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(BlocksNatural.HEAD_HUSK_STEVE);
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.075f, 0.01f));
        LootTableHelper.appendLoot(EntityType.HUSK.getLootTableId(), builder);
        
        // illusioner
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.ILLUSIONER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        LootTableHelper.appendLoot(EntityType.ILLUSIONER.getLootTableId(), builder);
        
        // iron golem
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.65f);
        LootTableHelper.appendLoot(EntityType.IRON_GOLEM.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.IRON_SCRAP)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 8), false))
        );
        LootTableHelper.appendLoot(EntityType.IRON_GOLEM.getLootTableId(), builder);
        
        // llama
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.LLAMA.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.LLAMA.getLootTableId(), builder);
        
        // mooshroom
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.MOOSHROOM.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.MOOSHROOM.getLootTableId(), builder);
        
        // mule
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.MULE.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.MULE.getLootTableId(), builder);
        
        // ocelot
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.OCELOT.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.OCELOT.getLootTableId(), builder);
        
        // panda
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.PANDA.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.PANDA.getLootTableId(), builder);
        
        // parrot
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BIRD_THIGH)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
        );
        LootTableHelper.appendLoot(EntityType.PARROT.getLootTableId(), builder);
        
        // phantom
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.25f);
        LootTableHelper.appendLoot(EntityType.PHANTOM.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_PHANTOM_EYE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        );
        builder.conditionally(KilledByPlayerLootCondition.builder());
        LootTableHelper.appendLoot(EntityType.PHANTOM.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))            
        );
        LootTableHelper.appendLoot(EntityType.PHANTOM.getLootTableId(), builder);
        
        // pig
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.PIG.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(0, 1);
        builder.with(ItemEntry.builder(ItemsModded.PIG_HIDE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.PIG.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.PIG.getLootTableId(), builder);
        
        // piglin brute
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.PIGLIN_BRUTE.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        LootTableHelper.appendLoot(EntityType.PIGLIN_BRUTE.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.GOLD_SCRAP)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.PIGLIN_BRUTE.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.GOLD_INGOT);
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.025f, 0.01f));
        LootTableHelper.appendLoot(EntityType.PIGLIN_BRUTE.getLootTableId(), builder);
        
        // piglin
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.25f);
        LootTableHelper.appendLoot(EntityType.PIGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        LootTableHelper.appendLoot(EntityType.PIGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.TREATED_LEATHER)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.PIGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.GOLD_SCRAP)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.PIGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.GOLD_INGOT);
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.025f, 0.01f));
        LootTableHelper.appendLoot(EntityType.PIGLIN.getLootTableId(), builder);
        
        // pillager
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.PILLAGER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        LootTableHelper.appendLoot(EntityType.PILLAGER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        builder.with(ItemEntry.builder(ItemsModded.ARROW_BUNDLE).weight(1)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.with(ItemEntry.builder(Items.ARROW).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.PILLAGER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        builder.with(ItemEntry.builder(Items.GOAT_HORN).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.with(ItemEntry.builder(Items.EMERALD).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.PILLAGER.getLootTableId(), builder);
        
        // player
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.PLAYER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        LootTableHelper.appendLoot(EntityType.PLAYER.getLootTableId(), builder);
        
        // polar bear
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.POLAR_BEAR.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.POLAR_BEAR.getLootTableId(), builder);
        
        // rabbit
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.RABBIT.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        LootTableHelper.appendLoot(EntityType.RABBIT.getLootTableId(), builder);
        
        // ravager
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.65f);
        LootTableHelper.appendLoot(EntityType.RAVAGER.getLootTableId(), builder);
        
        // sheep
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.SHEEP.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.SHEEP.getLootTableId(), builder);
        
        // silverfish
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_SILVERFISH)
            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
        );
        LootTableHelper.appendLoot(EntityType.SILVERFISH.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        LootTableHelper.appendLoot(EntityType.SILVERFISH.getLootTableId(), builder);
        
        // skeleton horse
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.SKELETON_HORSE.getLootTableId(), builder);
        
        // skeleton
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.SKELETON.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(8));
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(4)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
        );
        LootTableHelper.appendLoot(EntityType.SKELETON.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.ARROW_BUNDLE).weight(7));
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.02f, 0.01f));
        LootTableHelper.appendLoot(EntityType.SKELETON.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.SKELETON_SKULL);
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.1f, 0.1f));
        LootTableHelper.appendLoot(EntityType.SKELETON.getLootTableId(), builder);
        
        // snow golem
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.SNOW_GOLEM.getLootTableId(), builder);
        
        // spider
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_CAVE_MAGGOT).weight(7));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_SILVERFISH).weight(7));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_ABYSSWATCHER).weight(5));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BAT_WING).weight(5));
        LootTableHelper.appendLoot(EntityType.SPIDER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_TRIPE));
        LootTableHelper.appendLoot(EntityType.SPIDER.getLootTableId(), builder);
        
        // squid
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_SQUID_TENTACLE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
        );
        LootTableHelper.appendLoot(EntityType.SQUID.getLootTableId(), builder);
        
        // stray
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.STRAY.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(8));
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(4)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
        );
        LootTableHelper.appendLoot(EntityType.STRAY.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.ARROW_BUNDLE).weight(7));
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.02f, 0.01f));
        LootTableHelper.appendLoot(EntityType.STRAY.getLootTableId(), builder);
        
        // strider
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.STRIDER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.STRIDER.getLootTableId(), builder);
        
        // trader llama
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.TRADER_LLAMA.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.TRADER_LLAMA.getLootTableId(), builder);
        
        // turtle
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.TURTLE.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.TURTLE.getLootTableId(), builder);
        
        // vex
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.25f);
        LootTableHelper.appendLoot(EntityType.VEX.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.PHANTOM_MEMBRANE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.conditionally(KilledByPlayerLootCondition.builder());
        LootTableHelper.appendLoot(EntityType.VEX.getLootTableId(), builder);
        
        // villager
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.VILLAGER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.TOTEM_OF_TRADE)
            .conditionally(RandomChanceLootCondition.builder(0.1f)
                    )
        );
        builder.with(ItemEntry.builder(ItemsModded.TOTEM_OF_PACIFISM)
            .conditionally(RandomChanceLootCondition.builder(0.5f))
        );
        LootTableHelper.appendLoot(EntityType.VILLAGER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        LootTableHelper.appendLoot(EntityType.VILLAGER.getLootTableId(), builder);
        
        // vindicator
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.VINDICATOR.getLootTableId(), builder);
        
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        LootTableHelper.appendLoot(EntityType.VINDICATOR.getLootTableId(), builder);
        
        // wandering trader
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.WANDERING_TRADER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        LootTableHelper.appendLoot(EntityType.WANDERING_TRADER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.MILK_BUCKET)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))            
        );
        builder.with(ItemEntry.builder(Items.POTION)
            .apply(SetPotionLootFunction.builder(Potions.INVISIBILITY))
            .conditionally(RandomChanceLootCondition.builder(0.35f))
        );
        LootTableHelper.appendLoot(EntityType.WANDERING_TRADER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.TOTEM_OF_TRADE)
            .conditionally(RandomChanceLootCondition.builder(0.1f))
        );
        builder.with(ItemEntry.builder(ItemsModded.TOTEM_OF_PACIFISM)
            .conditionally(RandomChanceLootCondition.builder(0.25f))
        );
        LootTableHelper.appendLoot(EntityType.WANDERING_TRADER.getLootTableId(), builder);
        
        // witch
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.35f);
        LootTableHelper.appendLoot(EntityType.WITCH.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(8)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))   
        );
        LootTableHelper.appendLoot(EntityType.WITCH.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.EMERALD)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.conditionally(KilledByPlayerLootCondition.builder());
        LootTableHelper.appendLoot(EntityType.WITCH.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(0, 1);
        builder.with(ItemEntry.builder(Items.SUSPICIOUS_STEW)
            .apply(SetStewEffectLootFunction.builder().withEffect(StatusEffects.BLINDNESS, UniformLootNumberProvider.create(5*20, 7*20)))
        );
        builder.with(ItemEntry.builder(Items.SUSPICIOUS_STEW)
            .apply(SetStewEffectLootFunction.builder().withEffect(StatusEffects.JUMP_BOOST, UniformLootNumberProvider.create(7*20, 10*20)))
        );
        builder.with(ItemEntry.builder(Items.SUSPICIOUS_STEW)
            .apply(SetStewEffectLootFunction.builder().withEffect(StatusEffects.NIGHT_VISION, UniformLootNumberProvider.create(7*20, 10*20)))
        );
        builder.with(ItemEntry.builder(Items.SUSPICIOUS_STEW)
            .apply(SetStewEffectLootFunction.builder().withEffect(StatusEffects.POISON, UniformLootNumberProvider.create(10*20, 20*20)))
        );
        builder.with(ItemEntry.builder(Items.SUSPICIOUS_STEW)
            .apply(SetStewEffectLootFunction.builder().withEffect(StatusEffects.SATURATION, UniformLootNumberProvider.create(7*20, 10*20)))
        );
        builder.with(ItemEntry.builder(Items.SUSPICIOUS_STEW)
            .apply(SetStewEffectLootFunction.builder().withEffect(StatusEffects.WEAKNESS, UniformLootNumberProvider.create(6*20, 8*20)))
        );
        LootTableHelper.appendLoot(EntityType.WITCH.getLootTableId(), builder);
        
        // wither skeleton
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.COAL_NUGGET).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.with(ItemEntry.builder(ItemsModded.COAL_NUGGET).weight(1)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.WITHER_SKELETON.getLootTableId(), builder);
        
        // wither
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.LIFE_GEM)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3)))
        );
        LootTableHelper.appendLoot(EntityType.WITHER.getLootTableId(), builder);
        
        // wolf
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.WOLF.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_CANID)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE)))
        );
        LootTableHelper.appendLoot(EntityType.WOLF.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.WOLF.getLootTableId(), builder);
        
        // hoglin
        builder = LootBuilder.create().rolls(0, 1);
        rawBeasts(builder);
        LootTableHelper.appendLoot(EntityType.HOGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.HOGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.PIG_HIDE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 3), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        LootTableHelper.appendLoot(EntityType.HOGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.MONSTER_HEART).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.MONSTER_GUTS).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.MONSTER_LIVER).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_LIVER).weight(3)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_HEART).weight(3)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_GUTS).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2), false))
        );
        LootTableHelper.appendLoot(EntityType.HOGLIN.getLootTableId(), builder);
        
        // zombie horse
        builder = LootBuilder.create().rolls(0, 1);
        builder.with(ItemEntry.builder(FoodIngredients.MONSTER_HEART).weight(3)
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
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_HEART).weight(3)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_GUTS).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2), false))
        );
        LootTableHelper.appendLoot(EntityType.ZOMBIE_HORSE.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(0, 1);
        bones(builder);
        LootTableHelper.appendLoot(EntityType.ZOMBIE_HORSE.getLootTableId(), builder);
        
        // zombie villager
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.ZOMBIE_VILLAGER.getLootTableId(), builder);
        
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
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_HEART).weight(3)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_GUTS).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
        );
        builder.with(ItemEntry.builder(Items.DIRT).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5));
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        LootTableHelper.appendLoot(EntityType.ZOMBIE_VILLAGER.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.CLOTH)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2), false))
        );
        builder.with(ItemEntry.builder(Items.EMERALD));
        builder.with(ItemEntry.builder(Items.BREAD));
        builder.with(ItemEntry.builder(FoodRegular.HARDTACK));
        builder.with(ItemEntry.builder(FoodIngredients.PURIFIED_WATER));
        builder.with(ItemEntry.builder(FoodIngredients.PUMPKIN_SLICE));
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.025f, 0.01f));
        LootTableHelper.appendLoot(EntityType.ZOMBIE_VILLAGER.getLootTableId(), builder);
        
        // zombie
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.ZOMBIE.getLootTableId(), builder);
        
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
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_HEART).weight(3)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_GUTS).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
        );
        builder.with(ItemEntry.builder(Items.DIRT).weight(5)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
            .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5));
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.CLOTH)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2), false))
        );
        builder.with(ItemEntry.builder(Items.EMERALD));
        builder.with(ItemEntry.builder(Items.BREAD));
        builder.with(ItemEntry.builder(FoodRegular.HARDTACK));
        builder.with(ItemEntry.builder(FoodIngredients.PURIFIED_WATER));
        builder.with(ItemEntry.builder(FoodIngredients.PUMPKIN_SLICE));
        builder.with(ItemEntry.builder(FoodIngredients.CAVE_ROOT));
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.025f, 0.01f));
        LootTableHelper.appendLoot(EntityType.ZOMBIE.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(Items.ZOMBIE_HEAD));
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.075f, 0.01f));
        LootTableHelper.appendLoot(EntityType.ZOMBIE.getLootTableId(), builder);
        
        // zombified piglin
        builder = LootBuilder.create().rolls(1);
        lifeGem(builder, 0.15f);
        LootTableHelper.appendLoot(EntityType.ZOMBIFIED_PIGLIN.getLootTableId(), builder);
        
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
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_HEART).weight(3)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_GUTS).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(ItemsModded.SKULL_SHARD).weight(3)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5));
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        LootTableHelper.appendLoot(EntityType.ZOMBIFIED_PIGLIN.getLootTableId(), builder);
        
        builder.with(ItemEntry.builder(FoodRegular.NETHER_WART_STIR_FRY));
        builder.with(ItemEntry.builder(FoodRegular.MAGMA_CREME_SOUP));
        builder.with(ItemEntry.builder(ItemsModded.GOLD_SCRAP)
           .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2), false))
           .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
        );
        builder.conditionally(KilledByPlayerLootCondition.builder());
        builder.conditionally(RandomChanceWithLootingLootCondition.builder(0.3f, 0.01f));
        LootTableHelper.appendLoot(EntityType.ZOMBIFIED_PIGLIN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.rolls(1).with(ItemEntry.builder(ItemsModded.WARDEN_ANTLER)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)))
        );
        
        // warden
        LootTableHelper.appendLoot(EntityType.WARDEN.getLootTableId(), builder);
        builder = LootBuilder.create().rolls(1);
        builder.rolls(1).with(ItemEntry.builder(ItemsModded.LIFE_GEM)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3)))
        );
        LootTableHelper.appendLoot(EntityType.WARDEN.getLootTableId(), builder);
        
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.DRAGON_TOOTH)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
        );
        
        // ender dragon
        LootTableHelper.appendLoot(EntityType.ENDER_DRAGON.getLootTableId(), builder);
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.ENDER_DRAGON_EYE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
        );
        LootTableHelper.appendLoot(EntityType.ENDER_DRAGON.getLootTableId(), builder);
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.ENDER_DRAGON_GLAND)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
        );
        LootTableHelper.appendLoot(EntityType.ENDER_DRAGON.getLootTableId(), builder);
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.RAW_ENDERMITE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8, 24)))
        );
        LootTableHelper.appendLoot(EntityType.ENDER_DRAGON.getLootTableId(), builder);
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_HEART)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
        );
        LootTableHelper.appendLoot(EntityType.ENDER_DRAGON.getLootTableId(), builder);
        builder = LootBuilder.create().rolls(1);
        builder.with(ItemEntry.builder(ItemsModded.LIFE_GEM)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6)))
        );
        LootTableHelper.appendLoot(EntityType.ENDER_DRAGON.getLootTableId(), builder);
        

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
        
        LootBuilder builder;
        
        // amethyst_cluster
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.AMETHYST_CLUSTER);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Tools.ANTHROPOLOGISTS_ROCK_PICK)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.AMETHYST_CLUSTER.getLootTableId(), builder);
        
        // blue ice
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.BLUE_ICE);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Tools.ICE_TONGS)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.BLUE_ICE.getLootTableId(), builder);
        
        // bookshelf
        builder = LootBuilder.create().rolls(1);
        builder.with(BlocksModded.EMPTY_BOOKSHELF);
        LootTableHelper.appendLoot(Blocks.BOOKSHELF.getLootTableId(), builder);
        
        // brain coral block
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.BRAIN_CORAL_BLOCK);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.BRAIN_CORAL_BLOCK.getLootTableId(), builder);
        
        // brain coral fan
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.BRAIN_CORAL_FAN);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.BRAIN_CORAL_FAN.getLootTableId(), builder);
        
        // brain coral
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.BRAIN_CORAL);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.BRAIN_CORAL.getLootTableId(), builder);
        
        // bubble coral block
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.BUBBLE_CORAL_BLOCK);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.BUBBLE_CORAL_BLOCK.getLootTableId(), builder);
        
        // bubble coral fan
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.BUBBLE_CORAL_FAN);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.BUBBLE_CORAL_FAN.getLootTableId(), builder);
        
        // bubble coral
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.BUBBLE_CORAL);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.BUBBLE_CORAL.getLootTableId(), builder);
        
        // fire coral block
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.FIRE_CORAL_BLOCK);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.FIRE_CORAL_BLOCK.getLootTableId(), builder);
        
        // fire coral fan
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.FIRE_CORAL_FAN);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.FIRE_CORAL_FAN.getLootTableId(), builder);
        
        // fire coral
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.FIRE_CORAL);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.FIRE_CORAL.getLootTableId(), builder);
        
        // horn coral block
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.HORN_CORAL_BLOCK);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.HORN_CORAL_BLOCK.getLootTableId(), builder);
        
        // horn coral fan
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.HORN_CORAL_FAN);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.HORN_CORAL_FAN.getLootTableId(), builder);
        
        // horn coral
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.HORN_CORAL);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.HORN_CORAL.getLootTableId(), builder);
        
        // ice
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.ICE);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Tools.ICE_TONGS)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.ICE.getLootTableId(), builder);
        
        // large amethyst bud
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.LARGE_AMETHYST_BUD);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Tools.ANTHROPOLOGISTS_ROCK_PICK)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.LARGE_AMETHYST_BUD.getLootTableId(), builder);
        
        // medium amethyst bud
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.MEDIUM_AMETHYST_BUD);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Tools.ANTHROPOLOGISTS_ROCK_PICK)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.MEDIUM_AMETHYST_BUD.getLootTableId(), builder);
        
        // packed ice
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.PACKED_ICE);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Tools.ICE_TONGS)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.PACKED_ICE.getLootTableId(), builder);
        
        // small amethyst bud
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.SMALL_AMETHYST_BUD);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Tools.ANTHROPOLOGISTS_ROCK_PICK)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.SMALL_AMETHYST_BUD.getLootTableId(), builder);
        
        // spawner
        builder = LootBuilder.create().rolls(1);
        builder.with(BlocksModded.DEFECTIVE_SPAWNER);
        builder.conditionally(SurvivesExplosionLootCondition.builder());
        LootTableHelper.appendLoot(Blocks.SPAWNER.getLootTableId(), builder);
        
        // tube coral block
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.TUBE_CORAL_BLOCK);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.TUBE_CORAL_BLOCK.getLootTableId(), builder);
        
        // tube coral fan
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.TUBE_CORAL_FAN);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.TUBE_CORAL_FAN.getLootTableId(), builder);
        
        // tube coral
        builder = LootBuilder.create().rolls(1);
        builder.with(Items.TUBE_CORAL);
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(ModItemTags.CORAL_KNIFE)));
        builder.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, IntRange.atLeast(1)))).invert());
        LootTableHelper.appendLoot(Blocks.TUBE_CORAL.getLootTableId(), builder);
    }
    
    // common loots start
    
    private static void lifeGem(LootBuilder builder, float chance) {
        builder.with(ItemEntry.builder(ItemsModded.LIFE_GEM)
            .conditionally(RandomChanceLootCondition.builder(chance))
        );
    }
    
    private static void bones(LootBuilder builder) {
        builder.with(ItemEntry.builder(Items.BONE_MEAL).weight(10)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))            
        );
        builder.with(ItemEntry.builder(ItemsModded.BEAST_BONE).weight(8)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
        builder.with(ItemEntry.builder(Items.BONE).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))   
        );
    }
    
    private static void rawBeasts(LootBuilder builder) {
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_HEART).weight(3));
        builder.with(ItemEntry.builder(FoodIngredients.RAW_BEAST_LIVER).weight(5));
    }
    
    private static void monster(LootBuilder builder) {
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
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_HEART).weight(3)
            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1), false))
        );
        builder.with(ItemEntry.builder(FoodIngredients.INFECTED_MONSTER_GUTS).weight(5)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1), false))
        );
    }
    
    // common loots end
    
    private static Identifier register(String id) {
        return Main.makeId(id);
    }
}
