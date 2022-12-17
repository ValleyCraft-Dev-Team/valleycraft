package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.loot.LootBuilder;
import net.linkle.valleycraft.util.loot.LootTableHelper;
import net.linkle.valleycraft.util.loot.LootUtils;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.ChestLootTableGenerator;
import net.minecraft.data.server.EntityLootTableGenerator;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.util.Identifier;

public class ModLootTables {
    public static final Identifier WATER_STRAINER = register("water_strainer/loot");
    
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
