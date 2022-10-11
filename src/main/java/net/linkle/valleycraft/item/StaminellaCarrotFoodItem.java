package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StaminellaCarrotFoodItem extends Item {

    public StaminellaCarrotFoodItem(Settings settings) {
        super(settings);
    }

    /** @param satMod = saturationModifier */
    public StaminellaCarrotFoodItem(Settings settings, int hunger, float satMod) {
        this(settings, hunger, satMod, false);
    }

    /** @param satMod = saturationModifier */
    public StaminellaCarrotFoodItem(Settings settings, int hunger, float satMod, boolean isMeat) {
        this(settings, hunger, satMod, isMeat, null);
    }

    /** @param satMod = saturationModifier */
    public StaminellaCarrotFoodItem(Settings settings, int hunger, float satMod, @Nullable FoodStatusEffect effects) {
        this(settings, hunger, satMod, false, effects);
    }

    /** @param satMod = saturationModifier */
    public StaminellaCarrotFoodItem(Settings settings, int hunger, float satMod, boolean isMeat, @Nullable FoodStatusEffect effects) {
        super(defaultGroup(settings).food(newFoodComponent(hunger, satMod, isMeat, effects)));
    }

    /** Sets default item group if there's no item group. */
    protected static Settings defaultGroup(Settings settings) {
        //if (((ItemSettingsAccessor)settings).getGroup() == null) {
            //settings.group(ItemGroups.COOKING_GROUP);
        //}
        return settings;
    }

    protected static FoodComponent newFoodComponent(int hunger, float saturationModifier, boolean isMeat, @Nullable FoodStatusEffect statusEffects) {
        var builder = new FoodComponent.Builder();
        builder.hunger(hunger);
        builder.saturationModifier(saturationModifier);

        if (isMeat) {
            builder.meat();
        }

        if (statusEffects != null) {
            statusEffects.build(builder);
        }

        return builder.build();
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("item.valleycraft.dishes.tooltip").formatted(Formatting.GRAY) );
        tooltip.add( new TranslatableText("item.valleycraft.dishes.tooltip_9").formatted(Formatting.GRAY) );
    }
}
