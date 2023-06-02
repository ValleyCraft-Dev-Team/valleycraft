package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.tool.ModToolMaterials;
import net.linkle.valleycraft.tool.ModToolMaterialsExtended;
import net.linkle.valleycraft.tool.Scalpel;
import net.linkle.valleycraft.tool.anthro.AnthroPickaxeItem;
import net.linkle.valleycraft.tool.anthro.AnthroPickaxeMaterial;
import net.linkle.valleycraft.tool.bows.ModBowItem;
import net.linkle.valleycraft.tool.environmental.*;
import net.linkle.valleycraft.tool.greatsword.GreatswordBase;
import net.linkle.valleycraft.tool.hatchet.HatchetAxeBase;
import net.linkle.valleycraft.tool.knife.DaggerBase;
import net.linkle.valleycraft.tool.knife.KnifeBase;
import net.linkle.valleycraft.tool.rusty.*;
import net.linkle.valleycraft.tool.scythe.ScytheBase;
import net.linkle.valleycraft.tool.staff.StaffBase;
import net.linkle.valleycraft.tool.throwing.RockItem;
import net.linkle.valleycraft.tool.travelers_sword.TravelerBase;
import net.linkle.valleycraft.tool.unbreakable.UnbreakableScalpelBase;
import net.linkle.valleycraft.tool.woodcutter_axe.WoodcutterAxeBase;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static net.linkle.valleycraft.init.Groups.VC_TOOLS;

import net.linkle.valleycraft.interfaces.PreventDestroy;
import net.linkle.valleycraft.item.ClimbingAxeItem;
import net.linkle.valleycraft.item.ModHoeItem;

public class Tools {
    //When we need to access a tool or weapon elsewhere in the codebase, such as to inject them into loot tables, we need them stored in variables.

    //environmental tools
    public static final Item BRANCH = new BranchWeaponItem(new BranchToolMaterial(), 3, -2.0f);
    public static final Item DRIFTWOOD_BRANCH = new BranchWeaponItem(new BranchToolMaterial(), 3, -2.0f);

    //public static final Item MAKESHIFT_SPEAR = new BranchSpearItem(ModToolMaterials.MAKESHIFT_WOOD, 4, -2.8f);
    public static final Item MAKESHIFT_PICKAXE = new BranchPickaxeItem(ModToolMaterials.MAKESHIFT_FLINT, 3, -3.0f);
    public static final Item MAKESHIFT_AXE = new BranchAxeItem(ModToolMaterials.MAKESHIFT_STONE, 3, -3.0f);
    public static final Item MAKESHIFT_SHOVEL = new BranchShovelItem(ModToolMaterials.MAKESHIFT_WOOD, 1, -3.0f);
    public static final Item MAKESHIFT_HOE = new BranchHoeItem(ModToolMaterials.MAKESHIFT_WOOD, 0, -3.0f);
    //public static final Item FLINT_AND_PRIMSTEEL = new FlintAndSteelItem((new Item.Settings()).maxDamage(4).group(VC_TOOLS));
    //public static final Item MAKESHIFT_SHEARS = new ShearsItem((new Item.Settings()).maxDamage(4).group(VC_TOOLS));

    public static final Item RUSTY_SWORD = new RustySwordItem(new RustyMaterial(),4, -2.4f);
    public static final Item RUSTY_PICKAXE = new RustyPickaxeItem(new RustyMaterial(),2, -2.8f);
    public static final Item RUSTY_AXE = new RustyAxeItem(new RustyMaterial(),7, -3.0f);
    public static final Item RUSTY_HOE = new RustyHoeItem(new RustyMaterial(),0, -1.0f);
    public static final Item RUSTY_SHOVEL = new RustyShovelItem(new RustyMaterial(),2, -3.0f);

    public static final Item THROWING_ROCK = new RockItem(new Item.Settings().maxCount(64).group(VC_TOOLS));
    //public static final Item ANTHROPOLOGISTS_ROCK_PICK = new AnthroPickaxeItem(new AnthroPickaxeMaterial());

    //public static final Item ANCIENT_CLIMBING_AXE = new ClimbingAxeItem(ModToolMaterials.STRONG_IRON, new Item.Settings().group(BOOKS).rarity(Rarity.EPIC));
    //public static final Item CORAL_KNIFE = new CoralDaggerItem(new CoralDaggerToolMaterial(), 3, -1.4f);
    //public static final Item CAVE_FISHERS_RAPIER = new CaveFisherSwordItem(new CaveFisherToolMaterial(), 4, -2.4f);
    public static final Item CLIMBING_AXE = new ClimbingAxeItem(ModToolMaterials.BRASIUM, new Item.Settings().group(VC_TOOLS));

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

