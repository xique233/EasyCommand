package life.magpies

import life.magpies.registry.ModRegister
import life.magpies.registry.util.ModLootTableModifiers
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object EasyCommand : ModInitializer {
    const val MOD_ID = "easycommand"
    val logger: Logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModRegister.register()
        // 注册唱片随机生成
        ModLootTableModifiers.modifierLootTables()
        logger.info("Hello Fabric world!")
    }
}