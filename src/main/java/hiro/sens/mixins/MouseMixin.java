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
    //ordinal: 0 or >=6 => Game Crash instantly
    //ordinal: 1 => Affect `i` variable
    //ordinal: 2 => Affect `j` variable
    //ordinal: 3 => Affect `e` variable
    //ordinal: 4 => Affect `g` variable
    //ordinal: 5 => Affect `h` variable
    //yep, there's no `d`. Seem like:
        //double e = Math.pow((Double)this.client.options.getMouseSensitivity().getValue() * (double)0.6F + (double)0.2F, 3);
    @ModifyVariable(method = "updateMouse", at = @At("STORE"), ordinal = 3)
    private double modifyBaseSensitivity(double originalE) {
        return MinecraftClient.getInstance().options.getMouseSensitivity().getValue();
    }
}

