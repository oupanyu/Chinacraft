package ocean.chinacraft;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import ocean.chinacraft.recipe.BronzePowderRecipe;
import ocean.chinacraft.recipe.CopperPowderRecipe;
import ocean.chinacraft.recipe.TinPowderRecipe;

public class RecipeRegister {
    public static final SpecialRecipeSerializer<TinPowderRecipe> TIN_DUST_RECIPE_RECIPE_SERIALIZER = RecipeSerializer.register("tin_powder_recipe",new SpecialRecipeSerializer<>(TinPowderRecipe::new));

    public static final SpecialRecipeSerializer<CopperPowderRecipe> COPPER_DUST_RECIPE_RECIPE_SERIALIZER = RecipeSerializer.register("copper_powder_recipe",new SpecialRecipeSerializer<>(CopperPowderRecipe::new));
    public static final SpecialRecipeSerializer<BronzePowderRecipe> BRONZE_DUST_RECIPE_RECIPE_SERIALIZER = RecipeSerializer.register("bronze_powder_recipe",new SpecialRecipeSerializer<>(BronzePowderRecipe::new));


    public static void registry(){
        Chinacraft.LOGGER.info("logging recipes");
    }
}
