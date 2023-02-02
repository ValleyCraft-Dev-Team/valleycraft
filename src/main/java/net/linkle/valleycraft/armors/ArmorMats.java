package net.linkle.valleycraft.armors;

import net.linkle.valleycraft.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.minecraft.item.Items.*;

/** Armor Materials */
@SuppressWarnings("unused")
public enum ArmorMats implements ArmorMaterial {

    ALEX("ruined_alex_zombie", ints(2), 10, 15, equipLeather(), items(Items.LEATHER)),
    EFE("ruined_efe_zombie", ints(2), 10, 15, equipLeather(), items(Items.LEATHER)),
    BIKINI("bikini", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_NEUTRAL("neutral_bikini", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_REPAIRED("bikini_repaired", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_NEUTRAL_REPAIRED("neutral_bikini_repaired", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_COAT("wretch", ints(1,2), 10, 15, equipLeather(), items(Items.LEATHER)),
    BIKINI_MASC("bikini_masc", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    SWIMSUIT_BLACK_NEUTRAL("neutral_bikini_swimsuit", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    SWIMSUIT_BLACK_FEMME("bikini_swimsuit", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    SWIMSUIT_BLACK_MASC("bikini_swimsuit_masc", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_MASC_REPAIRED("bikini_masc_repaired", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BRUTE("brute", ints(3), 10, 15, equipLeather(), items(Items.LEATHER)),
    CANVAS("canvas", ints(1,1,2,1), 10, 15, equipLeather(), items(ModItems.PLANT_FIBER_CANVAS)),
    SNOW_CAP("snow_cap", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    STABLEHAND_HAT("stablehand", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    DROWNED("ruined_drowned", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    REPAIRED_DROWNED("repaired_drowned", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    EYEPATCH("eyepatch", ints(1), 10, 15, equipLeather(), items(Items.LEATHER)),
    HEADSCARF("seaologer_headscarf", ints(1), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    FUR("fur_boots", ints(2,3), 10, 15, equipLeather(), items(Items.LEATHER)),
    FLOWERING_HAT("flower_crown", ints(1,5,6,1), 10, 15, equipLeather(), items(Blocks.FLOWERING_AZALEA)),
    DIERDRA_LAUREL("dierdra_laurel", ints(1,5,6,2), 10, 15, equipLeather(), items(Blocks.VINE)),
    MOBLIN("moblin", ints(1,3,5,2), 15, 0, equipLeather(), items(ModItems.BEAST_BONE)),
    HUSK("ruined_husk", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    REPAIRED_HUSK("repaired_husk", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    MINER("ruined_miner", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH, ModItems.CLOTH)),
    REPAIRED_MINER("repaired_miner", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH, ModItems.CLOTH)),
    LEGGINGS("leggings", ints(1,2,2,2), 30, 15, equipLeather(), items(Items.LEATHER)),
    BLACK_FEATHERED_HAT("black_feathered_hat", ints(2,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    DRIPLEAF("dripleaf", ints(1,5,6,1), 10, 15, equipLeather(), items(Blocks.BIG_DRIPLEAF)),
    WHITE_FEATHER("white_feather", ints(1,5,6,1), 10, 15, equipLeather(), items(Items.FEATHER)),
    CROW_FEATHER("crow_feather", ints(1,5,6,1), 10, 15, equipLeather(), items(ModItems.CROWS_FEATHER)),
    SEAGULL_FEATHER("seagull_feather", ints(1,5,6,1), 10, 15, equipLeather(), items(ModItems.SEAGULLS_FEATHER)),
    DUCK_FEATHER("duck_feather", ints(1,5,6,1), 10, 15, equipLeather(), items(ModItems.DUCKS_FEATHER)),

    CIRCLET_GOLD("golden_circlet", ints(0,0,0,2), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    CIRCLET_IRON("iron_circlet", ints(0,0,0,1), 15, 9, equipChain(), items(Items.IRON_INGOT)),
    CIRCLET_DIAMOND("diamond_circlet", ints(0,0,0,2), 15, 9, equipChain(), items(ModItems.DIAMOND_PLATE)),
    CIRCLET_ROSEGOLD("rosegold_circlet", ints(0,0,0,2), 15, 15, equipChain(), items(ModItems.ROSEGOLD_INGOT)),
    CIRCLET_NETHERITE("netherite_circlet", ints(0,0,0,3), 15, 15, equipChain(), items(Items.NETHERITE_INGOT)),
    CIRCLET_PRIMSTEEL("primsteel_circlet", ints(0,0,0,1), 15, 15, equipChain(), items(ModItems.PRIMSTEEL_INGOT)),
    CIRCLET_LEATHER("leather_circlet", ints(0,0,0,1), 15, 15, equipChain(), items(ModItems.TREATED_LEATHER)),

    CROWN("golden_crown", ints(0,0,0,3), 15, 25, equipGold(), items(Items.GOLD_INGOT)),

    ECHO_DIADEM("echo_shard_diadem", ints(2,2,2,2), 10, 25, equipChain(), items()),
    TREE_GOD("tree_god_mask", ints(2,2,2,2), 10, 25, equipLeather(), items(Items.OAK_LOG)),

    RIBCAGE("ribcage", ints(6), 10, 22, equipLeather(), items(Items.BONE), 1.0f, 0.0f),
    WITHER_RIBCAGE("wither_ribcage", ints(7), 10, 22, equipLeather(), items(Items.BONE), 1.0f, 0.0f),

    MOGARS_BROKEN("mogars_broken_golemite_goggles", ints(1,5,6,2), 10, 15, equipChain(), items(IRON_INGOT)),
    MOGARS_FIXED("mogars_fixed_golemite_goggles", ints(2,5,6,2), 10, 15, equipChain(), items(IRON_INGOT)),
    AMETHYST_GOGGLES("amethyst_goggles", ints(2,2,2,2), 10, 15, equipChain(), items(COPPER_INGOT, AMETHYST_SHARD)),
    NIGHTVISION_GOGGLES("nightvision_goggles", ints(2,2,2,2), 10, 15, equipChain(), items(COPPER_INGOT, AMETHYST_SHARD)),
    PIGLIN("piglin", ints(2), 10, 15, equipLeather(), items(Items.LEATHER)),
    PILLAGER("pillager", ints(3), 10, 15, equipLeather(), items(Items.LEATHER)),
    STEVE("ruined_steve_zombie", ints(2), 10, 15, equipLeather(), items(Items.LEATHER)),
    STRAW_HAT("straw_hat", ints(2,5,6,2), 10, 15, equipLeather(), items(Items.WHEAT)),
    STRAYA("cartographers_bag", ints(1,5,6,2), 15, 15, equipChain(), items(ModItems.LEATHER_STRAP)),
    STRAY("ruined_stray", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    TRADER("trader", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    VILLAGER("villager", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    WITCH("witch", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    VISOR("visor", ints(3), 10, 15, equipChain(), items(COPPER_INGOT)),
    BUTTON("button", ints(0,0,7,2), 10, 15, equipChain(), items(Items.STRING)),
    CHEF("chef", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    EVOKER("evoker", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),

    PRIMSTEEL("golemite", ints(1,4,5,2), 15, 18, equipIron(), items(ModItems.PRIMSTEEL_INGOT)),
    ROSEGOLD("rosegold", ints(2,5,7,2), 15, 15, equipGold(), items(ModItems.ROSEGOLD_INGOT), 0.75f, 0.0f),
    SCALE("scale", ints(0,6,7,3), 15, 9, equipChain(), items(Items.IRON_INGOT)),
    LEATHER_NO_OVERLAY("leather_no_overlay", ints(1,2,3,2), 7, 9, equipLeather(), items(ModItems.TREATED_LEATHER)),
    LEATHER_MODIFIED("leather_modified", ints(1,2,3,2), 7, 9, equipLeather(), items(ModItems.TREATED_LEATHER)),
    CLOTH("cloth", ints(1,2,3,2), 7, 9, equipLeather(), items(ModItems.CLOTH)),
    WATTLE("wattle", ints(1,2,2,1), 3, 15, equipLeather(), items(ModItems.PLANK)),
    QUIVER("quiver", ints(1,2,2,2), 7, 9, equipLeather(), items(ModItems.TREATED_LEATHER)),

    //ANCIENT_AGLETS("ancient_aglets", ints(1,4,5,2), 15, 18, equipIron(), items(COPPER_INGOT)),

    RF_LEATHER("reinforced_leather", ints(1,1,2,2), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    RF_GOLD("reinforced_gold", ints(1,1,4,3), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    RF_IRON("reinforced_iron", ints(2,3,5,3), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    RF_PRIMSTEEL("reinforced_primsteel", ints(1,2,4,3), 15, 18, equipChain(), items(ModItems.PRIMSTEEL_INGOT)),
    RF_ROSEGOLD("reinforced_rosegold", ints(2,3,5,3), 15, 15, equipChain(), items(ModItems.ROSEGOLD_INGOT),0.75f, 0.0f),
    RF_DIAMOND("reinforced_diamond", ints(3,4,7,4), 15, 10, equipChain(), items(Items.DIAMOND), 2.0f, 0.0f),
    RF_NETHERITE("reinforced_netherite", ints(3,4,7,4), 15, 15, equipChain(), items(Items.NETHERITE_INGOT), 3.0f, 0.0f),

    HAUBERK_LEATHER("leather_hauberk", ints(1,2,2,2), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    HAUBERK_GOLD("gold_hauberk", ints(1,3,4,3), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    HAUBERK_IRON("iron_hauberk", ints(2,5,5,3), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    HAUBERK_PRIMSTEEL("primsteel_hauberk", ints(1,4,4,3), 15, 18, equipChain(), items(ModItems.PRIMSTEEL_INGOT)),
    HAUBERK_ROSEGOLD("rosegold_hauberk", ints(2,5,5,3), 15, 15, equipChain(), items(ModItems.ROSEGOLD_INGOT),0.75f, 0.0f),
    HAUBERK_DIAMOND("diamond_hauberk", ints(3,6,7,4), 15, 10, equipChain(), items(Items.DIAMOND), 2.0f, 0.0f),
    HAUBERK_NETHERITE("netherite_hauberk", ints(3,6,7,4), 15, 15, equipChain(), items(Items.NETHERITE_INGOT), 3.0f, 0.0f),

    SHULKER("shulker", ints(0,0,6,4), 15, 20, equipLeather(), items(SHULKER_SHELL), 3.0f, 0.0f),

    MUMMY("mummy_wraps", ints(1,1,1,1), 7, 18, equipLeather(), items(ModItems.CLOTH)),
    ANCIENT_ROBE("ancient_robe", ints(2,3), 7, 18, equipLeather(), items(ModItems.CLOTH)),

    RED_CLOAK("red_cloak", ints(0,0,4,2), 15, 15, equipLeather(), items(ModItems.CLOTH)),
    GREEN_CLOAK("green_cloak", ints(0,0,4,2), 15, 15, equipLeather(), items(ModItems.CLOTH)),
    PURPLE_CLOAK("purple_cloak", ints(0,0,4,2), 15, 15, equipLeather(), items(ModItems.CLOTH)),
    CYAN_CLOAK("cyan_cloak", ints(0,0,4,2), 15, 15, equipLeather(), items(ModItems.CLOTH)),

    DIVING("diving", ints(2,5,7,3), 15, 5, equipLeather(), items(ModItems.PRIMSTEEL_INGOT)),
    COPPER_DIVING("copper_diving", ints(2,5,7,2), 15, 5, equipLeather(), items(COPPER_INGOT));

    // ### Other Utility Methods ###

    private static Ingredient items(ItemConvertible... items) {
        return Ingredient.ofItems(items);
    }

    // ### Protection Utility Methods ###

    /** Create integer array of protection amounts. */
    private static int[] ints(int feet, int leg, int body, int head) {
        return new int[] {feet, leg, body, head};
    }

    /** Create integer array of protection amounts. */
    private static int[] ints(int headNfeet, int bodyNleg) {
        return ints(headNfeet, bodyNleg, bodyNleg, headNfeet);
    }

    /** Create integer array of protection amounts. */
    private static int[] ints(int all) {
        return ints(all, all, all, all);
    }

    // ### Equipping Sounds ###

    private static SoundEvent equipChain() {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
    }

    private static SoundEvent equipElytra() {
        return SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA;
    }

    private static SoundEvent equipGeneric() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    private static SoundEvent equipGold() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
    }

    private static SoundEvent equipIron() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    private static SoundEvent equipLeather() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    private static SoundEvent equipNetherite() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    private static SoundEvent equipTurtle() {
        return SoundEvents.ITEM_ARMOR_EQUIP_TURTLE;
    }

    // ### The Enum Class Itself ###

    static final int[] BASE_DURABILITY = {13, 15, 16, 11};

    private final String name;
    private final int[] protectionAmounts;
    private final int durabilityMultiplier;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Ingredient repairIngredient;
    private final float toughness;
    private final float knockbackResistance;

    ArmorMats(String name, int[] prtAmts, int durMul, int ench, SoundEvent sound, Ingredient repair) {
        this(name, prtAmts, durMul, ench, sound, repair, 0, 0);
    }

    ArmorMats(String name, int[] prtAmts, int durMul, int ench, SoundEvent sound, Ingredient repair, float tough, float knockback) {
        this.name = name;
        this.protectionAmounts = prtAmts;
        this.durabilityMultiplier = durMul;
        this.enchantability = ench;
        this.equipSound = sound;
        this.repairIngredient = repair;
        this.toughness = tough;
        this.knockbackResistance = knockback;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
