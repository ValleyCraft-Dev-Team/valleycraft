package net.linkle.valleycraft.entity.skeletons;

import net.linkle.valleycraft.init.Tools;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SunkenEntity extends SkeletonEntity {
    public SunkenEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }
}
