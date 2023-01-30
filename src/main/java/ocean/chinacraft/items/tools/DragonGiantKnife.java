package ocean.chinacraft.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.items.tools.material.ModItemMaterial;

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
