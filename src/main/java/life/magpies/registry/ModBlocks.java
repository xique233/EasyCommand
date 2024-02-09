package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
//
//    public static final Block CITRINE_BLOCK = new Block(AbstractBlock.Settings.create()
//            .mapColor(MapColor.IRON_GRAY)
//            .requiresTool().strength(4.0f)
//            .sounds(BlockSoundGroup.METAL));
//    public static final Block CITRINE_ORE = new ExperienceDroppingBlock
//            (UniformIntProvider.create(2, 6),
//                    AbstractBlock.Settings.create()
//                            .mapColor(MapColor.IRON_GRAY)
//                            .requiresTool().strength(4.0F, 4.0F));
    public static final BlockItem DEEPSLATE_CITRINE_ORE= new BlockItem(new ExperienceDroppingBlock(UniformIntProvider.create(2, 6),
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.IRON_GRAY)
                            .requiresTool().strength(4.0F, 4.0F)), new FabricItemSettings());

    public static void registerBlockItems() {
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "deepslate_citrine_ore"), DEEPSLATE_CITRINE_ORE);
    }

    public static void registerModBlocks() {
        SimplerTemplateMod.LOGGER.info("Registering Mod Blocks for " + SimplerTemplateMod.MOD_ID);
    }
}
