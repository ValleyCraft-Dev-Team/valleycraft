package net.linkle.valleycraft.init;

import net.linkle.valleycraft.tool.environmental.*;
import net.linkle.valleycraft.tool.knife.KnifeBase;
import net.linkle.valleycraft.tool.knife.special.CoralDaggerItem;
import net.linkle.valleycraft.tool.knife.special.CoralDaggerToolMaterial;
import net.linkle.valleycraft.tool.shovel.special.OarItem;
import net.linkle.valleycraft.tool.shovel.special.OarToolMaterial;
import net.linkle.valleycraft.tool.sword.special.*;
import net.linkle.valleycraft.tool.woodcutter_axe.WoodcutterAxeBase;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;

import static net.linkle.valleycraft.init.ModGroups.VC_TOOLS;

public class ModTools {
    //When we need to access a tool or weapon elsewhere in the codebase, such as to inject them into loot tables, we need them stored in variables.
    //environmental tools
    public static final Item BRANCH = new BranchToolItem(new BranchToolMaterial(), 3, -2.0f);
    public static final Item FLINT = new FlintToolItem(new FlintToolMaterial());
    public static final Item HEFTY_ROCK = new RockToolItem(new RockToolMaterial());
    public static final Item RUSTY_SWORD = new RustySwordItem(new RustySwordMaterial(),4, -2.4f);
    public static final Item OAR = new OarItem(new OarToolMaterial(),3, -2.5f);

    public static final Item CORAL_KNIFE = new CoralDaggerItem(new CoralDaggerToolMaterial(), 3, -1.4f);
    public static final Item CAVE_FISHERS_RAPIER = new CaveFisherSwordItem(new CaveFisherToolMaterial(), 4, -2.4f);
    public static final Item SEAOLOGER_BROKEN = new BrokenSeagerCutlassItem(new BrokenSeagerToolMaterial(), 2, -1.8f);
    public static final Item SEAOLOGER_FIXED = new FixedSeagerCutlassItem(new FixedSeagerToolMaterial(), 5, -1.8f);

    //The base attack damage of each tool type.
    //These values are added to the attack stats of their materials when they're registered.
    //The attack stats are listed in RoseGoldToolMaterial.class.
    public static final Integer KNIFE_BASE_DAMAGE = 1;
    public static final Integer WOODCUTTER_BASE_DAMAGE = 2;
    //The base attack speed of each tool type.
    //These numbers are subtracted from four, so 4.0 will make the tool never charge, and higher will likely cause issues.
    //Larger number = slower, smaller number = faster.
    public static final Float KNIFE_BASE_SPEED = -2.0f;
    public static final Float WOODCUTTER_BASE_SPEED = -3.5f;
    //The item settings for knives made of 'basic' materials- wood, gold, stone, iron, rose gold, diamond, netherite
    public static final Item.Settings BASIC_KNIFE_SETTINGS = new Item.Settings().group(VC_TOOLS);
    public static final Item.Settings BASIC_WOODCUTTER_SETTINGS = new Item.Settings().group(VC_TOOLS);

    public static void initialize() {
        //Environmental
        Reg.register("branch", BRANCH);
        Reg.register("sharp_flint", FLINT);
        Reg.register("hefty_rock", HEFTY_ROCK);
        Reg.register("rusted_sword", RUSTY_SWORD);

        //Material technically
        Reg.register("wooden_oar", OAR);

        //Knives
        Reg.register("knife_wooden", new KnifeBase(ToolMaterials.WOOD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_stone", new KnifeBase(ToolMaterials.STONE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_golden", new KnifeBase(ToolMaterials.GOLD, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_iron", new KnifeBase(ToolMaterials.IRON, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_diamond", new KnifeBase(ToolMaterials.DIAMOND, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));
        Reg.register("knife_netherite", new KnifeBase(ToolMaterials.NETHERITE, KNIFE_BASE_DAMAGE, KNIFE_BASE_SPEED, BASIC_KNIFE_SETTINGS));

        //Woodcutter's Axes
        Reg.register("woodcutter_axe_wooden", new WoodcutterAxeBase(ToolMaterials.WOOD, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_stone", new WoodcutterAxeBase(ToolMaterials.STONE, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_golden", new WoodcutterAxeBase(ToolMaterials.GOLD, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_iron", new WoodcutterAxeBase(ToolMaterials.IRON, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_diamond", new WoodcutterAxeBase(ToolMaterials.DIAMOND, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));
        Reg.register("woodcutter_axe_netherite", new WoodcutterAxeBase(ToolMaterials.NETHERITE, WOODCUTTER_BASE_DAMAGE, WOODCUTTER_BASE_SPEED, BASIC_WOODCUTTER_SETTINGS));

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
    }
}
