package ocean.chinacraft;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ocean.chinacraft.blocks.JadeWorkbenchBlock;
import ocean.chinacraft.blocks.LanternFestivalLanterns;
import ocean.chinacraft.blocks.StoneLantern;
import ocean.chinacraft.blocks.StoneMortarBlock;
import ocean.chinacraft.blocks.world.sapling.ModSaplingBlock;
import ocean.chinacraft.blocks.world.tree.CherrySaplingGenerator;
import ocean.chinacraft.blocks.world.tree.MulberrySaplingGenerator;

public class BlockRegister {

    public static final Block TIN_ORE = registerNormalBlock("tin_ore",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);//锡矿石

    public static final Block SILVER_ORE = registerNormalBlock("silver_ore",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);//银矿石



    public static final Block JADE_ORE = registerNormalBlock("jade_ore",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);//玉原石

    public static final Block MARBLE_BLOCK = registerNormalBlock("marble",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);//大理石

    public static final Block SMOOTH_MARBLE_BLOCK = registerNormalBlock("smooth_marble",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);
    public static final Block PILLAR_MARBLE_BLOCK = registerNormalBlock("pillar_marble",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);
    public static final Block CHISELED_MARBLE_BLOCK = registerNormalBlock("chiseled_marble",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);
    public static final Block SLAB_MARBLE_BLOCK = register("slab_marble",new SlabBlock(FabricBlockSettings.copy(MARBLE_BLOCK)));
    public static final Block STAIR_MARBLE_BLOCK = register("stair_marble",new StairsBlock(MARBLE_BLOCK.getDefaultState(),FabricBlockSettings.copy(MARBLE_BLOCK)));
    public static final Block MARBLE_WALL = register("marble_wall",new WallBlock(AbstractBlock.Settings.copy(MARBLE_BLOCK)));//大理石衍生方块

    public static final Block BRICK_BLACK_BLOCK = registerNormalBlock("brick_black",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);
    public static final Block STAIR_BRICK_BLACK_BLOCK = register("stair_brick_black",new StairsBlock(BRICK_BLACK_BLOCK.getDefaultState(),FabricBlockSettings.copy(BRICK_BLACK_BLOCK)));
    public static final Block SLAB_BRICK_BLACK_BLOCK = register("slab_brick_black",new SlabBlock(FabricBlockSettings.copy(BRICK_BLACK_BLOCK)));
    public static final Block MOSSY_BRICK_BLACK_BLOCK = registerNormalBlock("mossy_brick_black",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);
    public static final Block BLACKER_BRICK_BLACK_BLOCK = registerNormalBlock("blacker_brick_black",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);
    public static final Block BRICK_BLACK_WALL_BLOCK = register("brick_black_wall",new WallBlock(FabricBlockSettings.copy(BRICK_BLACK_BLOCK)));//青砖及衍生方块

