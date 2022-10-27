package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

/** block materials */
public class BlockMats {
    public static final Material POT = new FabricMaterialBuilder(MapColor.TERRACOTTA_BROWN).notSolid().build();
}
