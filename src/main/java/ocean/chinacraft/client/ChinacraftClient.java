package ocean.chinacraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.client.util.ScreenshotRecorder;
import ocean.chinacraft.ModScreenHandler;
import ocean.chinacraft.client.blocks.ClientBlocks;
import ocean.chinacraft.client.screen.JadeWorkbenchScreen;
import ocean.chinacraft.client.screen.StoneMortarScreen;
import ocean.chinacraft.screen.StoneMortarScreenHandler;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class ChinacraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ClientBlocks.init();
        ScreenRegistry.register(ModScreenHandler.JADE_WORKBENCH_SCREEN_HANDLER, JadeWorkbenchScreen::new);
        ScreenRegistry.register(ModScreenHandler.STONE_MORTAR_SCREEN_HANDLER, StoneMortarScreen::new);

    }
}
