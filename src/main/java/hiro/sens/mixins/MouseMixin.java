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

    //DON'T CHANGE `ordinal`
    //for some reason:
    //ordinal: 3 => Affect `e` variable in 1.21.4
    //ordinal: 4 => Affect `e` variable in 1.20.1
    @ModifyVariable(method = "updateMouse", at = @At("STORE"), ordinal = 4)
    private double modifyBaseSensitivity(double originalE) {
        return MinecraftClient.getInstance().options.getMouseSensitivity().getValue();
    }
}

