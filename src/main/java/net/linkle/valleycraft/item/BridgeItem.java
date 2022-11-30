package net.linkle.valleycraft.item;

import org.jetbrains.annotations.Nullable;

import net.linkle.valleycraft.block.BridgeBlockExt;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.Direction;

public class BridgeItem extends BlockItem {
    
    protected final BridgeBlockExt bridge;

    public BridgeItem(Block block, Settings settings) {
        super(block, settings);
        this.bridge = (BridgeBlockExt)block;
    }

    @Override
    @Nullable
    public ItemPlacementContext getPlacementContext(ItemPlacementContext context) {
        if (context.getSide() == Direction.UP) {
            var pos = context.getBlockPos().down();
            var world = context.getWorld();
            var state = world.getBlockState(pos);
            if (state.getBlock() instanceof BridgeBlockExt) {
                var facing = context.getPlayerFacing();
                var mutable = pos.mutableCopy().move(facing);
                int i = 0;
                while (i < 5) {
                    state = world.getBlockState(mutable);
                    if (state.getBlock() instanceof BridgeBlockExt bridge && !bridge.isAnchor()) {
                        mutable.move(facing);
                        ++i;
                    } else {
                        if (!state.canReplace(context)) break;
                        return ItemPlacementContext.offset(context, mutable, facing);
                    }
                }
                return null;
            }
        }
        return context;
    }

    @Override
    protected boolean checkStatePlacement() {
        return false;
    }
}
