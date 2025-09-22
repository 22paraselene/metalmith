package metalmith.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sweenus.simplyswords.item.SimplySwordsSwordItem;
import metalmith.Metalmith;

public class SimplySwordsRegistration {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Metalmith.MOD_ID);

    // 武器属性定义 - 根据你的设定调整这些值
    private static final float COPPER_DAMAGE_MODIFIER = 3.0f;
    private static final float SILICON_BRONZE_DAMAGE_MODIFIER = 3.0f;
    private static final float VEIN_GOLD_DAMAGE_MODIFIER = 3.0f;
    private static final float FLAM_IRON_DAMAGE_MODIFIER = 3.0f;

    // 武器类型基础攻击速度 - 相对于标准剑的-2.4f
    private static final float LONGSWORD_SPEED = -2.4f;
    private static final float TWINBLADE_SPEED = -2.0f;
    private static final float RAPIER_SPEED = -1.8f;
    private static final float KATANA_SPEED = -2.0f;
    private static final float SAI_SPEED = -1.5f;
    private static final float SPEAR_SPEED = -2.7f;
    private static final float GLAIVE_SPEED = -2.6f;
    private static final float WARGLAIVE_SPEED = -2.2f;
    private static final float CUTLASS_SPEED = -2.0f;
    private static final float CLAYMORE_SPEED = -2.8f;
    private static final float GREATAXE_SPEED = -3.1f;
    private static final float GREATHAMMER_SPEED = -3.2f;
    private static final float CHAKRAM_SPEED = -3.0f;
    private static final float SCYTHE_SPEED = -2.7f;
    private static final float HALBERD_SPEED = -2.8f;

    // 材料对攻击速度的影响
    private static final float COPPER_SPEED_MODIFIER = 0.0f; 
    private static final float SILICON_BRONZE_SPEED_MODIFIER = -0.1f; 
    private static final float VEIN_GOLD_SPEED_MODIFIER = 0.3f;
    private static final float FLAM_IRON_SPEED_MODIFIER = -0.1f; 

    // 武器类型伤害修饰符
    private static final float LONGSWORD_MODIFIER = 0.0f;
    private static final float TWINBLADE_MODIFIER = 0.0f;
    private static final float RAPIER_MODIFIER = -1.0f;
    private static final float KATANA_MODIFIER = 0.0f;
    private static final float SAI_MODIFIER = -3.0f;
    private static final float SPEAR_MODIFIER = 0.0f;
    private static final float GLAIVE_MODIFIER = 0.0f;
    private static final float WARGLAIVE_MODIFIER = 0.0f;
    private static final float CUTLASS_MODIFIER = 0.0f;
    private static final float CLAYMORE_MODIFIER = 2.0f;
    private static final float GREATAXE_MODIFIER = 3.0f;
    private static final float GREATHAMMER_MODIFIER = 4.0f;
    private static final float CHAKRAM_MODIFIER = -1.0f;
    private static final float SCYTHE_MODIFIER = 1.0f;
    private static final float HALBERD_MODIFIER = 3.0f;

    // 辅助方法：计算最终攻击速度
    private static float getAttackSpeed(String weaponType, String material) {
        float baseSpeed = 0.0f;
        
        // 根据武器类型获取基础攻击速度
        switch (weaponType) {
            case "longsword": baseSpeed = LONGSWORD_SPEED; break;
            case "twinblade": baseSpeed = TWINBLADE_SPEED; break;
            case "rapier": baseSpeed = RAPIER_SPEED; break;
            case "katana": baseSpeed = KATANA_SPEED; break;
            case "sai": baseSpeed = SAI_SPEED; break;
            case "spear": baseSpeed = SPEAR_SPEED; break;
            case "glaive": baseSpeed = GLAIVE_SPEED; break;
            case "warglaive": baseSpeed = WARGLAIVE_SPEED; break;
            case "cutlass": baseSpeed = CUTLASS_SPEED; break;
            case "claymore": baseSpeed = CLAYMORE_SPEED; break;
            case "greataxe": baseSpeed = GREATAXE_SPEED; break;
            case "greathammer": baseSpeed = GREATHAMMER_SPEED; break;
            case "chakram": baseSpeed = CHAKRAM_SPEED; break;
            case "scythe": baseSpeed = SCYTHE_SPEED; break;
            case "halberd": baseSpeed = HALBERD_SPEED; break;
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
    
    // 辅助方法：计算伤害
    private static int getDamage(String material, float weaponModifier) {
        float baseDamage = 0.0f;
        
        switch (material) {
            case "copper": baseDamage = COPPER_DAMAGE_MODIFIER; break;
            case "silicon_bronze": baseDamage = SILICON_BRONZE_DAMAGE_MODIFIER; break;
            case "vein_gold": baseDamage = VEIN_GOLD_DAMAGE_MODIFIER; break;
            case "flam_iron": baseDamage = FLAM_IRON_DAMAGE_MODIFIER; break;
        }
        
        return (int) (baseDamage + weaponModifier);
    }

    // 注册铜武器
    public static final RegistryObject<Item> COPPER_LONGSWORD = ITEMS.register("copper_longsword",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", LONGSWORD_MODIFIER), 
                    getAttackSpeed("longsword", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_TWINBLADE = ITEMS.register("copper_twinblade",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", TWINBLADE_MODIFIER), 
                    getAttackSpeed("twinblade", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_RAPIER = ITEMS.register("copper_rapier",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", RAPIER_MODIFIER), 
                    getAttackSpeed("rapier", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_KATANA = ITEMS.register("copper_katana",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", KATANA_MODIFIER), 
                    getAttackSpeed("katana", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_SAI = ITEMS.register("copper_sai",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", SAI_MODIFIER), 
                    getAttackSpeed("sai", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_SPEAR = ITEMS.register("copper_spear",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", SPEAR_MODIFIER), 
                    getAttackSpeed("spear", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_GLAIVE = ITEMS.register("copper_glaive",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", GLAIVE_MODIFIER), 
                    getAttackSpeed("glaive", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_WARGLAIVE = ITEMS.register("copper_warglaive",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", WARGLAIVE_MODIFIER), 
                    getAttackSpeed("warglaive", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_CUTLASS = ITEMS.register("copper_cutlass",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", CUTLASS_MODIFIER), 
                    getAttackSpeed("cutlass", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_CLAYMORE = ITEMS.register("copper_claymore",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", CLAYMORE_MODIFIER), 
                    getAttackSpeed("claymore", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_GREATAXE = ITEMS.register("copper_greataxe",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", GREATAXE_MODIFIER), 
                    getAttackSpeed("greataxe", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_GREATHAMMER = ITEMS.register("copper_greathammer",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", GREATHAMMER_MODIFIER), 
                    getAttackSpeed("greathammer", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_CHAKRAM = ITEMS.register("copper_chakram",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", CHAKRAM_MODIFIER), 
                    getAttackSpeed("chakram", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_SCYTHE = ITEMS.register("copper_scythe",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", SCYTHE_MODIFIER), 
                    getAttackSpeed("scythe", "copper"), 
                    "metalmith:copper_ingot"));

    public static final RegistryObject<Item> COPPER_HALBERD = ITEMS.register("copper_halberd",
            () -> new SimplySwordsSwordItem(ToolsRegistration.COPPER_TIER,
                    getDamage("copper", HALBERD_MODIFIER), 
                    getAttackSpeed("halberd", "copper"), 
                    "metalmith:copper_ingot"));

    // 硅青铜武器
    public static final RegistryObject<Item> SILICON_BRONZE_LONGSWORD = ITEMS.register("silicon_bronze_longsword",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", LONGSWORD_MODIFIER), 
                    getAttackSpeed("longsword", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_TWINBLADE = ITEMS.register("silicon_bronze_twinblade",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", TWINBLADE_MODIFIER), 
                    getAttackSpeed("twinblade", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_RAPIER = ITEMS.register("silicon_bronze_rapier",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", RAPIER_MODIFIER), 
                    getAttackSpeed("rapier", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_KATANA = ITEMS.register("silicon_bronze_katana",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", KATANA_MODIFIER), 
                    getAttackSpeed("katana", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_SAI = ITEMS.register("silicon_bronze_sai",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", SAI_MODIFIER), 
                    getAttackSpeed("sai", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_SPEAR = ITEMS.register("silicon_bronze_spear",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", SPEAR_MODIFIER), 
                    getAttackSpeed("spear", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_GLAIVE = ITEMS.register("silicon_bronze_glaive",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", GLAIVE_MODIFIER), 
                    getAttackSpeed("glaive", "silicon_brone"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_WARGLAIVE = ITEMS.register("silicon_bronze_warglaive",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", WARGLAIVE_MODIFIER), 
                    getAttackSpeed("warglaive", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_CUTLASS = ITEMS.register("silicon_bronze_cutlass",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", CUTLASS_MODIFIER), 
                    getAttackSpeed("cutlass", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_CLAYMORE = ITEMS.register("silicon_bronze_claymore",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", CLAYMORE_MODIFIER), 
                    getAttackSpeed("claymore", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_GREATAXE = ITEMS.register("silicon_bronze_greataxe",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", GREATAXE_MODIFIER), 
                    getAttackSpeed("greataxe", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_GREATHAMMER = ITEMS.register("silicon_bronze_greathammer",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", GREATHAMMER_MODIFIER), 
                    getAttackSpeed("greathammer", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_CHAKRAM = ITEMS.register("silicon_bronze_chakram",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", CHAKRAM_MODIFIER), 
                    getAttackSpeed("chakram", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_SCYTHE = ITEMS.register("silicon_bronze_scythe",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", SCYTHE_MODIFIER), 
                    getAttackSpeed("scythe", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    public static final RegistryObject<Item> SILICON_BRONZE_HALBERD = ITEMS.register("silicon_bronze_halberd",
            () -> new SimplySwordsSwordItem(ToolsRegistration.SILICON_BRONZE_TIER,
                    getDamage("silicon_bronze", HALBERD_MODIFIER), 
                    getAttackSpeed("halberd", "silicon_bronze"), 
                    "metalmith:silicon_bronze_ingot"));

    // 石脉金武器
    public static final RegistryObject<Item> VEIN_GOLD_LONGSWORD = ITEMS.register("vein_gold_longsword",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", LONGSWORD_MODIFIER), 
                    getAttackSpeed("longsword", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_TWINBLADE = ITEMS.register("vein_gold_twinblade",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", TWINBLADE_MODIFIER), 
                    getAttackSpeed("twinblade", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_RAPIER = ITEMS.register("vein_gold_rapier",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", RAPIER_MODIFIER), 
                    getAttackSpeed("rapier", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_KATANA = ITEMS.register("vein_gold_katana",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", KATANA_MODIFIER), 
                    getAttackSpeed("katana", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_SAI = ITEMS.register("vein_gold_sai",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", SAI_MODIFIER), 
                    getAttackSpeed("sai", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_SPEAR = ITEMS.register("vein_gold_spear",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", SPEAR_MODIFIER), 
                    getAttackSpeed("spear", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_GLAIVE = ITEMS.register("vein_gold_glaive",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", GLAIVE_MODIFIER), 
                    getAttackSpeed("glaive", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_WARGLAIVE = ITEMS.register("vein_gold_warglaive",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", WARGLAIVE_MODIFIER), 
                    getAttackSpeed("warglaive", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_CUTLASS = ITEMS.register("vein_gold_cutlass",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", CUTLASS_MODIFIER), 
                    getAttackSpeed("cutlass", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_CLAYMORE = ITEMS.register("vein_gold_claymore",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", CLAYMORE_MODIFIER), 
                    getAttackSpeed("claymore", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_GREATAXE = ITEMS.register("vein_gold_greataxe",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", GREATAXE_MODIFIER), 
                    getAttackSpeed("greataxe", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_GREATHAMMER = ITEMS.register("vein_gold_greathammer",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", GREATHAMMER_MODIFIER), 
                    getAttackSpeed("greathammer", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_CHAKRAM = ITEMS.register("vein_gold_chakram",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", CHAKRAM_MODIFIER), 
                    getAttackSpeed("chakram", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_SCYTHE = ITEMS.register("vein_gold_scythe",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", SCYTHE_MODIFIER), 
                    getAttackSpeed("scythe", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    public static final RegistryObject<Item> VEIN_GOLD_HALBERD = ITEMS.register("vein_gold_halberd",
            () -> new SimplySwordsSwordItem(ToolsRegistration.VEIN_GOLD_TIER,
                    getDamage("vein_gold", HALBERD_MODIFIER), 
                    getAttackSpeed("halberd", "vein_gold"), 
                    "metalmith:vein_gold_ingot"));

    // 炽玄铁武器
    public static final RegistryObject<Item> FLAM_IRON_LONGSWORD = ITEMS.register("flam_iron_longsword",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", LONGSWORD_MODIFIER), 
                    getAttackSpeed("longsword", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_TWINBLADE = ITEMS.register("flam_iron_twinblade",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", TWINBLADE_MODIFIER), 
                    getAttackSpeed("twinblade", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_RAPIER = ITEMS.register("flam_iron_rapier",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", RAPIER_MODIFIER), 
                    getAttackSpeed("rapier", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_KATANA = ITEMS.register("flam_iron_katana",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", KATANA_MODIFIER), 
                    getAttackSpeed("katana", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_SAI = ITEMS.register("flam_iron_sai",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", SAI_MODIFIER), 
                    getAttackSpeed("sai", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_SPEAR = ITEMS.register("flam_iron_spear",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", SPEAR_MODIFIER), 
                    getAttackSpeed("spear", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_GLAIVE = ITEMS.register("flam_iron_glaive",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", GLAIVE_MODIFIER), 
                    getAttackSpeed("glaive", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_WARGLAIVE = ITEMS.register("flam_iron_warglaive",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", WARGLAIVE_MODIFIER), 
                    getAttackSpeed("warglaive", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_CUTLASS = ITEMS.register("flam_iron_cutlass",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", CUTLASS_MODIFIER), 
                    getAttackSpeed("cutlass", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_CLAYMORE = ITEMS.register("flam_iron_claymore",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", CLAYMORE_MODIFIER), 
                    getAttackSpeed("claymore", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_GREATAXE = ITEMS.register("flam_iron_greataxe",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", GREATAXE_MODIFIER), 
                    getAttackSpeed("greataxe", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_GREATHAMMER = ITEMS.register("flam_iron_greathammer",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", GREATHAMMER_MODIFIER), 
                    getAttackSpeed("greathammer", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_CHAKRAM = ITEMS.register("flam_iron_chakram",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", CHAKRAM_MODIFIER), 
                    getAttackSpeed("chakram", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_SCYTHE = ITEMS.register("flam_iron_scythe",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", SCYTHE_MODIFIER), 
                    getAttackSpeed("scythe", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));

    public static final RegistryObject<Item> FLAM_IRON_HALBERD = ITEMS.register("flam_iron_halberd",
            () -> new SimplySwordsSwordItem(ToolsRegistration.FLAM_IRON_TIER,
                    getDamage("flam_iron", HALBERD_MODIFIER), 
                    getAttackSpeed("halberd", "flam_iron"), 
                    "metalmith:flam_iron_ingot"));
}