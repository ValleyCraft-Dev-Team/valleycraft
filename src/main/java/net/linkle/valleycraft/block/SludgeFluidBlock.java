package net.linkle.valleycraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.linkle.valleycraft.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SludgeFluidBlock extends FluidBlock {
    
    private static final Material MATERIAL = new FabricMaterialBuilder(MapColor.DARK_GREEN).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().liquid().build();
    
    public SludgeFluidBlock(FlowableFluid fluid) {
        super(fluid, Settings.of(MATERIAL).noCollision().strength(100.0f).dropsNothing());
    }
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity living) {
            living.addStatusEffect(new StatusEffectInstance(ModEffects.ROT_BLIGHT, 7 * 20));
        }
    }
    
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
