package net.linkle.valleycraft.block;

import java.util.function.Supplier;

import com.google.common.collect.ImmutableMap;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.init.BlocksNatural;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class SludgeFluidBlock extends FluidBlock {
    
    private static final Material MATERIAL = new FabricMaterialBuilder(MapColor.DARK_GREEN).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().liquid().build();
    
    // convert stone blocks into a cracked variant if contacted.
    private static final ImmutableMap<Block, Supplier<Block>> MAP;
    static {
        var builder = new ImmutableMap.Builder<Block, Supplier<Block>>();
        builder.put(Blocks.COBBLESTONE, ()-> BlocksNatural.LOOSE_ROCKS.block);
        builder.put(Blocks.DEEPSLATE_BRICKS, ()->Blocks.CRACKED_DEEPSLATE_BRICKS);
        builder.put(Blocks.DEEPSLATE_TILES, ()->Blocks.CRACKED_DEEPSLATE_TILES);
        builder.put(Blocks.NETHER_BRICKS, ()->Blocks.CRACKED_NETHER_BRICKS);
        builder.put(Blocks.STONE_BRICKS, ()->Blocks.CRACKED_STONE_BRICKS);
        builder.put(Blocks.INFESTED_STONE_BRICKS, ()->Blocks.INFESTED_CRACKED_STONE_BRICKS);
        builder.put(Blocks.POLISHED_BLACKSTONE_BRICKS, ()->Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        MAP = builder.build();
    }
    
    public SludgeFluidBlock(FlowableFluid fluid) {
        super(fluid, Settings.of(MATERIAL).noCollision().strength(100.0f).dropsNothing());
    }
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if ((pos.getY() + state.getFluidState().getHeight(world, pos)) >= entity.getBoundingBox().minY) {
            entity.setVelocity(entity.getVelocity().multiply(0.9, 0.9, 0.9));
            if (entity instanceof LivingEntity living) {
                living.addStatusEffect(new StatusEffectInstance(ModEffects.ROT_BLIGHT, 7 * 20));
            }
        }
    }
    
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);
        convertBlock(world, pos);
    }
    
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);
        convertBlock(world, pos);
    }
    
    private void convertBlock(World world, BlockPos pos) {
        for (var face : Direction.values()) {
            if (face == Direction.UP) continue;
            var neigborPos = pos.offset(face);
            var neigborBlock = world.getBlockState(neigborPos);
            var crackedBlock = MAP.get(neigborBlock.getBlock());
            if (crackedBlock != null) {
                world.setBlockState(neigborPos, crackedBlock.get().getDefaultState());
                world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, neigborPos, Block.getRawIdFromState(neigborBlock));
            }
        }
    }
    
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
