package ocean.chinacraft.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.EntryTypeRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.client.entry.FluidEntryDefinition;
import me.shedaniel.rei.plugin.client.entry.ItemEntryDefinition;
import ocean.chinacraft.BlockRegister;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.ItemRegister;
import ocean.chinacraft.recipe.MortarRecipe;
import ocean.chinacraft.rei.display.MortarDisplay;
import ocean.chinacraft.rei.display.category.MortarDisplayCategory;

public class REIClientPlugins implements REIClientPlugin {

    public static final CategoryIdentifier<MortarDisplay> MORTAR_DISPLAY_CATEGORY_IDENTIFIER = CategoryIdentifier.of(Chinacraft.MODID,"plugins/mortar");

    public static class ModEntryStack{
        public static final EntryStack STONE_MORTAR_ENTRYSTACK = EntryStacks.of(BlockRegister.STONE_MORTAR);
        public static final EntryIngredient RICE_INGREDIENT = EntryIngredients.of(ItemRegister.RICES_FLOUR);

    }

    @Override
    public void registerEntryTypes(EntryTypeRegistry registry) {
        registry.register(VanillaEntryTypes.ITEM, new ItemEntryDefinition());
        registry.register(VanillaEntryTypes.FLUID, new FluidEntryDefinition());

    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(MortarRecipe.class, MortarDisplay::new);
        REIClientPlugin.super.registerDisplays(registry);
    }

    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(MORTAR_DISPLAY_CATEGORY_IDENTIFIER, MortarDisplay.serializer());
        REIClientPlugin.super.registerDisplaySerializer(registry);
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(

                new MortarDisplayCategory()
        );
        registry.addWorkstations(MORTAR_DISPLAY_CATEGORY_IDENTIFIER, EntryStacks.of(BlockRegister.STONE_MORTAR));
        REIClientPlugin.super.registerCategories(registry);
    }

}
