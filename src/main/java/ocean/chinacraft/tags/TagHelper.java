package ocean.chinacraft.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class TagHelper {

    public static class Items{
        public static boolean check(Item item, TagKey<Item> tagKey){
            return Registry.ITEM.getOrCreateEntry(Registry.ITEM.getKey(item).get()).isIn(tagKey);
        }
        public static boolean checkByIStack(ItemStack itemStack, TagKey<Item> tagKey){
            return Registry.ITEM.getOrCreateEntry(Registry.ITEM.getKey(itemStack.getItem()).get()).isIn(tagKey);
        }
    }

    public static class Blocks{
        public static boolean check(Block block, TagKey<Block> tagKey){
            return Registry.BLOCK.getOrCreateEntry(Registry.BLOCK.getKey(block).get()).isIn(tagKey);
        }
    }
}
