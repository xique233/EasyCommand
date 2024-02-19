package life.magpies.registry.config

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi


object ModMenuConfigScreen: ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { parent -> ModConfig.createGui(parent)  }
    }
}