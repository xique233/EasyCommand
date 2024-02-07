package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
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
    public static final Block CITRINE_BLOCK =
            registerBlock("citrine_block",
                    new Block(AbstractBlock.Settings.create()
                            .mapColor(MapColor.IRON_GRAY)
                            .requiresTool().strength(4.0f)
                            .sounds(BlockSoundGroup.METAL)));
    public static final Block CITRINE_ORE =
            registerBlock("citrine_ore",
                    new ExperienceDroppingBlock
                            (UniformIntProvider.create(2,6),AbstractBlock.Settings.create()
                                            .mapColor(MapColor.IRON_GRAY)
                                            .requiresTool().strength(4.0F,4.0F)));
    public static final Block DEEPSLATE_CITRINE_ORE =
            registerBlock("deepslate_citrine_ore",
                    new ExperienceDroppingBlock
                            (UniformIntProvider.create(2,6),AbstractBlock.Settings.create()
                                    .mapColor(MapColor.IRON_GRAY)
                                    .requiresTool().strength(4.0F,4.0F)));
    // 注册
    public static Block registerBlock(String name, Block block) {
        ModItems.registerItem(name, new BlockItem(block, new FabricItemSettings()));
        return Registry.register(Registries.BLOCK, new Identifier(SimplerTemplateMod.MOD_ID, name), block);
    }
    public static void registerModBlocks() {
        SimplerTemplateMod.LOGGER.info("Registering Mod Blocks for " + SimplerTemplateMod.MOD_ID);
    }
}
