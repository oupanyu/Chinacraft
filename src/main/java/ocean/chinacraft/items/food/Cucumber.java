package ocean.chinacraft.items.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import ocean.chinacraft.Chinacraft;

public class Cucumber extends Item {
    public Cucumber() {
        super(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(3.0f).build()).group(Chinacraft.ITEM_GROUP));
    }
}
