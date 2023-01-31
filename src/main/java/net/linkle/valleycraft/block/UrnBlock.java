package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class UrnBlock extends ClayPotBlock {
    
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 16, 14);
    
    private final IntProvider experienceDropped;
    
    public UrnBlock(Settings settings) {
        this(settings, ConstantIntProvider.ZERO);
    }

    public UrnBlock(Settings settings, IntProvider experienceDropped) {
        super(settings);
        this.experienceDropped = experienceDropped;
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    
    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, stack, dropExperience);
        if (dropExperience) {
            this.dropExperienceWhenMined(world, pos, stack, this.experienceDropped);
        }
    }
}
