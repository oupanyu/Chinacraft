package ocean.chinacraft;

import ocean.chinacraft.world.gen.ores.SilverOre;
import ocean.chinacraft.world.gen.ores.TinOre;

public class WorldGenRegister {
    public static void register(){
        TinOre.register();
        SilverOre.register();
    }
}
