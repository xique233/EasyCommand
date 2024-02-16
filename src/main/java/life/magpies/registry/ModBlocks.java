package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    // 物品组

    public static final Block CITRINE_BLOCK = new Block(FabricBlockSettings.create()
            .mapColor(MapColor.IRON_GRAY)
            .requiresTool()
            .strength(4.0f)
            .sounds(BlockSoundGroup.METAL));

    public static final Block CITRINE_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(2, 6),
            FabricBlockSettings
                    .create()
                    .mapColor(MapColor.IRON_GRAY)
                    .requiresTool()
                    .strength(4.0F, 4.0F));
    public static final Block DEEPSLATE_CITRINE_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(2, 6),
            FabricBlockSettings
                    .create()
                    .mapColor(MapColor.IRON_GRAY)
                    .requiresTool()
                    .strength(4.0F, 4.0F));

    // 注册组

    public static void registerBlock() {
        registerModBlocks();
        Registry.register(Registries.BLOCK, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_block"), CITRINE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_block"), new BlockItem(CITRINE_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_ore"), CITRINE_ORE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_ore"), new BlockItem(CITRINE_ORE, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(SimplerTemplateMod.MOD_ID, "deepslate_citrine_ore"), DEEPSLATE_CITRINE_ORE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "deepslate_citrine_ore"), new BlockItem(DEEPSLATE_CITRINE_ORE, new FabricItemSettings()));

    }

    public static void registerModBlocks() {
        SimplerTemplateMod.LOGGER.info("Registering Mod Blocks for " + SimplerTemplateMod.MOD_ID);
    }
}
