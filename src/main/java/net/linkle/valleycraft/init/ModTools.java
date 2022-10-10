package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.tool.ModToolMaterials;
import net.linkle.valleycraft.tool.environmental.*;
import net.linkle.valleycraft.tool.knife.KnifeBase;
import net.linkle.valleycraft.tool.knife.ModdedKnifeBase;
import net.linkle.valleycraft.tool.knife.special.CoralDaggerItem;
import net.linkle.valleycraft.tool.knife.special.CoralDaggerToolMaterial;
import net.linkle.valleycraft.tool.scythe.ModdedScytheBase;
import net.linkle.valleycraft.tool.scythe.ScytheBase;
import net.linkle.valleycraft.tool.shovel.special.OarItem;
import net.linkle.valleycraft.tool.shovel.special.OarToolMaterial;
import net.linkle.valleycraft.tool.sword.special.*;
import net.linkle.valleycraft.tool.throwing.BoneDartItem;
import net.linkle.valleycraft.tool.woodcutter_axe.ModdedWoodcutterAxeBase;
import net.linkle.valleycraft.tool.woodcutter_axe.WoodcutterAxeBase;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;
import static net.linkle.valleycraft.init.ModGroups.VC_TOOLS;

import net.linkle.valleycraft.item.ClimbingAxeItem;

public class ModTools {
    //When we need to access a tool or weapon elsewhere in the codebase, such as to inject them into loot tables, we need them stored in variables.
    //environmental tools
    public static final Item BRANCH = new BranchToolItem(new BranchToolMaterial(), 3, -2.0f);
    public static final Item FLINT = new FlintToolItem(new FlintToolMaterial());
    public static final Item HEFTY_ROCK = new RockToolItem(new RockToolMaterial());
    public static final Item RUSTY_SWORD = new RustySwordItem(new RustySwordMaterial(),4, -2.4f);
    public static final Item OAR = new OarItem(new OarToolMaterial(),3, -2.8f);
    public static final Item LADLE = new OarItem(new OarToolMaterial(),2, -2.5f);
    public static final Item BONE_DART_ITEM = new BoneDartItem(new Item.Settings().maxCount(64).group(VC_TOOLS));
    public static final Item CORAL_KNIFE = new CoralDaggerItem(new CoralDaggerToolMaterial(), 3, -1.4f);
    public static final Item CAVE_FISHERS_RAPIER = new CaveFisherSwordItem(new CaveFisherToolMaterial(), 4, -2.4f);
    public static final Item SEAOLOGER_BROKEN = new BrokenSeagerCutlassItem(new BrokenSeagerToolMaterial(), 2, -1.8f);
    public static final Item SEAOLOGER_FIXED = new FixedSeagerCutlassItem(new FixedSeagerToolMaterial(), 5, -1.8f);
    public static final Item CLIMBING_AXE = new ClimbingAxeItem(ToolMaterials.IRON, new Item.Settings().group(VC_TOOLS));
    public static final Item ANCIENT_CLIMBING_AXE = new ClimbingAxeItem(ToolMaterials.DIAMOND, new Item.Settings().group(BOOKS).rarity(Rarity.EPIC));

    //The base attack damage of each tool type.
    //These values are added to the attack stats of their materials when they're registered.
    //The attack stats are listed in RoseGoldToolMaterial.class.
    public static final Integer KNIFE_BASE_DAMAGE = 2;
    public static final Integer DAGGER_BASE_DAMAGE = 3;
    public static final Integer WOODCUTTER_BASE_DAMAGE = 8;
    public static final Integer SCYTHE_BASE_DAMAGE = 4;
    //The base attack speed of each tool type.
    //These numbers are subtracted from four, so 4.0 will make the tool never charge, and higher will likely cause issues.
    //Larger number = slower, smaller number = faster.
    public static final Float KNIFE_BASE_SPEED = -2.0f;
    public static final Float WOODCUTTER_BASE_SPEED = -3.4f;
    public static final Float SCYTHE_BASE_SPEED = -2.7f;
    public static final Float DAGGER_BASE_SPEED = -2.6f;
    //The item settings for knives made of 'basic' materials- wood, gold, stone, iron, rose gold, diamond, netherite
    public static final Item.Settings BASIC_KNIFE_SETTINGS = new Item.Settings().group(VC_TOOLS);
    public static final Item.Settings BASIC_WOODCUTTER_SETTINGS = new Item.Settings().group(VC_TOOLS);
    public static final Item.Settings BASIC_SCYTHE_SETTINGS = new Item.Settings().group(VC_TOOLS);
    public static final Item.Settings BASIC_DAGGER_SETTINGS = new Item.Settings().group(VC_TOOLS);

