package net.linkle.valleycraft.tool.bows;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class ModCrossBowItem extends CrossbowItem {
    public ModCrossBowItem(Settings settings) {
        super(settings);
    }

    /**edit field range**/
    @Override
    public int getRange() {
        //default bow range is 15
        //default crossbow range is 8
        return 15;
    }

    /**edit field pulling progress*/
    //default bow speed is 20
    //default crossbow speed is 25 - (5 * i) where i is the level of the quick_charge enchantment
    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        return f;
    }
}
