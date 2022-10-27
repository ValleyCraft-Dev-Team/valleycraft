package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.BlockMats;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ModLadderBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape EAST_SHAPE;
    protected static final VoxelShape WEST_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape NORTH_SHAPE;

    public ModLadderBlock(Settings setting) {
        super(setting);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
        case SOUTH -> SOUTH_SHAPE;
        case WEST -> WEST_SHAPE;
        case EAST -> EAST_SHAPE;
        default -> NORTH_SHAPE;
        };
    }

    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        var pos = ctx.getBlockPos();
        var world = ctx.getWorld();
        var side = ctx.getSide();
        BlockState state;

        if (side.getAxis().isVertical()) {
            state = world.getBlockState(pos.offset(side.getOpposite()));
            if (state.getBlock() instanceof ModLadderBlock) {
                return state.get(FACING);
            }
        }

        if ((state = world.getBlockState(pos.down())).getBlock() instanceof ModLadderBlock) {
            return state.get(FACING);
        }
        if ((state = world.getBlockState(pos.up())).getBlock() instanceof ModLadderBlock) {
            return state.get(FACING);
        }

        return getSideElseUserFacing(ctx);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
    
    public static Settings settings() {
        return Settings.of(BlockMats.LADDER).nonOpaque();
    }

    static {
        EAST_SHAPE = Block.createCuboidShape(13,0,0,16,16,16);
        NORTH_SHAPE = Block.createCuboidShape(0,0,0,16,16,3);
        WEST_SHAPE = Block.createCuboidShape(0,0,0,3,16,16);
        SOUTH_SHAPE = Block.createCuboidShape(0,0,13,16,16,16);
    }
}

