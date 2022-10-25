package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.init.ModBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class WaypointBlockEntity extends BlockEntity {
    public WaypointBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.WAYPOINT_ENTITY, pos, state);
    }
}
