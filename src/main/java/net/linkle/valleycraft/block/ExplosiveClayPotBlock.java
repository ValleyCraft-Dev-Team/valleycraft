package net.linkle.valleycraft.block;

import net.linkle.valleycraft.extension.FallingBlockEntityExt;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion.DestructionType;

public class ExplosiveClayPotBlock extends ClayPotBlock {

    public ExplosiveClayPotBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.dropItem = false;
        ((FallingBlockEntityExt)entity).setDestroyedOnLanding();
    }
    
    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!world.isClient && world.random.nextFloat() < fallDistance - 0.5f && entity instanceof LivingEntity && (entity instanceof PlayerEntity || world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) && entity.getWidth() * entity.getWidth() * entity.getHeight() > 0.512f) {
            explode(world, Vec3d.of(pos));
        }
    }
    
    @Override
    public void onDestroyedOnLanding(World world, BlockPos pos, FallingBlockEntity entity) {
        if (!world.isClient) {
            explode(world, entity);
        }
    }
    
    protected void explode(World world, Entity entity) {
        var center = entity.getBoundingBox().getCenter();
        world.createExplosion(entity, center.getX(), center.getY(), center.getZ(), 2.5f, DestructionType.DESTROY);
    }
    
    protected void explode(World world, Vec3d pos) {
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2.5f, DestructionType.DESTROY);
    }
}