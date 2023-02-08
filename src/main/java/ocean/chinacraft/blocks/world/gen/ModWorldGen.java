package ocean.chinacraft.blocks.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import ocean.chinacraft.blocks.world.ModPlacedFeatures;

public class ModWorldGen {
    public static void register(){
        genTrees();
    }
    private static void genTrees(){
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MULBERRY_PLACED.getKey().get());
    }
}
