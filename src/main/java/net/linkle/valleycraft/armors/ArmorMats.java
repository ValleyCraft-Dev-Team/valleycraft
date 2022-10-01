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
    
    public static final ArmorMat ALEX = new ArmorMat("ruined_alex_zombie", 10, ints(2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat BIKINI = new ArmorMat("bikini", 10, ints(1, 2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat BIKINI_COAT = new ArmorMat("wretch", 10, ints(1, 2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat BIKINI_MASC = new ArmorMat("bikini_masc", 10, ints(1, 2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat BRUTE = new ArmorMat("brute", 10, ints(3), 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat CANVAS = new ArmorMat("canvas", 10, ints(1, 1, 2, 1), 15, equipLeather(), items(ModItems.COVER));
    public static final ArmorMat SNOW_CAP = new ArmorMat("snow_cap", 10, ints(2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat DROWNED = new ArmorMat("ruined_drowned", 10, ints(1, 2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat EYEPATCH = new ArmorMat("eyepatch", 10, ints(1), 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat FUR = new ArmorMat("fur_boots", 10, ints(2, 3), 15, equipLeather(), items());
    public static final ArmorMat FLOWERING_HAT = new ArmorMat("flower_crown", 10, ints(1, 5, 6, 2), 15, equipLeather(), items(Blocks.FLOWERING_AZALEA));
    public static final ArmorMat GOLEMITE = new ArmorMat("moblin", 15, ints(1, 3, 5, 2), 0, equipLeather(), items(ModItems.BEAST_BONE));
    public static final ArmorMat HUSK = new ArmorMat("ruined_husk", 10, ints(1, 2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat LEGGINGS = new ArmorMat("leggings", 30, ints(1, 2, 2, 2), 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat LIBRARIAN = new ArmorMat("librarian", 10, ints(1), 15, equipLeather(), items(Items.BOOK));
    public static final ArmorMat MOBLIN_TALISMAN = new ArmorMat("moblin_talisman", 10, ints(2, 2, 3, 2), 15, equipLeather(), items());
    public static final ArmorMat MOGARS_BROKEN = new ArmorMat("mogars_broken_golemite_goggles", 10, ints(1, 5, 6, 2), 15, equipChain(), items());
    public static final ArmorMat MOGARS_FIXED = new ArmorMat("mogars_fixed_golemite_goggles", 10, ints(2, 5, 6, 2), 15, equipChain(), items());
    public static final ArmorMat PIGLIN = new ArmorMat("piglin", 10, ints(2), 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat PILLAGER = new ArmorMat("pillager", 10, ints(3), 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat PRIMSTEEL = new ArmorMat("primsteel", 15, ints(1, 3, 5, 2), 0, equipLeather(), items(ModItems.BEAST_BONE));
    public static final ArmorMat STEVE = new ArmorMat("ruined_steve_zombie", 10, ints(2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat STRAW_HAT = new ArmorMat("straw_hat", 10, ints(2, 5, 6, 2), 15, equipLeather(), items(Items.WHEAT));
    public static final ArmorMat STRAYA = new ArmorMat("cartographers_bag", 15, ints(1, 5, 6, 2), 15, equipChain(), items(Items.LEATHER));
    public static final ArmorMat STRAY = new ArmorMat("ruined_stray", 10, ints(2), 15, equipLeather(), items(ModItems.CLOTH));
    public static final ArmorMat TRADER = new ArmorMat("trader", 10, ints(2, 3), 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat VILLAGER = new ArmorMat("villager", 10, ints(2, 3), 15, equipLeather(), items(Items.LEATHER));
    public static final ArmorMat VISOR = new ArmorMat("visor", 10, ints(3), 15, equipChain(), items(Items.COPPER_INGOT));
    
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
    
    private static SoundEvent equipNETHERITE() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }
    
    private static SoundEvent equipTURTLE() {
        return SoundEvents.ITEM_ARMOR_EQUIP_TURTLE;
    }
}
