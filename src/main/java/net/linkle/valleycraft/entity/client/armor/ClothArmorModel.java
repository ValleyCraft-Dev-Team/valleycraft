package net.linkle.valleycraft.entity.client.armor;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.item.ClothingArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ClothArmorModel extends AnimatedGeoModel<ClothingArmorItem> {
    @Override
    public Identifier getModelResource(ClothingArmorItem object) {
        return new Identifier(Main.ID, "geo/clothing.geo.json");
    }

    @Override
    public Identifier getTextureResource(ClothingArmorItem object) {
        return new Identifier(Main.ID, "textures/models/armor/clothing_template.png");
    }

    @Override
    public Identifier getAnimationResource(ClothingArmorItem animatable) {
        return new Identifier(Main.ID, "animations/armor_animation.json");
    }
}
