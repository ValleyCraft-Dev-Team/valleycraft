package net.linkle.valleycraft.entity.skeletons;

import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.init.Armors;
import net.linkle.valleycraft.init.Tools;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LichEntity extends SkeletonEntity {
    public LichEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.equipStack(EquipmentSlot.HEAD, this.makeHeadGear());
        this.equipStack(EquipmentSlot.CHEST, this.makeCloak());
        this.equipStack(EquipmentSlot.MAINHAND, this.makeInitialWeapon());
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    private ItemStack makeInitialWeapon() {
        return new ItemStack(Tools.SCYTHE_IRON);
    }

    public static DefaultAttributeContainer.Builder createHostileAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0);
    }

    private ItemStack makeHeadGear() {
        return new ItemStack(Armors.LICH_HOOD_KEEPSAKE);
    }
    private ItemStack makeCloak() {
        return new ItemStack(Armors.LICH_CLOAK_KEEPSAKE);
    }

    protected void updateEnchantments(Random random, LocalDifficulty localDifficulty) {
    }

    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        return effect.getEffectType() == StatusEffects.WITHER ? false : super.canHaveStatusEffect(effect);
    }


    public boolean tryAttack(Entity target) {
        if (!super.tryAttack(target)) {
            return false;
        } else {
            if (target instanceof LivingEntity) {
                ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(ModEffects.SOUL_FADING, 100), this);
            }
            return true;
        }
    }
}
