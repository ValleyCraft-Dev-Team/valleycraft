package net.linkle.valleycraft.block;

import net.minecraft.block.*;
import net.minecraft.block.LichenGrower.GrowPos;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class GlowSplatterBlock extends MultifaceGrowthBlock {
    
    protected final LichenGrower grower = new LichenGrower(new GlowSplatterGrowChecker());

    public GlowSplatterBlock() {
        super(Settings.of(Material.PLANT, MapColor.GREEN).noCollision().strength(0.2f).sounds(BlockSoundGroup.SLIME).luminance(GlowLichenBlock.getLuminanceSupplier(12)));
    }

    @Override
    public LichenGrower getGrower() {
        return grower;
    }

    protected class GlowSplatterGrowChecker implements LichenGrower.GrowChecker {
        
        @Override
        public BlockState getStateWithDirection(BlockState state, BlockView world, BlockPos pos, Direction direction) {
            return withDirection(state, world, pos, direction);
        }

        @Override
        public boolean canGrow(BlockView var1, BlockPos var2, GrowPos var3) {
            return false;
        }
        
        @Override
        public boolean canGrow(BlockState state) {
            return false;
        }
        
        @Override
        public boolean canGrow(BlockState state, Direction direction) {
            return false;
        }
        
        @Override
        public boolean place(WorldAccess world, GrowPos growPos, BlockState state, boolean markForPostProcessing) {
            return false;
        }
        
    }
}
