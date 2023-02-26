package ocean.chinacraft;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ocean.chinacraft.items.CCNormalItem;
import ocean.chinacraft.items.ModHammer;
import ocean.chinacraft.items.armor.ArmorMarteial;
import ocean.chinacraft.items.bucket.WoodBucket;
import ocean.chinacraft.items.food.Corn;
import ocean.chinacraft.items.food.Cucumber;
import ocean.chinacraft.items.food.Eggplant;
import ocean.chinacraft.items.food.MoonCake;
import ocean.chinacraft.items.jade.HibiscusJadeItem;
import ocean.chinacraft.items.jade.JadeItem;
import ocean.chinacraft.items.jade.JasperItem;
import ocean.chinacraft.items.jade.PurpleJadeItem;
import ocean.chinacraft.items.spell.*;
import ocean.chinacraft.items.tools.*;
import ocean.chinacraft.items.tools.material.HammerMertiral;
import ocean.chinacraft.items.tools.material.ModItemMaterial;

import static ocean.chinacraft.Chinacraft.ITEM_GROUP;

public class ItemRegister {

    public static final Item JADE_ITEM = register("jade",new JadeItem());

    public static final Item JASPER_ITEM = register("jasper",new JasperItem());

    public static final Item HIBISCUS_JADE_ITEM = register("hibiscus_jade",new HibiscusJadeItem());

    public static final Item PURPLE_JADE_ITEM = register("purple_jade",new PurpleJadeItem());

    private static final Item CORN = register("corn",new Corn());
    private static final Item CUCUMBER = register("cucumber",new Cucumber());
    private static final Item EGGPLANT = register("eggplant",new Eggplant());
    private static final Item MOON_CAKE = register("moon_cake",new MoonCake());
    //可食用物品

    public static final Item RICES_EAR = registerNormalItem("rices_ear");//米穗


    public static final Item TIN_POWDER = registerNormalItem("tin_powder");//锡粉
    public static final Item COPPER_POWDER = registerNormalItem("copper_powder");//铜粉
    public static final Item BRONZE_POWDER = registerNormalItem("bronze_powder");//青铜粉
    public static final Item TIN_INGOT = registerNormalItem("tin_ingot");//锡锭
    public static final Item SILVER_INGOT = registerNormalItem("silver_ingot");//银锭
    public static final Item BRONZE_INGOT = registerNormalItem("bronze_ingot");//青铜锭
    public static final Item BLACK_BRICK = registerNormalItem("black_brick");//青砖
    public static final Item CLAY_SAND_MIXTURE = registerNormalItem("clay_sand_mixture");//黏土沙混合物

    public static final Item FIRE_BRICK = registerNormalItem("fire_brick");//耐火砖
    public static final Item PEELED_BAMBOO =registerNormalItem("peeled_bamboo");//杀青竹子
    public static final Item SALT = registerNormalItem("salt");//盐
    public static final Item BLACK_DOG_BLOOD = registerNormalItem("black_dog_blood");//黑狗血
    public static final Item FLOUR = registerNormalItem("flour");//面粉
    public static final Item RICES_FLOUR = registerNormalItem("rices_flour");//米粉
    public static final Item WOOD_BUCKET = register("wood_bucket",new WoodBucket(Fluids.EMPTY,new Item.Settings().maxCount(1).group(ITEM_GROUP)));
    public static final Item WOOD_WATER_BUCKET = register("wood_water_bucket",new WoodBucket(Fluids.WATER,new Item.Settings().maxCount(1).recipeRemainder(WOOD_BUCKET).group(ITEM_GROUP)));

    //各种锤子
    public static final Item STONE_HAMMER = register("stone_hammer",new ModHammer(HammerMertiral.STONE_HAMMER,-1,-3));
    public static final Item IRON_HAMMER = register("iron_hammer",new ModHammer(HammerMertiral.IRON_HAMMER,-1,-3));
    public static final Item BRONZE_HAMMER = register("bronze_hammer",new ModHammer(HammerMertiral.BRONZE_HAMMER,-1,-3));
    public static final Item DIAMOND_HAMMER = register("diamond_hammer",new ModHammer(HammerMertiral.DIAMOND_HAMMER,-1,-3));

