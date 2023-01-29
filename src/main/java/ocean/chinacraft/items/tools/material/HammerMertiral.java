package ocean.chinacraft.items.tools.material;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import ocean.chinacraft.ItemRegister;

public enum HammerMertiral implements ToolMaterial {

    /**
     * 石锤子
     */
    STONE_HAMMER(1, 240, 1, 6f, 10, Ingredient.ofItems(ItemRegister.STONE_HAMMER)),

    /**
     * 铁锤子
     */
    IRON_HAMMER(2, 475, 1, 7f, 10, Ingredient.ofItems(ItemRegister.IRON_HAMMER)),

    /**
     * 青铜锤子
     */
    BRONZE_HAMMER(2, 475, 1, 7f, 10, Ingredient.ofItems(ItemRegister.BRONZE_HAMMER)),

    /**
     * 钻石锤子
     */
    DIAMOND_HAMMER(3, 2096, 1, 8f, 10, Ingredient.ofItems(ItemRegister.DIAMOND_HAMMER));;




    private final int level;
    private final int maxUses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    HammerMertiral(int level, int maxUses, float speed, float attackDamageBonus, int enchantmentValue,
                   Ingredient repairIngredient){
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
