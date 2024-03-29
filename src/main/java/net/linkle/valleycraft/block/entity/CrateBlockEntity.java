package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.block.CabinetBlock;
import net.linkle.valleycraft.block.CounterDrawerBlock;
import net.linkle.valleycraft.init.BlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class CrateBlockEntity extends ContainerBlockEntity {
    public CrateBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.CRATE.type(), pos, state);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.valleycraft.crate");
    }

    @Override
    public int size() {
        return 27;
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new GenericContainerScreenHandler(ScreenHandlerType.GENERIC_9X3, syncId, playerInventory, this, 3);
    }
    
    @Override
    protected void setOpen(BlockState state, boolean open) {
        world.setBlockState(getPos(), state.with(CabinetBlock.OPEN, open), Block.NOTIFY_ALL);
        playSound(state, open ? SoundEvents.BLOCK_BARREL_OPEN : SoundEvents.BLOCK_BARREL_CLOSE);
    }
    
    private void playSound(BlockState state, SoundEvent soundEvent) {
        var vec = state.get(CounterDrawerBlock.FACING).getVector();
        double x = (double)pos.getX() + 0.5 + (double)vec.getX() / 2.0;
        double y = (double)pos.getY() + 0.5 + (double)vec.getY() / 2.0;
        double z = (double)pos.getZ() + 0.5 + (double)vec.getZ() / 2.0;
        world.playSound(null, x, y, z, soundEvent, SoundCategory.BLOCKS, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
    }
}
