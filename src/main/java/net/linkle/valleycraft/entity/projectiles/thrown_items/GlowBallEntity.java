package net.linkle.valleycraft.entity.projectiles.thrown_items;

import net.linkle.valleycraft.init.ModBlocks;
import net.linkle.valleycraft.init.ModEntityType;
import net.linkle.valleycraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.block.PumpkinBlock;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class GlowBallEntity extends ThrownItemEntity {

    public GlowBallEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GlowBallEntity(World world, LivingEntity owner) {
        super(ModEntityType.GLOW_BALL, owner, world);
    }

    public GlowBallEntity(World world, double x, double y, double z) {
        super(ModEntityType.GLOW_BALL, x, y, z, world);
    }
    
    @Override
    protected Item getDefaultItem() {
        return Items.SNOWBALL;
    }

    private ParticleEffect getParticleParameters() {
        ItemStack stack = this.getItem();
        return new ItemStackParticleEffect(ParticleTypes.ITEM, stack.isEmpty() ? new ItemStack(ModItems.GLOW_BALL) : stack);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            ParticleEffect particleEffect = this.getParticleParameters();
            for (int i = 0; i < 8; ++i) {
                world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity entity) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0), this.getEffectCause());
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }
    
    @Override
    protected void onBlockHit(BlockHitResult result) {
        var sidePos = result.getBlockPos().offset(result.getSide());
        var state = world.getBlockState(sidePos);
        if (state.getMaterial().isReplaceable()) {
            var newState = ModBlocks.GLOW_SPLATTER.getState().with(MultifaceGrowthBlock.getProperty(result.getSide().getOpposite()), true);
            if (newState.canPlaceAt(world, sidePos)) {
                world.setBlockState(sidePos, newState);
            }
        } else if (state.isOf(ModBlocks.GLOW_SPLATTER.block)) {
            var newState = state.with(MultifaceGrowthBlock.getProperty(result.getSide().getOpposite()), true);
            if (newState.canPlaceAt(world, sidePos)) {
                world.setBlockState(sidePos, newState);
            }
        }
    }
}