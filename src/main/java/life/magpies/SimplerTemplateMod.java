package life.magpies;

import life.magpies.registry.ModItemGrounds;
import life.magpies.registry.ModRegister;
import life.magpies.registry.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimplerTemplateMod implements ModInitializer {
    public static final String MOD_ID = "simplertemplatemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        ModItemGrounds.buildItemGroups();
        ModRegister.registerMod();
        ModLootTableModifiers.modifierLootTables();
    }
}

