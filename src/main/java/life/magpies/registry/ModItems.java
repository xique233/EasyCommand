package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import life.magpies.registry.items.MegaphoneItem;
import life.magpies.registry.items.ModFoodComponents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItems {

    // 注册物品
    public static final Item CITRINE_SWORD = new SwordItem(ModToolMaterials.SLIVER, 2, 1.2f, new FabricItemSettings());
    public static final Item CITRINE_PICKAXE = new PickaxeItem(ModToolMaterials.SLIVER, 1, -2f, new FabricItemSettings());
    public static final Item CITRINE = new Item(new FabricItemSettings());
    public static final Item RAW_CITRINE = new Item(new FabricItemSettings());
    public static final Item MEGAPHONE = new MegaphoneItem(new FabricItemSettings().maxCount(1));
    public static final Item Pudding = new Item(new Item.Settings().food(ModFoodComponents.FRUIT_PUDDING));
    // 注册组
    public static void registerItem() {
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine"), CITRINE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "raw_citrine"), RAW_CITRINE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "mega_phone"), MEGAPHONE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_sword"), CITRINE_SWORD);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_pickaxe"), CITRINE_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, "pudding"), Pudding);
        Registry.register(Registries.ITEM_GROUP, new Identifier(SimplerTemplateMod.MOD_ID, "citrine_group"), ITEM_GROUP);
    }

    // 物品组
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CITRINE))
            .displayName(Text.translatable("itemgroup." + SimplerTemplateMod.MOD_ID + ".citrine"))
            .entries((context, entries) -> {
                entries.add(CITRINE);
                entries.add(RAW_CITRINE);
//                entries.add(CITRINE_BLOCK);
//                entries.add(CITRINE_ORE);
//                entries.add(DEEPSLATE_CITRINE_ORE);
                entries.add(CITRINE_SWORD);
                entries.add(CITRINE_PICKAXE);
                entries.add(MEGAPHONE);
                entries.add(Pudding);
            })
            .build();

    public static void registerModItems() {
        SimplerTemplateMod.LOGGER.debug("Registering mod items for" + SimplerTemplateMod.MOD_ID);
    }
}
