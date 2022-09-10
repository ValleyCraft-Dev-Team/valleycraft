package net.linkle.valleycraft.item;

public class GoldenFoodItem extends FoodItem {
    public GoldenFoodItem(Settings settings, int hunger, float satMod) {
        super(settings, hunger, satMod);
    }
    
    public GoldenFoodItem(Settings settings, int hunger, float satMod, boolean isMeat) {
        super(settings, hunger, satMod, isMeat);
    }
}
