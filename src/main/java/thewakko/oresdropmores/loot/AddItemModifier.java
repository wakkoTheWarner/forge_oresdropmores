package thewakko.oresdropmores.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import thewakko.oresdropmores.config.OresDropMoresCommonConfigs;

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
            .fieldOf("item").forGetter(m -> m.item)).apply(inst, AddItemModifier::new)));
    private final Item item;

    protected AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // establishing variables
        int silkTouchLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SILK_TOUCH, context.getParam(LootContextParams.TOOL));
        int fortuneLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.BLOCK_FORTUNE, context.getParam(LootContextParams.TOOL));
        int numDrops = 0;

        // code
        if (context.hasParam(LootContextParams.TOOL) && context.getParamOrNull(LootContextParams.TOOL).isCorrectToolForDrops(context.getParam(LootContextParams.BLOCK_STATE))) {
            // if mined with a pickaxe
            if (silkTouchLevel <= 0) {
                // if no silk touch is active, then extra drops
                if (context.getParamOrNull(LootContextParams.BLOCK_STATE).getBlock() == Blocks.ANCIENT_DEBRIS) {
                    // if ancient debris
                    generatedLoot.clear();
                    if (context.getRandom().nextFloat() >= 0.0f) {
                        // chance of getting extra drops 0.0f 100% / 1.0f for 0% (DEBRIS)
                        if (fortuneLevel == 1) {
                            numDrops = (int)(Math.floor(Math.random() *(3 - 2 + 1) + 2));
                        } else if (fortuneLevel == 2) {
                            numDrops = (int)(Math.floor(Math.random() *(3 - 3 + 1) + 3));
                        } else if (fortuneLevel == 3) {
                            numDrops = (int)(Math.floor(Math.random() *(6 - 3 + 1) + 3));
                        } else {
                            numDrops = (int)(Math.floor(Math.random() *(3 - 1 + 1) + 1));
                        }
                    } else {
                        numDrops = 1;
                    }
                } else {
                    // if not ancient debris
                    if (context.getRandom().nextFloat() >= 0.0f) {
                        // chance of getting extra drops 0.0f 100% / 1.0f for 0% (ORES)
                        if (fortuneLevel == 1) {
                            numDrops = (int)(Math.floor(Math.random() *(2 - 1 + 1) + 1));
                        } else if (fortuneLevel == 2) {
                            numDrops = (int)(Math.floor(Math.random() *(2 - 2 + 1) + 2));
                        } else if (fortuneLevel == 3) {
                            numDrops = (int)(Math.floor(Math.random() *(6 - 2 + 1) + 2));
                        } else {
                            numDrops = (int)(Math.floor(Math.random() *(2 - 0 + 1) + 0));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < numDrops; i++) {
            generatedLoot.add(new ItemStack(item));
        }

        return generatedLoot;

    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}