    //青铜大剑
    public static final Item BIG_BRONZE_SWORD = register("big_bronze_sword",new SwordItem(ModItemMaterial.BIG_BRONZE_SWORD,3,-2.4f,new FabricItemSettings().group(ITEM_GROUP)));
    //狼牙棒
    public static final Item MACE = register("mace",new SwordItem(ModItemMaterial.MACE,3,-2.4f,new FabricItemSettings().group(ITEM_GROUP)));
    //九曲镗
    public static final Item JIU_QU_TANG = register("jiu_qu_tang",new SwordItem(ModItemMaterial.JIU_QU_TANG,3,-2.4f,new FabricItemSettings().group(ITEM_GROUP)));
    //炎龙巨刀
    public static final Item YAN_LONG_BIG_KNIFE = register("yan_long_big_knife",new DragonGiantKnife());
    //青铜大刀 - 翡翠
    public static final Item BRONZE_SWORD_JADE = register("bronze_sword_jade",new BronzeSwordJade());
    //青铜大刀 - 碧玉
    public static final Item BRONZE_SWORD_JASPER = register("bronze_sword_jasper",new BronzeSwordJasper());
    //青铜大刀 - 紫玉
    public static final Item BRONZE_SWORD_PURPLE = register("bronze_sword_purple",new BronzeSwordPurple());
    //青铜大刀 - 芙蓉玉
    public static final Item BRONZE_SWORD_HIBISCUS = register("bronze_sword_hibiscus",new BronzeSwordHibiscus());
    //青铜镐、斧、铲子、锄头

    public static final Item ZEN_STICK = register("zen_stick",new ZenStick(new FabricItemSettings().maxCount(1).group(ITEM_GROUP)));

    public static final Item ART_CUTTING_KNIFE = registerNormalItem("art_cutting_knife");
    public static final Item JADE_CUTTING_KNIFE = registerNormalItem("jade_cutting_knife");//切割刀


    public static final Item BRONZE_PICKAXE = register("bronze_pickaxe",new BronzePickaxe());
    public static final Item BRONZE_AXE = register("bronze_axe",new BronzeAxe());
    public static final Item BRONZE_SHOVEL = register("bronze_shovel",new BronzeAxe());
    public static final Item BRONZE_HOE = register("bronze_hoe",new BronzeAxe());

    //灵符
    public static final Item SPIRIT_SPELL = registerNormalItem("spirit_spell");
    //火符
    public static final Item FIRE_SPELL = register("fire_spell",new FireSpell());
    //金睛符
    public static final Item NIGHT_SPELL = register("night_spell",new NightSpell());
    //毒符
    public static final Item POISON_SPELL = register("poison_spell",new PoisonSpell());
    //能量符
    public static final Item POWER_SPELL = register("power_spell",new PowerSpell());
    //命符
    public static final Item HEAL_SPELL = register("heal_spell",new HealSpell());
    //护符
    public static final Item PROTECT_SPELL = register("protect_spell",new ProtectSpell());
    //混沌符
    public static final Item CHAOTIC_SPELL = register("chaotic_spell",new ChaoticSpell());

    public static final Item BLACK_SILK = registerNormalItem("black_silk");


    //青铜套装
    public static final Item BRONZE_HELMET = register("bronze_head",new ArmorItem(ArmorMarteial.BRONZE_ARMOR, EquipmentSlot.HEAD,new FabricItemSettings()));
    public static final Item BRONZE_CHEST = register("bronze_chest",new ArmorItem(ArmorMarteial.BRONZE_ARMOR, EquipmentSlot.CHEST,new FabricItemSettings()));
    public static final Item BRONZE_LEGGINGS = register("bronze_leggings" ,new ArmorItem(ArmorMarteial.BRONZE_ARMOR, EquipmentSlot.LEGS,new FabricItemSettings()));
    public static final Item BRONZE_BOOTS = register("bronze_feet",new ArmorItem(ArmorMarteial.BRONZE_ARMOR, EquipmentSlot.FEET,new FabricItemSettings()));

    public static final Item MUlBERRY_LEAF = registerNormalItem("mulberry_leaf");
    public static final Item SILKWORM_EGG = registerNormalItem("silkworm_egg");

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
