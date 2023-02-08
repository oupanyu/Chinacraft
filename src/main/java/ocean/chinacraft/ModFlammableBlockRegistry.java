package ocean.chinacraft;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlockRegistry {
    public static void register() {
        FlammableBlockRegistry flammableBlockRegistry = FlammableBlockRegistry.getDefaultInstance();
        flammableBlockRegistry.add(BlockRegister.MULBERRY_LOG,5,5);
        flammableBlockRegistry.add(BlockRegister.MULBERRY_PLANKS,5,20);
        flammableBlockRegistry.add(BlockRegister.MULBERRY_LEAVES,30,60);
    }
}
