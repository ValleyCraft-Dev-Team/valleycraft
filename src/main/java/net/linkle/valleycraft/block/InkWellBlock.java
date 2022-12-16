package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class InkWellBlock extends HorizontalWithWaterBlock {
    
    protected static final VoxelShape SHAPE = Block.createCuboidShape(6, 0, 6, 10, 6, 10);

    public InkWellBlock() {
        this(settings());
    }
    
    public InkWellBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }
    
    public static Settings settings() {
        return Settings.of(Material.DECORATION).breakInstantly().sounds(BlockSoundGroup.GLASS).nonOpaque();
    }
}
