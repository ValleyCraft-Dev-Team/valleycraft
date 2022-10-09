package net.linkle.valleycraft.block;

import java.util.List;
import java.util.Optional;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DefectiveBlock extends Block {
    public DefectiveBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.getItem() instanceof SpawnEggItem item) {
            if (world.isClient) {
                return ActionResult.SUCCESS;
            }
            
            var spawner = Blocks.SPAWNER.getDefaultState();
            Optional<MobSpawnerBlockEntity> optional;
            if (world.setBlockState(pos, spawner) && (optional = world.getBlockEntity(pos, BlockEntityType.MOB_SPAWNER)).isPresent()) {
                var entity = optional.get();
                var logic = entity.getLogic();
                var type = item.getEntityType(stack.getNbt());
                logic.setEntityId(type);
                entity.markDirty();
                world.updateListeners(pos, spawner, spawner, Block.NOTIFY_ALL);
                if (!player.getAbilities().creativeMode) stack.decrement(1);
                return ActionResult.CONSUME;
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("block.valleycraft.defective_spawner.tooltip").formatted(Formatting.GRAY) );
        tooltip.add( new TranslatableText("block.valleycraft.defective_spawner.tooltip_2").formatted(Formatting.GRAY) );
    }
}
