package hiro.sens.mixins;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Environment(EnvType.CLIENT)
@Mixin(Mouse.class)
public class MouseMixin {

    @ModifyVariable(method = "updateMouse", at = @At("STORE"), ordinal = 3)
    private double modifyBaseSensitivity(double originalD) {
        return MinecraftClient.getInstance().options.getMouseSensitivity().getValue();
    }

    @ModifyVariable(method = "updateMouse", at = @At("STORE"), ordinal = 4)
    private double modifyScaleSensitivity(double originalD) {
        return MinecraftClient.getInstance().options.getMouseSensitivity().getValue();
    }
}

