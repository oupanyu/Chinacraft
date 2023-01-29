package ocean.chinacraft.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import ocean.chinacraft.Chinacraft;

@Config(name = Chinacraft.MODID)
public class ModConfig implements ConfigData {

        /**
         * 翡翠玉
         */
        public Integer JADE = 5;

        /**
         * 碧玉
         */
        public Integer JASPER = 4;

        /**
         * 芙蓉玉
         */
        public Integer HIBISCUS_JADE = 3;

        /**
         * 紫玉
         */
        public Integer PURPLE_JADE = 2;

        /**
         * 合成玉失败后默认给的物品
         */
        public String OTHER_JADE = "minecraft:iron_ingot";


        /**
         * 合成粉末后锤子所消耗的耐久度
         */
        public Integer CRAFT_POWDER_HAMMER_CONSUME = 50;

        /**
         * 玉石工作台合成玉时锤子所消耗的耐久度
         */
        public Integer JADEWORKBENCH_CONSUME = 50;

        /**
         * 炎龙大刀在玉石工作台中出现的几率
         */
        public Integer YAN_LONG_BIG_KNIFE = 5;

        /**
         * 合成特殊的青铜大刀失败后给的物品
         */
        public String YAN_LONG_OTHER = "minecraft:iron_ingot";

        /**
         * 开启雷笋生长
         */
        public Boolean ENABLE_LIGHTNING_BAMBOO_GROWTH = true;

        /**
         * 四书成就激活后获得的生命值加成
         */
        public Integer FOUR_BOOKS_HEALTH = 6;


}
