package ocean.chinacraft.items.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import ocean.chinacraft.util.ModUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SilkNightArmor extends ArmorItem {
    public SilkNightArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.chinacraft.nightarmor.0"));
        tooltip.add(new TranslatableText("tooltip.chinacraft.nightarmor.1"));
        tooltip.add(new TranslatableText("tooltip.chinacraft.nightarmor.2"));
        tooltip.add(new TranslatableText("tooltip.chinacraft.nightarmor.3"));
    }

    public static boolean hasFood(PlayerEntity player) {
        return player.getHungerManager().getFoodLevel() >= 14;
    }

    public static boolean invalid(PlayerEntity player) {
        return ModUtil.hasCorrectArmorOn(ArmorMarteial.SILK_NIGHT_ARMOR, player) && hasFood(player) && player.isSneaking();
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player && invalid(player)){


        }
    }
}
