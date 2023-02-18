package ocean.chinacraft.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.List;
import java.util.Random;

public class ModUtil {
    /**
     * 生成1-100的随机数
     *
     * @return 结果
     */
    public static Integer random() {
        return (int) (Math.random() * (100 - 1) + 1);
    }

    public static float randomFloat(float max) {
        Random random = new Random();
        return random.nextFloat(max);
    }

    /**
     * 生成指定随机数
     *
     * @return 结果
     */
    public static Integer random(int max, int min) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static boolean isNotNull(ItemStack... items) {
        for (ItemStack item : items) {
            if (item == null || item.getItem() == Items.AIR || item.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Object数组转int数组
     *
     * @param target 目标字符
     * @return 结果
     */
    public static Integer[] getIntArray(Object[] target) {
        Integer[] ret = new Integer[target.length];
        for (int i = 0; i < target.length; i++) {
            ret[i] = Integer.parseInt(String.valueOf(target[i]));
        }
        return ret;
    }

    public static boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        List<ItemStack> armorList = player.getInventory().armor;
        ItemStack boot = armorList.get(8);
        ItemStack leggings = armorList.get(7);
        ItemStack chest = armorList.get(6);
        ItemStack helmet = armorList.get(5);
        if (ModUtil.isNotNull(boot, leggings, chest, helmet)) {
            ArmorItem b = (ArmorItem) boot.getItem();
            ArmorItem l = (ArmorItem) leggings.getItem();
            ArmorItem c = (ArmorItem) chest.getItem();
            ArmorItem h = (ArmorItem) helmet.getItem();
            return h.getMaterial() == material && c.getMaterial() == material &&
                    l.getMaterial() == material && b.getMaterial() == material;
        }
        return false;
    }
}
