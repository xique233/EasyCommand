package life.magpies.registry.util

import life.magpies.registry.ModItems
import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.fabricmc.fabric.api.loot.v2.LootTableEvents.Modify
import net.fabricmc.fabric.api.loot.v2.LootTableSource
import net.minecraft.loot.LootManager
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier

object ModLootTableModifiers {
    // 宝箱生成地
    private val JUNGLE_TEMPLE_ID = Identifier("minecraft", "chests/jungle_temple")
    private val DESERT_TEMPLE_IDDESERT_TEMPLE_ID = Identifier("minecraft", "chests/desert_pyramid")
    private val DUNGEON_ID = Identifier("minecraft", "chests/simple_dungeon")
    private val ABANDONED_MINESHAFT_ID = Identifier("minecraft", "chests/abandoned_mineshaft")
    private val END_CITY_ID = Identifier("minecraft", "chests/end_city")
    fun modifierLootTables() {
        LootTableEvents.MODIFY.register((Modify { resourceManager: ResourceManager?, lootManager: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, source: LootTableSource? ->
            if (JUNGLE_TEMPLE_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_COLOR))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (JUNGLE_TEMPLE_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_LOVE))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (JUNGLE_TEMPLE_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_ROMEO))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
        }))
        LootTableEvents.MODIFY.register((Modify { resourceManager: ResourceManager?, lootManager: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, source: LootTableSource? ->
            if (DESERT_TEMPLE_IDDESERT_TEMPLE_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_HAPPINESS))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (DESERT_TEMPLE_IDDESERT_TEMPLE_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_PUBERTY))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (DESERT_TEMPLE_IDDESERT_TEMPLE_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_PROUD_IDOL))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
        }))
        LootTableEvents.MODIFY.register((Modify { resourceManager: ResourceManager?, lootManager: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, source: LootTableSource? ->
            if (DUNGEON_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_GOOD_FRIDAY_MORNING))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (DUNGEON_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_ALL_I_CAN_GIVE_YOU))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (DUNGEON_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_CONGRATULATIONS))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (DUNGEON_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_THE_SCANDAL_ON_THURSDAY))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
        }))
        LootTableEvents.MODIFY.register((Modify { resourceManager: ResourceManager?, lootManager: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, source: LootTableSource? ->
            if (ABANDONED_MINESHAFT_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_TOKYO_SPRING_MEETING))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (ABANDONED_MINESHAFT_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_TOKYO_SUMMER_MEETING))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (ABANDONED_MINESHAFT_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_THE_OATH_OF_THE_HEART))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
        }))
        LootTableEvents.MODIFY.register((Modify { resourceManager: ResourceManager?, lootManager: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, source: LootTableSource? ->
            if (END_CITY_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_BAMBU_DISCO))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (END_CITY_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_TOKYO_WINTER_MEETING))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
            if (END_CITY_ID == id) {
                val poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(ModItems.MUSIC_DISC_TUESDAY_IS_KISS_DAY))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)))
                tableBuilder.pool((poolBuilder.build()))
            }
        }))
    }
}