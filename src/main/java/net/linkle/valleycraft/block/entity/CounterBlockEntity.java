package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.block.CounterBlock;
import net.linkle.valleycraft.init.ModBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CounterBlockEntity extends LootableContainerBlockEntity {
    
    public static final int SLOT_SIZE = 18;
    
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(size(), ItemStack.EMPTY);
    private ViewerCountManager stateManager = new CounterViewerCountManager();
    
    public CounterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.COUNTER, pos, state);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.valleycraft.counter");
    }

    @Override
    public int size() {
        return SLOT_SIZE;
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
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new GenericContainerScreenHandler(ScreenHandlerType.GENERIC_9X2, syncId, playerInventory, this, 2);
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
    
    void setOpen(BlockState state, boolean open) {
        world.setBlockState(getPos(), state.with(CounterBlock.OPEN, open), Block.NOTIFY_ALL);
    }
    
    void playSound(BlockState state, SoundEvent soundEvent) {
        var vec = state.get(CounterBlock.FACING).getVector();
        double x = (double)pos.getX() + 0.5 + (double)vec.getX() / 2.0;
        double y = (double)pos.getY() + 0.5 + (double)vec.getY() / 2.0;
        double z = (double)pos.getZ() + 0.5 + (double)vec.getZ() / 2.0;
        world.playSound(null, x, y, z, soundEvent, SoundCategory.BLOCKS, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
    }
    
    private class CounterViewerCountManager extends ViewerCountManager {

        @Override
        protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
            playSound(state, SoundEvents.BLOCK_BARREL_OPEN);
            setOpen(state, true);
        }

        @Override
        protected void onContainerClose(World world, BlockPos pos, BlockState state) {
            playSound(state, SoundEvents.BLOCK_BARREL_CLOSE);
            setOpen(state, false);
        }

        @Override
        protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
        }

        @Override
        protected boolean isPlayerViewing(PlayerEntity player) {
            if (player.currentScreenHandler instanceof GenericContainerScreenHandler) {
                Inventory inventory = ((GenericContainerScreenHandler)player.currentScreenHandler).getInventory();
                return inventory == CounterBlockEntity.this;
            }
            return false;
        }
    }
}
