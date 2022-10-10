package net.linkle.valleycraft.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class SoulPetItem extends SoulItem {
    
    public static final String SOUL_PET_KEY = "SoulPet";
    public static final String PET_OWNER_KEY = "PetOwner";
    public static final String PET_NAME_KEY = "PetName";
    
    public SoulPetItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        var nbt = stack.getSubNbt(SOUL_PET_KEY);
        if (nbt != null) {
            String petName = nbt.getString(PET_NAME_KEY);
            String petOwner = nbt.getString(PET_OWNER_KEY);
            
            tooltip.add(new LiteralText(petName).formatted(Formatting.YELLOW));
            
            //tooltip.add(new LiteralText("Pet Named ").formatted(Formatting.GOLD).append(new LiteralText(petName).formatted(Formatting.YELLOW)));
            //tooltip.add(new LiteralText("Was Owned by ").formatted(Formatting.GOLD).append(new LiteralText(petOwner).formatted(Formatting.YELLOW)));
        }
    }
    
    public static void setTag(ItemStack stack, TameableEntity pet) {
        if (!pet.isTamed() || pet.getOwner() == null);
        Entity owner = pet.getOwner();
        
        var nbt = stack.getOrCreateSubNbt(SOUL_PET_KEY);
        nbt.putString(PET_OWNER_KEY, owner.getName().getString());
        nbt.putString(PET_NAME_KEY, pet.getName().getString());
    }
}
