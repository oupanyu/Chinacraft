package ocean.chinacraft.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import ocean.chinacraft.ItemRegister;

public enum ArmorMarteial  implements ArmorMaterial {

    /**
     * 青铜
     */
    BRONZE_ARMOR("bronze_armor", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F,
            0.0F, Ingredient.ofItems(ItemRegister.BRONZE_INGOT)),

    /**
     * 丝绸 - 夜行衣
     */
    SILK_NIGHT_ARMOR("silk_night_armor", 100, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F,
            0.0F,Ingredient.ofItems(ItemRegister.BLACK_SILK));
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
        return HEALTH_PER_SLOT[slot.getEntitySlotId()] * durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return slotProtections[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