    public static final Integer MAKESHIFT_BASED_DAMAGE = 1;

    //The base attack speed of each tool type.
    //These numbers are subtracted from four, so 4.0 will make the tool never charge, and higher will likely cause issues.
    //Larger number = slower, smaller number = faster.
    public static final Float KNIFE_BASE_SPEED = -2.2f;
    public static final Float WOODCUTTER_BASE_SPEED = -3.3f;
    public static final Float SCYTHE_BASE_SPEED = -3.0f;
    public static final Float DAGGER_BASE_SPEED = -2.4f;
    public static final Float HATCHET_BASE_SPEED = -2.4f;
    public static final Float SPEAR_BASE_SPEED = -2.6f;
    public static final Float TRAVELER_BASE_SPEED = -2.2f;
    public static final Float MACE_BASE_SPEED = -2.2f;
    public static final Float STAFF_BASE_SPEED = -2.2f;
    public static final Float GREATSWORD_BASE_SPEED = -3.2f;

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
    public static final Item.Settings BASIC_SETTINGS_RARE = new Item.Settings().group(VC_TOOLS).rarity(Rarity.RARE);
    public static final Item.Settings BASIC_SETTINGS_UNCOMMON = new Item.Settings().group(VC_TOOLS).rarity(Rarity.UNCOMMON);
    //public static final Item.Settings BASIC_ARTIFACT_SETTINGS_RARE = new Item.Settings().group(BOOKS).rarity(Rarity.RARE);
    //public static final Item.Settings BASIC_ARTIFACT_SETTINGS_EPIC = new Item.Settings().group(BOOKS).rarity(Rarity.EPIC);
    //public static final Item.Settings BASIC_ARTIFACT_SETTINGS_UNCOMMON = new Item.Settings().group(BOOKS).rarity(Rarity.UNCOMMON);
    //public static final Item.Settings UNBREAKABLE_ARTIFACT_SETTINGS_EPIC_1561 = new Item.Settings().maxDamage(1561).fireproof().group(BOOKS).rarity(Rarity.EPIC);
    //public static final Item.Settings UNBREAKABLE_ARTIFACT_SETTINGS_EPIC_780 = new Item.Settings().maxDamage(780).fireproof().group(BOOKS).rarity(Rarity.EPIC);

    //bow reg
    public static final Item BRASIUM_COMPOUND = new ModBowItem(new FabricItemSettings().group(VC_TOOLS).maxDamage(770));

    //wooden tools
    public static final Item KNIFE_WOODEN = new KnifeBase(ToolMaterials.WOOD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS);
    public static final Item HATCHET_WOODEN = new HatchetAxeBase(ToolMaterials.WOOD, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS);
    public static final Item WOODCUTTER_AXE_WOODEN = new WoodcutterAxeBase(ModToolMaterialsExtended.WOOD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS);
    public static final Item SCYTHE_WOODEN = new ScytheBase(ToolMaterials.WOOD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS);
    public static final Item DAGGER_WOODEN = new DaggerBase(ToolMaterials.WOOD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS);
    public static final Item TRAVELER_WOODEN = new TravelerBase(ToolMaterials.WOOD, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS);
    public static final Item GREATSWORD_WOODEN = new GreatswordBase(ModToolMaterialsExtended.WOOD_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS);
    public static final Item WOODEN_OAR = new StaffBase(ModToolMaterials.PLANK, STAFF_BASE_DAMAGE, STAFF_BASE_SPEED, BASIC_SETTINGS);
    public static final Item WOODEN_STAFF = new StaffBase(ModToolMaterials.PLANK, STAFF_BASE_DAMAGE, STAFF_BASE_SPEED, BASIC_SETTINGS);
    public static final Item BAMBOO_STAFF = new StaffBase(ModToolMaterials.BAMBOO, STAFF_BASE_DAMAGE, STAFF_BASE_SPEED, BASIC_SETTINGS);

    public static final Item SCYTHE_IRON = new ScytheBase(ToolMaterials.IRON, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS);
    public static final Item DAGGER_IRON = new DaggerBase(ToolMaterials.IRON, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS);
    public static final Item ICE_TONGS = new PickaxeItem(ModToolMaterials.BRASIUM, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS);

