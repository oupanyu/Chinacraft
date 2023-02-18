package ocean.chinacraft;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.entity.ItemEntity;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import ocean.chinacraft.screen.JadeWorkbenchScreenHandler;
import ocean.chinacraft.screen.StoneMortarScreenHandler;

public class ModScreenHandler {
    public static ScreenHandlerType<JadeWorkbenchScreenHandler> JADE_WORKBENCH_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(Chinacraft.MODID,"jade_workbench"),JadeWorkbenchScreenHandler::new);
    public static ScreenHandlerType<StoneMortarScreenHandler> STONE_MORTAR_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(Chinacraft.MODID,"stone_mortar"), StoneMortarScreenHandler::new);
}
