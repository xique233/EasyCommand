package life.magpies.registry.commands;

import com.mojang.brigadier.context.CommandContext;
import life.magpies.SimplerTemplateMod;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandDay {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("day")
                    .requires(source -> source.hasPermissionLevel(3))
                    .executes(ctx -> execute(ctx, true))); // 设置时间为白天
            dispatcher.register(literal("night")
                    .requires(source -> source.hasPermissionLevel(3))
                    .executes(ctx -> execute(ctx, false))); // 设置时间为黑夜
        });
    }

    public static int execute(CommandContext<ServerCommandSource> ctx, boolean isDay) {
        ServerCommandSource source = ctx.getSource();
        ServerPlayerEntity player = source.getPlayer();
        if (player == null) {
            source.sendError(Text.translatable("command." + SimplerTemplateMod.MOD_ID + ".warning"));
            return 0;
        }
        ServerWorld world = player.getServerWorld();
        // 获取当前维度
        Identifier OverWorld = ServerWorld.OVERWORLD.getValue();
        if (world.getRegistryKey().getValue().equals(OverWorld)) {
            if (isDay) {
                world.setTimeOfDay(2000);

            } else {
                world.setTimeOfDay(13000);
            }
            source.sendFeedback(() -> Text.translatable("command." + SimplerTemplateMod.MOD_ID + (isDay ? ".day" : ".night")), false);
            return 1;
        } else
            source.sendFeedback(() -> Text.translatable("command." + SimplerTemplateMod.MOD_ID + ".dimension_warning_time"), false);
        return 0;
    }
}
