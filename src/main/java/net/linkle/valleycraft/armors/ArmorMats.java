package net.linkle.valleycraft.armors;

import net.linkle.valleycraft.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

/** Mod Armor Materials */
@SuppressWarnings("unused")
public class ArmorMats {
    
    public static final ArmorMat ALEX = new ArmorMat("ruined_alex_zombie", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat BIKINI = new ArmorMat("bikini", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat BIKINI_COAT = new ArmorMat("wretch", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat BIKINI_MASC = new ArmorMat("bikini_masc", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat BRUTE = new ArmorMat("brute", ints(3), 10, 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat CANVAS = new ArmorMat("canvas", ints(1,1,2,1), 10, 15, equipLeather(), items(ModItems.COVER));
    public static final ArmorMat SNOW_CAP = new ArmorMat("snow_cap", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat DROWNED = new ArmorMat("ruined_drowned", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat REPAIRED_DROWNED = new ArmorMat("repaired_drowned", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat EYEPATCH = new ArmorMat("eyepatch", ints(1), 10, 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat FUR = new ArmorMat("fur_boots", ints(2,3), 10, 15, equipLeather(), items());
    public static final ArmorMat FLOWERING_HAT = new ArmorMat("flower_crown", ints(1,5,6,2), 10, 15, equipLeather(), items(Blocks.FLOWERING_AZALEA));
    public static final ArmorMat GOLEMITE = new ArmorMat("moblin", ints(1,3,5,2), 15, 0, equipLeather(), items(ModItems.BEAST_BONE));
    public static final ArmorMat HUSK = new ArmorMat("ruined_husk", ints(1,2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat REPAIRED_HUSK = new ArmorMat("repaired_husk", ints(2,3), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat LEGGINGS = new ArmorMat("leggings", ints(1,2,2,2), 30, 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat LIBRARIAN = new ArmorMat("librarian", ints(1), 10, 15, equipLeather(), items(Items.BOOK));
    public static final ArmorMat MOBLIN_TALISMAN = new ArmorMat("moblin_talisman", ints(2,2,3,2), 10, 15, equipChain(), items());
    public static final ArmorMat EMERALD_TALISMAN = new ArmorMat("emerald_talisman", ints(2,2,2,2), 10, 22, equipChain(), items());
    public static final ArmorMat MOGARS_BROKEN = new ArmorMat("mogars_broken_golemite_goggles", ints(1,5,6,2), 10, 15, equipChain(), items());
    public static final ArmorMat MOGARS_FIXED = new ArmorMat("mogars_fixed_golemite_goggles", ints(2,5,6,2), 10, 15, equipChain(), items());
    public static final ArmorMat PIGLIN = new ArmorMat("piglin", ints(2), 10, 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat PILLAGER = new ArmorMat("pillager", ints(3), 10, 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat PRIMSTEEL = new ArmorMat("primsteel", ints(1,3,5,2), 15, 0, equipLeather(), items(ModItems.BEAST_BONE));
    public static final ArmorMat STEVE = new ArmorMat("ruined_steve_zombie", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat STRAW_HAT = new ArmorMat("straw_hat", ints(2,5,6,2), 10, 15, equipLeather(), items(Items.WHEAT));
    public static final ArmorMat STRAYA = new ArmorMat("cartographers_bag", ints(1,5,6,2), 15, 15, equipChain(), items(Items.LEATHER));
    public static final ArmorMat STRAY = new ArmorMat("ruined_stray", ints(2), 10, 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat TRADER = new ArmorMat("trader", ints(2,3), 10, 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat VILLAGER = new ArmorMat("villager", ints(2,3), 10, 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat VISOR = new ArmorMat("visor", ints(3), 10, 15, equipChain(), items(Items.COPPER_INGOT));
    public static final ArmorMat SCALE = new ArmorMat("scale", ints(0,0,7,3), 10, 15, equipChain(), items(Items.IRON_INGOT));

    public static void initialize() {
        
    }
    
    // ### Other Utility Methods ###
    
    private static Ingredient items(ItemConvertible... items) {
        return Ingredient.ofItems(items);
    }
    
    // ### Protection Utility Methods ###
    
    private static int[] ints(int feet, int leg, int body, int head) {
        return new int[] {feet, leg, body, head};
    }
    
    private static int[] ints(int headNfeet, int bodyNleg) {
        return ints(headNfeet, bodyNleg, bodyNleg, headNfeet);
    }
    
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
}
