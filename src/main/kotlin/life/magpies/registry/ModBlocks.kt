package life.magpies.registry

import life.magpies.EasyCommand
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.block.MapColor
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider

object ModBlocks {
    // 物品组
    private val CITRINE_BLOCK: Block = Block(
        FabricBlockSettings.create()
            .mapColor(MapColor.IRON_GRAY)
            .requiresTool()
            .strength(4.0f)
            .sounds(BlockSoundGroup.METAL)
    )

    private val CITRINE_ORE: Block = ExperienceDroppingBlock(
        UniformIntProvider.create(2, 6),
        FabricBlockSettings
            .create()
            .mapColor(MapColor.IRON_GRAY)
            .requiresTool()
            .strength(4.0f, 4.0f)
    )
    private val DEEPSLATE_CITRINE_ORE: Block = ExperienceDroppingBlock(
        UniformIntProvider.create(2, 6),
        FabricBlockSettings
            .create()
            .mapColor(MapColor.IRON_GRAY)
            .requiresTool()
            .strength(4.0f, 4.0f)
    )

    // 注册组
    fun registerBlock() {
        registerModBlocksLog()
        Registry.register(
            Registries.BLOCK,
            Identifier(EasyCommand.MOD_ID, "citrine_block"),
            CITRINE_BLOCK
        )
        Registry.register(
            Registries.ITEM, Identifier(EasyCommand.MOD_ID, "citrine_block"), BlockItem(
                CITRINE_BLOCK, FabricItemSettings()
            )
        )
        Registry.register(
            Registries.BLOCK,
            Identifier(EasyCommand.MOD_ID, "citrine_ore"),
            CITRINE_ORE
        )
        Registry.register(
            Registries.ITEM, Identifier(EasyCommand.MOD_ID, "citrine_ore"), BlockItem(
                CITRINE_ORE, FabricItemSettings()
            )
        )
        Registry.register(
            Registries.BLOCK,
            Identifier(EasyCommand.MOD_ID, "deepslate_citrine_ore"),
            DEEPSLATE_CITRINE_ORE
        )
        Registry.register(
            Registries.ITEM, Identifier(EasyCommand.MOD_ID, "deepslate_citrine_ore"), BlockItem(
                DEEPSLATE_CITRINE_ORE, FabricItemSettings()
            )
        )
    }

    fun registerModBlocksLog() {
        EasyCommand.logger.info("Registering Mod Blocks for " + EasyCommand.MOD_ID)
    }
}