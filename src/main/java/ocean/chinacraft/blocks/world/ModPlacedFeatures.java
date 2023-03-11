package ocean.chinacraft.blocks.world;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> MULBERRY_PLACED = PlacedFeatures.register("mulberry_placed",
            ModConfiguredFeatures.MULBERRY_SPAWN , VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0,0.5f,1)
            ));

    public static final RegistryEntry<PlacedFeature> CHERRY_PLACED = PlacedFeatures.register("cherry_placed",
            ModConfiguredFeatures.CHERRY_SPAWN , VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0,0.5f,1)
            ));

    public static final RegistryEntry<PlacedFeature> AZALEA_PLACED = PlacedFeatures.register("azalea_placed",
            ModConfiguredFeatures.AZALEA, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> PEONY_PLACED = PlacedFeatures.register("peony_placed",
            ModConfiguredFeatures.PEONY, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> CHRYSANTHEMUM_PLACED = PlacedFeatures.register("chrysanthemum_placed",
            ModConfiguredFeatures.CHRYSANTHEMUM, RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
}
