package ocean.chinacraft.client;

import net.fabricmc.api.ClientModInitializer;
import ocean.chinacraft.client.blocks.ClientBlocks;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class ChinacraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientBlocks.init();
    }
}
