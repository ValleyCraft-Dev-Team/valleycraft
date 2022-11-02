package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

/**
 * Commonly used for blocks with facing. Overriding the method such as
 * appendProperties and getPlacementState without calling the subclass method
 * 'super.appendProperties()' is prone to break block's horizontal facing.
 */
public class DirectionBlock extends FacingBlock {
    // DON"T COPY THIS CLASS! Just extent it lmao.

    protected DirectionBlock(Settings settings) {
        super(settings);
        setDefaultState();
    }

    /** A common method to set its default state. */
    protected final void setDefaultState() {
        setDefaultState(newDefaultState(Direction.NORTH));
    }

    /** A common method to get a new default state. */
    protected BlockState newDefaultState(Direction facing) {
        return stateManager.getDefaultState().with(FACING, facing);
    }

    /** Please call this subclass method to append facing property: <code>super.appendProperties(builder)</code> */
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public final BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public final BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(FACING, mirror.apply(state.get(FACING)));
    }

    /**
     * Use {@link DirectionBlock#getFacing(ItemPlacementContext)} if you only modify
     * face direction placement.
     */
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(FACING, getFacing(ctx));
    }

    /** Override this method for custom facing. */
    protected Direction getFacing(ItemPlacementContext ctx) {
        return ctx.getPlayerLookDirection();
    }
}
