package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.init.ModBlockEntityType;
import net.linkle.valleycraft.util.Util;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AllayLanternBlockEntity extends BlockEntity {
    public short ticks = 200, timer;
    public int sine = Util.RANDOM.nextInt(1000);

    public AllayLanternBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.ALLAY_LANTERN, pos, state);
        resetTimer();
    }
    
    public static void tickClient(World world, BlockPos pos, BlockState state, AllayLanternBlockEntity entity) {
        entity.tickClient();
    }
    
    private void tickClient() {
        ticks++;
        timer--;
        if (timer < 0) {
            resetTimer(); // resets shake timer
            ticks = 0;
        }
        sine++; // bobbing
        sine %= 5000000;
    }
    
    private void resetTimer() {
        timer = (short)Util.nextInt(Util.RANDOM, 20*20, 60*20);
        //timer = 60;
    }
}
