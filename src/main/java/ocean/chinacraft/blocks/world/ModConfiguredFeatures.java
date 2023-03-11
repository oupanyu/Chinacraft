package ocean.chinacraft.blocks.world;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import ocean.chinacraft.BlockRegister;
import ocean.chinacraft.Chinacraft;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MULBERRY_TREE =
            ConfiguredFeatures.register("mulberry_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(BlockRegister.MULBERRY_LOG),
                    new StraightTrunkPlacer(3,4,3),
                    BlockStateProvider.of(BlockRegister.MULBERRY_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(0),4),
                    new TwoLayersFeatureSize(1,0,2)
                            ).build());

    public static final RegistryEntry<PlacedFeature> MULBERRY_CHECKED = PlacedFeatures.register("mulberry_checked",MULBERRY_TREE,
            PlacedFeatures.wouldSurvive(BlockRegister.MULBERRY_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MULBERRY_SPAWN = ConfiguredFeatures.register("mulberry_spawn",
            Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(List.of(new RandomFeatureEntry(MULBERRY_CHECKED, 0.5F)),
                    MULBERRY_CHECKED)
            );

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CHERRY_TREE =
            ConfiguredFeatures.register("cherry_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(BlockRegister.CHERRY_LOG),
                    new StraightTrunkPlacer(3,4,3),
                    BlockStateProvider.of(BlockRegister.CHERRY_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2),ConstantIntProvider.create(0),4),
                    new TwoLayersFeatureSize(1,0,2)
            ).build());
    public static final RegistryEntry<PlacedFeature> CHERRY_CHECKED = PlacedFeatures.register("cherry_checked",CHERRY_TREE,
            PlacedFeatures.wouldSurvive(BlockRegister.CHERRY_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CHERRY_SPAWN = ConfiguredFeatures.register("cherry_spawn",
            Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(List.of(new RandomFeatureEntry(CHERRY_CHECKED, 0.5F)),
                    CHERRY_CHECKED)
    );


    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> AZALEA =
            ConfiguredFeatures.register("azalea_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockRegister.AZALEA)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PEONY =
            ConfiguredFeatures.register("peony_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockRegister.PEONY)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> CHRYSANTHEMUM =
            ConfiguredFeatures.register("chrysanthemum", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockRegister.CHRYSANTHEMUM)))));


    public static void registry(){
        Chinacraft.LOGGER.info("registering tree structures..");
    }
}
