package ocean.chinacraft.recipe;

import com.google.common.collect.Lists;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.ItemRegister;
import ocean.chinacraft.RecipeRegister;
import ocean.chinacraft.tags.TagHelper;
import ocean.chinacraft.tags.TagsRegister;

import java.util.ArrayList;

public class TinPowderRecipe extends SpecialCraftingRecipe {

    int hammerSlot;

    public TinPowderRecipe(Identifier id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        ArrayList<ItemStack> stackArrayList = Lists.newArrayList();
        for (int i =0;i<inventory.size();i++){
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()){
                if (TagHelper.Items.checkByIStack(stack,TagsRegister.Items.HAMMER_TAG)){
                    stackArrayList.add(stack);
                }else if (TagHelper.Items.checkByIStack(stack,TagsRegister.Items.C_TIN_INGOTS)){
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
        for (int i =0;i<inventory.size();i++){
            ItemStack stack = inventory.getStack(i);
            if (!stack.isEmpty()){
                count++;
                if (TagHelper.Items.checkByIStack(stack,TagsRegister.Items.C_TIN_INGOTS)){
                    hasIngot = true;
                } else if (TagHelper.Items.checkByIStack(stack,TagsRegister.Items.HAMMER_TAG)) {
                    hasHammer = true;
                    hammerSlot = i;
                }
            }
        }
        if (hasHammer && hasIngot && count == 2){
            return ItemRegister.TIN_POWDER.getDefaultStack();
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
        ItemStack stack = inventory.getStack(hammerSlot).copy();
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
        return RecipeRegister.TIN_DUST_RECIPE_RECIPE_SERIALIZER;
    }


}
