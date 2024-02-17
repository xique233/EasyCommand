package life.magpies.registry.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import life.magpies.EasyCommand
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text

object CommandWeather {
    fun register() {
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, registryAccess: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(CommandManager.literal("sunny")
                .requires { source: ServerCommandSource ->
                    source.hasPermissionLevel(
                        3
                    )
                }
                .executes { ctx: CommandContext<ServerCommandSource> ->
                    execute(
                        ctx,
                        true
                    )
                }
            ) // 设置时间为晴天
            dispatcher.register(CommandManager.literal("rain")
                .requires { source: ServerCommandSource ->
                    source.hasPermissionLevel(
                        3
                    )
                }
                .executes { ctx: CommandContext<ServerCommandSource> ->
                    execute(
                        ctx,
                        false
                    )
                }
            ) // 设置时间为雨天
        })
    }

    private fun execute(ctx: CommandContext<ServerCommandSource>, isDay: Boolean): Int {
        val source = ctx.source
        val player = CommandUtils.getPlayer(ctx)
        if (player == null) {
            source.sendError(Text.translatable(("command." + EasyCommand.MOD_ID) + ".warning"))
            return 0
        }
        val world = player.serverWorld
        // 获取当前维度
        val overWorld = ServerWorld.OVERWORLD.value
        if (world.registryKey.value == overWorld) {
            if (isDay) {
                world.setWeather(0, 0, false, false)
            } else {
                world.setWeather(0, 12000, true, true)
            }
            source.sendFeedback({
                Text.translatable(
                    ("command." + EasyCommand.MOD_ID) + (if (isDay) ".sunny" else ".rain")
                )
            }, false)
            return 1
        } else source.sendFeedback({
            Text.translatable(
                ("command." + EasyCommand.MOD_ID) + ".dimension_warning_weather"
            )
        }, false)
        return 0
    }
}