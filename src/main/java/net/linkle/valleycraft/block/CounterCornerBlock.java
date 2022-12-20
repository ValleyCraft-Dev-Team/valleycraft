package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CounterCornerBlock extends HorizontalWithWaterBlock {

    protected static final VoxelShape NORTH_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape EAST_SHAPE;
    protected static final VoxelShape WEST_SHAPE;

    public CounterCornerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }
    
    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        if (ctx.getPlayer() == null) {
            return Direction.NORTH;
        }
        float yaw = ctx.getPlayer().getYaw()-45f;
        for (; yaw < -180f; yaw += 360f) {}
        return Direction.fromRotation(yaw);
    }
    
    static {
        var northBaseShape = Block.createCuboidShape(0, 0, 0, 16, 13, 12);
        var southBaseShape = Block.createCuboidShape(0, 0, 4, 16, 13, 16);
        var eastBaseShape = Block.createCuboidShape(4, 0, 0, 16, 13, 16);
        var westBaseShape = Block.createCuboidShape(0, 0, 0, 12, 13, 16);

        var northCounterShape = Block.createCuboidShape(0, 13, 0, 16, 16, 14);
        var southeCounterShape = Block.createCuboidShape(0, 13, 2, 16, 16, 16);
        var eastCounterShape = Block.createCuboidShape(2, 13, 0, 16, 16, 16);
        var westCounterShape = Block.createCuboidShape(0, 13, 0, 14, 16, 16);
        
        var northBasePartShape = Block.createCuboidShape(4, 0, 0, 16, 13, 16);
        var southBasePartShape = Block.createCuboidShape(0, 0, 0, 12, 13, 16);
        var eastBasePartShape = Block.createCuboidShape(0, 0, 4, 16, 13, 16);
        var westBasePartShape = Block.createCuboidShape(0, 0, 0, 16, 13, 12);

        var northCounterPartShape = Block.createCuboidShape(2, 13, 0, 16, 16, 16);
        var southeCounterPartShape = Block.createCuboidShape(0, 13, 0, 14, 16, 16);
        var eastCounterPartShape = Block.createCuboidShape(0, 13, 2, 16, 16, 16);
        var westCounterPartShape = Block.createCuboidShape(0, 13, 0, 16, 16, 14);
        
        NORTH_SHAPE = VoxelShapes.union(northBaseShape, northCounterShape, northBasePartShape, northCounterPartShape);
        SOUTH_SHAPE = VoxelShapes.union(southBaseShape, southeCounterShape, southBasePartShape, southeCounterPartShape);
        EAST_SHAPE = VoxelShapes.union(eastBaseShape, eastCounterShape, eastBasePartShape, eastCounterPartShape);
        WEST_SHAPE = VoxelShapes.union(westBaseShape, westCounterShape, westBasePartShape, westCounterPartShape);
    }
}
