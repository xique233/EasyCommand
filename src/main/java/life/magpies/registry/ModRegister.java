package life.magpies.registry;

import life.magpies.registry.commands.ModCommands;
import life.magpies.registry.sounds.ModSounds;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

import static life.magpies.registry.ModItems.CITRINE_ORE_PLACED_KEY;

public class ModRegister {
    public static void registerMod() {
        ModBlocks.registerBlock();
        ModItems.registerModItems();
        ModSounds.registerSounds();
        ModCommands.registerCommands();

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CITRINE_ORE_PLACED_KEY);
    }
}
