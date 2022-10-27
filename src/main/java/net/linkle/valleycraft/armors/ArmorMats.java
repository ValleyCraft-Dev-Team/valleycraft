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

/** Armor Materials */
@SuppressWarnings("unused")
public enum ArmorMats implements ArmorMaterial {
    
    ALEX("ruined_alex_zombie", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    EFE("ruined_efe_zombie", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI("bikini", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_REPAIRED("bikini_repaired", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_COAT("wretch", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_MASC("bikini_masc", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    SWIMSUIT_BLACK_FEMME("bikini_swimsuit", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    SWIMSUIT_BLACK_MASC("bikini_swimsuit_masc", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BIKINI_MASC_REPAIRED("bikini_masc_repaired", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    BRUTE("brute", ints(3), 10, 15, equipLeather(), items(Items.LEATHER)),
    CANVAS("canvas", ints(1,1,2,1), 10, 15, equipLeather(), items(ModItems.BOOK_COVER)),
    SNOW_CAP("snow_cap", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    STABLEHAND_HAT("stablehand", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    DROWNED("ruined_drowned", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    REPAIRED_DROWNED("repaired_drowned", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    EYEPATCH("eyepatch", ints(1), 10, 15, equipLeather(), items(Items.LEATHER)),
    FUR("fur_boots", ints(2,3), 10, 15, equipLeather(), items()),
    FLOWERING_HAT("flower_crown", ints(1,5,6,2), 10, 15, equipLeather(), items(Blocks.FLOWERING_AZALEA)),
    MOBLIN("moblin", ints(1,3,5,2), 15, 0, equipLeather(), items(ModItems.BEAST_BONE)),
    HUSK("ruined_husk", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    REPAIRED_HUSK("repaired_husk", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    MINER("ruined_miner", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    REPAIRED_MINER("repaired_miner", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    LEGGINGS("leggings", ints(1,2,2,2), 30, 15, equipLeather(), items(Items.LEATHER)),
    LIBRARIAN("librarian", ints(1), 10, 15, equipLeather(), items(Items.BOOK)),
    MOBLIN_TALISMAN("moblin_talisman", ints(2,2,3,2), 10, 15, equipChain(), items()),
    ENDER_DRAGON_TALISMAN("ender_dragon_talisman", ints(2,2,3,2), 10, 32, equipChain(), items()),
    EMERALD_TALISMAN("emerald_talisman", ints(2,2,2,2), 10, 22, equipChain(), items()),
    ECHO_TALISMAN("echo_shard", ints(2,2,2,2), 10, 25, equipChain(), items()),
    AMETHYST_TALISMAN("amethyst_talisman", ints(2,2,2,2), 10, 22, equipChain(), items()),
    GOLDEN_GLASSES("golden_glasses", ints(2,2,2,2), 10, 22, equipChain(), items()),
    ROSEGOLD_GLASSES("rosegold_glasses", ints(2,2,2,3), 10, 22, equipChain(), items()),

    CIRCLET_GOLD("golden_circlet", ints(0,0,0,2), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    CIRCLET_EMERALD("emerald_circlet", ints(0,0,0,2), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    CIRCLET_IRON("iron_circlet", ints(0,0,0,2), 15, 9, equipChain(), items(Items.IRON_INGOT)),
    CIRCLET_AMBER("amber_circlet", ints(0,0,0,2), 15, 9, equipChain(), items(Items.IRON_INGOT)),
    CIRCLET_AMETHYST("amethyst_circlet", ints(0,0,0,2), 15, 9, equipChain(), items(Items.IRON_INGOT)),
    CIRCLET_DIAMOND("diamond_circlet", ints(0,0,0,2), 15, 9, equipChain(), items(Items.IRON_INGOT)),
    CIRCLET_ROSEGOLD("rosegold_circlet", ints(0,0,0,2), 15, 15, equipChain(), items(ModItems.ROSEGOLD_INGOT)),
    CIRCLET_PRISMARINE("prismarine_circlet", ints(0,0,0,2), 15, 15, equipChain(), items(ModItems.ROSEGOLD_INGOT)),

    ECHO_DIADEM("echo_shard_diadem", ints(2,2,2,2), 10, 25, equipChain(), items()),
    TREE_GOD("tree_god_mask", ints(2,2,2,2), 10, 25, equipLeather(), items()),

    MOGARS_BROKEN("mogars_broken_golemite_goggles", ints(1,5,6,2), 10, 15, equipChain(), items()),
    MOGARS_FIXED("mogars_fixed_golemite_goggles", ints(2,5,6,2), 10, 15, equipChain(), items()),
    PIGLIN("piglin", ints(2), 10, 15, equipLeather(), items(Items.LEATHER)),
    PILLAGER("pillager", ints(3), 10, 15, equipLeather(), items(Items.LEATHER)),
    STEVE("ruined_steve_zombie", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    STRAW_HAT("straw_hat", ints(2,5,6,2), 10, 15, equipLeather(), items(Items.WHEAT)),
    STRAYA("cartographers_bag", ints(1,5,6,2), 15, 15, equipChain(), items(Items.LEATHER)),
    STRAY("ruined_stray", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    TRADER("trader", ints(2,3), 10, 15, equipLeather(), items(Items.LEATHER)),
    VILLAGER("villager", ints(2,3), 10, 15, equipLeather(), items(Items.LEATHER)),
    WITCH("witch", ints(2,3), 10, 15, equipLeather(), items(Items.LEATHER)),
    VISOR("visor", ints(3), 10, 15, equipChain(), items(Items.COPPER_INGOT)),
    BUTTON("button", ints(0,0,7,2), 10, 15, equipChain(), items(Items.STRING)),
    CHEF("chef", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),
    EVOKER("evoker", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH)),

    PRIMSTEEL("golemite", ints(1,4,5,2), 15, 18, equipIron(), items(ModItems.PRIMSTEEL_INGOT)),
    ROSEGOLD("rosegold", ints(2,5,7,2), 15, 15, equipGold(), items(ModItems.ROSEGOLD_INGOT), 0.75f, 0.0f),
    GOLEMITE("primsteel", ints(2,5,7,2), 15, 5, equipIron(), items(ModItems.GOLEMITE_INGOT),1.0f,0.0f),
    SCALE("scale", ints(0,6,7,3), 15, 9, equipChain(), items(Items.IRON_INGOT)),
    LEATHER_NO_OVERLAY("leather_no_overlay", ints(1,2,3,2), 7, 9, equipLeather(), items(ModItems.TREATED_LEATHER)),
    CLOTH("cloth", ints(1,2,3,2), 7, 9, equipLeather(), items(ModItems.CLOTH)),
    WATTLE("wattle", ints(1,2,2,1), 3, 15, equipLeather(), items(ModItems.PLANK)),

    RF_GOLD("reinforced_gold", ints(0,0,2,3), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    RF_IRON("reinforced_iron", ints(0,0,3,3), 15, 25, equipChain(), items(Items.GOLD_INGOT)),
    RF_PRIMSTEEL("reinforced_primsteel", ints(0,0,2,3), 15, 18, equipChain(), items(ModItems.PRIMSTEEL_INGOT)),
    RF_ROSEGOLD("reinforced_rosegold", ints(0,0,3,3), 15, 15, equipChain(), items(ModItems.ROSEGOLD_INGOT),0.75f, 0.0f),
    RF_GOLEMITE("reinforced_golemite", ints(0,0,3,3), 15, 5, equipChain(), items(ModItems.GOLEMITE_INGOT), 1.0f, 0.0f),
    RF_DIAMOND("reinforced_diamond", ints(0,0,4,4), 15, 10, equipChain(), items(Items.DIAMOND), 2.0f, 0.0f),
    RF_NETHERITE("reinforced_netherite", ints(0,0,4,4), 15, 15, equipChain(), items(Items.NETHERITE_INGOT), 3.0f, 0.0f),

    SHULKER("shulker", ints(0,0,6,4), 15, 20, equipLeather(), items(Items.NETHERITE_INGOT), 3.0f, 0.0f),

    MUMMY("mummy_wraps", ints(1,1,1,1), 7, 18, equipLeather(), items(ModItems.CLOTH)),
    ANCIENT_ROBE("ancient_robe", ints(2,3), 7, 18, equipLeather(), items(ModItems.CLOTH)),

    RED_CLOAK("red_cloak", ints(0,0,4,2), 15, 15, equipLeather(), items(ModItems.CLOTH)),
    GREEN_CLOAK("green_cloak", ints(0,0,4,2), 15, 15, equipLeather(), items(ModItems.CLOTH)),
    PURPLE_CLOAK("purple_cloak", ints(0,0,4,2), 15, 15, equipLeather(), items(ModItems.CLOTH)),
    CYAN_CLOAK("cyan_cloak", ints(0,0,4,2), 15, 15, equipLeather(), items(ModItems.CLOTH)),

    DIVING("diving", ints(2,5,7,2), 15, 5, equipLeather(), items(ModItems.PRIMSTEEL_INGOT));

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
