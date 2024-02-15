package life.magpies.registry.sounds;

import life.magpies.SimplerTemplateMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent COLOR = registerSoundEvent("color");
    public static final SoundEvent LOVE = registerSoundEvent("the_world_is_falling_in_love");
    public static final SoundEvent ROMEO = registerSoundEvent("romeo");
    public static final SoundEvent HAPPINESS = registerSoundEvent("happiness");
    public static final SoundEvent PUBERTY = registerSoundEvent("puberty");
    public static final SoundEvent PROUD_IDOL = registerSoundEvent("proud_idol");
    public static final SoundEvent GOOD_FRIDAY_MORNING = registerSoundEvent("good_friday_morning");
    public static final SoundEvent ALL_I_CAN_GIVE_YOU = registerSoundEvent("all_i_can_give_you");
    public static final SoundEvent THE_SCANDAL_ON_THURSDAY = registerSoundEvent("the_scandal_on_thursday");
    public static final SoundEvent CONGRATULATIONS = registerSoundEvent("congratulations_and_prosperity");
    public static final SoundEvent THE_OATH_OF_THE_HEART = registerSoundEvent("the_oath_of_the_heart");
    public static final SoundEvent TOKYO_SUMMER_MEETING = registerSoundEvent("tokyo_summer_meeting");
    public static final SoundEvent TOKYO_SPRING_MEETING = registerSoundEvent("tokyo_spring_meeting");
    public static final SoundEvent TOKYO_WINTER_MEETING = registerSoundEvent("tokyo_winter_meeting");
    public static final SoundEvent TUESDAY_IS_KISS_DAY = registerSoundEvent("tuesday_is_kiss_day");
    public static final SoundEvent BAMBU_DISCO = registerSoundEvent("bambu_disco");
    // 注册声音事件
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(SimplerTemplateMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    // 声音日志
    public static void registerSounds() {
        System.out.println("Registering ModSounds for " + SimplerTemplateMod.MOD_ID);
    }
}
