package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.List;

public class ShivercapBlock extends ModMushroomBlockDaySafe {
    public ShivercapBlock() {
        this(Settings.copy(Blocks.RED_MUSHROOM).ticksRandomly().nonOpaque());
    }

    public ShivercapBlock(Settings settings) {
        super(settings);
    }
    
    public ShivercapBlock large() {
        shape = Block.createCuboidShape(4, 0, 4, 12, 9, 12);
        return this;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("block.valleycraft.dishes.tooltip").formatted(Formatting.GRAY) );
        tooltip.add( Text.translatable("block.valleycraft.dishes.tooltip_2").formatted(Formatting.GRAY) );
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.setInPowderSnow(true);
        if (!world.isClient) {
            if (entity.isOnFire() && (world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) || entity instanceof PlayerEntity) && entity.canModifyAt(world, pos)) {
                world.breakBlock(pos, false);
            }
            entity.setOnFire(false);
        }
    }
}
