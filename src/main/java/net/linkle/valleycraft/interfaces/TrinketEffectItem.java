package net.linkle.valleycraft.interfaces;

import java.util.ArrayList;

import dev.emi.trinkets.TrinketSlot;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.linkle.valleycraft.util.EffectSetting;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;

public class TrinketEffectItem extends TrinketItem {

	private final ArrayList<EffectSetting> effects = new ArrayList<>();
	
	public TrinketEffectItem(Settings settings) {
		super(settings);
	}
	
	public TrinketEffectItem add(StatusEffect effect) {
		return addEffect(effect, 0);
	}
	
	public TrinketEffectItem addEffect(StatusEffect effect, int level) {
		effects.add(new EffectSetting(effect, level));
		return this;
	}
	
	@Override
	public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
		var comp = TrinketsApi.getTrinketComponent(entity);
		if (comp.isPresent() && comp.get().isEquipped(stack.getItem())) {
			for (var effect : effects) {
				entity.addStatusEffect(new StatusEffectInstance(effect.effect(), 10, effect.amplifier(), true, false, true));
			}
		}
	}
}
