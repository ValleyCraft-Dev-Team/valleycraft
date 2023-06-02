package net.linkle.valleycraft.tags;

import net.linkle.valleycraft.Main;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class ModBlockTags {
    public static final TagKey<Block> BIG_FLOWER_POTS = registerMod("big_flower_pots");
    public static final TagKey<Block> DIRT_STONE = registerMod("dirt_stone");

    public static void initialize() {
    }

    private static TagKey<Block> registerMod(String id) {
        return TagKey.of(Registry.BLOCK_KEY, Main.makeId(id));
    }
}
