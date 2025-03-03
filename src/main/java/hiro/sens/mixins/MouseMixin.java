package hiro.sens.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@OnlyIn(Dist.CLIENT)
@Mixin(MouseHandler.class)
public class MouseMixin {

    //DON'T CHANGE `ordinal`
    //for some reason:
    //ordinal: 3 => Affect `e` variable in 1.21.4
    //ordinal: 4 => Affect `e` variable in 1.20.1
    @ModifyVariable(method = "turnPlayer", at = @At("STORE"), ordinal = 4)
    private double modifyBaseSensitivity(double sens) {
        return Minecraft.getInstance().options.sensitivity().get();
    }
}