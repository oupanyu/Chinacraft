package ocean.chinacraft.recipe;

import com.google.common.collect.Lists;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.ItemRegister;
import ocean.chinacraft.RecipeRegister;
import ocean.chinacraft.config.ModConfig;
import ocean.chinacraft.items.ModHammer;
import ocean.chinacraft.items.ModIngots;
import ocean.chinacraft.items.dust.AbstractPowder;


import java.util.ArrayList;

public class ModHammerRecipe extends SpecialCraftingRecipe {

    int hammerSlot;

    public ModHammerRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        ArrayList<ItemStack> stackArrayList = Lists.newArrayList();
        for (int i =0;i<inventory.size();i++){
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()){
                if (stack.getItem() instanceof ModHammer){
                    stackArrayList.add(stack);
                }else if (stack.getItem() instanceof ModIngots){
                    stackArrayList.add(stack);
                }else if(stack.getItem() == Items.COPPER_INGOT){
                    stackArrayList.add(stack);
                }

            }

        }
        return stackArrayList.size() == 2;

    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        boolean hasIngot = false,hasHammer = false;
        int count = 0;
        Item ingot = null;
        for (int i =0;i<inventory.size();i++){
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()){
                count++;
                if (stack.getItem() instanceof ModIngots || stack.getItem() == Items.COPPER_INGOT){
                    ingot = stack.getItem();
                    hasIngot = true;
                } else if (stack.getItem() instanceof ModHammer) {
                    hasHammer = true;
                    hammerSlot = i;
                }
            }
        }
        if (hasHammer && hasIngot && count == 2){
            if (ingot instanceof ModIngots){
                Item dust = ((ModIngots) ingot).getDust();
                return dust.getDefaultStack();
            } else if (ingot == Items.COPPER_INGOT) {
                return ItemRegister.COPPER_POWDER.getDefaultStack();
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width*height >= 2;
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(9,ItemStack.EMPTY);
        ItemStack stack = inventory.getStack(hammerSlot);
        stack.setDamage(stack.getDamage() + Chinacraft.config.CRAFT_POWDER_HAMMER_CONSUME);
        if (stack.getDamage() >= stack.getMaxDamage()) {
            defaultedList.set(hammerSlot,ItemStack.EMPTY);
            return defaultedList;
        }
        defaultedList.set(hammerSlot,stack);
        return defaultedList;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }


}
