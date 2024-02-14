package life.magpies.registry;

import life.magpies.SimplerTemplateMod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGrounds {
    private static final Identifier MUSIC_DISCS_ID = new Identifier(SimplerTemplateMod.MOD_ID, "music_discs");
    private static final Identifier CITRINE_ID = new Identifier(SimplerTemplateMod.MOD_ID, "citrine_items");

    public static final RegistryKey<ItemGroup> MUSIC_DISCS = RegistryKey.of(RegistryKeys.ITEM_GROUP, MUSIC_DISCS_ID);
    public static final RegistryKey<ItemGroup> CITRINE_ITEMS = RegistryKey.of(RegistryKeys.ITEM_GROUP, CITRINE_ID);

    public static void buildItemGroups() {
        Registry.register((Registries.ITEM_GROUP), MUSIC_DISCS_ID,
                FabricItemGroup
                        .builder()
                        .displayName(Text.translatable("itemgroup." + SimplerTemplateMod.MOD_ID + ".music_discs"))
                        .icon(() -> new ItemStack(ModItems.MUSIC_DISC_COLOR))
                        .build());
        Registry.register((Registries.ITEM_GROUP), CITRINE_ID,
                FabricItemGroup
                        .builder()
                        .displayName(Text.translatable("itemgroup." + SimplerTemplateMod.MOD_ID + ".citrine_items"))
                        .icon(() -> new ItemStack(ModItems.CITRINE))
                        .build());
    }
}
