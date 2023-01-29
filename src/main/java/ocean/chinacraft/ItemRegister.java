package ocean.chinacraft;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ocean.chinacraft.items.CCNormalItem;
import ocean.chinacraft.items.ModHammer;
import ocean.chinacraft.items.ModIngots;
import ocean.chinacraft.items.bucket.WoodBucket;
import ocean.chinacraft.items.food.Corn;
import ocean.chinacraft.items.food.Cucumber;
import ocean.chinacraft.items.food.Eggplant;
import ocean.chinacraft.items.food.MoonCake;
import ocean.chinacraft.items.jade.HibiscusJadeItem;
import ocean.chinacraft.items.jade.JadeItem;
import ocean.chinacraft.items.jade.JasperItem;
import ocean.chinacraft.items.jade.PurpleJadeItem;
import ocean.chinacraft.items.tools.material.HammerMertiral;

public class ItemRegister {

    public static final Item JADE_ITEM = register("jade",new JadeItem());

    private static final Item JASPER_ITEM = register("jasper",new JasperItem());

    private static final Item HIBISCUS_JADE_ITEM = register("hibiscus_jade",new HibiscusJadeItem());

    private static final Item PURPLE_JADE_ITEM = register("purple_jade",new PurpleJadeItem());

    private static final Item CORN = register("corn",new Corn());
    private static final Item CUCUMBER = register("cucumber",new Cucumber());
    private static final Item EGGPLANT = register("eggplant",new Eggplant());
    private static final Item MOON_CAKE = register("moon_cake",new MoonCake());
    //可食用物品

    public static final Item TIN_POWDER = registerNormalItem("tin_powder");//锡粉
    public static final Item COPPER_POWDER = registerNormalItem("copper_powder");//铜粉
    public static final Item BRONZE_POWDER = registerNormalItem("bronze_powder");//青铜粉
    private static final Item TIN_INGOT = registerNormalItem("tin_ingot");//锡锭
    private static final Item SILVER_INGOT = registerNormalItem("silver_ingot");//银锭
    private static final Item BRONZE_INGOT = registerNormalItem("bronze_ingot");//青铜锭
    private static final Item BLACK_BRICK = registerNormalItem("black_brick");//青砖
    private static final Item CLAY_SAND_MIXTURE = registerNormalItem("clay_sand_mixture");//黏土沙混合物

    private static final Item FIRE_BRICK = registerNormalItem("fire_brick");//耐火砖
    private static final Item PEELED_BAMBOO =registerNormalItem("peeled_bamboo");//杀青竹子
    private static final Item SALT = registerNormalItem("salt");//盐
    private static final Item BLACK_DOG_BLOOD = registerNormalItem("black_dog_blood");//黑狗血
    private static final Item FLOUR = registerNormalItem("flour");//面粉
    private static final Item RICES_FLOUR = registerNormalItem("rices_flour");//米粉
    public static final Item WOOD_BUCKET = register("wood_bucket",new WoodBucket(Fluids.EMPTY,new Item.Settings().maxCount(1).group(Chinacraft.ITEM_GROUP)));
    public static final Item WOOD_WATER_BUCKET = register("wood_water_bucket",new WoodBucket(Fluids.WATER,new Item.Settings().maxCount(1).recipeRemainder(WOOD_BUCKET).group(Chinacraft.ITEM_GROUP)));

    public static final Item STONE_HAMMER = register("stone_hammer",new ModHammer(HammerMertiral.STONE_HAMMER,-1,-3));
    public static final Item IRON_HAMMER = register("iron_hammer",new ModHammer(HammerMertiral.IRON_HAMMER,-1,-3));
    public static final Item BRONZE_HAMMER = register("bronze_hammer",new ModHammer(HammerMertiral.BRONZE_HAMMER,-1,-3));
    public static final Item DIAMOND_HAMMER = register("diamond_hammer",new ModHammer(HammerMertiral.DIAMOND_HAMMER,-1,-3));





    public static void register(){
        Chinacraft.LOGGER.info("Registering Items...");
    }
    private static Item register(String id,Item item){
        return Registry.register(Registry.ITEM,new Identifier(Chinacraft.MODID,id),item);
    }
    private static Item registerNormalItem(String id){
        return Registry.register(Registry.ITEM,new Identifier(Chinacraft.MODID,id),new CCNormalItem());
    }

}
