package net.linkle.valleycraft.block;

import net.linkle.valleycraft.block.entity.WaypointBlockEntity;
import net.linkle.valleycraft.extension.ServerPlayerEntityExt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class WaypointBlock extends Block implements BlockEntityProvider {
    public WaypointBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WaypointBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            ((ServerPlayerEntityExt)player).setWaypointPos(pos);
            player.sendMessage(Text.translatable("text.valleycraft.waypoint.waypoint_set"), true);
        }
        return ActionResult.success(world.isClient);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = Direction.random(random);
            if (direction != Direction.UP) {
                BlockPos blockPos = pos.offset(direction);
                BlockState blockState = world.getBlockState(blockPos);
                if (!state.isOpaque() || !blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
                    double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetX() * 0.6D;
                    double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetY() * 0.6D;
                    double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetZ() * 0.6D;
                    world.addParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 0.0D, 0.0D, 0.0D);
                }
            }
            if (random.nextInt(5) == 0) {
                for (int i = 0; i < 32; i++) {
                    world.addParticle(ParticleTypes.ENCHANT, pos.getX() + 0.5 + (world.random.nextFloat() - 0.5) * 2, pos.getY() + 3, pos.getZ() + 0.5 + (world.random.nextFloat() - 0.5) * 2, random.nextDouble(), -3, random.nextDouble());
                    world.addParticle(ParticleTypes.ENCHANT, pos.getX() + 0.5 + (world.random.nextFloat() - 0.5) * 2, pos.getY() + 4, pos.getZ() + 0.5 + (world.random.nextFloat() - 0.5) * 2, random.nextDouble(), -3, random.nextDouble());
                }
            }
        }
    }
}
