package net.linkle.valleycraft.entity.ai.goal;

import net.linkle.valleycraft.entity.SporeCreeperEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.CreeperEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class SporeCreeperIgniteGoal extends Goal {
    private final SporeCreeperEntity sporeCreeper;
    @Nullable
    private LivingEntity target;

    public SporeCreeperIgniteGoal(SporeCreeperEntity sporeCreeper) {
        this.sporeCreeper = sporeCreeper;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.sporeCreeper.getTarget();
        return this.sporeCreeper.getFuseSpeed() > 0 || livingEntity != null && this.sporeCreeper.squaredDistanceTo(livingEntity) < 9.0D;
    }

    public void start() {
        this.sporeCreeper.getNavigation().stop();
        this.target = this.sporeCreeper.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.sporeCreeper.setFuseSpeed(-1);
        } else if (this.sporeCreeper.squaredDistanceTo(this.target) > 49.0D) {
            this.sporeCreeper.setFuseSpeed(-1);
        } else {
            this.sporeCreeper.setFuseSpeed(1);
        }
    }
}