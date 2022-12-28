package net.linkle.valleycraft.item;

import java.util.Map;

import org.jetbrains.annotations.Nullable;

import net.linkle.valleycraft.block.BridgeBlockExt;
import net.linkle.valleycraft.block.RopeBlockExt;
import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class RopeItem extends AliasedBlockItem {

    protected final Block verticalBlock;
    protected final Block horizontalBlock;
    
    public RopeItem(Settings settings) {
        super(ModBlocks.ROPE_VERTICAL.block, settings);
        this.verticalBlock = ModBlocks.ROPE_VERTICAL.block;
        this.horizontalBlock = ModBlocks.ROPE_HORIZONTAL.block;
    }
    
    @Override
    @Nullable
    protected BlockState getPlacementState(ItemPlacementContext context) {
        var block = context.getSide().getAxis().isVertical() ? verticalBlock : horizontalBlock;
        var state = block.getPlacementState(context);
        return state != null && this.canPlace(context, state) ? state : null;
    }
    
    @Override
    @Nullable
    public ItemPlacementContext getPlacementContext(ItemPlacementContext context) {
        if (context.getPlayer() == null) return context;
        var world = context.getWorld();
        BlockPos pos = context.getBlockPos().offset(context.getSide().getOpposite());
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof RopeBlockExt rope) {
            var isVertical = rope.isVertical();
            var facing = isVertical ? Direction.DOWN : context.getPlayerFacing();
            var mutable = pos.mutableCopy().move(facing);
            int i = 0;
            while (i < 5) {
                state = world.getBlockState(mutable);
                if (state.getBlock() instanceof RopeBlockExt block && block.isVertical() == isVertical) {
                    mutable.move(facing);
                    ++i;
                } else {
                    if (!state.canReplace(context)) break;
                    return ItemPlacementContext.offset(context, mutable, facing);
                }
            }
            return null;
        }
        return context;
    }
    
    @Override
    public void appendBlocks(Map<Block, Item> map, Item item) {
        super.appendBlocks(map, item);
        map.put(horizontalBlock, item);
    }
}
