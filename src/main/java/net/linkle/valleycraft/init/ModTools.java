package net.linkle.valleycraft.init;

import net.linkle.valleycraft.tool.ModToolMaterials;
import net.linkle.valleycraft.tool.ModToolMaterialsExtended;
import net.linkle.valleycraft.tool.anthro.AnthroPickaxeItem;
import net.linkle.valleycraft.tool.anthro.AnthroPickaxeMaterial;
import net.linkle.valleycraft.tool.environmental.*;
import net.linkle.valleycraft.tool.hatchet.HatchetAxeBase;
import net.linkle.valleycraft.tool.knife.DaggerBase;
import net.linkle.valleycraft.tool.knife.KnifeBase;
import net.linkle.valleycraft.tool.knife.special.CoralDaggerItem;
import net.linkle.valleycraft.tool.knife.special.CoralDaggerToolMaterial;
import net.linkle.valleycraft.tool.mace.MaceBase;
import net.linkle.valleycraft.tool.pickaxes.RustyPickaxeItem;
import net.linkle.valleycraft.tool.pickaxes.RustyPickaxeMaterial;
import net.linkle.valleycraft.tool.scythe.ScytheBase;
import net.linkle.valleycraft.tool.shovel.special.LadleItem;
import net.linkle.valleycraft.tool.shovel.special.OarItem;
import net.linkle.valleycraft.tool.shovel.special.OarToolMaterial;
import net.linkle.valleycraft.tool.spear.SpearBase;
import net.linkle.valleycraft.tool.staff.StaffBase;
import net.linkle.valleycraft.tool.sword.special.*;
import net.linkle.valleycraft.tool.throwing.BoneDartItem;
import net.linkle.valleycraft.tool.travelers_sword.TravelerBase;
import net.linkle.valleycraft.tool.woodcutter_axe.WoodcutterAxeBase;
import net.linkle.valleycraft.tool.woodcutter_axe.special.TimberAxeItem;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

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
    public static final Item RUSTY_PICKAXE = new RustyPickaxeItem(new RustyPickaxeMaterial(),3, -2.8f);
    //public static final Item OAR = new OarItem(new OarToolMaterial(),3, -2.8f);
    public static final Item LADLE = new LadleItem(new OarToolMaterial(),2, -2.5f);
    public static final Item THROWING_ROCK = new BoneDartItem(new Item.Settings().maxCount(64).group(VC_TOOLS));
    public static final Item ANTHROPOLOGISTS_ROCK_PICK = new AnthroPickaxeItem(new AnthroPickaxeMaterial());

    public static final Item ANCIENT_CLIMBING_AXE = new ClimbingAxeItem(ToolMaterials.DIAMOND, new Item.Settings().group(BOOKS).rarity(Rarity.EPIC));
    public static final Item MOBLIN_BROKEN = new BrokenSeagerCutlassItem(new BrokenSeagerToolMaterial(), 2, -1.8f);
    public static final Item CORAL_KNIFE = new CoralDaggerItem(new CoralDaggerToolMaterial(), 3, -1.4f);
    public static final Item CAVE_FISHERS_RAPIER = new CaveFisherSwordItem(new CaveFisherToolMaterial(), 4, -2.4f);
    public static final Item SEAOLOGER_BROKEN = new BrokenSeagerCutlassItem(new BrokenSeagerToolMaterial(), 2, -1.8f);
    public static final Item SEAOLOGER_FIXED = new FixedSeagerCutlassItem(new FixedSeagerToolMaterial(), 5, -1.8f);
    public static final Item CLIMBING_AXE = new ClimbingAxeItem(ToolMaterials.IRON, new Item.Settings().group(VC_TOOLS));

    //The base attack damage of each tool type.
    //These values are added to the attack stats of their materials when they're registered.
    //The attack stats are listed in RoseGoldToolMaterial.class.
    public static final Integer KNIFE_BASE_DAMAGE = 2;
    public static final Integer DAGGER_BASE_DAMAGE = 3;
    public static final Integer WOODCUTTER_BASE_DAMAGE = 8;
    public static final Integer SCYTHE_BASE_DAMAGE = 4;
    public static final Integer HATCHET_BASE_DAMAGE = 5;
    public static final Integer SPEAR_BASE_DAMAGE = 3;
    public static final Integer TRAVELER_BASE_DAMAGE = 3;
    public static final Integer MACE_BASE_DAMAGE = 3;
    public static final Integer STAFF_BASE_DAMAGE = 3;
    public static final Integer GREATSWORD_BASE_DAMAGE = 8;

    //The base attack speed of each tool type.
    //These numbers are subtracted from four, so 4.0 will make the tool never charge, and higher will likely cause issues.
    //Larger number = slower, smaller number = faster.
    public static final Float KNIFE_BASE_SPEED = -2.0f;
    public static final Float WOODCUTTER_BASE_SPEED = -3.4f;
    public static final Float SCYTHE_BASE_SPEED = -2.7f;
    public static final Float DAGGER_BASE_SPEED = -2.4f;
    public static final Float HATCHET_BASE_SPEED = -3.0f;
    public static final Float SPEAR_BASE_SPEED = -2.6f;
    public static final Float TRAVELER_BASE_SPEED = -2.2f;
    public static final Float MACE_BASE_SPEED = -2.2f;
    public static final Float STAFF_BASE_SPEED = -2.2f;
    public static final Float GREATSWORD_BASE_SPEED = -3.4f;

    //these are all vanilla, dont alter them Linkle! signed, Linkle
    public static final Integer AXE_BASE_DAMAGE = 6;
    public static final Float AXE_BASE_SPEED = -3.2f;
    public static final Integer PICKAXE_BASE_DAMAGE = 1;
    public static final Float PICKAXE_BASE_SPEED = -2.8f;
    public static final Integer SWORD_BASE_DAMAGE = 3;
    public static final Float SWORD_BASE_SPEED = -2.4f;
    public static final Float SHOVEL_BASE_DAMAGE = 1.5f;
    public static final Float SHOVEL_BASE_SPEED = -3.0f;
    public static final Integer HOE_BASE_DAMAGE = 0;
    public static final Float HOE_BASE_SPEED = -3.0f;

    //The item settings for knives made of 'basic' materials- wood, gold, stone, iron, rose gold, diamond, netherite
    public static final Item.Settings BASIC_SETTINGS = new Item.Settings().group(VC_TOOLS);
    public static final Item.Settings BASIC_ARTIFACT_SETTINGS_RARE = new Item.Settings().group(BOOKS).rarity(Rarity.RARE);
    public static final Item.Settings BASIC_ARTIFACT_SETTINGS_EPIC = new Item.Settings().group(BOOKS).rarity(Rarity.EPIC);
    public static final Item.Settings BASIC_ARTIFACT_SETTINGS_UNCOMMON = new Item.Settings().group(BOOKS).rarity(Rarity.UNCOMMON);
    public static final Item.Settings BASIC_ARTIFACT_SETTINGS = new Item.Settings().group(BOOKS);

    public static void initialize() {
        //Environmental
        Reg.register("branch", BRANCH);
        Reg.register("sharp_flint", FLINT);
        Reg.register("hefty_rock", HEFTY_ROCK);
        Reg.register("throwing_rock", THROWING_ROCK);

        //Climbing Axes
        Reg.register("climbing_axe", CLIMBING_AXE);
        //Rock Picks
        Reg.register("anthropologists_rock_pick", ANTHROPOLOGISTS_ROCK_PICK);
        Reg.register("ice_tongs", new PickaxeItem(ModToolMaterials.BRASIUM, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS));
        //Staffs
        Reg.register("wooden_staff", new StaffBase(ModToolMaterials.PLANK, STAFF_BASE_DAMAGE, STAFF_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("bamboo_staff", new StaffBase(ModToolMaterials.BAMBOO, STAFF_BASE_DAMAGE, STAFF_BASE_SPEED, BASIC_SETTINGS));
        //Material technically
        Reg.register("wooden_oar", new StaffBase(ModToolMaterials.PLANK, STAFF_BASE_DAMAGE, STAFF_BASE_SPEED, BASIC_SETTINGS));

        //Knives
        Reg.register("knife_wooden", new KnifeBase(ToolMaterials.WOOD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_stone", new KnifeBase(ToolMaterials.STONE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_golden", new KnifeBase(ToolMaterials.GOLD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_primsteel", new KnifeBase(ModToolMaterials.PRIMSTEEL, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_iron", new KnifeBase(ToolMaterials.IRON, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_rosegold", new KnifeBase(ModToolMaterials.ROSEGOLD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_golemite", new KnifeBase(ModToolMaterials.GOLEMITE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_diamond", new KnifeBase(ToolMaterials.DIAMOND, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_netherite", new KnifeBase(ToolMaterials.NETHERITE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));

        //Hatchets
        Reg.register("hatchet_wooden", new HatchetAxeBase(ToolMaterials.WOOD, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_stone", new HatchetAxeBase(ToolMaterials.STONE, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_golden", new HatchetAxeBase(ToolMaterials.GOLD, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_primsteel", new HatchetAxeBase(ModToolMaterials.PRIMSTEEL, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_iron", new HatchetAxeBase(ToolMaterials.IRON, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_rosegold", new HatchetAxeBase(ModToolMaterials.ROSEGOLD, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_golemite", new HatchetAxeBase(ModToolMaterials.GOLEMITE, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_diamond", new HatchetAxeBase(ToolMaterials.DIAMOND, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_netherite", new HatchetAxeBase(ToolMaterials.NETHERITE, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));

        //Woodcutter's Axes
        Reg.register("woodcutter_axe_wooden", new WoodcutterAxeBase(ModToolMaterialsExtended.WOOD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_stone", new WoodcutterAxeBase(ModToolMaterialsExtended.STONE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_golden", new WoodcutterAxeBase(ModToolMaterialsExtended.GOLD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_primsteel", new WoodcutterAxeBase(ModToolMaterialsExtended.PRIMSTEEL_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_iron", new WoodcutterAxeBase(ModToolMaterialsExtended.IRON_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_rosegold", new WoodcutterAxeBase(ModToolMaterialsExtended.ROSEGOLD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_golemite", new WoodcutterAxeBase(ModToolMaterialsExtended.GOLEMITE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_diamond", new WoodcutterAxeBase(ModToolMaterialsExtended.DIAMOND_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_netherite", new WoodcutterAxeBase(ModToolMaterialsExtended.NETHERITE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));

        //Scythes
        Reg.register("scythe_wooden", new ScytheBase(ToolMaterials.WOOD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_stone", new ScytheBase(ToolMaterials.STONE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_golden", new ScytheBase(ToolMaterials.GOLD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_primsteel", new ScytheBase(ModToolMaterials.PRIMSTEEL, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_iron", new ScytheBase(ToolMaterials.IRON, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_rosegold", new ScytheBase(ModToolMaterials.ROSEGOLD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_golemite", new ScytheBase(ModToolMaterials.GOLEMITE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_diamond", new ScytheBase(ToolMaterials.DIAMOND, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_netherite", new ScytheBase(ToolMaterials.NETHERITE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));

        //Spear
        Reg.register("spear_wooden", new SpearBase(ToolMaterials.WOOD, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("spear_stone", new SpearBase(ToolMaterials.STONE, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("spear_golden", new SpearBase(ToolMaterials.GOLD, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("spear_primsteel", new SpearBase(ModToolMaterials.PRIMSTEEL, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("spear_iron", new SpearBase(ToolMaterials.IRON, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("spear_rosegold", new SpearBase(ModToolMaterials.ROSEGOLD, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("spear_golemite", new SpearBase(ModToolMaterials.GOLEMITE, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("spear_diamond", new SpearBase(ToolMaterials.DIAMOND, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("spear_netherite", new SpearBase(ToolMaterials.NETHERITE, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));

        //Dagger
        Reg.register("dagger_wooden", new DaggerBase(ToolMaterials.WOOD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_stone", new DaggerBase(ToolMaterials.STONE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_golden", new DaggerBase(ToolMaterials.GOLD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_primsteel", new DaggerBase(ModToolMaterials.PRIMSTEEL, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_iron", new DaggerBase(ToolMaterials.IRON, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_rosegold", new DaggerBase(ModToolMaterials.ROSEGOLD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_golemite", new DaggerBase(ModToolMaterials.GOLEMITE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_diamond", new DaggerBase(ToolMaterials.DIAMOND, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_netherite", new DaggerBase(ToolMaterials.NETHERITE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));

        //Traveler
        Reg.register("traveler_wooden", new TravelerBase(ToolMaterials.WOOD, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_stone", new TravelerBase(ToolMaterials.STONE, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_golden", new TravelerBase(ToolMaterials.GOLD, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_primsteel", new TravelerBase(ModToolMaterials.PRIMSTEEL, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_iron", new TravelerBase(ToolMaterials.IRON, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_rosegold", new TravelerBase(ModToolMaterials.ROSEGOLD, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_golemite", new TravelerBase(ModToolMaterials.GOLEMITE, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_diamond", new TravelerBase(ToolMaterials.DIAMOND, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_netherite", new TravelerBase(ToolMaterials.NETHERITE, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));

        //Woodcutter's Axes
        Reg.register("wooden_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.WOOD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("stone_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.STONE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("golden_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.GOLD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("primsteel_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.PRIMSTEEL_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("iron_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.IRON_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.ROSEGOLD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("golemite_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.GOLEMITE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("diamond_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.DIAMOND_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("netherite_greatsword", new WoodcutterAxeBase(ModToolMaterialsExtended.NETHERITE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));

        //Swords
        Reg.register("primsteel_sword", new SwordItem(ModToolMaterials.PRIMSTEEL, SWORD_BASE_DAMAGE, SWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_sword", new SwordItem(ModToolMaterials.ROSEGOLD, SWORD_BASE_DAMAGE, SWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("golemite_sword", new SwordItem(ModToolMaterials.GOLEMITE, SWORD_BASE_DAMAGE, SWORD_BASE_SPEED, BASIC_SETTINGS));

        //Axes
        Reg.register("primsteel_axe", new AxeItem(ModToolMaterials.PRIMSTEEL, AXE_BASE_DAMAGE, AXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_axe", new AxeItem(ModToolMaterials.ROSEGOLD, AXE_BASE_DAMAGE, AXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("golemite_axe", new AxeItem(ModToolMaterials.GOLEMITE, AXE_BASE_DAMAGE, AXE_BASE_SPEED, BASIC_SETTINGS));

        //Pickaxes
        Reg.register("primsteel_pickaxe", new PickaxeItem(ModToolMaterials.PRIMSTEEL, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_pickaxe", new PickaxeItem(ModToolMaterials.ROSEGOLD, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("golemite_pickaxe", new PickaxeItem(ModToolMaterials.GOLEMITE, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS));

        //Shovels
        Reg.register("primsteel_shovel", new ShovelItem(ModToolMaterials.PRIMSTEEL, SHOVEL_BASE_DAMAGE, SHOVEL_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_shovel", new ShovelItem(ModToolMaterials.ROSEGOLD, SHOVEL_BASE_DAMAGE, SHOVEL_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("golemite_shovel", new ShovelItem(ModToolMaterials.GOLEMITE, SHOVEL_BASE_DAMAGE, SHOVEL_BASE_SPEED, BASIC_SETTINGS));

        //Hoes
        Reg.register("primsteel_hoe", new ShovelItem(ModToolMaterials.PRIMSTEEL, HOE_BASE_DAMAGE, HOE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_hoe", new ShovelItem(ModToolMaterials.ROSEGOLD, HOE_BASE_DAMAGE, HOE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("golemite_hoe", new ShovelItem(ModToolMaterials.GOLEMITE, HOE_BASE_DAMAGE, HOE_BASE_SPEED, BASIC_SETTINGS));

        //Meteorite Artifacts/Tools
        Reg.register("meteorite_sword", new SwordItem(ModToolMaterials.METEORITE, SWORD_BASE_DAMAGE, SWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("meteorite_short_sword", new TravelerBase(ModToolMaterials.METEORITE, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("meteorite_war_axe", new WoodcutterAxeBase(ModToolMaterials.METEORITE, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("meteorite_mace", new MaceBase(ModToolMaterials.METEORITE, MACE_BASE_DAMAGE, MACE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("meteorite_misericorde", new DaggerBase(ModToolMaterials.METEORITE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));

        //Artifacts
        Reg.register("ladle", LADLE);
        Reg.register("ancient_bamboo_staff", new StaffBase(ModToolMaterials.NATURES_BLESSING, STAFF_BASE_DAMAGE, STAFF_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_UNCOMMON));
        Reg.register("jungles_blessing", new ScytheBase(ModToolMaterials.NATURES_BLESSING, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_EPIC));
        Reg.register("field_surgeons_misericorde", new DaggerBase(ModToolMaterials.OBSIDIAN, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_EPIC));
        Reg.register("witch_blade", new DaggerBase(ModToolMaterials.AMETHYST, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_RARE));
        Reg.register("ancient_gear_mace", new MaceBase(ModToolMaterials.COPPER, MACE_BASE_DAMAGE, MACE_BASE_SPEED, BASIC_ARTIFACT_SETTINGS));
        Reg.register("knife_coral_encrusted", CORAL_KNIFE);
        Reg.register("rapier_cave_fishers", CAVE_FISHERS_RAPIER);
        Reg.register("prismace", new MaceBase(ModToolMaterials.PRISMARINE, MACE_BASE_DAMAGE, MACE_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_UNCOMMON));
        Reg.register("toy_sword", new TravelerBase(ToolMaterials.WOOD, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_RARE));
        Reg.register("moblin_sword_broken", MOBLIN_BROKEN);
        Reg.register("moblin_sword_fixed", new TravelerBase(ToolMaterials.IRON, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_UNCOMMON));
        Reg.register("dierdra_spear", new SpearBase(ToolMaterials.WOOD, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_RARE));
        Reg.register("seaologer_broken", SEAOLOGER_BROKEN);
        Reg.register("seaologer_fixed", SEAOLOGER_FIXED);
        Reg.register("ancient_climbing_axe", ANCIENT_CLIMBING_AXE);
        Reg.register("twinblade", new SpearBase(ModToolMaterials.GOLEMITE, SPEAR_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("piglin_battle_hammer", new WoodcutterAxeBase(ModToolMaterials.GOLEMITE, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));

        //rusty
        Reg.register("rusted_sword", RUSTY_SWORD);
        Reg.register("rusted_pickaxe", RUSTY_PICKAXE);
    }
}
