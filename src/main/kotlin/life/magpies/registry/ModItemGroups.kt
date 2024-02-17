package life.magpies.registry

import life.magpies.EasyCommand
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {

    private val MUSIC_DISCS_ID: Identifier = Identifier(EasyCommand.MOD_ID, "music_discs");
    private val CITRINE_ID: Identifier = Identifier(EasyCommand.MOD_ID, "citrine_items");

    val MUSIC_DISCS: RegistryKey<ItemGroup> = RegistryKey.of(RegistryKeys.ITEM_GROUP, MUSIC_DISCS_ID)
    val CITRINE_ITEMS: RegistryKey<ItemGroup> = RegistryKey.of(RegistryKeys.ITEM_GROUP, CITRINE_ID)
    fun buildItemGroups() {
        Registry.register(
            (Registries.ITEM_GROUP),
            CITRINE_ID,
            net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
                .builder()
                .displayName(Text.translatable("item_group." + EasyCommand.MOD_ID + ".music_discs"))
                .icon(fun(): ItemStack { return ItemStack(ModItems.CITRINE)})
                .build()
        )
        Registry.register(
            (Registries.ITEM_GROUP),
            MUSIC_DISCS_ID,
            net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
                .builder()
                .displayName(Text.translatable("item_group." + EasyCommand.MOD_ID + ".music_discs"))
                .icon(fun(): ItemStack { return ItemStack(ModItems.MUSIC_DISC_COLOR)})
                .build()
        )
    }
}