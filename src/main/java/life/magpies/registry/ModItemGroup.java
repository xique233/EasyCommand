package life.magpies.registry;

import life.magpies.SimplerTemplateMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroup {

    // 创建分类
    public static final ItemGroup CITRINE =
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
            })
            .build());

    // 初始化记录日志
    public static void registerModItemGroup() {

        SimplerTemplateMod.LOGGER.debug("Registering mod item group for " + SimplerTemplateMod.MOD_ID);
    }

}

