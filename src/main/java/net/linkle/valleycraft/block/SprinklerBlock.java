package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.Particles;
import net.linkle.valleycraft.init.Sounds;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SprinklerBlock extends Block {
    
    public static final BooleanProperty POWERED = Properties.POWERED;
    
    protected static final VoxelShape SHAPE;

    public SprinklerBlock() {
        super(Settings.of(Material.METAL, MapColor.STONE_GRAY).strength(3.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().breakInstantly());
        setDefaultState(stateManager.getDefaultState().with(POWERED, false));
    }
    
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }
        var powered = state.get(POWERED);
        if (powered != world.isReceivingRedstonePower(pos)) {
            if (powered) {
                world.createAndScheduleBlockTick(pos, this, 4);
            } else {
                world.setBlockState(pos, state.cycle(POWERED), Block.NOTIFY_LISTENERS);
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(POWERED) && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, state.cycle(POWERED), Block.NOTIFY_LISTENERS);
        }
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(POWERED));
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(POWERED)) {
            double x = pos.getX()+0.5;
            double y = pos.getY()+0.75;
            double z = pos.getZ()+0.5;
            if (random.nextFloat() < 0.1f) {
                world.playSound(x, y, z, Sounds.SPRINKLER.sound, SoundCategory.BLOCKS, 0.4f, 1.0f, false);
            }
            for (int i = 0; i < 6; i++) {
                double speed = MathHelper.nextDouble(random, 0.2, 0.5);
                double angle = random.nextDouble() * Math.PI*2.0;
                double sin = Math.sin(angle);
                double cos = Math.cos(angle);
                world.addParticle(Particles.SPRINKLE, x+(sin*0.2), y, z+(cos*0.2), sin*speed, 0.2, cos*speed);
            }
        }
    }
    
    static {
        var base = createCuboidShape(6, 0, 6, 10, 8, 10);
        var head = createCuboidShape(2, 8, 2, 14, 12, 14);
        SHAPE = VoxelShapes.union(base, head);
    }
}
