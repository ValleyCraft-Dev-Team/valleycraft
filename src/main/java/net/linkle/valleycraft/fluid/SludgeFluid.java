package net.linkle.valleycraft.fluid;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Nullable;

import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.init.ModBlocks;
import net.linkle.valleycraft.init.ModFluids;
import net.linkle.valleycraft.init.ModItems;
import net.linkle.valleycraft.tags.ModFluidTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class SludgeFluid extends FlowableFluid {

    @Override
    public Fluid getFlowing() {
        return ModFluids.SLUDGE_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.SLUDGE_STILL;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.SLUDGE_BUCKET;
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        
    }

    @Override
    @Nullable
    public ParticleEffect getParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    @Override
    protected boolean isInfinite() {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }
    
    @Override
    public Vec3d getVelocity(BlockView world, BlockPos pos, FluidState state) {
        return super.getVelocity(world, pos, state).multiply(0.5);
    }

    @Override
    public int getFlowSpeed(WorldView world) {
        return 2;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return ModBlocks.SLUDGE_FLUID.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.SLUDGE_STILL || fluid == ModFluids.SLUDGE_FLOWING;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return 2;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 20;
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return true;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }

    public static class Flowing extends SludgeFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends SludgeFluid {

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
