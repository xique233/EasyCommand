package life.magpies.registry.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import life.magpies.EasyCommand
import life.magpies.registry.config.ModConfig
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text

object CommandList {
    fun register() {
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, registryAccess: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(CommandManager.literal("listEasy")
                .requires { source: ServerCommandSource ->
                    source.hasPermissionLevel(
                        ModConfig.list
                    )
                }
                .executes { ctx -> execute(ctx) }
            )
        })
    }

    private fun execute(ctx: CommandContext<ServerCommandSource>): Int {
        val source = ctx.source
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_kit"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_day"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_night"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_sun"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_rain"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_this"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_tpa"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_tpc"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_tpaccept"))
        source.sendMessage(Text.translatable(("command." + EasyCommand.MOD_ID) + ".explain_tpcetp"))
        return 1
    }
}