package thewakko.oresdropmores.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OresDropMoresClientConfigs {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Work in Progress");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
