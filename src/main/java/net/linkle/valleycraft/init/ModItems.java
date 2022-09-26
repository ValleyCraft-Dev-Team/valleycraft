package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.FoodItem;
import net.linkle.valleycraft.item.SalveItem;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static net.linkle.valleycraft.init.ModGroups.*;

public class ModItems {

    //ingredients
    public static final Item SALT = new Item(itemSettings());
    public static final Item FLOUR = new Item(itemSettings());

    //misc
    public static final Item FIBER = new Item(itemSettings().group(ITEMS));
    public static final Item COVER = new Item(itemSettings().group(ITEMS));
    public static final Item MULCH = new Item(itemSettings().group(ITEMS));
    public static final Item CROWS_FEATHER = new Item(itemSettings().group(ITEMS));
    public static final Item SEAGULLS_FEATHER = new Item(itemSettings().group(ITEMS));
    public static final Item DUCKS_FEATHER = new Item(itemSettings().group(ITEMS));
    public static final Item BEAST_BONE = new Item(itemSettings().group(ITEMS));
    public static final Item STRING = new Item(itemSettings().group(ITEMS));
    public static final Item SALVE = new SalveItem(itemSettings().group(VC_TOOLS).maxCount(16), 0, 0.0f, StatusEffects.REGENERATION);
    public static final Item DOG_BISCUIT = new FoodItem(itemSettings().group(VC_TOOLS), 2, 0.4f, true);
    
    // crops
    public static final Item RICE_SEEDS = new AliasedBlockItem(ModBlocks.RICES, itemSettings().group(ITEMS));
    public static final Item PUFF_BALL_SEEDS = new AliasedBlockItem(ModBlocks.PUFF_BALL, itemSettings().group(ITEMS));
    public static final Item ONION_SEEDS = new AliasedBlockItem(ModBlocks.ONIONS, itemSettings().group(ITEMS));
    public static final Item FIRE_PEPPER_SEEDS = new AliasedBlockItem(ModBlocks.FIRE_PEPPERS, itemSettings().group(ITEMS));
    public static final Item CAVE_ROOT_SEEDS = new AliasedBlockItem(ModBlocks.CAVE_ROOT_CROP, itemSettings().group(ITEMS));
    public static final Item ANCIENT_FLOWER_SEEDS = new AliasedBlockItem(ModBlocks.ANCIENT_FLOWERS, itemSettings().group(ITEMS));
    public static final Item AMETHYSTLE_SEEDS = new AliasedBlockItem(ModBlocks.AMETHYSTLES, itemSettings().group(ITEMS));

    public static final Item T_TRADE = new Item(itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON).maxCount(1));
    public static final Item T_APPRECIATION = new Item(itemSettings().group(BOOKS).rarity(Rarity.RARE).maxCount(1));
    public static final Item T_VISITORS = new Item(itemSettings().group(BOOKS).rarity(Rarity.EPIC).maxCount(1));

    //disabled unless needed in future
    //public static final Item EVIL_CRYSTAL = new Item(itemSettings().group(ITEMS));
    //public static final Item GRATITUDE_CRYSTAL = new Item(itemSettings().group(ITEMS));
    //public static final Item MONSTER_CLAW = new Item(itemSettings().group(ITEMS));
    //public static final Item MONSTER_TOOTH = new Item(itemSettings().group(ITEMS));
    //public static final Item JELLY_BLOB = new Item(itemSettings().group(ITEMS));
    //public static final Item T_PROTECTION = new Item(itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON).maxCount(1));
    //public static final Item T_EXPLORATION = new Item(itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON).maxCount(1));
    //public static final Item T_KNOWLEDGE = new Item(itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON).maxCount(1));
    //public static final Item T_FRIENDSHIP = new Item(itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON).maxCount(1));

    public static void initialize() {
        Reg.register("salve", SALVE);
        Reg.register("dog_biscuit", DOG_BISCUIT);

        Reg.register("flour", FLOUR);
        Reg.register("salt", SALT);

        Reg.register("fiber", FIBER);

        Reg.register("beast_bone", BEAST_BONE);

        Reg.register("seagulls_feather", SEAGULLS_FEATHER);
        Reg.register("ducks_feather", DUCKS_FEATHER);
        Reg.register("crows_feather", CROWS_FEATHER);

        //Reg.register("jelly_blob", JELLY_BLOB);
        //Reg.register("monster_claw", MONSTER_CLAW);
        //Reg.register("monster_tooth", MONSTER_TOOTH);
        //Reg.register("evil_crystal", EVIL_CRYSTAL);
        //Reg.register("gratitude_crystal", GRATITUDE_CRYSTAL);

        Reg.register("book_cover", COVER);
        Reg.register("plant_fiber_string", STRING);

        Reg.register("mulch", MULCH);
        
        // crops
        Reg.register("rice_seeds", RICE_SEEDS);
        Reg.register("puff_ball_seeds", PUFF_BALL_SEEDS);
        Reg.register("onion_seeds", ONION_SEEDS);
        Reg.register("fire_pepper_seeds", FIRE_PEPPER_SEEDS);
        Reg.register("cave_root_seeds", CAVE_ROOT_SEEDS);
        Reg.register("ancient_flower_seeds", ANCIENT_FLOWER_SEEDS);
        Reg.register("amethystle_seeds", AMETHYSTLE_SEEDS);

        //Reg.register("totem_of_protection", T_PROTECTION);
        Reg.register("totem_of_trade", T_TRADE);
        //Reg.register("totem_of_knowledge", T_KNOWLEDGE);
        Reg.register("totem_of_appreciation", T_APPRECIATION);
        //Reg.register("totem_of_friendship", T_FRIENDSHIP);
        //Reg.register("totem_of_exploration", T_EXPLORATION);
        Reg.register("totem_of_visitors", T_VISITORS);

        ModArmors.initialize();
        TieredFoodItems.initialize();
        IngredientFoodItems.initialize();
        RegularFoodItems.initialize();
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(INGREDIENTS);
    }
}
