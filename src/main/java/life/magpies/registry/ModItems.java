package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import life.magpies.registry.items.MegaphoneItem;
import life.magpies.registry.items.ModFoodComponents;
import life.magpies.registry.items.custom.*;
import life.magpies.registry.sounds.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

import static net.minecraft.util.Rarity.RARE;


public class ModItems {
    // 注册物品
    public static final Item CITRINE = registerCitrineItems("citrine", new Item(new FabricItemSettings()));
    public static final Item CITRINE_SWORD = registerCitrineItems("citrine_sword", new SwordItem(CitrineToolMaterials.SLIVER, 2, -2.2f, new FabricItemSettings()));
    public static final Item CITRINE_PICKAXE = registerCitrineItems("citrine_pickaxe", new CitrinePickaxeItem(CitrineToolMaterials.SLIVER, 1, -2.8F, new Item.Settings()));
    public static final Item CITRINE_AXE = registerCitrineItems("citrine_axe", new CitrineAxeItem(CitrineToolMaterials.SLIVER, 5, -3.0F, new Item.Settings()));
    public static final Item CITRINE_SHOVEL = registerCitrineItems("citrine_shovel", new CitrineShovelItem(CitrineToolMaterials.SLIVER, 1, -3F, new Item.Settings()));
    public static final Item CITRINE_HOE = registerCitrineItems("citrine_hoe", new CitrineHoeItem(CitrineToolMaterials.SLIVER, -3, -0F, new Item.Settings()));
    public static final Item RAW_CITRINE = registerCitrineItems("raw_citrine", new Item(new FabricItemSettings()));
    public static final Item MEGAPHONE = registerCitrineItems("mega_phone", new MegaphoneItem(new FabricItemSettings().maxCount(1)));
    public static final Item PUDDING = registerCitrineItems("pudding", new Item(new Item.Settings().food(ModFoodComponents.FRUIT_PUDDING)));

    // 唱片
    public static final Item MUSIC_DISC_COLOR = registerMusicDiscsItem("music_disc_color", new MusicDiscItem(12, ModSounds.COLOR, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_LOVE = registerMusicDiscsItem("music_disc_love", new MusicDiscItem(8, ModSounds.LOVE, new FabricItemSettings().maxCount(1).rarity(RARE), 330));
    public static final Item MUSIC_DISC_ROMEO = registerMusicDiscsItem("music_disc_romeo", new MusicDiscItem(12, ModSounds.ROMEO, new FabricItemSettings().maxCount(1).rarity(RARE), 330));
    public static final Item MUSIC_DISC_HAPPINESS = registerMusicDiscsItem("music_disc_happiness", new MusicDiscItem(12, ModSounds.HAPPINESS, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_PUBERTY = registerMusicDiscsItem("music_disc_puberty", new MusicDiscItem(12, ModSounds.PUBERTY, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_PROUD_IDOL = registerMusicDiscsItem("music_disc_proud_idol", new MusicDiscItem(12, ModSounds.PROUD_IDOL, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_GOOD_FRIDAY_MORNING = registerMusicDiscsItem("music_disc_good_friday_morning", new MusicDiscItem(12, ModSounds.GOOD_FRIDAY_MORNING, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_ALL_I_CAN_GIVE_YOU = registerMusicDiscsItem("music_disc_all_i_can_give_you", new MusicDiscItem(2, ModSounds.ALL_I_CAN_GIVE_YOU, new FabricItemSettings().maxCount(1).rarity(RARE), 200));
    public static final Item MUSIC_DISC_CONGRATULATIONS = registerMusicDiscsItem("music_disc_congratulations", new MusicDiscItem(2, ModSounds.CONGRATULATIONS, new FabricItemSettings().maxCount(1).rarity(RARE), 230));
    public static final Item MUSIC_DISC_THE_SCANDAL_ON_THURSDAY = registerMusicDiscsItem("music_disc_the_scandal_on_thursday", new MusicDiscItem(5, ModSounds.THE_SCANDAL_ON_THURSDAY, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_THE_OATH_OF_THE_HEART = registerMusicDiscsItem("music_disc_the_oath_of_the_heart", new MusicDiscItem(6, ModSounds.THE_OATH_OF_THE_HEART, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_TOKYO_SUMMER_MEETING = registerMusicDiscsItem("music_disc_tokyo_summer_meeting", new MusicDiscItem(8, ModSounds.TOKYO_SUMMER_MEETING, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_TOKYO_SPRING_MEETING = registerMusicDiscsItem("music_disc_tokyo_spring_meeting", new MusicDiscItem(8, ModSounds.TOKYO_SPRING_MEETING, new FabricItemSettings().maxCount(1).rarity(RARE), 250));
    public static final Item MUSIC_DISC_TUESDAY_IS_KISS_DAY = registerMusicDiscsItem("music_disc_tuesday_is_kiss_day", new MusicDiscItem(6, ModSounds.TUESDAY_IS_KISS_DAY, new FabricItemSettings().maxCount(1).rarity(RARE), 270));
    public static final Item MUSIC_DISC_TOKYO_WINTER_MEETING = registerMusicDiscsItem("music_disc_tokyo_winter_meeting", new MusicDiscItem(8, ModSounds.TOKYO_WINTER_MEETING, new FabricItemSettings().maxCount(1).rarity(RARE), 260));
    public static final Item MUSIC_DISC_BAMBU_DISCO = registerMusicDiscsItem("music_disc_bambo_disco", new MusicDiscItem(8, ModSounds.BAMBU_DISCO, new FabricItemSettings().maxCount(1).rarity(RARE), 200));
    // 世界生成矿石
    public static final RegistryKey<PlacedFeature> CITRINE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_ore_custom"));


    // 注册组
    private static Item registerMusicDiscsItem(String name, Item item) {
        return registerItem(name, item, ModItemGrounds.MUSIC_DISCS);
    }

    private static Item registerCitrineItems(String name, Item item) {
        return registerItem(name, item, ModItemGrounds.CITRINE_ITEMS);
    }

    private static Item registerItem(String name, Item item, RegistryKey<ItemGroup> group) {
        Item registered = Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(registered));
        return registered;
    }

    public static void registerModItems() {
        SimplerTemplateMod.LOGGER.debug("Registering mod items for" + SimplerTemplateMod.MOD_ID);
    }
}
