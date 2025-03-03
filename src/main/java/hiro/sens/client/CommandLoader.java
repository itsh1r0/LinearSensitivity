package hiro.sens.client;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.text.DecimalFormat;

public class CommandLoader {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.######");
    private static final DecimalFormat PERCENTAGE_FORMAT = new DecimalFormat("#");

    @SubscribeEvent
    public static void registerCommands(RegisterClientCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("sens")
                .then(Commands.argument("value", FloatArgumentType.floatArg())
                        .executes(context -> {
                            double input = FloatArgumentType.getFloat(context, "value");
                            double sensitivity = (input > 1) ? 1 : Math.max(input, 0);
                            Minecraft.getInstance().options.sensitivity().set(sensitivity);
                            Minecraft.getInstance().options.save();

                            sendMessage(String.format("§cSet sensitivity to %s (%s%%)",
                                    DECIMAL_FORMAT.format(sensitivity),
                                    PERCENTAGE_FORMAT.format(sensitivity * 200)));

                            return Command.SINGLE_SUCCESS;
                        }))
                .executes(context -> {
                    double currentSens = Minecraft.getInstance().options.sensitivity().get();
                    sendMessage(String.format("§cCurrent sensitivity: %s (%s%%)",
                            DECIMAL_FORMAT.format(currentSens),
                            PERCENTAGE_FORMAT.format(currentSens * 200)));
                    sendMessage("§cUsage: /sens <int/float>");
                    return Command.SINGLE_SUCCESS;
                }));
    }

    private static void sendMessage(String message) {
        if (Minecraft.getInstance().player != null) {
            Minecraft.getInstance().gui.setOverlayMessage(Component.literal(message), false);
        }
    }
}