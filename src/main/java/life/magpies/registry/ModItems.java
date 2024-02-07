package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public static final Item CITRINE_SWORD = registerItem("citrine_sword",
            new SwordItem(GuiditeMaterial.INSTANCE,
                    2,1.2f,
                    new FabricItemSettings()));

    // 注册名为黄晶的物品
    public static final Item CITRINE = registerItem("citrine", new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine", new Item(new FabricItemSettings()));

    public static Item registerItem(String name, Item item) {
        // 添加到fabric中
        return Registry.register(Registries.ITEM, new Identifier(SimplerTemplateMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SimplerTemplateMod.LOGGER.debug("Registering mod items for" + SimplerTemplateMod.MOD_ID);
    }
}
