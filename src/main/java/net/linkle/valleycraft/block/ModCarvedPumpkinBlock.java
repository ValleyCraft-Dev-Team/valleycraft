package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.function.MaterialPredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * An extension of CarvedPumpkinBlock that lets our carved pumpkins and jack o' lanterns be used to make golems.
 *
 * Because mojank was a piece of shit and made most of the methods in that class private,
 * I had to duplicate every method and field relevant to golem assembling to this class.
 * The only changes between these methods and fields and the ones in the superclass is the changed IS_GOLEM_HEAD_PREDICATE,
 * the arrays in the BlockPattern fields being changes according to IntelliJ's recommendations, and two redundant casts removed.
 *
 * There's probably a smarter way to do this using mixin or "access wideners" or some shit,
 * but I almost had two meltdowns trying to get that shit to work. I'm done. This is my solution.
 */

public class ModCarvedPumpkinBlock extends CarvedPumpkinBlock {
    @Nullable
    private BlockPattern snowGolemDispenserPattern;
    @Nullable
    private BlockPattern snowGolemPattern;
    @Nullable
    private BlockPattern ironGolemDispenserPattern;
    @Nullable
    private BlockPattern ironGolemPattern;
    private static final Predicate<BlockState> IS_GOLEM_HEAD_PREDICATE;

    public ModCarvedPumpkinBlock(Settings settings) {
        super(settings);
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            this.trySpawnEntity(world, pos);
        }
    }

    public boolean canDispense(WorldView world, BlockPos pos) {
        return this.getSnowGolemDispenserPattern().searchAround(world, pos) != null || this.getIronGolemDispenserPattern().searchAround(world, pos) != null;
    }

    private void trySpawnEntity(World world, BlockPos pos) {
        BlockPattern.Result result = this.getSnowGolemPattern().searchAround(world, pos);
        int i;
        Iterator var6;
        ServerPlayerEntity serverPlayerEntity;
        int j;
        if (result != null) {
            for(i = 0; i < this.getSnowGolemPattern().getHeight(); ++i) {
                CachedBlockPosition cachedBlockPosition = result.translate(0, i, 0);
                world.setBlockState(cachedBlockPosition.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                world.syncWorldEvent(2001, cachedBlockPosition.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition.getBlockState()));
            }

            SnowGolemEntity snowGolemEntity = EntityType.SNOW_GOLEM.create(world);
            BlockPos blockPos = result.translate(0, 2, 0).getBlockPos();
            snowGolemEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5D, (double)blockPos.getY() + 0.05D, (double)blockPos.getZ() + 0.5D, 0.0F, 0.0F);
            world.spawnEntity(snowGolemEntity);
            var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, snowGolemEntity.getBoundingBox().expand(5.0D)).iterator();

            while(var6.hasNext()) {
                serverPlayerEntity = (ServerPlayerEntity)var6.next();
                Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, snowGolemEntity);
            }

            for(j = 0; j < this.getSnowGolemPattern().getHeight(); ++j) {
                CachedBlockPosition cachedBlockPosition2 = result.translate(0, j, 0);
                world.updateNeighbors(cachedBlockPosition2.getBlockPos(), Blocks.AIR);
            }
        } else {
            result = this.getIronGolemPattern().searchAround(world, pos);
            if (result != null) {
                for(i = 0; i < this.getIronGolemPattern().getWidth(); ++i) {
                    for(int k = 0; k < this.getIronGolemPattern().getHeight(); ++k) {
                        CachedBlockPosition cachedBlockPosition3 = result.translate(i, k, 0);
                        world.setBlockState(cachedBlockPosition3.getBlockPos(), Blocks.AIR.getDefaultState(), 2);
                        world.syncWorldEvent(2001, cachedBlockPosition3.getBlockPos(), Block.getRawIdFromState(cachedBlockPosition3.getBlockState()));
                    }
                }

                BlockPos blockPos2 = result.translate(1, 2, 0).getBlockPos();
                IronGolemEntity ironGolemEntity = EntityType.IRON_GOLEM.create(world);
                ironGolemEntity.setPlayerCreated(true);
                ironGolemEntity.refreshPositionAndAngles((double)blockPos2.getX() + 0.5D, (double)blockPos2.getY() + 0.05D, (double)blockPos2.getZ() + 0.5D, 0.0F, 0.0F);
                world.spawnEntity(ironGolemEntity);
                var6 = world.getNonSpectatingEntities(ServerPlayerEntity.class, ironGolemEntity.getBoundingBox().expand(5.0D)).iterator();

                while(var6.hasNext()) {
                    serverPlayerEntity = (ServerPlayerEntity)var6.next();
                    Criteria.SUMMONED_ENTITY.trigger(serverPlayerEntity, ironGolemEntity);
                }

                for(j = 0; j < this.getIronGolemPattern().getWidth(); ++j) {
                    for(int l = 0; l < this.getIronGolemPattern().getHeight(); ++l) {
                        CachedBlockPosition cachedBlockPosition4 = result.translate(j, l, 0);
                        world.updateNeighbors(cachedBlockPosition4.getBlockPos(), Blocks.AIR);
                    }
                }
            }
        }
    }

    private BlockPattern getSnowGolemDispenserPattern() {
        if (this.snowGolemDispenserPattern == null) {
            this.snowGolemDispenserPattern = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.snowGolemDispenserPattern;
    }

    private BlockPattern getSnowGolemPattern() {
        if (this.snowGolemPattern == null) {
            this.snowGolemPattern = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.snowGolemPattern;
    }

    private BlockPattern getIronGolemDispenserPattern() {
        if (this.ironGolemDispenserPattern == null) {
            this.ironGolemDispenserPattern = BlockPatternBuilder.start().aisle("~ ~", "###", "~#~").where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.IRON_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.ironGolemDispenserPattern;
    }

    private BlockPattern getIronGolemPattern() {
        if (this.ironGolemPattern == null) {
            this.ironGolemPattern = BlockPatternBuilder.start().aisle("~^~", "###", "~#~").where('^', CachedBlockPosition.matchesBlockState(IS_GOLEM_HEAD_PREDICATE)).where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.IRON_BLOCK))).where('~', CachedBlockPosition.matchesBlockState(MaterialPredicate.create(Material.AIR))).build();
        }

        return this.ironGolemPattern;
    }

    static {
        IS_GOLEM_HEAD_PREDICATE = (state) -> {
            return state != null && (state.isOf(ModBlocks.GHOST_PUMPKIN_CARVED.block) || state.isOf(ModBlocks.GHOST_JACK_O_LANTERN.block));
        };
    }
}