    public static final Block BAMBOO_PLANK_BLOCK = register("bamboo_plank",new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block STAIR_BAMBOO_BLOCK = register("stair_bamboo",new StairsBlock(BAMBOO_PLANK_BLOCK.getDefaultState(),FabricBlockSettings.copy(BAMBOO_PLANK_BLOCK)));
    public static final Block SLAB_BAMBOO_BLOCK = register("slab_bamboo",new SlabBlock(FabricBlockSettings.copy(BAMBOO_PLANK_BLOCK)));
    public static final Block BAMBOO_FENCE_BLOCK = register("bamboo_fence",new FenceBlock(FabricBlockSettings.copy(BAMBOO_PLANK_BLOCK)));
    public static final Block BAMBOO_FENCE_GATE_BLOCK = register("bamboo_fence_gate",new FenceGateBlock(FabricBlockSettings.copy(BAMBOO_FENCE_BLOCK)));//竹衍生方块

    public static final Block PEELED_BAMBOO_BLOCK = registerNormalBlock("peeled_bamboo_plank",Material.BAMBOO,1.8f,Chinacraft.ITEM_GROUP);
    public static final Block STAIR_PEELED_BAMBOO_BLOCK = register("stair_peeled_bamboo",new StairsBlock(PEELED_BAMBOO_BLOCK.getDefaultState(),FabricBlockSettings.copy(PEELED_BAMBOO_BLOCK)));
    public static final Block SLAB_PEELED_BAMBOO_BLOCK = register("slab_peeled_bamboo",new SlabBlock(FabricBlockSettings.copy(PEELED_BAMBOO_BLOCK)));
    public static final Block PEELED_BAMBOO_FENCE_BLOCK = register("peeled_bamboo_fence",new FenceBlock(FabricBlockSettings.copy(PEELED_BAMBOO_BLOCK)));
    public static final Block PEELED_BAMBOO_FENCE_GATE_BLOCK = register("peeled_bamboo_fence_gate",new FenceGateBlock(FabricBlockSettings.copy(PEELED_BAMBOO_FENCE_BLOCK)));//杀青竹衍生方块

    public static final Block PEELED_BAMBOO_WINDOW = register("peeled_bamboo_window",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));
    public static final Block PEELED_BAMBOO_WINDOW_2 = register("peeled_bamboo_window2",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));
    public static final Block PEELED_BAMBOO_WINDOW_3 = register("peeled_bamboo_window3",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));//竹窗格

    public static final Block WOOD_WINDOW = register("wood_window",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));
    public static final Block WOOD_WINDOW_2 = register("wood_window2",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));
    public static final Block WOOD_WINDOW_3 = register("wood_window3",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));
    public static final Block WOOD_WINDOW_4 = register("wood_window4",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));
    public static final Block WOOD_WINDOW_DRAGON = register("wood_window_dragon",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));
    public static final Block WOOD_WINDOW_FU = register("wood_window_fu",new PaneBlock(FabricBlockSettings.copy(Blocks.IRON_BARS).strength(0.8f)));//木窗格


    public static final Block FIRE_BRICK_BLOCK = registerNormalBlock("fire_brick_block",Material.STONE,2.0f,Chinacraft.ITEM_GROUP);//耐火砖
    public static final Block BRONZE_BLOCK = registerNormalBlock("bronze_block",Material.METAL,2.2f,Chinacraft.ITEM_GROUP);
    public static final Block TIN_BLOCK = registerNormalBlock("tin_block",Material.METAL,2.2f,Chinacraft.ITEM_GROUP);
    public static final Block SILVER_BLOCK = registerNormalBlock("silver_block",Material.METAL,2.2f,Chinacraft.ITEM_GROUP);//矿物块
    public static final Block LANTERN_FESTIVAL_LANTERNS = register("lantern_festival_lanterns",new LanternFestivalLanterns(FabricBlockSettings.copy(Blocks.LANTERN).sounds(BlockSoundGroup.WOOL)));
    public static final Block STONE_LANTERN = register("stone_lantern",new StoneLantern(FabricBlockSettings.copy(Blocks.LANTERN).luminance(state -> 10)));//灯笼

    public static final Block MULBERRY_LOG = register("mulberry_log",new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block MULBERRY_PLANKS = register("mulberry_planks",new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block MULBERRY_LEAVES = register("mulberry_leaves",new Block(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));
    public static final Block MULBERRY_SAPLING = register("mulberry_sapling",new ModSaplingBlock(new MulberrySaplingGenerator(),FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final Block CHERRY_LOG = register("cherry_log",new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CHERRY_PLANKS = register("cherry_planks",new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CHERRY_LEAVES = register("cherry_leaves",new Block(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));
    public static final Block CHERRY_SAPLING = register("cherry_sapling",new ModSaplingBlock(new CherrySaplingGenerator(),FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final Block JADE_WORKBENCH = register("jade_workbench_block",new JadeWorkbenchBlock(FabricBlockSettings.of(Material.STONE).requiresTool().hardness(2.0f)));

    public static final Block STONE_MORTAR = register("stone_mortar_block",new StoneMortarBlock(FabricBlockSettings.of(Material.STONE).requiresTool().hardness(2.0f)));

    public static final Block RICES_EAR_SEEDS = register("rices_ear_seeds",new CropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));//米穗

    public static final Block AZALEA = register("azalea",new FlowerBlock(StatusEffects.MINING_FATIGUE,2, FabricBlockSettings.copy(Blocks.DANDELION)));//花
    public static final Block PEONY = register("peony",new FlowerBlock(StatusEffects.MINING_FATIGUE,2, FabricBlockSettings.copy(Blocks.DANDELION)));
    public static final Block CHRYSANTHEMUM = register("chrysanthemum",new FlowerBlock(StatusEffects.MINING_FATIGUE,2, FabricBlockSettings.copy(Blocks.DANDELION)));

    //public static final Block






    public static void registry(){
        Chinacraft.LOGGER.info("Registering blocks...");

    }
    private static Block register(String id,Block block){
        Block cache = Registry.register(Registry.BLOCK,new Identifier(Chinacraft.MODID,id),block);
        Registry.register(Registry.ITEM, new Identifier(Chinacraft.MODID,id), new BlockItem(block, new FabricItemSettings().group(Chinacraft.ITEM_GROUP)));
        return cache;
    }
    private static Block registerNormalBlock(String id, Material material, float hardness, ItemGroup itemGroup){
        Block block = new Block(FabricBlockSettings.of(material).hardness(hardness).requiresTool());
        Registry.register(Registry.BLOCK,new Identifier(Chinacraft.MODID,id),block);
        Registry.register(Registry.ITEM, new Identifier(Chinacraft.MODID,id), new BlockItem(block, new FabricItemSettings().group(itemGroup)));
        return block;
    }

    //TODO:石灯笼、木窗、竹窗、元宵灯笼
}
