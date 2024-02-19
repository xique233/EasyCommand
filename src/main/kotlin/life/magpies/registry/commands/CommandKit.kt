package life.magpies.registry.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.IntegerArgumentType
import com.mojang.brigadier.context.CommandContext
import life.magpies.registry.config.ModConfig.kit
import life.magpies.registry.config.ModConfig.kit_Radius

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.entity.ItemEntity
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import net.minecraft.util.math.Box

object CommandKit {
    fun register() {
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, registryAccess: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(
                CommandManager.literal("kit")
                    .requires { source: ServerCommandSource ->
                        source.hasPermissionLevel(
                            kit
                        )
                    }
                    .executes { context: CommandContext<ServerCommandSource> ->
                        execute(
                            context,
                            5
                        )
                    }
                    .then(
                        CommandManager.argument("radius", IntegerArgumentType.integer())
                            .executes { ctx: CommandContext<ServerCommandSource> ->
                                execute(
                                    ctx,
                                    IntegerArgumentType.getInteger(ctx, "radius")
                                )
                            }
                    )
            )
        })
    }

    private fun execute(ctx: CommandContext<ServerCommandSource>, radius: Int): Int {
        if (radius > kit_Radius) {
            ctx.source.sendFeedback({
                Text.of((("超过最大限制范围 $kit_Radius")))
            }, false)
            return 0
        }
        // 获取玩家的对象
        val player = CommandUtils.getPlayer(ctx) ?: return 0
        val playPos = player.pos
        // 获取世界对象
        val world = player.entityWorld
        var killEntities = 0
        // 遍历世界中的实体
        // 检查实体是否不是玩家本身
        // 检查实体是否是生物（如生物实体而不是方块或物品）
        world.getEntitiesByClass(
            ItemEntity::class.java, Box(
                playPos.getX() - radius,
                playPos.getY() - radius,
                playPos.getZ() - radius,
                playPos.getX() + radius,
                playPos.getY() + radius,
                playPos.getZ() + radius
            )
        ) { entity: ItemEntity? -> true }.stream().filter { entity: ItemEntity -> entity != player }
            .forEach { entity: ItemEntity ->
                entity.kill()
                killEntities++
            }
        ctx.source.sendFeedback({
            Text.literal(
                "清理了附近的${killEntities}个掉落物"
            )
        }, false)
        return 1
    }
}