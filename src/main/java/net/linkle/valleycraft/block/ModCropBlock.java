package net.linkle.valleycraft.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public abstract class ModCropBlock extends CropBlock {
    
    protected final VoxelShape[] shapes;
    protected boolean useShape;

    public ModCropBlock(Settings settings) {
        super(settings);
        shapes = new VoxelShape[getMaxAge()+1];
    }
    
    /** Generate shape size
     * @param sizeOffset - width and length
     * @param scale - height scale */
    public ModCropBlock genSize(float sizeOffset, float scale) {
        useShape = true;
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = createCuboidShape(sizeOffset, 0f, sizeOffset, 16f-sizeOffset, (i+1f)*2f*scale, 16f-sizeOffset);
        }
        return this;
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return useShape ? shapes[getAge(state)] : super.getOutlineShape(state, world, pos, context);
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean mature = isMature(state);

        if (!mature && player.getStackInHand(hand).getItem() == Items.BONE_MEAL) {
            return ActionResult.PASS;
        }

        if (mature) {
            var stack = getPickItem(world.random);
            if (stack != null) {
                dropStack(world, pos, getPickItem(world.random));
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
                world.setBlockState(pos, state.with(getAgeProperty(), getPickedMinAge()), 2);
                return ActionResult.success(world.isClient);
            }
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
    
    @Override
    protected abstract ItemConvertible getSeedsItem();

    /** Get crop's drop/pick item. */
    @Nullable
    protected abstract ItemStack getPickItem(Random random);

    /** Get min age after it been picked. */
    protected int getPickedMinAge() {
        return 0;
    }
}
