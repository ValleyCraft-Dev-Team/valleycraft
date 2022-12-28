package net.linkle.valleycraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class NautilusShellBlock extends DirectionBlockWithWater {
    protected static final VoxelShape EAST_SHAPE;
    protected static final VoxelShape WEST_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape NORTH_SHAPE;
    protected static final VoxelShape UP_SHAPE;
    protected static final VoxelShape DOWN_SHAPE;

    public NautilusShellBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .sounds(BlockSoundGroup.CALCITE).breakInstantly().nonOpaque());
        setDefaultState();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            case UP -> UP_SHAPE;
            case DOWN -> DOWN_SHAPE;
        };
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    static {
        var side_x = Block.createCuboidShape(6, 0, 2, 10, 11, 14);
        var side_z = Block.createCuboidShape(2, 0, 6, 14, 11, 10);
        var down = Block.createCuboidShape(2, 0, 2, 14, 4, 14);

        UP_SHAPE = side_z;
        DOWN_SHAPE = down;
        EAST_SHAPE = side_z;
        WEST_SHAPE = side_z;
        NORTH_SHAPE = side_x;
        SOUTH_SHAPE = side_x;
    }
}