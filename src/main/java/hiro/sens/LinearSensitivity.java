package hiro.sens;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("linearsensitivity")
public class LinearSensitivity {
    public LinearSensitivity() {
        MinecraftForge.EVENT_BUS.register(hiro.sens.client.CommandLoader.class);
    }
}