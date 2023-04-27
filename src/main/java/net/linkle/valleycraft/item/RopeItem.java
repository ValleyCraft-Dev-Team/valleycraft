package net.linkle.valleycraft.item;

import java.util.Map;
import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import net.linkle.valleycraft.block.RopeBlockExt;
import net.linkle.valleycraft.enums.BlockEnum;
import net.linkle.valleycraft.init.BlocksModded;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class RopeItem extends AliasedBlockItem {

    protected final Supplier<BlockEnum> verticalBlock;
    protected final Supplier<BlockEnum> horizontalBlock;
    
    public RopeItem(Settings settings) {
        super(Blocks.AIR, settings);
        this.verticalBlock = () -> BlocksModded.ROPE_VERTICAL;
        this.horizontalBlock = () -> BlocksModded.ROPE_HORIZONTAL;
    }
    
    @Override
    @Nullable
    protected BlockState getPlacementState(ItemPlacementContext context) {
        var block = context.getSide().getAxis().isVertical() ? verticalBlock.get().asBlock() : horizontalBlock.get().asBlock();
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
    public Block getBlock() {
    	return verticalBlock.get().asBlock();
    }
    
    @Override
    public void appendBlocks(Map<Block, Item> map, Item item) {
    	map.put(verticalBlock.get().asBlock(), item);
        map.put(horizontalBlock.get().asBlock(), item);
    }
}
