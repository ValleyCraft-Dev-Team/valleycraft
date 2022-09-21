package net.linkle.valleycraft.init;

import net.minecraft.item.FoodComponent;

public class Foods {
    public static FoodComponent create(int hunger, float satMod) {
        return new FoodComponent.Builder().hunger(hunger).saturationModifier(satMod).build();
    }
}
