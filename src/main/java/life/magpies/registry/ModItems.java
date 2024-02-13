package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import life.magpies.registry.commands.ModCommands;
import life.magpies.registry.items.MegaphoneItem;
import life.magpies.registry.items.ModFoodComponents;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static life.magpies.registry.ModBlocks.*;
import static net.minecraft.util.Rarity.RARE;


public class ModItems {
    // 注册物品
    public static final Item CITRINE_SWORD = new SwordItem(CitrineToolMaterials.SLIVER, 2, -2.4f, new FabricItemSettings());
    public static final Item CITRINE_PICKAXE = new CitrinePickaxeItem(CitrineToolMaterials.SLIVER, 1, -2.8F, new Item.Settings());
    public static final Item CITRINE_AXE = new CitrineAxeItem(CitrineToolMaterials.SLIVER, 5, -3.0F, new Item.Settings());
    public static final Item CITRINE_SHOVEL = new CitrineShovelItem(CitrineToolMaterials.SLIVER, 1, -3F, new Item.Settings());
    public static final Item CITRINE_HOE = new CitrineHoeItem(CitrineToolMaterials.SLIVER, -3, -0F, new Item.Settings());
    public static final Item CITRINE = new Item(new FabricItemSettings());
    public static final Item RAW_CITRINE = new Item(new FabricItemSettings());
    public static final Item MEGAPHONE = new MegaphoneItem(new FabricItemSettings().maxCount(1));
    public static final Item PUDDING = new Item(new Item.Settings().food(ModFoodComponents.FRUIT_PUDDING));
    public static final Item MUSIC_DISC_COLOR = new MusicDiscItem(12, ModSounds.COLOR,new FabricItemSettings().maxCount(1).rarity(RARE),250 );
    public static final Item MUSIC_DISC_LOVE = new MusicDiscItem(8, ModSounds.LOVE,new FabricItemSettings().maxCount(1).rarity(RARE),330 );
    public static final Item MUSIC_DISC_CONGRATULATIONS = new MusicDiscItem(4, ModSounds.CONGRATULATIONS, new FabricItemSettings().maxCount(1).rarity(RARE),210);
    // 世界生成矿石
    public static final RegistryKey<PlacedFeature> CITRINE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_ore_custom"));

    // 注册组
    public static void registerItem() {
        new ModCommands();
        ModBlocks.registerBlock();
        ModItems.registerModItems();
        ModSounds.registerSounds();
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine"), CITRINE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "raw_citrine"), RAW_CITRINE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "mega_phone"), MEGAPHONE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_sword"), CITRINE_SWORD);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_pickaxe"), CITRINE_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_axe"), CITRINE_AXE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_shovel"), CITRINE_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_hoe"), CITRINE_HOE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "pudding"), PUDDING);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "music_disc_color"), MUSIC_DISC_COLOR);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "music_disc_love"), MUSIC_DISC_LOVE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "music_disc_congratulations"), MUSIC_DISC_CONGRATULATIONS);
        Registry.register(Registries.ITEM_GROUP, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_group"), ITEM_GROUP);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CITRINE_ORE_PLACED_KEY);
    }

    // 物品组
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CITRINE))
            .displayName(Text.translatable("itemgroup." + SimplerTemplateMod.MOD_ID + ".citrine"))
            .entries((context, entries) -> {
                entries.add(CITRINE);
                entries.add(RAW_CITRINE);
                entries.add(CITRINE_BLOCK);
                entries.add(CITRINE_ORE);
                entries.add(DEEPSLATE_CITRINE_ORE);
                entries.add(CITRINE_SWORD);
                entries.add(CITRINE_PICKAXE);
                entries.add(CITRINE_AXE);
                entries.add(CITRINE_SHOVEL);
                entries.add(CITRINE_HOE);
                entries.add(MUSIC_DISC_COLOR);
                entries.add(MUSIC_DISC_LOVE);
                entries.add(MUSIC_DISC_CONGRATULATIONS);
                entries.add(MEGAPHONE);
                entries.add(PUDDING);
            })
            .build();

    public static void registerModItems() {
        SimplerTemplateMod.LOGGER.debug("Registering mod items for" + SimplerTemplateMod.MOD_ID);
    }
}
