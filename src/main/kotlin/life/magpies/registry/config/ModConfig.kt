package life.magpies.registry.config

import dev.isxander.yacl3.api.ConfigCategory
import dev.isxander.yacl3.api.Option
import dev.isxander.yacl3.api.OptionDescription
import dev.isxander.yacl3.api.YetAnotherConfigLib
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder
import net.minecraft.client.gui.screen.Screen
import net.minecraft.text.Text

object ModConfig {
    var booleanToggle: Boolean = true

    var kit: Int = 0
    var kit_Radius: Int = 30
    var sun: Int = 3
    var rain: Int = 3
    var hear: Int = 0
    var list: Int = 0
    var day: Int = 3
    var night: Int = 3
    private fun save() {}

    fun createGui(parent: Screen): Screen? {
        return YetAnotherConfigLib.createBuilder()
            .title(Text.literal("Text name"))
            .category(
                ConfigCategory.createBuilder()
                    .name(Text.literal("EasyCommand"))
                    .tooltip(Text.literal("配置简单指令"))
                    .option(
                        Option.createBuilder<Int>()
                            .name(Text.literal("kit权限配置"))
                            .description(OptionDescription.of(Text.literal("0最低权限 5最高权限")))
                            .binding(0, { this.kit }, fun(newValue) { kit = newValue })
                            .controller { opt -> IntegerSliderControllerBuilder.create(opt).step(1).range(0, 5) }
                            .build()
                    )
                    .option(
                        Option.createBuilder<Int>()
                            .name(Text.literal("kit范围配置"))
                            .description(OptionDescription.of(Text.literal("设置清除掉落物的半径范围")))
                            .binding(30, { this.kit_Radius }, fun(newValue) { kit_Radius = newValue })
                            .controller { opt -> IntegerSliderControllerBuilder.create(opt).step(1).range(0, 300) }
                            .build()
                    )
                    .option(
                        Option.createBuilder<Int>()
                            .name(Text.literal("sun权限配置"))
                            .description(OptionDescription.of(Text.literal("设置使用sun的权限等级")))
                            .binding(3, { this.sun }, fun(newValue) { sun = newValue })
                            .controller { opt -> IntegerSliderControllerBuilder.create(opt).step(1).range(0, 5) }
                            .build()
                    )
                    .option(
                        Option.createBuilder<Int>()
                            .name(Text.literal("rain权限配置"))
                            .description(OptionDescription.of(Text.literal("设置使用rain的权限等级")))
                            .binding(3, { this.rain }, fun(newValue) { rain = newValue })
                            .controller { opt -> IntegerSliderControllerBuilder.create(opt).step(1).range(0, 5) }
                            .build()
                    )
                    .option(
                        Option.createBuilder<Int>()
                            .name(Text.literal("hear权限配置"))
                            .description(OptionDescription.of(Text.literal("设置使用this的权限等级")))
                            .binding(0, { this.hear }, fun(newValue) { hear = newValue })
                            .controller { opt -> IntegerSliderControllerBuilder.create(opt).step(1).range(0, 5) }
                            .build()
                    )
                    .option(
                        Option.createBuilder<Int>()
                            .name(Text.literal("list权限配置"))
                            .description(OptionDescription.of(Text.literal("设置使用list的权限等级")))
                            .binding(0, { this.list }, fun(newValue) { list = newValue })
                            .controller { opt -> IntegerSliderControllerBuilder.create(opt).step(1).range(0, 5) }
                            .build()
                    )
                    .option(
                        Option.createBuilder<Int>()
                            .name(Text.literal("day权限配置"))
                            .description(OptionDescription.of(Text.literal("设置使用day的权限等级")))
                            .binding(3, { this.day }, fun(newValue) { day = newValue })
                            .controller { opt -> IntegerSliderControllerBuilder.create(opt).step(1).range(0, 5) }
                            .build()
                    )
                    .option(
                        Option.createBuilder<Int>()
                            .name(Text.literal("night权限配置"))
                            .description(OptionDescription.of(Text.literal("设置使用night的权限等级")))
                            .binding(3, { this.night }, fun(newValue) { night = newValue })
                            .controller { opt -> IntegerSliderControllerBuilder.create(opt).step(1).range(0, 5) }
                            .build()
                    )
                    .build()
            )
            .save(ModConfig::save).build().generateScreen(parent)
    }
}