package ocean.chinacraft.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ModIngots extends Item {

    Item dust;
    public ModIngots(Item dust) {
        super(new FabricItemSettings());
        this.dust = dust;
    }
    public Item getDust(){
        return dust;
    }
}
