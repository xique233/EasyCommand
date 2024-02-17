package life.magpies.registry

import life.magpies.registry.sounds.ModSounds

object ModRegister {
    fun register() {
        ModItemGroups.buildItemGroups()
        ModItems.registerItemLog()
        ModSounds.registerSounds()
    }
}