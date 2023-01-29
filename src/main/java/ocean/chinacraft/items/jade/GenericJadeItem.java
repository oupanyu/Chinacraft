package ocean.chinacraft.items.jade;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import ocean.chinacraft.Chinacraft;

public class GenericJadeItem extends Item {
    public GenericJadeItem() {
        super(new FabricItemSettings().group(Chinacraft.ITEM_GROUP).maxCount(1));
    }
}
