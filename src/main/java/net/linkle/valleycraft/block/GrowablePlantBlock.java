package net.linkle.valleycraft.block;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.PlantVoxelShapes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GrowablePlantBlock extends ModPlantBlock implements Fertilizable {

	private final Identifier oldPlant;
	
	public GrowablePlantBlock(Settings settings, Identifier oldPlant) {
		super(PlantVoxelShapes.DEFAULT_PLANT_SHAPE, settings);
		this.oldPlant = oldPlant;
	}
	
	public GrowablePlantBlock(Settings settings, String oldPlant) {
		this(PlantVoxelShapes.DEFAULT_PLANT_SHAPE, settings, oldPlant);
	}
	
	public GrowablePlantBlock(VoxelShape shape, Settings settings, String oldPlant) {
		super(shape, settings);
		this.oldPlant = Main.makeId(oldPlant);
	}
	
	@Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }
    
	@Override
	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		var block = Registry.BLOCK.get(oldPlant);
		if (block instanceof TallPlantBlock) {
			if (block.getDefaultState().canPlaceAt(world, pos) && world.isAir(pos.up())) {
	            TallPlantBlock.placeAt(world, block.getDefaultState(), pos, Block.NOTIFY_LISTENERS);
	        }
		} else {
			world.setBlockState(pos, block.getDefaultState(), Block.NOTIFY_LISTENERS);
		}
	}
	
}
