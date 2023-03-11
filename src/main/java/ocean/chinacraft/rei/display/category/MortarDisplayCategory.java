package ocean.chinacraft.rei.display.category;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import ocean.chinacraft.BlockRegister;
import ocean.chinacraft.client.screen.StoneMortarScreen;
import ocean.chinacraft.rei.REIClientPlugins;
import ocean.chinacraft.rei.display.MortarDisplay;

import java.util.List;

public class MortarDisplayCategory implements DisplayCategory<MortarDisplay> {
    @Override
    public CategoryIdentifier getCategoryIdentifier() {
        return REIClientPlugins.MORTAR_DISPLAY_CATEGORY_IDENTIFIER;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("category.chinacraft.recipe.mortar");
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
        widgets.add(Widgets.createLabel(new Point(startPoint.x + 47,startPoint.y - 13),new TranslatableText("category.chinacraft.recipe.mortar")).noShadow().rightAligned().color(0xFF404040, 0xFFBBBBBB));
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
