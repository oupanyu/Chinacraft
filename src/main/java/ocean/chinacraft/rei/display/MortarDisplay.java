package ocean.chinacraft.rei.display;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.DefaultStoneCuttingDisplay;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import ocean.chinacraft.recipe.MortarRecipe;
import ocean.chinacraft.rei.REIClientPlugins;
import ocean.chinacraft.rei.display.category.MortarDisplayCategory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MortarDisplay extends BasicDisplay {
    public MortarDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }


    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return REIClientPlugins.MORTAR_DISPLAY_CATEGORY_IDENTIFIER;
    }

    public MortarDisplay(MortarRecipe recipe) {
        this(EntryIngredients.ofIngredients(recipe.getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.getOutput())),
                Optional.ofNullable(recipe.getId()));
    }

    public MortarDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Optional<Identifier> location) {
        super(inputs, outputs, location);
    }
    public static BasicDisplay.Serializer<MortarDisplay> serializer() {
        return BasicDisplay.Serializer.ofSimple(MortarDisplay::new);
    }
}
