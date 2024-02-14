package life.magpies.registry.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandWeather {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("sunny")
                    .requires(source -> source.hasPermissionLevel(3))
                    .executes(ctx -> execute(ctx, true))); // 设置时间为晴天
            dispatcher.register(literal("rain")
                    .requires(source -> source.hasPermissionLevel(3))
                    .executes(ctx -> execute(ctx, false))); // 设置时间为雨天
        });
    }

    public static int execute(CommandContext<ServerCommandSource> ctx, boolean isDay) {
        ServerCommandSource source = ctx.getSource();
        ServerPlayerEntity player = source.getPlayer();
        if (player == null) {
            source.sendError(Text.literal("只有玩家可以执行此命令!"));
            return 0;
        }
        ServerWorld world = player.getServerWorld();
        // 获取当前维度
        Identifier OverWorld = ServerWorld.OVERWORLD.getValue();
        if (world.getRegistryKey().getValue().equals(OverWorld)) {
            if (isDay) {
                world.setWeather(0, 0, false, false);

            } else {
                world.setWeather(0,12000,true,true);
            }
            source.sendFeedback(() -> Text.literal("天气已设置为" + (isDay ? "晴天" : "雨天")), false);
            return 1;
        } else
            source.sendFeedback(() -> Text.literal("当前维度无法设置天气"), false);
        return 0;
    }
}
