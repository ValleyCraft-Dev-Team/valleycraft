package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class CurtainBlock extends HorizontalWithWaterBlock {
    
    public static final BooleanProperty OPEN = Properties.OPEN;
    public static final BooleanProperty CORD = BooleanProperty.of("cord");
    
    private static final double OFFSET = 0.001;
    protected static final VoxelShape OPEN_EAST_SHAPE  = Block.createCuboidShape(OFFSET,  0, 0,  2,  16, 16);
    protected static final VoxelShape OPEN_WEST_SHAPE  = Block.createCuboidShape(14, 0, 0,  16-OFFSET, 16, 16);
    protected static final VoxelShape OPEN_SOUTH_SHAPE = Block.createCuboidShape(0,  0, OFFSET,  16, 16, 2);
    protected static final VoxelShape OPEN_NORTH_SHAPE = Block.createCuboidShape(0,  0, 14, 16, 16, 16-OFFSET);
    
    protected static final VoxelShape CLOSED_EAST_SHAPE  = Block.createCuboidShape(0,  0, 0,  2,  16, 16);
    protected static final VoxelShape CLOSED_WEST_SHAPE  = Block.createCuboidShape(14, 0, 0,  16, 16, 16);
    protected static final VoxelShape CLOSED_SOUTH_SHAPE = Block.createCuboidShape(0,  0, 0,  16, 16, 2);
    protected static final VoxelShape CLOSED_NORTH_SHAPE = Block.createCuboidShape(0,  0, 14, 16, 16, 16);

    public CurtainBlock() {
        super(Settings.of(Material.WOOD).strength(0.2f).sounds(BlockSoundGroup.WOOD));
        setDefaultState(newDefaultState().with(OPEN, false).with(CORD, true));
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            fluidTick(world, pos);
        }
        
        if (!canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        
        var face = state.get(FACING);
        var left = face.rotateYCounterclockwise();
        if (left.getAxis() == direction.getAxis() && 
            pos.getY() == posFrom.getY() && 
            newState.getBlock() instanceof CurtainBlock && 
            face == newState.get(FACING)) {
            state = state.with(OPEN, newState.get(OPEN));
        }
        
        var block = world.getBlockState(pos.offset(left));
        return state.with(CORD, !(block.getBlock() instanceof CurtainBlock && face == block.get(FACING)));
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var state = super.getPlacementState(ctx);
        var world = ctx.getWorld();
        var pos = ctx.getBlockPos();
        var left = state.get(FACING).rotateYCounterclockwise();
        
        var block = world.getBlockState(pos.offset(left));
        if (block.getBlock() instanceof CurtainBlock) {
            state = state.with(CORD, false).with(OPEN, block.get(OPEN));
        }
        block = world.getBlockState(pos.offset(left.getOpposite()));
        if (block.getBlock() instanceof CurtainBlock) {
            state = state.with(OPEN, block.get(OPEN));
        }
        
        return state;
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.getBlockState(pos.offset(state.get(FACING).getOpposite())).isAir();
    }
    
    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }
    
    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return getSideElseUserFacing(ctx).getOpposite();
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(OPEN)) {
            return switch (state.get(FACING)) {
            case NORTH -> OPEN_NORTH_SHAPE;
            case EAST -> OPEN_EAST_SHAPE;
            case SOUTH -> OPEN_SOUTH_SHAPE;
            case WEST -> OPEN_WEST_SHAPE;
            default -> VoxelShapes.fullCube();
            };
        }
        
        return switch (state.get(FACING)) {
        case NORTH -> CLOSED_NORTH_SHAPE;
        case EAST -> CLOSED_EAST_SHAPE;
        case SOUTH -> CLOSED_SOUTH_SHAPE;
        case WEST -> CLOSED_WEST_SHAPE;
        default -> VoxelShapes.fullCube();
        };
    }
    
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        //return state.get(OPEN) ? VoxelShapes.empty() : getOutlineShape(state, world, pos, context);
        return VoxelShapes.empty();
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(OPEN, CORD);
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        state = state.cycle(OPEN);
        world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
        if (state.get(WATERLOGGED)) {
            fluidTick(world, pos);
        }
        boolean isOpen = state.get(OPEN);
        var sound = isOpen ? ModSounds.CURTAIN_OPEN : ModSounds.CURTAIN_CLOSE;
        world.playSound(null, pos, sound, SoundCategory.BLOCKS, 0.5f, isOpen ? 1.0f : 0.95f);
        world.emitGameEvent(player, state.get(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
        return ActionResult.success(world.isClient);
    }
}
