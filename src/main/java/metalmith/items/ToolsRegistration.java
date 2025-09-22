package metalmith.items;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import metalmith.Metalmith;

public class ToolsRegistration {
    public static final DeferredRegister<Item> TOOLS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Metalmith.MOD_ID);

    public interface TierWithTooltip extends Tier {
        String getTooltipKey();  // 语言文件键前缀
        int getTooltipLines();   // 提示行数
        boolean requiresShift(); // 是否需要Shift
    }

    // 工具类型基础攻击速度
    private static final float SWORD_SPEED = -2.4f;
    private static final float PICKAXE_SPEED = -2.8f;
    private static final float AXE_SPEED = -3.0f;
    private static final float SHOVEL_SPEED = -3.0f;
    private static final float HOE_SPEED = -2.0f;

    // 材料对攻击速度的影响
    private static final float COPPER_SPEED_MODIFIER = 0.0f;
    private static final float SILICON_BRONZE_SPEED_MODIFIER = -0.1f;
    private static final float VEIN_GOLD_SPEED_MODIFIER = 0.3f;
    private static final float FLAM_IRON_SPEED_MODIFIER = -0.1f;

    // 工具类型伤害基值
    private static final int SWORD_DAMAGE = 3;
    private static final int PICKAXE_DAMAGE = 1;
    private static final int AXE_DAMAGE = 6;
    private static final float SHOVEL_DAMAGE = 1.5f;
    private static final int HOE_DAMAGE = -1;

    // 铜工具
    public static final Tier COPPER_TIER = new Tier() {
        @Override public int getUses() { return 200; }
        @Override public float getSpeed() { return 5F; }
        @Override public float getAttackDamageBonus() { return 1.0F; }
        @Override public int getLevel() { return 2; }
        @Override public int getEnchantmentValue() { return 16; }
        @Override public @NotNull Ingredient getRepairIngredient() { return Ingredient.of(Items.COPPER_INGOT); }
    };

    // 硅青铜工具
    public static final Tier SILICON_BRONZE_TIER = new TierWithTooltip() {
        @Override public int getUses() { return 900; }
        @Override public float getSpeed() { return 7F; }
        @Override public float getAttackDamageBonus() { return 3.0F; }
        @Override public int getLevel() { return 3; }
        @Override public int getEnchantmentValue() { return 16; }
        @Override public @NotNull Ingredient getRepairIngredient() { return Ingredient.of(Items.COPPER_INGOT); }

        public String getTooltipKey() { return "tooltip.metalmith.silicon_bronze"; }
        public int getTooltipLines() { return 1; }
        public boolean requiresShift() { return false; }
    };

    // 石脉金工具
    public static final Tier VEIN_GOLD_TIER = new TierWithTooltip() {
        @Override public int getUses() { return 500; }
        @Override public float getSpeed() { return 12F; }
        @Override public float getAttackDamageBonus() { return 0.0F; }
        @Override public int getLevel() { return 2; }
        @Override public int getEnchantmentValue() { return 22; }
        @Override public @NotNull Ingredient getRepairIngredient() { return Ingredient.of(Items.GOLD_INGOT); }

        public String getTooltipKey() { return "tooltip.metalmith.vein_gold"; }
        public int getTooltipLines() { return 1; }
        public boolean requiresShift() { return false; }
    };

    // 炽玄铁工具
    public static final Tier FLAM_IRON_TIER = new TierWithTooltip() {
        @Override public int getUses() { return 1800; }
        @Override public float getSpeed() { return 8F; }
        @Override public float getAttackDamageBonus() { return 4.0F; }
        @Override public int getLevel() { return 3; }
        @Override public int getEnchantmentValue() { return 14; }
        @Override public @NotNull Ingredient getRepairIngredient() { return Ingredient.of(Items.IRON_INGOT); }

        public String getTooltipKey() { return "tooltip.metalmith.flam_iron"; }
        public int getTooltipLines() { return 1; }
        public boolean requiresShift() { return false; }
    };

    // 辅助方法：计算最终攻击速度
    private static float getAttackSpeed(String toolType, String material) {
        float baseSpeed = 0.0f;
        
        // 根据工具类型获取基础攻击速度
        switch (toolType) {
            case "sword": baseSpeed = SWORD_SPEED; break;
            case "pickaxe": baseSpeed = PICKAXE_SPEED; break;
            case "axe": baseSpeed = AXE_SPEED; break;
            case "shovel": baseSpeed = SHOVEL_SPEED; break;
            case "hoe": baseSpeed = HOE_SPEED; break;
        }
        
        // 根据材料获取速度修正
        float materialModifier = 0.0f;
        switch (material) {
            case "copper": materialModifier = COPPER_SPEED_MODIFIER; break;
            case "silicon_bronze": materialModifier = SILICON_BRONZE_SPEED_MODIFIER; break;
            case "vein_gold": materialModifier = VEIN_GOLD_SPEED_MODIFIER; break;
            case "flam_iron": materialModifier = FLAM_IRON_SPEED_MODIFIER; break;
        }
        
        return baseSpeed + materialModifier;
    }
    
    // 辅助方法：获取伤害基值
    private static Number getDamage(String toolType) {
        switch (toolType) {
            case "sword": return SWORD_DAMAGE;
            case "pickaxe": return PICKAXE_DAMAGE;
            case "axe": return AXE_DAMAGE;
            case "shovel": return SHOVEL_DAMAGE;
            case "hoe": return HOE_DAMAGE;
            default: return 0;
        }
    }

    // 工具注册 - 使用统一的辅助方法
    public static final RegistryObject<Item> COPPER_SWORD = TOOLS.register("copper_sword",
            () -> new SwordItem(COPPER_TIER, getDamage("sword").intValue(), getAttackSpeed("sword", "copper"), new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = TOOLS.register("copper_pickaxe",
            () -> new PickaxeItem(COPPER_TIER, getDamage("pickaxe").intValue(), getAttackSpeed("pickaxe", "copper"), new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = TOOLS.register("copper_axe",
            () -> new AxeItem(COPPER_TIER, getDamage("axe").floatValue(), getAttackSpeed("axe", "copper"), new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SHOVEL = TOOLS.register("copper_shovel",
            () -> new ShovelItem(COPPER_TIER, getDamage("shovel").floatValue(), getAttackSpeed("shovel", "copper"), new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = TOOLS.register("copper_hoe",
            () -> new HoeItem(COPPER_TIER, getDamage("hoe").intValue(), getAttackSpeed("hoe", "copper"), new Item.Properties()));
    // 硅青铜工具
    public static final RegistryObject<Item> SILICON_BRONZE_SWORD = TOOLS.register("silicon_bronze_sword",
            () -> new SwordItem(SILICON_BRONZE_TIER, getDamage("sword").intValue(), getAttackSpeed("sword", "silicon_bronze"), new Item.Properties()));
    public static final RegistryObject<Item> SILICON_BRONZE_PICKAXE = TOOLS.register("silicon_bronze_pickaxe",
            () -> new PickaxeItem(SILICON_BRONZE_TIER, getDamage("pickaxe").intValue(), getAttackSpeed("pickaxe", "silicon_bronze"), new Item.Properties()));
    public static final RegistryObject<Item> SILICON_BRONZE_AXE = TOOLS.register("silicon_bronze_axe",
            () -> new AxeItem(SILICON_BRONZE_TIER, getDamage("axe").floatValue(), getAttackSpeed("axe", "silicon_bronze"), new Item.Properties()));
    public static final RegistryObject<Item> SILICON_BRONZE_SHOVEL = TOOLS.register("silicon_bronze_shovel",
            () -> new ShovelItem(SILICON_BRONZE_TIER, getDamage("shovel").floatValue(), getAttackSpeed("shovel", "silicon_bronze"), new Item.Properties()));
    public static final RegistryObject<Item> SILICON_BRONZE_HOE = TOOLS.register("silicon_bronze_hoe",
            () -> new HoeItem(SILICON_BRONZE_TIER, getDamage("hoe").intValue(), getAttackSpeed("hoe", "silicon_bronze"), new Item.Properties()));
    // 石脉金工具
    public static final RegistryObject<Item> VEIN_GOLD_SWORD = TOOLS.register("vein_gold_sword",
            () -> new SwordItem(VEIN_GOLD_TIER, getDamage("sword").intValue(), getAttackSpeed("sword", "vein_gold"), new Item.Properties()));
    public static final RegistryObject<Item> VEIN_GOLD_PICKAXE = TOOLS.register("vein_gold_pickaxe",
            () -> new PickaxeItem(VEIN_GOLD_TIER, getDamage("pickaxe").intValue(), getAttackSpeed("pickaxe", "vein_gold"), new Item.Properties()));
    public static final RegistryObject<Item> VEIN_GOLD_AXE = TOOLS.register("vein_gold_axe",
            () -> new AxeItem(VEIN_GOLD_TIER, getDamage("axe").floatValue(), getAttackSpeed("axe", "vein_gold"), new Item.Properties()));
    public static final RegistryObject<Item> VEIN_GOLD_SHOVEL = TOOLS.register("vein_gold_shovel",
            () -> new ShovelItem(VEIN_GOLD_TIER, getDamage("shovel").floatValue(), getAttackSpeed("shovel", "vein_gold"), new Item.Properties()));
    public static final RegistryObject<Item> VEIN_GOLD_HOE = TOOLS.register("vein_gold_hoe",
            () -> new HoeItem(VEIN_GOLD_TIER, getDamage("hoe").intValue(), getAttackSpeed("hoe", "vein_gold"), new Item.Properties()));
    // 炽玄铁工具
    public static final RegistryObject<Item> FLAM_IRON_SWORD = TOOLS.register("flam_iron_sword",
            () -> new SwordItem(FLAM_IRON_TIER, getDamage("sword").intValue(), getAttackSpeed("sword", "flam_iron"), new Item.Properties()));
    public static final RegistryObject<Item> FLAM_IRON_PICKAXE = TOOLS.register("flam_iron_pickaxe",
            () -> new PickaxeItem(FLAM_IRON_TIER, getDamage("pickaxe").intValue(), getAttackSpeed("pickaxe", "flam_iron"), new Item.Properties()));
    public static final RegistryObject<Item> FLAM_IRON_AXE = TOOLS.register("flam_iron_axe",
            () -> new AxeItem(FLAM_IRON_TIER, getDamage("axe").floatValue(), getAttackSpeed("axe", "flam_iron"), new Item.Properties()));
    public static final RegistryObject<Item> FLAM_IRON_SHOVEL = TOOLS.register("flam_iron_shovel",
            () -> new ShovelItem(FLAM_IRON_TIER, getDamage("shovel").floatValue(), getAttackSpeed("shovel", "flam_iron"), new Item.Properties()));
    public static final RegistryObject<Item> FLAM_IRON_HOE = TOOLS.register("flam_iron_hoe",
            () -> new HoeItem(FLAM_IRON_TIER, getDamage("hoe").intValue(), getAttackSpeed("hoe", "flam_iron"), new Item.Properties()));
}