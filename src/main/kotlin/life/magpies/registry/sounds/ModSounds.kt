package life.magpies.registry.sounds

import life.magpies.EasyCommand
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier


object ModSounds {
    val COLOR: SoundEvent = registerSoundEvent("color")
    val LOVE: SoundEvent = registerSoundEvent("the_world_is_falling_in_love")
    val ROMEO: SoundEvent = registerSoundEvent("romeo")
    val HAPPINESS: SoundEvent = registerSoundEvent("happiness")
    val PUBERTY: SoundEvent = registerSoundEvent("puberty")
    val PROUD_IDOL: SoundEvent = registerSoundEvent("proud_idol")
    val GOOD_FRIDAY_MORNING: SoundEvent = registerSoundEvent("good_friday_morning")
    val ALL_I_CAN_GIVE_YOU: SoundEvent = registerSoundEvent("all_i_can_give_you")
    val THE_SCANDAL_ON_THURSDAY: SoundEvent = registerSoundEvent("the_scandal_on_thursday")
    val CONGRATULATIONS: SoundEvent = registerSoundEvent("congratulations_and_prosperity")
    val THE_OATH_OF_THE_HEART: SoundEvent = registerSoundEvent("the_oath_of_the_heart")
    val TOKYO_SUMMER_MEETING: SoundEvent = registerSoundEvent("tokyo_summer_meeting")
    val TOKYO_SPRING_MEETING: SoundEvent = registerSoundEvent("tokyo_spring_meeting")
    val TOKYO_WINTER_MEETING: SoundEvent = registerSoundEvent("tokyo_winter_meeting")
    val TUESDAY_IS_KISS_DAY: SoundEvent = registerSoundEvent("tuesday_is_kiss_day")
    val BAMBU_DISCO: SoundEvent = registerSoundEvent("bambu_disco")

    // 注册声音事件
    private fun registerSoundEvent(name: String): SoundEvent {
        val id = Identifier(EasyCommand.MOD_ID, name)
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id))
    }

    // 声音日志
    fun registerSoundsLog() {
        EasyCommand.logger.debug("Registering ModSounds for " + EasyCommand.MOD_ID)
    }
}