package metalmith.items;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.sweenus.simplyswords.item.SimplySwordsSwordItem; // 确保导入 SimplySwordsSwordItem
import metalmith.Metalmith;

import java.util.List;

@Mod.EventBusSubscriber(modid = Metalmith.MOD_ID, value = Dist.CLIENT)
public class Tooltip {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        // 检查是否为工具或盔甲
        if (stack.getItem() instanceof TieredItem) {
            Tier tier = ((TieredItem) stack.getItem()).getTier();
            if (tier instanceof ToolsRegistration.TierWithTooltip) {
                addTooltip(tooltip, (ToolsRegistration.TierWithTooltip) tier);
            }
        } else if (stack.getItem() instanceof ArmorItem) {
            ArmorMaterial material = ((ArmorItem) stack.getItem()).getMaterial();
            if (material instanceof ArmorRegistration.ArmorMaterialWithTooltip) {
                addTooltip(tooltip, (ArmorRegistration.ArmorMaterialWithTooltip) material);
            }
        }
        // 添加对Simply Swords武器的检查
        else if (stack.getItem() instanceof SimplySwordsSwordItem) {
            // 根据武器材料添加相应的工具提示
            ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(stack.getItem());
            if (registryName != null) {
                String itemName = registryName.getPath();

                if (itemName.contains("copper")) {
                    addLines(tooltip, "tooltip.metalmith.copper", 1);
                } else if (itemName.contains("silicon_bronze")) {
                    addLines(tooltip, "tooltip.metalmith.silicon_bronze", 1);
                } else if (itemName.contains("vein_gold")) {
                    addLines(tooltip, "tooltip.metalmith.vein_gold", 2);
                } else if (itemName.contains("flam_iron")) {
                    addLines(tooltip, "tooltip.metalmith.flam_iron", 1);
                }
            }
        }
    }

    // 统一添加提示
    private static void addTooltip(List<Component> tooltip, ToolsRegistration.TierWithTooltip tier) {
        if (tier.requiresShift()) {
            if (Screen.hasShiftDown()) addLines(tooltip, tier.getTooltipKey(), tier.getTooltipLines());
            else tooltip.add(Component.translatable("tooltip.metalmith.hold_shift"));
        } else {
            addLines(tooltip, tier.getTooltipKey(), tier.getTooltipLines());
        }
    }

    private static void addTooltip(List<Component> tooltip, ArmorRegistration.ArmorMaterialWithTooltip material) {
        if (material.requiresShift()) {
            if (Screen.hasShiftDown()) addLines(tooltip, material.getTooltipKey(), material.getTooltipLines());
            else tooltip.add(Component.translatable("tooltip.metalmith.hold_shift"));
        } else {
            addLines(tooltip, material.getTooltipKey(), material.getTooltipLines());
        }
    }

    private static void addLines(List<Component> tooltip, String key, int lines) {
        for (int i = 1; i <= lines; i++) {
            tooltip.add(Component.translatable(key + ".line" + i));
        }
    }
}