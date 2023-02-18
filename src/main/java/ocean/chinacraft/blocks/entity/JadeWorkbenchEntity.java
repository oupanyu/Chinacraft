package ocean.chinacraft.blocks.entity;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.ItemRegister;
import ocean.chinacraft.ModBlockEntities;
import ocean.chinacraft.WorldGenRegister;
import ocean.chinacraft.blocks.JadeWorkbenchBlock;
import ocean.chinacraft.config.ModConfig;
import ocean.chinacraft.inventory.ImplementedInventory;
import ocean.chinacraft.items.jade.GenericJadeItem;
import ocean.chinacraft.items.jade.JadeItem;
import ocean.chinacraft.screen.JadeWorkbenchScreenHandler;
import ocean.chinacraft.tags.TagHelper;
import ocean.chinacraft.tags.TagsRegister;
import ocean.chinacraft.util.ModUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Optional;

public class JadeWorkbenchEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4,ItemStack.EMPTY);
    private static final HashMap<Integer,ItemStack> STACK_MAP = new HashMap<>();

    static {
        Integer jade = Chinacraft.config.JADE;
        Integer jasper = Chinacraft.config.JASPER;
        Integer hibiscusJade = Chinacraft.config.HIBISCUS_JADE;
        Integer purpleJade = Chinacraft.config.PURPLE_JADE;
        STACK_MAP.put(jade,new ItemStack(ItemRegister.JADE_ITEM));
        STACK_MAP.put(jasper,new ItemStack(ItemRegister.JASPER_ITEM));
        STACK_MAP.put(hibiscusJade,new ItemStack(ItemRegister.HIBISCUS_JADE_ITEM));
        STACK_MAP.put(purpleJade,new ItemStack(ItemRegister.PURPLE_JADE_ITEM));

    }

    private static final Item OTHER_JADE = Registry.ITEM.getOrEmpty(Identifier.tryParse(Chinacraft.config.OTHER_JADE)).orElseThrow(() ->
            new IllegalArgumentException("Unknown item:  " + Chinacraft.config.OTHER_JADE));

    private static final Item YAN_LONG_OTHER = Registry.ITEM.getOrEmpty(Identifier.tryParse(Chinacraft.config.YAN_LONG_OTHER)).orElseThrow(() ->
            new IllegalArgumentException("Unknown item:  " + Chinacraft.config.YAN_LONG_OTHER));
    public JadeWorkbenchEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.JADE_WORKBENCH, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("screen.chinacraft.Jade_workbench_block");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new JadeWorkbenchScreenHandler(syncId,inv,this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt,inventory);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt,inventory);
        super.readNbt(nbt);

    }
    public static void tick(World world, BlockPos pos, BlockState state, JadeWorkbenchEntity entity){
        if (!world.isClient) {
            if (hasRecipe(entity)) {
                craftItems(entity);
            }
        }
    }

    private static void craftItems(JadeWorkbenchEntity entity){

        Integer random = ModUtil.random();

         if (entity.getStack(2).getItem() == ItemRegister.BIG_BRONZE_SWORD
                && entity.getStack(3).isEmpty() && entity.getStack(1).getItem() instanceof GenericJadeItem) {
             Integer rand = ModUtil.random();
             //几率之外的物品
             ItemStack output = new ItemStack(YAN_LONG_OTHER);
             Integer bigSword = Chinacraft.config.YAN_LONG_BIG_KNIFE;
             if (random <= bigSword) {
                 output = new ItemStack(ItemRegister.YAN_LONG_BIG_KNIFE);
                 entity.getStack(2).decrement(1);
             }
             entity.getStack(1).decrement(1);
             if (entity.getStack(3).getItem() == YAN_LONG_OTHER){
                 entity.getStack(3).setCount(entity.getStack(3).getCount()+1);
             }else {
                 entity.setStack(3,output);
             }
         }else if (entity.getStack(2) == ItemStack.EMPTY){
             try {
                 ItemStack hammerStack = entity.getStack(0);
                 hammerStack.setDamage(hammerStack.getDamage() + Chinacraft.config.JADEWORKBENCH_CONSUME);
                 if (hammerStack.getDamage() >= hammerStack.getMaxDamage()) {
                     hammerStack.decrement(1);
                 }
                 //默认合成物品，没有在几率范围内，全部给铁锭
                 //但使用的是配置文件中的参数值
                 //ItemStack output = iRecipe.getResultItem();
                 ItemStack output = new ItemStack(OTHER_JADE);
                 ItemStack match = match(random);
                 if (!match.isEmpty()) {
                     output = match;
                 }
                 ItemStack stack = entity.getStack(0);
                 entity.getStack(1).decrement(1);
                 entity.setStack(2,output);
             }catch (Exception e){
                 Chinacraft.LOGGER.error("Can't find this item:" + Chinacraft.config.OTHER_JADE + ".Please check the config file.");
                 Chinacraft.LOGGER.error(e.getMessage(),e);
             }
         }

    }

    public static ItemStack match(Integer random) {
        Object[] objects = STACK_MAP.keySet().toArray();
        Integer[] intArray = ModUtil.getIntArray(objects);
        Integer approximateValue = getMatchValue(random, intArray);
        if (approximateValue != null) {
            return STACK_MAP.get(approximateValue);
        }
        return ItemStack.EMPTY;
    }

    private static Integer getMatchValue(Integer num, Integer[] source) {
        for (Integer nums : source) {
            if (num <= nums) {
                return nums;
            }
        }
        return null;
    }

    private static boolean isHammer(ItemStack stack){
        return TagHelper.Items.checkByIStack(stack, TagsRegister.Items.HAMMER_TAG);
    }
    private static boolean isJadeOre(ItemStack stack){
        return TagHelper.Items.checkByIStack(stack,TagsRegister.Items.JADE_ORES_TAG);
    }
    private static boolean hasRecipe(JadeWorkbenchEntity entity){
        boolean slotZeroIsHammerOrSword = isHammer(entity.getStack(0));
        boolean slotFirstIsJadeOre = isJadeOre(entity.getStack(1));
        boolean hasItemInSecondSlot = entity.getStack(2) != ItemStack.EMPTY;
        if (!slotFirstIsJadeOre && entity.getStack(1).getItem() instanceof GenericJadeItem){
            if (entity.getStack(2).getItem() == ItemRegister.BIG_BRONZE_SWORD){
                hasItemInSecondSlot = false;
                slotFirstIsJadeOre = true;
            }
        }


        return slotZeroIsHammerOrSword && slotFirstIsJadeOre && !hasItemInSecondSlot;
    }
}
