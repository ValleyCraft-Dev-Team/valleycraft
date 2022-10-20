package net.linkle.valleycraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.linkle.valleycraft.init.ModBlocks;
import net.linkle.valleycraft.init.NaturalBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class GhostPumpkinBlock extends GourdBlock {

    public GhostPumpkinBlock() {
        super(settings());
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player2, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player2.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS)) {
            if (!world.isClient) {
                Direction direction = hit.getSide();
                Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player2.getHorizontalFacing().getOpposite() : direction;
                world.playSound(null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.setBlockState(pos, ModBlocks.GHOST_PUMPKIN_CARVED.getState().with(ModCarvedPumpkinBlock.FACING, direction2), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
                ItemEntity itemEntity = new ItemEntity(world, (double)pos.getX() + 0.5 + (double)direction2.getOffsetX() * 0.65, (double)pos.getY() + 0.1, (double)pos.getZ() + 0.5 + (double)direction2.getOffsetZ() * 0.65, new ItemStack(Items.PUMPKIN_SEEDS, 4));
                itemEntity.setVelocity(0.05 * (double)direction2.getOffsetX() + world.random.nextDouble() * 0.02, 0.05, 0.05 * (double)direction2.getOffsetZ() + world.random.nextDouble() * 0.02);
                world.spawnEntity(itemEntity);
                itemStack.damage(1, player2, player -> player.sendToolBreakStatus(hand));
                world.emitGameEvent(player2, GameEvent.SHEAR, pos);
                player2.incrementStat(Stats.USED.getOrCreateStat(Items.SHEARS));
            }
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player2, hand, hit);
    }

    public static FabricBlockSettings settings() {
        return FabricBlockSettings.of(Material.GOURD, MapColor.WHITE_GRAY).strength(1.0f).sounds(BlockSoundGroup.WOOD);
    }

    @Override
    public StemBlock getStem() {
        return (StemBlock)NaturalBlocks.GHOST_PUMPKIN_STEM.block;
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock)NaturalBlocks.ATTACHED_GHOST_PUMPKIN_STEM.block;
    }
}
