package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.LeadItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class StakeBlock extends PillarWithWaterBlock {
    protected static final VoxelShape X_SHAPE;
    protected static final VoxelShape Y_SHAPE;
    protected static final VoxelShape Z_SHAPE;

    public StakeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(AXIS)) {
        case X -> X_SHAPE;
        case Y -> Y_SHAPE;
        case Z -> Z_SHAPE;
        };
    }

    static {
        Y_SHAPE = Block.createCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
        Z_SHAPE = Block.createCuboidShape(6.5D, 6.5D, 0.0D, 9.5D, 9.5D, 16.0D);
        X_SHAPE = Block.createCuboidShape(0.0D, 6.5D, 6.5D, 16.0D, 9.5D, 9.5D);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient && state.get(AXIS) == Direction.Axis.Y) {
            ItemStack itemStack = player.getStackInHand(hand);
            return itemStack.isOf(Items.LEAD) ? ActionResult.SUCCESS : ActionResult.PASS;
        } else {
            return LeadItem.attachHeldMobsToBlock(player, world, pos);
        }
    }
}