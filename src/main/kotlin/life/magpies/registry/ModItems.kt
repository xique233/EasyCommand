package life.magpies.registry

import life.magpies.EasyCommand
import life.magpies.registry.items.MegaphoneItem
import life.magpies.registry.items.ModFoodComponents
import life.magpies.registry.items.custom.*
import life.magpies.registry.sounds.ModSounds
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.MusicDiscItem
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity.RARE


object ModItems {
    val CITRINE: Item = registerCitrineItems("citrine", Item(FabricItemSettings()))
    val CITRINE_SWORD: Item =
        registerCitrineItems("citrine_sword", SwordItem(CitrineToolMaterials.SLIVER, 2, -2.2f, FabricItemSettings()))
    val CITRINE_PICKAXE: Item = registerCitrineItems(
        "citrine_pickaxe",
        CitrinePickaxeItem(CitrineToolMaterials.SLIVER, 1, -2.8f, Item.Settings())
    )
    val CITRINE_AXE: Item =
        registerCitrineItems("citrine_axe", CitrineAxeItem(CitrineToolMaterials.SLIVER, 5, -3.0f, Item.Settings()))
    val CITRINE_SHOVEL: Item =
        registerCitrineItems("citrine_shovel", CitrineShovelItem(CitrineToolMaterials.SLIVER, 1, -3f, Item.Settings()))
    val CITRINE_HOE: Item =
        registerCitrineItems("citrine_hoe", CitrineHoeItem(CitrineToolMaterials.SLIVER, -3, -0f, Item.Settings()))
    val RAW_CITRINE: Item = registerCitrineItems("raw_citrine", Item(FabricItemSettings()))
    val MEGAPHONE: Item = registerCitrineItems("mega_phone", MegaphoneItem(FabricItemSettings().maxCount(1)))
    val PUDDING: Item = registerCitrineItems("pudding", Item(Item.Settings().food(ModFoodComponents.FRUIT_PUDDING)))

    // 唱片
    val MUSIC_DISC_COLOR: Item = registerMusicDiscsItem(
        "music_disc_color",
        MusicDiscItem(12, ModSounds.COLOR, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_LOVE: Item = registerMusicDiscsItem(
        "music_disc_love",
        MusicDiscItem(8, ModSounds.LOVE, FabricItemSettings().maxCount(1).rarity(RARE), 330)
    )
    val MUSIC_DISC_ROMEO: Item = registerMusicDiscsItem(
        "music_disc_romeo",
        MusicDiscItem(12, ModSounds.ROMEO, FabricItemSettings().maxCount(1).rarity(RARE), 330)
    )
    val MUSIC_DISC_HAPPINESS: Item = registerMusicDiscsItem(
        "music_disc_happiness",
        MusicDiscItem(12, ModSounds.HAPPINESS, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_PUBERTY: Item = registerMusicDiscsItem(
        "music_disc_puberty",
        MusicDiscItem(12, ModSounds.PUBERTY, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_PROUD_IDOL: Item = registerMusicDiscsItem(
        "music_disc_proud_idol",
        MusicDiscItem(12, ModSounds.PROUD_IDOL, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_GOOD_FRIDAY_MORNING: Item = registerMusicDiscsItem(
        "music_disc_good_friday_morning",
        MusicDiscItem(12, ModSounds.GOOD_FRIDAY_MORNING, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_ALL_I_CAN_GIVE_YOU: Item = registerMusicDiscsItem(
        "music_disc_all_i_can_give_you",
        MusicDiscItem(2, ModSounds.ALL_I_CAN_GIVE_YOU, FabricItemSettings().maxCount(1).rarity(RARE), 200)
    )
    val MUSIC_DISC_CONGRATULATIONS: Item = registerMusicDiscsItem(
        "music_disc_congratulations",
        MusicDiscItem(2, ModSounds.CONGRATULATIONS, FabricItemSettings().maxCount(1).rarity(RARE), 230)
    )
    val MUSIC_DISC_THE_SCANDAL_ON_THURSDAY: Item = registerMusicDiscsItem(
        "music_disc_the_scandal_on_thursday",
        MusicDiscItem(5, ModSounds.THE_SCANDAL_ON_THURSDAY, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_THE_OATH_OF_THE_HEART: Item = registerMusicDiscsItem(
        "music_disc_the_oath_of_the_heart",
        MusicDiscItem(6, ModSounds.THE_OATH_OF_THE_HEART, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_TOKYO_SUMMER_MEETING: Item = registerMusicDiscsItem(
        "music_disc_tokyo_summer_meeting",
        MusicDiscItem(8, ModSounds.TOKYO_SUMMER_MEETING, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_TOKYO_SPRING_MEETING: Item = registerMusicDiscsItem(
        "music_disc_tokyo_spring_meeting",
        MusicDiscItem(8, ModSounds.TOKYO_SPRING_MEETING, FabricItemSettings().maxCount(1).rarity(RARE), 250)
    )
    val MUSIC_DISC_TUESDAY_IS_KISS_DAY: Item = registerMusicDiscsItem(
        "music_disc_tuesday_is_kiss_day",
        MusicDiscItem(6, ModSounds.TUESDAY_IS_KISS_DAY, FabricItemSettings().maxCount(1).rarity(RARE), 270)
    )
    val MUSIC_DISC_TOKYO_WINTER_MEETING: Item = registerMusicDiscsItem(
        "music_disc_tokyo_winter_meeting",
        MusicDiscItem(8, ModSounds.TOKYO_WINTER_MEETING, FabricItemSettings().maxCount(1).rarity(RARE), 260)
    )
    val MUSIC_DISC_BAMBU_DISCO: Item = registerMusicDiscsItem(
        "music_disc_bambo_disco",
        MusicDiscItem(8, ModSounds.BAMBU_DISCO, FabricItemSettings().maxCount(1).rarity(RARE), 200)
    )


    private fun registerMusicDiscsItem(name: String, item: Item): Item {
        return registerItem(name, item, ModItemGroups.MUSIC_DISCS)
    }

    private fun registerCitrineItems(name: String, item: Item): Item {
        return registerItem(name, item, ModItemGroups.CITRINE_ITEMS)
    }

    private fun registerItem(name: String, item: Item, group: RegistryKey<ItemGroup>): Item {
        val registered: Item = Registry.register(Registries.ITEM, Identifier(EasyCommand.MOD_ID, name), item)
        ItemGroupEvents.modifyEntriesEvent(group).register { it.add(registered) }
        return registered
    }

    fun registerItemLog() {
        EasyCommand.logger.debug("EasyCommand Mod items for " + EasyCommand.MOD_ID)
    }
}