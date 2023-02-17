package net.linkle.valleycraft.block;

import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;

public class SpiderEggBlock extends Block {

    private static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 12, 12);
    
    public SpiderEggBlock() {
        super(Settings.of(Material.DECORATION).nonOpaque().sounds(BlockSoundGroup.WOOL).breakInstantly().resistance(0.1f));
    }

    private void spawnSpiders(ServerWorld world, BlockPos pos) {
        int randomSpiderAmount = MathHelper.nextBetween(world.random, 1, 3);
        for (int i = 0; i < randomSpiderAmount; i++) {
            var entity = EntityType.CAVE_SPIDER.create(world);
            entity.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
            world.spawnEntity(entity);
            entity.playSpawnEffects();
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.canPlaceAt(world, pos)) {
            return state;
        }

        return Blocks.AIR.getDefaultState();
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack,
            boolean dropExperience) {
        super.onStacksDropped(state, world, pos, stack, dropExperience);
        if (world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            spawnSpiders(world, pos);
        }
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (world instanceof ServerWorld server) {
            spawnSpiders(server, pos);
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity || entity instanceof CaveSpiderEntity) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
