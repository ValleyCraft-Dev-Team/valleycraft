package net.linkle.valleycraft.armors;

import com.google.common.collect.ImmutableMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StrayaEffect extends ArmorItem {
    private static final ImmutableMap<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP;
    
    static {
        var builder = new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>();
        builder.put(ArmorMats.STRAYA, new StatusEffectInstance(StatusEffects.LUCK, 400, 1));
        MATERIAL_TO_EFFECT_MAP = builder.build();
    }

    public StrayaEffect(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity player) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (var entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            var material = entry.getKey();
            var effect = entry.getValue();

            if(hasCorrectArmorOn(material, player)) {
                addStatusEffectForMaterial(player, material, effect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial material, StatusEffectInstance effect) {
        boolean hasPlayerEffect = player.hasStatusEffect(effect.getEffectType());

        if(hasCorrectArmorOn(material, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(effect));

            // var random = player.getRandom();
            // if(random.nextFloat() < 0.4f) { // 40% of damaging the armor! Possibly!
            //     player.getInventory().damageArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            // }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack breastplate = player.getInventory().getArmorStack(2);

        return !breastplate.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());

        return breastplate.getMaterial() == material;
    }
}