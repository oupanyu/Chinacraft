package ocean.chinacraft.blocks.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ocean.chinacraft.ModBlockEntities;
import ocean.chinacraft.inventory.ImplementedInventory;
import ocean.chinacraft.recipe.MortarRecipe;
import ocean.chinacraft.screen.StoneMortarScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class StoneMortarEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2,ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 100;

    public StoneMortarEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STONE_MORTAR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return StoneMortarEntity.this.progress;
                    case 1:
                        return StoneMortarEntity.this.maxProgress;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        StoneMortarEntity.this.progress = value;
                        break;
                    case 1:
                        StoneMortarEntity.this.maxProgress = value;
                        break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new StoneMortarScreenHandler(syncId,inv,this,this.propertyDelegate);
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt,inventory);
        nbt.putInt("progress", progress);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        progress = nbt.getInt("progress");
        Inventories.readNbt(nbt,inventory);
        super.readNbt(nbt);

    }
    @Override
    public Text getDisplayName() {
        return new TranslatableText("screen.chinacraft.buhrimill_block");
    }

    public static void tick(World world, BlockPos pos, BlockState state, StoneMortarEntity entity){
        if (!world.isClient) {
            if (hasRecipe(entity)) {
                entity.progress++;
                if (entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }
            } else {
                entity.decreaseProgress();
            }
        }
    }

    private static boolean hasRecipe(StoneMortarEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<MortarRecipe> match = world.getRecipeManager()
                .getFirstMatch(MortarRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(StoneMortarEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<MortarRecipe> match = world.getRecipeManager()
                .getFirstMatch(MortarRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(0,1);

            entity.setStack(1, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(1).getCount() + 1));

            entity.resetProgress();
        }
    }
    private void decreaseProgress() {
        if (this.progress >= 0){
            this.progress--;
            return;
        }
        this.progress = 0;
    }
    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(1).getItem() == output.getItem() || inventory.getStack(1).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount();
    }
}
