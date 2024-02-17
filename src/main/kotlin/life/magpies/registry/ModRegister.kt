package life.magpies.registry

import life.magpies.registry.ModItems.CITRINE_ORE_PLACED_KEY
import life.magpies.registry.commands.ModCommands
import life.magpies.registry.sounds.ModSounds
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.gen.GenerationStep

object ModRegister {
    fun register() {
        ModItemGroups.buildItemGroups()
        ModItems.registerItemLog()
        ModBlocks.registerBlock()
        ModSounds.registerSoundsLog()
        ModCommands.registerCommands()
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CITRINE_ORE_PLACED_KEY)
    }
}