    public static void initialize() {
        //Environmental
        Reg.register("branch", BRANCH);
        Reg.register("driftwood_branch", DRIFTWOOD_BRANCH);

        //Reg.register("sharp_flint", FLINT);
        //Reg.register("hefty_rock", HEFTY_ROCK);
        Reg.register("throwing_rock", THROWING_ROCK);
        //TODO add makeshift sword, hatchet, staff, spear
        Reg.register("makeshift_knife", new KnifeBase(ModToolMaterials.MAKESHIFT_WOOD, MAKESHIFT_BASED_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("makeshift_shovel", MAKESHIFT_SHOVEL);
        Reg.register("makeshift_pickaxe", MAKESHIFT_PICKAXE);
        Reg.register("makeshift_axe", MAKESHIFT_AXE);
        Reg.register("makeshift_hoe", MAKESHIFT_HOE);
        Reg.register("makeshift_club", new KnifeBase(ModToolMaterials.MAKESHIFT_WOOD, MAKESHIFT_BASED_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("makeshift_shears", MAKESHIFT_SHEARS);

        //makeshift bone
        Reg.register("knife_bone", new KnifeBase(ModToolMaterials.BONE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("bone_shovel", new ShovelItem(ModToolMaterials.BONE, SHOVEL_BASE_DAMAGE, SHOVEL_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("bone_pickaxe", new PickaxeItem(ModToolMaterials.BONE, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("bone_axe", new AxeItem(ModToolMaterials.BONE, AXE_BASE_DAMAGE, AXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("bone_hoe", new ModHoeItem(ModToolMaterials.BONE, HOE_BASE_DAMAGE, HOE_BASE_SPEED, BASIC_SETTINGS));

        //Reg.register("flint_and_primsteel", FLINT_AND_PRIMSTEEL);

        //dont add makeshift spear until adding in regular spears -> 1.1 w/ throwing ability?
        //Reg.register("makeshift_spear", MAKESHIFT_SPEAR);

        //Staffs
        Reg.register("wooden_staff", WOODEN_STAFF);
        Reg.register("bamboo_staff", BAMBOO_STAFF);

        //Specialty Tools
        Reg.register("wooden_oar", WOODEN_OAR);
        Reg.register("climbing_axe", CLIMBING_AXE);
        //Reg.register("anthropologists_rock_pick", ANTHROPOLOGISTS_ROCK_PICK);
        Reg.register("ice_tongs", ICE_TONGS);
        Reg.register("brasium_compound_bow", BRASIUM_COMPOUND);
        Reg.register("coral_knife", new Scalpel(ModToolMaterials.GUARDIAN, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS_UNCOMMON));
        Item knifeElder = Reg.register("coral_knife_guardian", new UnbreakableScalpelBase(ModToolMaterials.ELDER_GUARDIAN, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS_RARE));
        ModelPredicateProviderRegistry.register(knifeElder, new Identifier("broken"), (stack, world, entity, seed) -> PreventDestroy.isUsable(stack) ? 0.0f : 1.0f);

        //Knives
        Reg.register("knife_wooden", KNIFE_WOODEN);
        Reg.register("knife_stone", new KnifeBase(ToolMaterials.STONE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_golden", new KnifeBase(ToolMaterials.GOLD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("knife_primsteel", new KnifeBase(ModToolMaterials.PRIMSTEEL, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_iron", new KnifeBase(ToolMaterials.IRON, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_rosegold", new KnifeBase(ModToolMaterials.ROSEGOLD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_diamond", new KnifeBase(ToolMaterials.DIAMOND, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_echochalcum", new KnifeBase(ModToolMaterials.ECHOCHALCUM, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("knife_netherite", new KnifeBase(ToolMaterials.NETHERITE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_SETTINGS));

        //Hatchets
        Reg.register("hatchet_wooden", HATCHET_WOODEN);
        //Reg.register("hatchet_bone", new HatchetAxeBase(ModToolMaterials.BONE, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_stone", new HatchetAxeBase(ToolMaterials.STONE, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_golden", new HatchetAxeBase(ToolMaterials.GOLD, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("hatchet_primsteel", new HatchetAxeBase(ModToolMaterials.PRIMSTEEL, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_iron", new HatchetAxeBase(ToolMaterials.IRON, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_rosegold", new HatchetAxeBase(ModToolMaterials.ROSEGOLD, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_diamond", new HatchetAxeBase(ToolMaterials.DIAMOND, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_echochalcum", new HatchetAxeBase(ModToolMaterials.ECHOCHALCUM, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("hatchet_netherite", new HatchetAxeBase(ToolMaterials.NETHERITE, HATCHET_BASE_DAMAGE, HATCHET_BASE_SPEED, BASIC_SETTINGS));

        //Woodcutter's Axes (upgrade from axe)
        Reg.register("woodcutter_axe_wooden", WOODCUTTER_AXE_WOODEN);
        //Reg.register("woodcutter_axe_bone", new WoodcutterAxeBase(ModToolMaterialsExtended.BONE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_stone", new WoodcutterAxeBase(ModToolMaterialsExtended.STONE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_golden", new WoodcutterAxeBase(ModToolMaterialsExtended.GOLD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("woodcutter_axe_primsteel", new WoodcutterAxeBase(ModToolMaterialsExtended.PRIMSTEEL_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_iron", new WoodcutterAxeBase(ModToolMaterialsExtended.IRON_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_rosegold", new WoodcutterAxeBase(ModToolMaterialsExtended.ROSEGOLD_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_diamond", new WoodcutterAxeBase(ModToolMaterialsExtended.DIAMOND_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_echochalcum", new WoodcutterAxeBase(ModToolMaterialsExtended.ECHOCHALCUM_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("woodcutter_axe_netherite", new WoodcutterAxeBase(ModToolMaterialsExtended.NETHERITE_EXTENDED, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_SETTINGS));

        //Scythes (upgrade from hoe)
        Reg.register("scythe_wooden", SCYTHE_WOODEN);
        //Reg.register("scythe_bone", new ScytheBase(ModToolMaterials.BONE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_stone", new ScytheBase(ToolMaterials.STONE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_golden", new ScytheBase(ToolMaterials.GOLD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("scythe_primsteel", new ScytheBase(ModToolMaterials.PRIMSTEEL, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_iron", SCYTHE_IRON);
        Reg.register("scythe_rosegold", new ScytheBase(ModToolMaterials.ROSEGOLD, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_diamond", new ScytheBase(ToolMaterials.DIAMOND, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_echochalcum", new ScytheBase(ModToolMaterials.ECHOCHALCUM, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("scythe_netherite", new ScytheBase(ToolMaterials.NETHERITE, SCYTHE_BASE_DAMAGE, SCYTHE_BASE_SPEED, BASIC_SETTINGS));

        //Spear
        //Reg.register("spear_wooden", new SpearBase(ToolMaterials.WOOD, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("spear_stone", new SpearBase(ToolMaterials.STONE, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("spear_golden", new SpearBase(ToolMaterials.GOLD, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("spear_primsteel", new SpearBase(ModToolMaterials.PRIMSTEEL, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("spear_iron", new SpearBase(ToolMaterials.IRON, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("spear_rosegold", new SpearBase(ModToolMaterials.ROSEGOLD, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("spear_diamond", new SpearBase(ToolMaterials.DIAMOND, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("spear_netherite", new SpearBase(ToolMaterials.NETHERITE, SPEAR_BASE_DAMAGE, SPEAR_BASE_SPEED, BASIC_SETTINGS));

        //Dagger (upgrade from knife)
        Reg.register("dagger_wooden", DAGGER_WOODEN);
        //Reg.register("dagger_bone", new DaggerBase(ModToolMaterials.BONE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_stone", new DaggerBase(ToolMaterials.STONE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_golden", new DaggerBase(ToolMaterials.GOLD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("dagger_primsteel", new DaggerBase(ModToolMaterials.PRIMSTEEL, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_iron", DAGGER_IRON);
        Reg.register("dagger_rosegold", new DaggerBase(ModToolMaterials.ROSEGOLD, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_diamond", new DaggerBase(ToolMaterials.DIAMOND, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_echochalcum", new DaggerBase(ModToolMaterials.ECHOCHALCUM, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("dagger_netherite", new DaggerBase(ToolMaterials.NETHERITE, DAGGER_BASE_DAMAGE, DAGGER_BASE_SPEED, BASIC_SETTINGS));

        //Traveler (upgrade from knife)
        Reg.register("traveler_wooden", TRAVELER_WOODEN);
        //Reg.register("traveler_bone", new TravelerBase(ModToolMaterials.BONE, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_stone", new TravelerBase(ToolMaterials.STONE, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_golden", new TravelerBase(ToolMaterials.GOLD, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("traveler_primsteel", new TravelerBase(ModToolMaterials.PRIMSTEEL, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_iron", new TravelerBase(ToolMaterials.IRON, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_rosegold", new TravelerBase(ModToolMaterials.ROSEGOLD, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_diamond", new TravelerBase(ToolMaterials.DIAMOND, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_echochalcum", new TravelerBase(ModToolMaterials.ECHOCHALCUM, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("traveler_netherite", new TravelerBase(ToolMaterials.NETHERITE, TRAVELER_BASE_DAMAGE, TRAVELER_BASE_SPEED, BASIC_SETTINGS));

        //Greatswords (upgrade from sword)
        Reg.register("wooden_greatsword", GREATSWORD_WOODEN);
        //Reg.register("bone_greatsword", new GreatswordBase(ModToolMaterialsExtended.BONE_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("stone_greatsword", new GreatswordBase(ModToolMaterialsExtended.STONE_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("golden_greatsword", new GreatswordBase(ModToolMaterialsExtended.GOLD_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("primsteel_greatsword", new GreatswordBase(ModToolMaterialsExtended.PRIMSTEEL_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("iron_greatsword", new GreatswordBase(ModToolMaterialsExtended.IRON_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_greatsword", new GreatswordBase(ModToolMaterialsExtended.ROSEGOLD_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("diamond_greatsword", new GreatswordBase(ModToolMaterialsExtended.DIAMOND_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("echochalcum_greatsword", new GreatswordBase(ModToolMaterialsExtended.ECHOCHALCUM_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("netherite_greatsword", new GreatswordBase(ModToolMaterialsExtended.NETHERITE_EXTENDED, GREATSWORD_BASE_DAMAGE, GREATSWORD_BASE_SPEED, BASIC_SETTINGS));

        //Bone
        //Reg.register("bone_sword", new SwordItem(ModToolMaterials.BONE, SWORD_BASE_DAMAGE, SWORD_BASE_SPEED, BASIC_SETTINGS));

        //Primsteel
        //Reg.register("primsteel_sword", new SwordItem(ModToolMaterials.PRIMSTEEL, SWORD_BASE_DAMAGE, SWORD_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("primsteel_shovel", new ShovelItem(ModToolMaterials.PRIMSTEEL, SHOVEL_BASE_DAMAGE, SHOVEL_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("primsteel_pickaxe", new PickaxeItem(ModToolMaterials.PRIMSTEEL, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("primsteel_axe", new AxeItem(ModToolMaterials.PRIMSTEEL, AXE_BASE_DAMAGE, AXE_BASE_SPEED, BASIC_SETTINGS));
        //Reg.register("primsteel_hoe", new ModHoeItem(ModToolMaterials.PRIMSTEEL, HOE_BASE_DAMAGE, HOE_BASE_SPEED, BASIC_SETTINGS));

        //Rosegold
        Reg.register("rosegold_sword", new SwordItem(ModToolMaterials.ROSEGOLD, SWORD_BASE_DAMAGE, SWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_shovel", new ShovelItem(ModToolMaterials.ROSEGOLD, SHOVEL_BASE_DAMAGE, SHOVEL_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_pickaxe", new PickaxeItem(ModToolMaterials.ROSEGOLD, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_axe", new AxeItem(ModToolMaterials.ROSEGOLD, AXE_BASE_DAMAGE, AXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("rosegold_hoe", new ModHoeItem(ModToolMaterials.ROSEGOLD, HOE_BASE_DAMAGE, HOE_BASE_SPEED, BASIC_SETTINGS));

        //Echochalcum
        Reg.register("echochalcum_sword", new SwordItem(ModToolMaterials.ECHOCHALCUM, SWORD_BASE_DAMAGE, SWORD_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("echochalcum_shovel", new ShovelItem(ModToolMaterials.ECHOCHALCUM, SHOVEL_BASE_DAMAGE, SHOVEL_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("echochalcum_pickaxe", new PickaxeItem(ModToolMaterials.ECHOCHALCUM, PICKAXE_BASE_DAMAGE, PICKAXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("echochalcum_axe", new AxeItem(ModToolMaterials.ECHOCHALCUM, AXE_BASE_DAMAGE, AXE_BASE_SPEED, BASIC_SETTINGS));
        Reg.register("echochalcum_hoe", new ModHoeItem(ModToolMaterials.ECHOCHALCUM, HOE_BASE_DAMAGE, HOE_BASE_SPEED, BASIC_SETTINGS));

        //rusty
        Reg.register("rusted_sword", RUSTY_SWORD);
        Reg.register("rusted_shovel", RUSTY_SHOVEL);
        Reg.register("rusted_pickaxe", RUSTY_PICKAXE);
        Reg.register("rusted_axe", RUSTY_AXE);
        Reg.register("rusted_hoe", RUSTY_HOE);

        //artifacts
        //tools
        //Reg.register("prismarine_hoe", new ModPrismarineHoeItem(ModToolMaterials.PRISMARINE, HOE_BASE_DAMAGE, HOE_BASE_SPEED, BASIC_ARTIFACT_SETTINGS_RARE));
        //weapons
        //Reg.register("knife_coral_encrusted", CORAL_KNIFE);
        //Reg.register("rapier_cave_fishers", CAVE_FISHERS_RAPIER);
    }
}
