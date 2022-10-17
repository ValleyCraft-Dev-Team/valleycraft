package net.linkle.valleycraft.init;

import java.util.function.BiFunction;

import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.PlaceableOnWaterItem;

/** The test class for storing and registering blocks with enum. */
enum ModBlocksTest implements ItemConvertible, BlockConvertible {
    
    // ### The List Of Blocks ###
    
    // Block without the block item.
    AIR(new AirBlock(Block.Settings.copy(Blocks.AIR))),
    
    // Block with the standard block item.
    STONE(new Block(Block.Settings.copy(Blocks.STONE)), new Item.Settings()),
    
    // Block with the lilypad block item.
    LILY_PAD(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), new Item.Settings(), PlaceableOnWaterItem::new);
    
    
    
    // ### The Enum Class Itself ###
    
    public final Block block;
    
    /** Register the block without the item. */
    ModBlocksTest(Block block) {
        this.block = block;
        //Reg.register(id(), block);
    }
    
    /** Register the block without the item. */
    ModBlocksTest(Block block, Item.Settings settings) {
        this(block, settings, BlockItem::new);
    }

    /** Register the block with the item.
     * @param function create and register the block item. Example: BlockItem::new  */
    ModBlocksTest(Block block, Item.Settings settings, BiFunction<Block, Item.Settings, Item> function) {
        this.block = block;
        //var id = makeId(id());
        //Registry.register(Registry.BLOCK, id, block);
        //Registry.register(Registry.ITEM, id, function.apply(block, settings));
    }
    
    private String id() {
        return name().toLowerCase();
    }

    @Override
    public Item asItem() {
        return block.asItem();
    }

    @Override
    public Block asBlock() {
        return block;
    }
}
