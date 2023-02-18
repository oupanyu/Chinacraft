package ocean.chinacraft.blocks;

import com.google.common.collect.ImmutableMap;
import com.terraformersmc.modmenu.config.option.BooleanConfigOption;
import it.unimi.dsi.fastutil.booleans.BooleanOpenHashSet;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.*;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import ocean.chinacraft.ModBlockEntities;
import ocean.chinacraft.blocks.entity.JadeWorkbenchEntity;
import ocean.chinacraft.blocks.entity.StoneMortarEntity;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.stream.Stream;

public class StoneMortarBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(6, 0, 3, 7, 6, 4),
            Block.createCuboidShape(4, 0, 5, 5, 6, 6),
            Block.createCuboidShape(11, 0, 6, 12, 6, 8),
            Block.createCuboidShape(5, 0, 9, 6, 6, 10),
            Block.createCuboidShape(4, 0, 8, 5, 6, 9),
            Block.createCuboidShape(4, 0, 6, 5, 6, 8),
            Block.createCuboidShape(9, 0, 10, 10, 6, 11),
            Block.createCuboidShape(6, 0, 10, 7, 6, 11),
            Block.createCuboidShape(11, 0, 8, 12, 6, 9),
            Block.createCuboidShape(10, 0, 9, 11, 6, 10),
            Block.createCuboidShape(7, 0, 3, 9, 6, 4),
            Block.createCuboidShape(9, 0, 3, 10, 6, 4),
            Block.createCuboidShape(10, 0, 4, 11, 6, 5),
            Block.createCuboidShape(5, 0, 4, 6, 6, 5),
            Block.createCuboidShape(7, 0, 10, 9, 6, 11),
            Block.createCuboidShape(11, 0, 5, 12, 6, 6),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(6, 0, 4, 10, 1, 10),
                    VoxelShapes.combineAndSimplify(Block.createCuboidShape(10, 0, 5, 11, 1, 9),
                            VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, -2, 6, 9, 7, 8),
                                    Block.createCuboidShape(5, 0, 5, 6, 1, 9), BooleanBiFunction.AND),
                            BooleanBiFunction.AND), BooleanBiFunction.AND)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }



    public StoneMortarBlock(Settings settings) {
        super(settings);
    }


    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StoneMortarEntity stoneMortarEntity){
                ItemScatterer.spawn(world,pos,stoneMortarEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state,world,pos,newState,moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient){
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if (screenHandlerFactory != null){
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.STONE_MORTAR, StoneMortarEntity::tick);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StoneMortarEntity(pos,state);
    }
}
