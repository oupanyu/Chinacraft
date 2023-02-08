package ocean.chinacraft.client.blocks;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import ocean.chinacraft.BlockRegister;
import ocean.chinacraft.ItemRegister;

public class ClientBlocks {
    public static void init(){
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockRegister.RICES_EAR_SEEDS);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockRegister.MULBERRY_LEAVES);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BlockRegister.MULBERRY_SAPLING);

    }
}
