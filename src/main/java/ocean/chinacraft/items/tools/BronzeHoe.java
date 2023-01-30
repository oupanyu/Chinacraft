package ocean.chinacraft.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.items.tools.material.ModItemMaterial;

public class BronzeHoe extends HoeItem {
    public BronzeHoe() {
        super(ModItemMaterial.BRONZE_HOE,1,-2.8f,new FabricItemSettings().group(Chinacraft.ITEM_GROUP));
    }
}
