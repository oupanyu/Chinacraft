package ocean.chinacraft.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum ArmorMarteial  implements ArmorMaterial {

    /**
     * 青铜
     */
    /*BRONZE_ARMOR("bronze_armor", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F,
            0.0F, () -> {
        return Ingredient.of(ModItems.BRONZE_INGOT.get());
    }),*/

    /**
     * 丝绸 - 夜行衣
     */
    /*SILK_NIGHT_ARMOR("silk_night_armor", 100, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F,
            0.0F, () -> {
        return Ingredient.of(ModItems.BLACK_SILK.get());
    })*/;
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Ingredient repairIngredient;

    ArmorMarteial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                  SoundEvent sound,
                  float toughness, float knockbackResistance, Ingredient repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }



    @Override
    public int getDurability(EquipmentSlot slot) {
        return 0;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
