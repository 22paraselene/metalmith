package metalmith.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import metalmith.Metalmith;

public class ArmorRegistration {
    public static final DeferredRegister<Item> ARMOR_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Metalmith.MOD_ID);

    public interface ArmorMaterialWithTooltip extends ArmorMaterial {
        String getTooltipKey();

        int getTooltipLines();

        boolean requiresShift();
    }

    // 铜盔甲
    private static final ArmorMaterial COPPER_ARMOR_MATERIAL = new ArmorMaterial() {
        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return new int[]{110, 160, 150, 130}[type.getSlot().getIndex()]; // 耐久
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return new int[]{1, 4, 5, 2}[type.getSlot().getIndex()]; // 护甲值
        }

        @Override
        public int getEnchantmentValue() {
            return 10;
        } // 附魔能力

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_IRON;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.COPPER_INGOT);
        } // 修理物品

        @Override
        public String getName() {
            return "metalmith:copper";
        }

        @Override
        public float getToughness() {
            return 0.0F;
        } // 韧性

        @Override
        public float getKnockbackResistance() {
            return 0.0F;
        } // 击退抗性
    };
    // 硅青铜盔甲
    private static final ArmorMaterial SILICON_BRONZE_ARMOR_MATERIAL = new ArmorMaterialWithTooltip() {
        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return new int[]{275, 400, 375, 325}[type.getSlot().getIndex()]; // 耐久
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return new int[]{2, 6, 7, 2}[type.getSlot().getIndex()]; // 护甲值
        }

        @Override
        public int getEnchantmentValue() {
            return 10;
        } // 附魔能力

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_IRON;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.COPPER_INGOT);
        } // 修理物品

        @Override
        public String getName() {
            return "metalmith:silicon_bronze";
        }

        @Override
        public float getToughness() {
            return 1.0F;
        } // 韧性

        @Override
        public float getKnockbackResistance() {
            return 0.1F;
        } // 击退抗性

        public String getTooltipKey() {
            return "tooltip.metalmith.silicon_bronze";
        }

        public int getTooltipLines() {
            return 1;
        }

        public boolean requiresShift() {
            return false;
        }
    };
    // 石脉金盔甲
    public static final ArmorMaterial VEIN_GOLD_ARMOR_MATERIAL = new ArmorMaterialWithTooltip() {
        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return new int[]{220, 230, 300, 260}[type.getSlot().getIndex()]; // 耐久
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return new int[]{1, 3, 5, 2}[type.getSlot().getIndex()]; // 护甲值
        }

        @Override
        public int getEnchantmentValue() {
            return 25;
        } // 附魔能力

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_IRON;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.GOLD_INGOT);
        } // 修理物品

        @Override
        public String getName() {
            return "metalmith:vein_gold";
        }

        @Override
        public float getToughness() {
            return 3.0F;
        } // 韧性

        @Override
        public float getKnockbackResistance() {
            return 0.1F;
        } // 击退抗性

        public String getTooltipKey() {
            return "tooltip.metalmith.vein_gold";
        }

        public int getTooltipLines() {
            return 2;
        }

        public boolean requiresShift() {
            return false;
        }
    };
    // 炽玄铁盔甲
    private static final ArmorMaterial FLAM_IRON_ARMOR_MATERIAL = new ArmorMaterialWithTooltip() {
        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return new int[]{385, 560, 525, 455}[type.getSlot().getIndex()]; // 耐久
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return new int[]{3, 6, 8, 3}[type.getSlot().getIndex()]; // 护甲值
        }

        @Override
        public int getEnchantmentValue() {
            return 9;
        } // 附魔能力

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_IRON;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.IRON_INGOT);
        } // 修理物品

        @Override
        public String getName() {
            return "metalmith:flam_iron";
        }

        @Override
        public float getToughness() {
            return 2.0F;
        } // 韧性

        @Override
        public float getKnockbackResistance() {
            return 0.2F;
        } // 击退抗性

        public String getTooltipKey() {
            return "tooltip.metalmith.flam_iron";
        }

        public int getTooltipLines() {
            return 1;
        }

        public boolean requiresShift() {
            return false;
        }
    };
    // 盔甲注册
    public static final RegistryObject<Item>
            COPPER_HELMET = ARMOR_ITEMS.register("copper_helmet", () -> new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties())),
            COPPER_CHESTPLATE = ARMOR_ITEMS.register("copper_chestplate", () -> new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties())),
            COPPER_LEGGINGS = ARMOR_ITEMS.register("copper_leggings", () -> new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties())),
            COPPER_BOOTS = ARMOR_ITEMS.register("copper_boots", () -> new ArmorItem(COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties())),

    SILICON_BRONZE_HELMET = ARMOR_ITEMS.register("silicon_bronze_helmet", () -> new ArmorItem(SILICON_BRONZE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties())),
            SILICON_BRONZE_CHESTPLATE = ARMOR_ITEMS.register("silicon_bronze_chestplate", () -> new ArmorItem(SILICON_BRONZE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties())),
            SILICON_BRONZE_LEGGINGS = ARMOR_ITEMS.register("silicon_bronze_leggings", () -> new ArmorItem(SILICON_BRONZE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties())),
            SILICON_BRONZE_BOOTS = ARMOR_ITEMS.register("silicon_bronze_boots", () -> new ArmorItem(SILICON_BRONZE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties())),

    VEIN_GOLD_HELMET = ARMOR_ITEMS.register("vein_gold_helmet", () -> new ArmorItem(VEIN_GOLD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties())),
            VEIN_GOLD_CHESTPLATE = ARMOR_ITEMS.register("vein_gold_chestplate", () -> new ArmorItem(VEIN_GOLD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties())),
            VEIN_GOLD_LEGGINGS = ARMOR_ITEMS.register("vein_gold_leggings", () -> new ArmorItem(VEIN_GOLD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties())),
            VEIN_GOLD_BOOTS = ARMOR_ITEMS.register("vein_gold_boots", () -> new ArmorItem(VEIN_GOLD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties())),

    FLAM_IRON_HELMET = ARMOR_ITEMS.register("flam_iron_helmet", () -> new ArmorItem(FLAM_IRON_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties())),
            FLAM_IRON_CHESTPLATE = ARMOR_ITEMS.register("flam_iron_chestplate", () -> new ArmorItem(FLAM_IRON_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties())),
            FLAM_IRON_LEGGINGS = ARMOR_ITEMS.register("flam_iron_leggings", () -> new ArmorItem(FLAM_IRON_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties())),
            FLAM_IRON_BOOTS = ARMOR_ITEMS.register("flam_iron_boots", () -> new ArmorItem(FLAM_IRON_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
}