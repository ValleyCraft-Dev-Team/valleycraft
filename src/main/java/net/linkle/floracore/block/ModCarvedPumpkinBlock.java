package net.linkle.floracore.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Wearable;
import net.minecraft.state.StateManager;

public class ModCarvedPumpkinBlock extends HorizontalFacingBlock implements Wearable {

    public ModCarvedPumpkinBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
