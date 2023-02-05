package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.BlocksNatural;
import org.jetbrains.annotations.Nullable;

import net.linkle.valleycraft.init.FoodIngredients;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class MaizeBlock extends ModCropBlock {
    public static final IntProperty AGE = IntProperty.of("age", 0, 10);;    
    
    public MaizeBlock() {
        super(Settings.copy(Blocks.WHEAT));
        shapes[0] = createCuboidShape(1, 0, 1, 15, 3, 15);
        shapes[1] = createCuboidShape(1, 0, 1, 15, 5, 15);
        shapes[2] = createCuboidShape(1, 0, 1, 15, 7, 15);
        shapes[3] = createCuboidShape(1, 0, 1, 15, 14, 15);
        shapes[4] = createCuboidShape(1, 0, 1, 15, 16, 15);
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (world.getBlockState(pos.up()).isOf(BlocksNatural.MAIZE_BOX.block)) {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
        return Blocks.AIR.getDefaultState();
    }
    
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos.up(), BlocksNatural.MAIZE_BOX.getState(), Block.NOTIFY_ALL);
    }
    
    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        if (blockPos.getY() < world.getTopY() - 1 && world.getBlockState(blockPos.up()).canReplace(ctx)) {
            return super.getPlacementState(ctx);
        }
        return null;
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shapes[Math.min(getAge(state), 4)];
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
    
    @Override
    protected int getGrowthAmount(World world) {
        return 1;
    }
    
    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }
    
    @Override
    public int getMaxAge() {
        return 10;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return FoodIngredients.MAIZE;
    }

    @Override
    protected ItemStack getPickItem(Random random) {
        return new ItemStack(FoodIngredients.MAIZE, MathHelper.nextInt(random, 2, 4));
    }

    @Override
    protected int getPickedMinAge() {
        return 7;
    }
}
