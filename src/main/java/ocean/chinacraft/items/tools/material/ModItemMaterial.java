package ocean.chinacraft.items.tools.material;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import ocean.chinacraft.ItemRegister;

public enum ModItemMaterial implements ToolMaterial {

    /**
     * 青铜大刀
     */
    BIG_BRONZE_SWORD(2, 500, 6.0F, 2.5F, 10, Ingredient.ofItems(ItemRegister.BIG_BRONZE_SWORD)),

    /**
     * 狼牙棒
     */
    MACE(2, 500, 6.0F, 2F, 10, Ingredient.ofItems(ItemRegister.MACE)),

    /**
     * 九曲镋
     */
    JIU_QU_TANG(2, 251, 6.0F, 2F, 10, Ingredient.ofItems(ItemRegister.JIU_QU_TANG)),

    /**
     * 炎龙巨刀
     */
    YAN_LONG_BIG_KNIFE(2, 3000, 6.0F, 6F, 10, Ingredient.ofItems(ItemRegister.YAN_LONG_BIG_KNIFE)),

    /**
     * 青铜大刀 - 翡翠
     */
    BRONZE_SWORD_JADE(2, 2000, 6.0F, 2.5F, 10, Ingredient.ofItems(ItemRegister.BRONZE_SWORD_JADE)),

    /**
     * 青铜大刀 - 碧玉
     */
    BRONZE_SWORD_JASPER(2, 2000, 6.0F, 2.5F, 10, Ingredient.ofItems(ItemRegister.BRONZE_SWORD_JASPER)),

    /**
     * 青铜大刀 - 芙蓉玉
     */
    BRONZE_SWORD_HIBISCUS(2, 2000, 6.0F, 2.5F, 10, Ingredient.ofItems(ItemRegister.BRONZE_SWORD_HIBISCUS)),

    /**
     * 青铜大刀 - 紫玉
     */
    BRONZE_SWORD_PURPLE(2, 2000, 6.0F, 2.5F, 10, Ingredient.ofItems(ItemRegister.BRONZE_SWORD_PURPLE)),

    /**
     * 青铜稿子
     */
    BRONZE_PICKAXE(2, 200, 6.0F, 2.0F, 10, Ingredient.ofItems(ItemRegister.BRONZE_PICKAXE)),

    /**
     * 青铜斧头
     */
    BRONZE_AXE(2, 251, 6.0F, 2.0F, 10, Ingredient.ofItems(ItemRegister.BRONZE_AXE)),

    /**
     * 青铜铲子
     */
    BRONZE_SHOVEL(2, 200, 6.0F, 2.0F, 10, Ingredient.ofItems(ItemRegister.BRONZE_SHOVEL)),

    /**
     * 青铜锄头
     */
    BRONZE_HOE(2, 251, 6.0F, 2.0F, 10, Ingredient.ofItems(ItemRegister.BRONZE_HOE));

    private final int level;
    private final int maxUses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    ModItemMaterial(int level, int maxUses, float speed, float attackDamageBonus, int enchantmentValue,
                Ingredient repairIngredient) {
        this.level = level;
        this.maxUses = maxUses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return maxUses;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return speed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamageBonus;
    }

    @Override
    public int getMiningLevel() {
        return level;
    }

    @Override
    public int getEnchantability() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }
}
