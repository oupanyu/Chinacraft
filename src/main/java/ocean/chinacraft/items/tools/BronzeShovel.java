package ocean.chinacraft.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.items.tools.material.ModItemMaterial;

public class BronzeShovel extends ShovelItem {
    public BronzeShovel() {
        super(ModItemMaterial.BRONZE_SHOVEL,1,-2.8f,new FabricItemSettings().group(Chinacraft.ITEM_GROUP));
    }
}
