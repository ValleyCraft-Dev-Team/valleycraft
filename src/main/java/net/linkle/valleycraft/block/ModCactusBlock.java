package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.PlantGroundPredicates;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ModCactusBlock extends ModPlantBlock {
    
    public ModCactusBlock(VoxelShape shape) {
        super(Settings.of(Material.PLANT).nonOpaque().strength(0.3f).sounds(BlockSoundGroup.WOOL));
        ground(PlantGroundPredicates.SAND);
        this.shape = shape;
    }
    
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
    
    @Override
    public float getMaxHorizontalModelOffset() {
        return 0.2f;
    }
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.damage(DamageSource.CACTUS, 1.0f);
    }
}
