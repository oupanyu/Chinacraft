package ocean.chinacraft.blocks.world;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> MULBERRY_PLACED = PlacedFeatures.register("mulberry_placed",
            ModConfiguredFeatures.MULBERRY_SPAWN , VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0,0.5f,1)
            ));
}
