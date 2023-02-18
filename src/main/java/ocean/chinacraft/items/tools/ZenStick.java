package ocean.chinacraft.items.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;

public class ZenStick extends Item {
    public ZenStick(Settings settings) {
        super(settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.isAlive()) {
            if (target.getHealth() <= target.getMaxHealth()-2){
                target.setHealth(target.getHealth() + 2);
            }
        }
        return true;
    }
}
