package net.linkle.valleycraft.block;

import net.linkle.valleycraft.block.entity.WaypointBlockEntity;
import net.linkle.valleycraft.extension.ServerPlayerEntityExt;
import net.linkle.valleycraft.init.ModBlockEntityType;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaypointBlock extends BlockWithEntity {
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
    
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state,
            BlockEntityType<T> type) {
        return world.isClient ? checkType(type, ModBlockEntityType.WAYPOINT_ENTITY, WaypointBlockEntity::clientTick) : null;
    }
    
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
