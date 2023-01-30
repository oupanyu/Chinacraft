package ocean.chinacraft.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.items.tools.material.ModItemMaterial;

public class BronzeAxe extends AxeItem {
    public BronzeAxe() {
        super(ModItemMaterial.BRONZE_AXE,1,-2.8f,new FabricItemSettings().group(Chinacraft.ITEM_GROUP));
    }
}
