package net.linkle.valleycraft.block;

import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.Direction;

public class FireTrapBlock extends DirectionBlock {
    public FireTrapBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx).getOpposite();
    }
}
