package net.linkle.valleycraft.entity.unused;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.world.World;

import static net.minecraft.util.math.MathHelper.nextDouble;

public class SoulPetEntity extends Entity {
    
    public static final int MAX_AGE = 7 * 20; // 6
    
    private ItemStack stack = ItemStack.EMPTY;
    
    public SoulPetEntity(EntityType<?> type, World world) {
        super(type, world);
        noClip = true;
    }
    
    public SoulPetEntity setStack(ItemStack stack) {
        this.stack = stack;
        return this;
    }
    
    @Override
    public void tick() {
        super.tick();
        if (age > MAX_AGE) {
            if (!world.isClient) {
                dropStack(stack);
            }
            discard();
        }
    }
    
    @Nullable
    public ItemEntity dropStack(ItemStack stack, float yOffset) {
        if (world.isClient || stack.isEmpty()) {
            return null;
        }
        
        var random = world.random;
        double v = 0.05;
        yOffset -= 0.25f;
        var entity = new ItemEntity(world, getX(), getY()+yOffset, getZ(), stack, nextDouble(random, -v, v), 0.15, nextDouble(random, v, v));
        entity.setToDefaultPickupDelay();
        world.spawnEntity(entity);
        return entity;
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        if (!stack.isEmpty()) {
            nbt.put("Item", stack.writeNbt(new NbtCompound()));
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        stack = ItemStack.fromNbt(nbt.getCompound("Item"));
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}
