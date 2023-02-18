package ocean.chinacraft;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ocean.chinacraft.blocks.entity.JadeWorkbenchEntity;
import ocean.chinacraft.blocks.entity.StoneMortarEntity;


public class ModBlockEntities {
    public static BlockEntityType<JadeWorkbenchEntity> JADE_WORKBENCH;
    public static BlockEntityType<StoneMortarEntity> STONE_MORTAR;

    public static void register(){
        JADE_WORKBENCH = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Chinacraft.MODID,"jade_workbench"),
                FabricBlockEntityTypeBuilder.create(JadeWorkbenchEntity::new,BlockRegister.JADE_WORKBENCH).build(null));

        STONE_MORTAR = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Chinacraft.MODID,"stone_mortar"),
                FabricBlockEntityTypeBuilder.create(StoneMortarEntity::new,BlockRegister.STONE_MORTAR).build(null));
    }
}
