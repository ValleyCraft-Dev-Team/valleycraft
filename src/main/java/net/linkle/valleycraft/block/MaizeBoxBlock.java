package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.BlocksNatural;
import org.jetbrains.annotations.Nullable;

import net.linkle.valleycraft.init.FoodIngredients;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

/**
 * This invisible block is automatically placed above the maize crop to transfer
 * interaction codes below it. Similar to a door.
 */
public class MaizeBoxBlock extends Block implements Fertilizable {
    
    protected final VoxelShape[] shapes;

    public MaizeBoxBlock() {
        super(Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP));
        shapes = new VoxelShape[3];
        shapes[0] = createCuboidShape(1, 0, 1, 15, 24-16, 15);
        shapes[1] = createCuboidShape(1, 0, 1, 15, 29-16, 15);
        shapes[2] = createCuboidShape(1, 0, 1, 15, 31-16, 15);
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        var corn = world.getBlockState(pos.down());
        if (!corn.isOf(BlocksNatural.MAIZE.block)) {
            return VoxelShapes.empty();
        }
        int level = corn.get(MaizeBlock.AGE)-5;
        if (level < 0) return VoxelShapes.empty();
        return shapes[Math.min(level, 2)];
    }
    
    @Override
    @SuppressWarnings("deprecation")
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (check(world, pos)) {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
        return Blocks.AIR.getDefaultState();
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        var corn = world.getBlockState(pos.down());
        if (!corn.isOf(BlocksNatural.MAIZE.block)) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), NOTIFY_LISTENERS);
            return ActionResult.FAIL;
        }
        return corn.getBlock().onUse(corn, world, pos.down(), player, hand, hit);
    }
    
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(FoodIngredients.MAIZE);
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return check(world, pos);
    }
    
    /** @return true if the current state is valid. */
    protected boolean check(BlockView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOf(BlocksNatural.MAIZE.block);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.afterBreak(world, player, pos, Blocks.AIR.getDefaultState(), blockEntity, stack);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean bool) {
        var corn = world.getBlockState(pos.down());
        if (!corn.isOf(BlocksNatural.MAIZE.block)) {
            return false;
        }
        return ((Fertilizable) BlocksNatural.MAIZE.block).isFertilizable(world, pos.down(), corn, bool);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        var corn = world.getBlockState(pos.down());
        if (!corn.isOf(BlocksNatural.MAIZE.block)) {
            return false;
        }
        return ((Fertilizable) BlocksNatural.MAIZE.block).canGrow(world, random, pos.down(), corn);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        var corn = world.getBlockState(pos.down());
        if (corn.isOf(BlocksNatural.MAIZE.block)) {
            ((Fertilizable) BlocksNatural.MAIZE.block).grow(world, random, pos.down(), corn);
        }
    }
}
