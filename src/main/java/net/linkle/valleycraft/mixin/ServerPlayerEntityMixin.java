package net.linkle.valleycraft.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import net.linkle.valleycraft.extension.ServerPlayerEntityExt;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(ServerPlayerEntity.class)
abstract class ServerPlayerEntityMixin extends PlayerEntity implements ServerPlayerEntityExt {

    private BlockPos waypointPosition;

    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile, @Nullable PlayerPublicKey publicKey) {
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
