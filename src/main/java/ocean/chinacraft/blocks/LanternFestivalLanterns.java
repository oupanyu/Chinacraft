package ocean.chinacraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.state.StateManager;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.shape.VoxelShape;

public class LanternFestivalLanterns extends HorizontalFacingBlock {

    private final VoxelShape SHAPES = Block.createCuboidShape(3, 2.5, 3, 13, 13.5, 13);

    public LanternFestivalLanterns(Settings settings) {
        super(settings);
    }

    public VoxelShape getSHAPES() {
        return SHAPES;
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING,rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.appendProperties(builder);
    }
}
