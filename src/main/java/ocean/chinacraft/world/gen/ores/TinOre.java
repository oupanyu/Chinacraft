package ocean.chinacraft.world.gen.ores;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import ocean.chinacraft.BlockRegister;
import ocean.chinacraft.Chinacraft;

import java.util.Arrays;

public class TinOre {

    private static ConfiguredFeature<?, ?> OVERWORLD_TIN_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    BlockRegister.TIN_ORE.getDefaultState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_TIN_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_TIN_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
            )); // height

    public static void register(){
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(Chinacraft.MODID, "overworld_tin_ore"), OVERWORLD_TIN_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Chinacraft.MODID, "overworld_tin_ore"),
                OVERWORLD_TIN_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Chinacraft.MODID, "overworld_tin_ore")));
    }
}
