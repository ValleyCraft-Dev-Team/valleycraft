package net.linkle.valleycraft.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class WastebinBlock extends Block {
    
    protected static final VoxelShape SHAPE;

    public WastebinBlock() {
        super(Settings.of(Material.METAL, MapColor.ORANGE).requiresTool().strength(2.5f, 5.0f).sounds(BlockSoundGroup.COPPER));
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (entity.getY()-pos.getY() < 0.2 && entity instanceof ItemEntity) {
            System.out.println(entity.getY()-pos.getY());
            entity.discard();
        }
    }
    
    static {
        VoxelShape topBase, bottomBase, leftBase, rightBase;
        topBase = createCuboidShape(0, 0, 14, 16, 16, 16);
        bottomBase = createCuboidShape(0, 0, 0, 16, 16, 2);
        leftBase = createCuboidShape(0, 0, 0, 2, 16, 16);
        rightBase = createCuboidShape(14, 0, 0, 16, 16, 16);
        SHAPE = VoxelShapes.union(topBase, bottomBase, leftBase, rightBase, Block.createCuboidShape(0, 0, 0, 16, 2, 16));
    }
}
