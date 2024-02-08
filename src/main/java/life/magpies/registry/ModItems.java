package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItems {
    // 注册工具
    public static final Item CITRINE_SWORD = registerItem("citrine_sword",
            new SwordItem(ModToolMaterials.SLIVER,
                    2, 1.2f,
                    new FabricItemSettings()));
    public static final Item CITRINE_PICKAXE = registerItem("citrine_pickaxe",
            new PickaxeItem(ModToolMaterials.SLIVER,
                    1, -2f,
                    new FabricItemSettings()));
    // 注册物品
    public static final Item CITRINE = registerItem("citrine", new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine", new Item(new FabricItemSettings()));

    // 注册组
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, name), item);
    }


    // 物品组
    public static final ItemGroup ITEM_CITRINE =
            Registry.register(Registries.ITEM_GROUP,
                    new Identifier(SimplerTemplateMod.MOD_ID, "citrine"),
                    FabricItemGroup.builder()
                            .icon(() -> new ItemStack(ModItems.CITRINE))
                            .displayName(Text.translatable("itemgroup.simplertemplatemod.citrine"))
                            .entries((context, entries) -> {
                                entries.add(ModItems.CITRINE);
                                entries.add(ModItems.RAW_CITRINE);
                                entries.add(ModBlocks.CITRINE_BLOCK);
                                entries.add(ModBlocks.CITRINE_ORE);
                                entries.add(ModBlocks.DEEPSLATE_CITRINE_ORE);
                                entries.add(ModItems.CITRINE_SWORD);
                                entries.add(ModItems.CITRINE_PICKAXE);
                            })
                            .build());

    public static void registerModItems() {
        SimplerTemplateMod.LOGGER.debug("Registering mod items for" + SimplerTemplateMod.MOD_ID);
    }
}
