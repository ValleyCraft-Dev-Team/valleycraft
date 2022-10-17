package net.linkle.valleycraft.item;

import java.util.*;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class ModItem extends Item {
    
    private final ArrayList<Text> texts = new ArrayList<>();

    public ModItem(Settings settings) {
        super(settings);
    }
    
    /** Append text to tooltip. 
     * @see ModItem#addText(String, Formatting)
     * @param trans translatable text. */
    public ModItem addText(String trans) {
        return addText(trans, Formatting.GRAY);
    }
    
    /** Append text to tooltip. 
     * @see ModItem#addText(Text)
     * @param trans translatable text. */
    public ModItem addText(String trans, Formatting format) {
        return addText(Text.translatable(trans).formatted(format));
    }
    
    /** Append text to tooltip. */
    public ModItem addText(Text text) {
        texts.add(text);
        return this;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.addAll(texts);
    }
}
