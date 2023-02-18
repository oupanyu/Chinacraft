package ocean.chinacraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.util.shape.VoxelShape;

public class StoneLantern extends HorizontalFacingBlock {
    public StoneLantern(Settings settings) {
        super(settings);
    }
    private final static VoxelShape SHAPES =
            Block.createCuboidShape(0, 0, 0, 16, 19, 16);

    public static VoxelShape getSHAPES() {
        return SHAPES;
    }
}
