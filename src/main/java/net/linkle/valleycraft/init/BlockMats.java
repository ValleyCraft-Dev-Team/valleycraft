package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

/** block materials */
public class BlockMats {
    public static final Material POT = new FabricMaterialBuilder(MapColor.TERRACOTTA_BROWN).build();
    public static final Material LADDER = new FabricMaterialBuilder(MapColor.OAK_TAN).lightPassesThrough().build();
    public static final Material ROPE = new FabricMaterialBuilder(MapColor.OAK_TAN).allowsMovement().lightPassesThrough().destroyedByPiston().build();
}
