package thewakko.oresdropmores.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OresDropMoresCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ORES_DROP_MORES_ACTIVE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ANCIENT_DEBRIS_CHECK;
    public static final ForgeConfigSpec.ConfigValue<Float>  ORES_DROP_MORES_CHANCE;

    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_DEFAULT_ORES_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_DEFAULT_ORES_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_FORTUNE_ONE_ORES_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_FORTUNE_ONE_ORES_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_FORTUNE_TWO_ORES_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_FORTUNE_TWO_ORES_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_FORTUNE_THREE_ORES_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_FORTUNE_THREE_ORES_DROP;

    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_DEFAULT_ANCDEB_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_DEFAULT_ANCDEB_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_FORTUNE_ONE_ANCDEB_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_FORTUNE_ONE_ANCDEB_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_FORTUNE_TWO_ANCDEB_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_FORTUNE_TWO_ANCDEB_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_FORTUNE_THREE_ANCDEB_DROP;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_FORTUNE_THREE_ANCDEB_DROP;


    static {
        BUILDER.push("Configs for Ores Drop Mores 3");

        ORES_DROP_MORES_ACTIVE = BUILDER.comment("Set to false to disable Ores Drop Mores Mod").define("ores_drop_mores_active", true);
        ANCIENT_DEBRIS_CHECK = BUILDER.comment("Set to false to disable the ancient debris special rules").define("ancient_debris_check", true);
        ORES_DROP_MORES_CHANCE = (ForgeConfigSpec.ConfigValue) BUILDER.comment("Set to 1.0 for 0% chance for extra ores, 0.0 for 100% chance for extra ores, 0.5 for 50% chance for extra ores").define("ores_drop_mores_chance", 0.0);
        // default drops for ores
        MAX_DEFAULT_ORES_DROP = BUILDER.comment("Set the maximum number of drops for normal mining").define("max_default_ores_drop", 2);
        MIN_DEFAULT_ORES_DROP = BUILDER.comment("Set the minimum number of drops for normal mining").define("min_default_ores_drop", 0);
        // fortune 1 drops for ores
        MAX_FORTUNE_ONE_ORES_DROP = BUILDER.comment("Set the maximum number of drops for fortune 1 mining").define("max_fortune_one_ores_drop", 2);
        MIN_FORTUNE_ONE_ORES_DROP = BUILDER.comment("Set the minimum number of drops for fortune 1 mining").define("min_fortune_one_ores_drop", 1);
        // fortune 2 drops for ores
        MAX_FORTUNE_TWO_ORES_DROP = BUILDER.comment("Set the maximum number of drops for fortune 2 mining").define("max_fortune_two_ores_drop", 2);
        MIN_FORTUNE_TWO_ORES_DROP = BUILDER.comment("Set the minimum number of drops for fortune 2 mining").define("min_fortune_two_ores_drop", 2);
        // fortune 3 drops for ores
        MAX_FORTUNE_THREE_ORES_DROP = BUILDER.comment("Set the maximum number of drops for fortune 3 mining").define("max_fortune_three_ores_drop", 6);
        MIN_FORTUNE_THREE_ORES_DROP = BUILDER.comment("Set the minimum number of drops for fortune 3 mining").define("min_fortune_three_ores_drop", 2);

        // default drops for ancient debris
        MAX_DEFAULT_ANCDEB_DROP = BUILDER.comment("Set the maximum number of drops for normal mining").define("max_default_ancdeb_drop", 3);
        MIN_DEFAULT_ANCDEB_DROP = BUILDER.comment("Set the minimum number of drops for normal mining").define("min_default_ancdeb_drop", 1);
        // fortune 1 drops for ancient debris
        MAX_FORTUNE_ONE_ANCDEB_DROP = BUILDER.comment("Set the maximum number of drops for fortune 1 mining").define("max_fortune_one_ancdeb_drop", 3);
        MIN_FORTUNE_ONE_ANCDEB_DROP = BUILDER.comment("Set the minimum number of drops for fortune 1 mining").define("min_fortune_one_ancdeb_drop", 2);
        // fortune 2 drops for ancient debris
        MAX_FORTUNE_TWO_ANCDEB_DROP = BUILDER.comment("Set the maximum number of drops for fortune 2 mining").define("max_fortune_two_ancdeb_drop", 3);
        MIN_FORTUNE_TWO_ANCDEB_DROP = BUILDER.comment("Set the minimum number of drops for fortune 2 mining").define("min_fortune_two_ancdeb_drop", 3);
        // fortune 3 drops for ancient debris
        MAX_FORTUNE_THREE_ANCDEB_DROP = BUILDER.comment("Set the maximum number of drops for fortune 3 mining").define("max_fortune_three_ancdeb_drop", 6);
        MIN_FORTUNE_THREE_ANCDEB_DROP = BUILDER.comment("Set the minimum number of drops for fortune 3 mining").define("min_fortune_three_ancdeb_drop", 3);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
