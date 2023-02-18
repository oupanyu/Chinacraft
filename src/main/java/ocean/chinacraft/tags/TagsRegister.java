package ocean.chinacraft.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ocean.chinacraft.Chinacraft;

public class TagsRegister {

    public static class Blocks{

        public static final TagKey<Block> C_SILVER_ORES = createCommonTag("silver_ores");



        private static TagKey<Block> createTag(String name){
            return TagKey.of(Registry.BLOCK_KEY,new Identifier(Chinacraft.MODID,name));
        }
        private static TagKey<Block> createCommonTag(String name){
            return TagKey.of(Registry.BLOCK_KEY,new Identifier("c",name));
        }
    }

    public static class Items{

        public static final TagKey<Item> C_COPPER_INGOTS = createCommonTag("copper_ingots");
        public static final TagKey<Item> C_TIN_INGOTS = createCommonTag("tin_ingots");
        public static final TagKey<Item> C_BRONZE_INGOTS = createCommonTag("bronze_ingots");

        public static final TagKey<Item> JADE_ORES_TAG = createTag("jade_ores");
        public static final TagKey<Item> HAMMER_TAG = createTag("hammers");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(Registry.ITEM_KEY,new Identifier(Chinacraft.MODID,name));
        }
        private static TagKey<Item> createCommonTag(String name){
            return TagKey.of(Registry.ITEM_KEY,new Identifier("c",name));
        }
    }

    public static void registry(){
        Chinacraft.LOGGER.info("Registering tags...");
    }
}
