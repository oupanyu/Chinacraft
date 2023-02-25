package ocean.chinacraft.rei.display.category;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.DisplayMerger;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import me.shedaniel.rei.plugin.common.displays.DefaultStoneCuttingDisplay;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import ocean.chinacraft.BlockRegister;
import ocean.chinacraft.rei.REIClientPlugins;
import ocean.chinacraft.rei.display.MortarDisplay;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MortarDisplayCategory implements DisplayCategory<MortarDisplay> {
    @Override
    public CategoryIdentifier getCategoryIdentifier() {
        return REIClientPlugins.MORTAR_DISPLAY_CATEGORY_IDENTIFIER;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("chinacraft.recipe.mortar");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BlockRegister.STONE_MORTAR);
    }

    @Override
    public List<Widget> setupDisplay(MortarDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)).animationDurationTicks(100));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5))
                .entries(display.getOutputEntries().get(0))
                .disableBackground()
                .markOutput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5))
                .entries(display.getInputEntries().get(0)).markInput());
        return widgets;
    }

}