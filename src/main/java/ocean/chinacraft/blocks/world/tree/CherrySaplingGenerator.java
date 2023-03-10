package ocean.chinacraft.blocks.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import ocean.chinacraft.blocks.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CherrySaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.CHERRY_TREE;
    }
}
