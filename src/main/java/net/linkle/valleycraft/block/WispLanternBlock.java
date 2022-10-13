package net.linkle.valleycraft.block;

import net.linkle.valleycraft.block.entity.WispLanternBlockEntity;
import net.linkle.valleycraft.init.ModBlockEntities;
import net.linkle.valleycraft.util.Util;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WispLanternBlock extends LanternBlock implements BlockEntityProvider {

    public WispLanternBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WispLanternBlockEntity(pos, state);
    }
    
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? Util.checkType(type, ModBlockEntities.WISP_LANTERN, WispLanternBlockEntity::tickClient) : null;
    }
}
