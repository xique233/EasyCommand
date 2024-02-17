package life.magpies.registry.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandHere {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("this")
                    .requires(source -> source.hasPermissionLevel(3))
                    .executes(CommandHere::execute));

        });
    }

    /**
     * 执行命令，如果满足特定条件，则为玩家应用发光效果。
     *
     * @param ctx 命令上下文
     * @return 整型数值
     */
    public static int execute(CommandContext<ServerCommandSource> ctx) {
        // 获取命令源
        ServerCommandSource source = ctx.getSource();
        // 检查命令源是否为玩家且命令是否由玩家执行
        if (source.getPlayer() != null && source.isExecutedByPlayer()) {
            // 获取发起玩家
            ServerPlayerEntity player = source.getPlayer();
            // 格式化玩家的位置信息
            Vec3d pos = player.getPos();
            String formattedPosition = FormattingPosition(pos);
            String world = onPlayerJoinWorld(player);

            // 为玩家添加发光效果
            source.getPlayer().addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600, 10));

            // 向玩家发送反馈消息
            source.getServer().getPlayerManager().broadcast(Text.literal(player.getName().getString() + " " + world + " " + formattedPosition).formatted(Formatting.YELLOW), false);
        }

        // 返回整型数值
        return 1;
    }


    public static String FormattingPosition(Vec3d position) {
        double x = position.getX();
        double y = position.getY();
        double z = position.getZ();
        return String.format("(X: %.2f, Y: %.2f, Z: %.2f)", x, y, z);
    }

    public static String onPlayerJoinWorld(PlayerEntity player) {
        // 检查玩家是否是服务器玩家实体，因为只有服务器玩家实体才有世界属性
        if (player instanceof ServerPlayerEntity serverPlayer) {
            // 将玩家实体转换为服务器玩家实体
            // 获取玩家所在的世界
            World world = serverPlayer.getWorld();
            // 检查世界是否是服务器世界，因为服务器世界有额外的方法和属性
            if (world instanceof ServerWorld serverWorld) {
                return serverWorld.getRegistryKey().getValue().toString();
            }
        }
        return "";
    }
}
