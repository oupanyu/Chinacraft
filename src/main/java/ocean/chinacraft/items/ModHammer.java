package ocean.chinacraft.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import ocean.chinacraft.Chinacraft;

public class ModHammer extends SwordItem {
    public ModHammer(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed, new FabricItemSettings().group(Chinacraft.ITEM_GROUP));
    }


    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

}
