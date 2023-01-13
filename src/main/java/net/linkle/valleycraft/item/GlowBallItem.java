package net.linkle.valleycraft.item;

import net.linkle.valleycraft.entity.projectiles.thrown_items.GlowBallEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.world.World;

public class GlowBallItem extends ThrowableItem {

    public GlowBallItem(Settings settings) {
        super(settings);
    }
    
    @Override
    protected ThrownItemEntity newThrownEntity(World world, PlayerEntity user) {
        return new GlowBallEntity(world, user);
    }
    
    @Override
    protected int getCooldownTick() {
        return 1 * 10;
    }
}
