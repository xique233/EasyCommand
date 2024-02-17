package life.magpies

import life.magpies.registry.ModRegister
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object EasyCommand : ModInitializer {
    const val MOD_ID = "easycommand"
    val logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModRegister.register()
        logger.info("Hello Fabric world!")
    }
}