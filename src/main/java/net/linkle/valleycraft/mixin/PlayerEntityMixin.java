package net.linkle.valleycraft.mixin;

import com.mojang.authlib.GameProfile;
import net.linkle.valleycraft.Debugs;
import net.linkle.valleycraft.block.WaypointBlock;
import net.linkle.valleycraft.extension.LivingEntityExt;
import net.linkle.valleycraft.extension.ServerPlayerEntityExt;
import net.linkle.valleycraft.init.ModEntityType;
import net.linkle.valleycraft.init.ModItems;
import net.linkle.valleycraft.item.SoulPetItem;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.function.Predicate;

@Mixin(ServerPlayerEntity.class)
abstract class PlayerEntityMixin extends PlayerEntity implements ServerPlayerEntityExt {

    private BlockPos waypointPosition;

    public PlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile, @Nullable PlayerPublicKey publicKey) {
        super(world, pos, yaw, gameProfile, publicKey);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo info) {
        if (this.waypointPosition != null) {
            nbt.putInt("WaypointPosX", waypointPosition.getX());
            nbt.putInt("WaypointPosY", waypointPosition.getY());
            nbt.putInt("WaypointPosZ", waypointPosition.getZ());
        }
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("WaypointPosX", NbtElement.NUMBER_TYPE) && nbt.contains("WaypointPosY", NbtElement.NUMBER_TYPE) && nbt.contains("WaypointPosZ", NbtElement.NUMBER_TYPE)) {
            waypointPosition = new BlockPos(nbt.getInt("WaypointPosX"), nbt.getInt("WaypointPosY"), nbt.getInt("WaypointPosZ"));
        }
    }

    @Override
    public void setWaypointPos(BlockPos pos) {
        waypointPosition = pos.toImmutable();
    }

    @Override
    public BlockPos getWaypointPos() {
        return waypointPosition;
    }
}
