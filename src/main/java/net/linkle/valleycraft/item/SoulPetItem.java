package net.linkle.valleycraft.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class SoulPetItem extends ModItem {
    
    public static final String SOUL_PET_KEY = "SoulPet";
    public static final String PET_OWNER_KEY = "PetOwner";
    public static final String PET_NAME_KEY = "PetName";
    
    public SoulPetItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        var nbt = stack.getSubNbt(SOUL_PET_KEY);
        if (nbt != null) {
            var petName = Text.Serializer.fromJson(nbt.getString(PET_NAME_KEY));
            if (petName != null) {
                tooltip.add(petName);
            }
        }
    }
    
    public static void setTag(ItemStack stack, TameableEntity pet) {
        if (!pet.isTamed() || pet.getOwner() == null) return;
        Entity owner = pet.getOwner();
        var nbt = stack.getOrCreateSubNbt(SOUL_PET_KEY);
        //nbt.putString(PET_OWNER_KEY, Text.Serializer.toJson(owner.getName()));
        nbt.putString(PET_NAME_KEY, Text.Serializer.toJson(pet.getName()));
    }
}
