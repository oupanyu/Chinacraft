package ocean.chinacraft.items.dust;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class AbstractPowder extends Item {
    public AbstractPowder() {
        super(new FabricItemSettings());
    }
    public Item getItem(){
        return this;
    }
}
