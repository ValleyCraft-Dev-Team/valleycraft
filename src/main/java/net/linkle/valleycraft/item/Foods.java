package net.linkle.valleycraft.item;

import net.minecraft.item.FoodComponent;

public class Foods {
    public static FoodComponent create(int hunger, float satMod) {
        return new FoodComponent.Builder().hunger(hunger).saturationModifier(satMod).build();
    }
    
    public static FoodComponent create(int hunger, float satMod, boolean alwaysEdible) {
        var builder = new FoodComponent.Builder().hunger(hunger).saturationModifier(satMod);
        if (alwaysEdible) builder.alwaysEdible();
        return builder.build();
    }
}
