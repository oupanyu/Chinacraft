package ocean.chinacraft;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import ocean.chinacraft.blocks.world.ModConfiguredFeatures;
import ocean.chinacraft.blocks.world.gen.ModWorldGen;
import ocean.chinacraft.config.ModConfig;
import ocean.chinacraft.tags.TagsRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chinacraft implements ModInitializer {

    public static final String MODID = "chinacraft";

    public static final Logger LOGGER = LogManager.getLogger("ChinaCraft");

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("chinacraft", "main"),
            () -> new ItemStack(Items.COPPER_INGOT));

    public static ModConfig config;





    @Override
    public void onInitialize() {
        ModConfiguredFeatures.registry();
        BlockRegister.registry();
        ItemRegister.register();
        TagsRegister.registry();
        WorldGenRegister.register();
        RecipeRegister.registry();
        ModFlammableBlockRegistry.register();
        ModWorldGen.register();
        ModBlockEntities.register();

        AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }
}