    public static void initialize() {
        //Environmental
        Reg.register("branch", BRANCH);
        Reg.register("sharp_flint", FLINT);
        Reg.register("hefty_rock", HEFTY_ROCK);
        Reg.register("throwing_rock", BONE_DART_ITEM);
        Reg.register("rusted_sword", RUSTY_SWORD);
        //Material technically
        Reg.register("wooden_oar", OAR);
        //Ladle
        Reg.register("ladle", LADLE);
        //Climbing Axes
        Reg.register("climbing_axe", CLIMBING_AXE);

        //Knives
        Reg.register("knife_wooden", new KnifeBase(ToolMaterials.WOOD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_stone", new KnifeBase(ToolMaterials.STONE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_golden", new KnifeBase(ToolMaterials.GOLD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_primsteel", new ModdedKnifeBase(ModToolMaterials.PRIMSTEEL, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_iron", new KnifeBase(ToolMaterials.IRON, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_rosegold", new ModdedKnifeBase(ModToolMaterials.ROSEGOLD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_golemite", new ModdedKnifeBase(ModToolMaterials.GOLEMITE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_diamond", new KnifeBase(ToolMaterials.DIAMOND, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_netherite", new KnifeBase(ToolMaterials.NETHERITE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));

        //Dagger
        Reg.register("dagger_wooden", new KnifeBase(ToolMaterials.WOOD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));
        Reg.register("dagger_stone", new KnifeBase(ToolMaterials.STONE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));
        Reg.register("dagger_golden", new KnifeBase(ToolMaterials.GOLD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));
        Reg.register("dagger_primsteel", new ModdedKnifeBase(ModToolMaterials.PRIMSTEEL, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));
        Reg.register("dagger_iron", new KnifeBase(ToolMaterials.IRON, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));
        Reg.register("dagger_rosegold", new ModdedKnifeBase(ModToolMaterials.ROSEGOLD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));
        Reg.register("dagger_golemite", new ModdedKnifeBase(ModToolMaterials.GOLEMITE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));
        Reg.register("dagger_diamond", new KnifeBase(ToolMaterials.DIAMOND, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));
        Reg.register("dagger_netherite", new KnifeBase(ToolMaterials.NETHERITE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_DAGGER_SETTINGS));

        //Woodcutter's Axes
        Reg.register("woodcutter_axe_wooden", new WoodcutterAxeBase(ToolMaterials.WOOD, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_stone", new WoodcutterAxeBase(ToolMaterials.STONE, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_golden", new WoodcutterAxeBase(ToolMaterials.GOLD, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_primsteel", new ModdedWoodcutterAxeBase(ModToolMaterials.PRIMSTEEL, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_iron", new WoodcutterAxeBase(ToolMaterials.IRON, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_rosegold", new ModdedWoodcutterAxeBase(ModToolMaterials.ROSEGOLD, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_golemite", new ModdedWoodcutterAxeBase(ModToolMaterials.GOLEMITE, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_diamond", new WoodcutterAxeBase(ToolMaterials.DIAMOND, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_netherite", new WoodcutterAxeBase(ToolMaterials.NETHERITE, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));

        //Scythes
        Reg.register("scythe_wooden", new ScytheBase(ToolMaterials.WOOD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));
        Reg.register("scythe_stone", new ScytheBase(ToolMaterials.STONE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));
        Reg.register("scythe_golden", new ScytheBase(ToolMaterials.GOLD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));
        Reg.register("scythe_primsteel", new ModdedScytheBase(ModToolMaterials.PRIMSTEEL, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));
        Reg.register("scythe_iron", new ScytheBase(ToolMaterials.IRON, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));
        Reg.register("scythe_rosegold", new ModdedScytheBase(ModToolMaterials.ROSEGOLD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));
        Reg.register("scythe_golemite", new ModdedScytheBase(ModToolMaterials.GOLEMITE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));
        Reg.register("scythe_diamond", new ScytheBase(ToolMaterials.DIAMOND, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));
        Reg.register("scythe_netherite", new ScytheBase(ToolMaterials.NETHERITE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SCYTHE_SETTINGS));

        //Undead Artifacts
        //Drowned
        Reg.register("knife_coral_encrusted", CORAL_KNIFE);
        Reg.register("rapier_cave_fishers", CAVE_FISHERS_RAPIER);
        //Mermaid's Sword
        //Arid & Husk
        //Mossy
        //Frozen
        //Zombified

        //Sea-O-Logers
        Reg.register("seaologer_broken", SEAOLOGER_BROKEN);                                         //Mermaid's Sword
        Reg.register("seaologer_fixed", SEAOLOGER_FIXED);                                         //Mermaid's Sword

        //1.1 planned
        //Reg.register("axe_timber_red", new TimberAxeItem(new TimberAxeToolMaterial()));
        
        Reg.register("ancient_climbing_axe", ANCIENT_CLIMBING_AXE);
    }
}
