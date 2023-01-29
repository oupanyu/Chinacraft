package ocean.chinacraft.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.items.tools.material.ModItemMaterial;
import org.jetbrains.annotations.NotNull;

public class BronzeSwordPurple extends SwordItem {
    public BronzeSwordPurple() {
        super(ModItemMaterial.BRONZE_SWORD_JADE, 3, -2.4f, new FabricItemSettings().group(Chinacraft.ITEM_GROUP));
    }
    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (!player.getMainHandStack().isEmpty() && player.getMainHandStack() == itemStack) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 0, 1, false, false));
            }
        }
    }
}
