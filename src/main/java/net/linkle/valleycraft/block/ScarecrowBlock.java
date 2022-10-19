package net.linkle.valleycraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ScarecrowBlock extends HorizontalWithWaterBlock {
    private static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 32, 12);

    public ScarecrowBlock(boolean isGlowing) {
        super(FabricBlockSettings.of(Material.WOOD)
                .sounds(BlockSoundGroup.WOOD).nonOpaque()
                .strength(1f, 2f).luminance(isGlowing ? 13 : 0));
        setDefaultState();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx).getOpposite();
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
