package net.linkle.valleycraft.block;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class CandleBottleBlock extends BlockWithWater {
    
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5, 11, 9, 11);

    public CandleBottleBlock() {
        this(settings());
    }
    
    public CandleBottleBlock(Settings settings) {
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
        return Settings.of(Material.DECORATION).strength(0.2f).sounds(BlockSoundGroup.GLASS).nonOpaque();
    }
}
