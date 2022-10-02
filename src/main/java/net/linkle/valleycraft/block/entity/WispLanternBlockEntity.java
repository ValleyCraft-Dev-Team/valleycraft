package net.linkle.valleycraft.block.entity;

import java.util.Random;

import net.linkle.valleycraft.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WispLanternBlockEntity extends BlockEntity {
    private static final Random RANDOM = new Random();
    
    public short ticks = 200, timer;
    public int sine = RANDOM.nextInt(1000);

    public WispLanternBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WISP_LANTERN, pos, state);
        resetTimer();
    }
    
    public static void tick(World world, BlockPos pos, BlockState state, WispLanternBlockEntity entity) {
        entity.tick();
    }
    
    private void tick() {
        ticks++;
        timer--;
        if (timer < 0) {
            resetTimer(); // shake timer
            ticks = 0;
        }
        sine++; // Bobbing speed
        sine %= 5000000;
    }
    
    private void resetTimer() {
        timer = (short)MathHelper.nextInt(RANDOM, 20*20, 60*20);
        //timer = 60;
    }
}
