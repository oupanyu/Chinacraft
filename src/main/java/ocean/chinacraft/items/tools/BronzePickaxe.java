package ocean.chinacraft.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import ocean.chinacraft.items.tools.material.ModItemMaterial;

import static ocean.chinacraft.Chinacraft.ITEM_GROUP;

public class BronzePickaxe extends PickaxeItem {
    public BronzePickaxe() {
        super(ModItemMaterial.BRONZE_PICKAXE,1,-2.8f,new FabricItemSettings().group(ITEM_GROUP));
    }
}
