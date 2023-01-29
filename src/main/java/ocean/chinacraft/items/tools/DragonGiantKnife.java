package ocean.chinacraft.items.tools.material;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import ocean.chinacraft.Chinacraft;

public class DragonGiantKnife extends SwordItem {
    public DragonGiantKnife() {
        super(ModItemMaterial.YAN_LONG_BIG_KNIFE, 3, -2.4f, new FabricItemSettings().group(Chinacraft.ITEM_GROUP));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        super.postHit(stack,target,attacker);
        target.setFireTicks(20);
        return true;
    }
}
