package ocean.chinacraft.items.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import ocean.chinacraft.Chinacraft;

public class MoonCake extends Item {
    public MoonCake() {
        super(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).snack().saturationModifier(6.0f).build()).group(Chinacraft.ITEM_GROUP));
    }
}
