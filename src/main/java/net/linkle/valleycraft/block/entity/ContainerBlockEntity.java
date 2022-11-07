package net.linkle.valleycraft.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** An abstract container block entity class to reduce half of implementation load. */
public abstract class ContainerBlockEntity extends LootableContainerBlockEntity {

    protected DefaultedList<ItemStack> inventory = DefaultedList.ofSize(size(), ItemStack.EMPTY);
    protected ViewerCountManager stateManager = new ContainerViewerCountManager();
    
    protected ContainerBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }
    
    protected abstract void setOpen(BlockState state, boolean open);
    
    protected boolean isPlayerViewing(PlayerEntity player) {
        if (player.currentScreenHandler instanceof GenericContainerScreenHandler handler) {
            return handler.getInventory() == ContainerBlockEntity.this;
        }
        return false;
    }
    
    protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
        
    }
    
    @Override
    public void onOpen(PlayerEntity player) {
        if (!removed && !player.isSpectator()) {
            stateManager.openContainer(player, getWorld(), getPos(), getCachedState());
        }
    }

    @Override
    public void onClose(PlayerEntity player) {
        if (!removed && !player.isSpectator()) {
            stateManager.closeContainer(player, getWorld(), getPos(), getCachedState());
        }
    }

    public void tick() {
        if (!removed) {
            stateManager.updateViewerCount(getWorld(), getPos(), getCachedState());
        }
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, inventory);
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(size(), ItemStack.EMPTY);
        if (!deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, inventory);
        }
    }
    
    protected class ContainerViewerCountManager extends ViewerCountManager {
        @Override
        protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
            setOpen(state, true);
        }

        @Override
        protected void onContainerClose(World world, BlockPos pos, BlockState state) {
            setOpen(state, false);
        } 

        @Override
        protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            ContainerBlockEntity.this.onViewerCountUpdate(world, pos, state, oldViewerCount, newViewerCount);
        }

        @Override
        protected boolean isPlayerViewing(PlayerEntity player) {
            return ContainerBlockEntity.this.isPlayerViewing(player);
        }
    }
}
