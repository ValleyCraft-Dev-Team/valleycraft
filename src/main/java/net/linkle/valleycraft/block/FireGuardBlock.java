package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.List;

public class FireGuardBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape NORTH_SHAPE_OUTLINE = Block.createCuboidShape(0,0, 0, 16, 13, 4);
    protected static final VoxelShape SOUTH_SHAPE_OUTLINE = Block.createCuboidShape(0, 0, 12, 16, 13, 16);
    protected static final VoxelShape WEST_SHAPE_OUTLINE = Block.createCuboidShape(0, 0, 0, 4, 13, 16);
    protected static final VoxelShape EAST_SHAPE_OUTLINE = Block.createCuboidShape(12, 0, 0, 16, 13, 16);
    protected static final VoxelShape NORTH_SHAPE_COLLISION = Block.createCuboidShape(0,0, 0, 16, 24, 4);
    protected static final VoxelShape SOUTH_SHAPE_COLLISION = Block.createCuboidShape(0, 0, 12, 16, 24, 16);
    protected static final VoxelShape WEST_SHAPE_COLLISION = Block.createCuboidShape(0, 0, 0, 4, 24, 16);
    protected static final VoxelShape EAST_SHAPE_COLLISION = Block.createCuboidShape(12, 0, 0, 16, 24, 16);

    public FireGuardBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE_OUTLINE;
            case SOUTH -> SOUTH_SHAPE_OUTLINE;
            case WEST -> WEST_SHAPE_OUTLINE;
            case EAST ->  EAST_SHAPE_OUTLINE;
            default -> NORTH_SHAPE_OUTLINE;
        };
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE_COLLISION;
            case SOUTH -> SOUTH_SHAPE_COLLISION;
            case WEST -> WEST_SHAPE_COLLISION;
            case EAST ->  EAST_SHAPE_COLLISION;
            default -> NORTH_SHAPE_COLLISION;
        };
    }

    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("block.valleycraft.fireguard.tooltip").formatted(Formatting.AQUA) );
        tooltip.add( Text.translatable("block.valleycraft.fireguard.tooltip_2").formatted(Formatting.AQUA) );
    }
}
