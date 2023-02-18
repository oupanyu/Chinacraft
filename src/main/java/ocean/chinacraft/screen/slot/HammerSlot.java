package ocean.chinacraft.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import ocean.chinacraft.tags.TagHelper;
import ocean.chinacraft.tags.TagsRegister;

public class HammerSlot extends Slot {
    public HammerSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return TagHelper.Items.checkByIStack(stack, TagsRegister.Items.HAMMER_TAG);
    }
}
