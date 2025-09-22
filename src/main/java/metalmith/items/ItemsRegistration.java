package metalmith.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import metalmith.Metalmith;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class ItemsRegistration {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Metalmith.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Metalmith.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Metalmith.MOD_ID);

    // 注册物品
    public static final RegistryObject<Item> COPPER_NUGGET =
            ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SILICON_BRONZE_RAW =
            ITEMS.register("silicon_bronze_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILICON_BRONZE_INGOT =
            ITEMS.register("silicon_bronze_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILICON_BRONZE_NUGGET =
            ITEMS.register("silicon_bronze_nugget", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VEIN_GOLD_RAW =
            ITEMS.register("vein_gold_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VEIN_GOLD_INGOT =
            ITEMS.register("vein_gold_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VEIN_GOLD_NUGGET =
            ITEMS.register("vein_gold_nugget", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLAM_IRON_RAW =
            ITEMS.register("flam_iron_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLAM_IRON_INGOT =
            ITEMS.register("flam_iron_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLAM_IRON_NUGGET =
            ITEMS.register("flam_iron_nugget", () -> new Item(new Item.Properties()));

    // 注册方块
    public static final RegistryObject<Block> SILICON_BRONZE_BLOCK =
            BLOCKS.register("silicon_bronze_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    public static final RegistryObject<Item> SILICON_BRONZE_BLOCK_ITEM =
            ITEMS.register("silicon_bronze_block", () -> new BlockItem(SILICON_BRONZE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Block> VEIN_GOLD_BLOCK =
            BLOCKS.register("vein_gold_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    public static final RegistryObject<Item> VEIN_GOLD_BLOCK_ITEM =
            ITEMS.register("vein_gold_block", () -> new BlockItem(VEIN_GOLD_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Block> FLAM_IRON_BLOCK =
            BLOCKS.register("flam_iron_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    public static final RegistryObject<Item> FLAM_IRON_BLOCK_ITEM =
            ITEMS.register("flam_iron_block", () -> new BlockItem(FLAM_IRON_BLOCK.get(), new Item.Properties()));


    // 注册新的创造模式分类
    public static final RegistryObject<CreativeModeTab> metalmith_TAB = CREATIVE_TABS.register(
            "metalmith_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.metalmith"))
                    .icon(() -> new ItemStack(SILICON_BRONZE_INGOT.get())) // 分类图标
                    .displayItems((params, output) -> {
                        // 添加所有注册物品到分类

                        // 工具
                        output.accept(ToolsRegistration.COPPER_SWORD.get());
                        output.accept(ToolsRegistration.COPPER_PICKAXE.get());
                        output.accept(ToolsRegistration.COPPER_AXE.get());
                        output.accept(ToolsRegistration.COPPER_SHOVEL.get());
                        output.accept(ToolsRegistration.COPPER_HOE.get());

                        output.accept(ToolsRegistration.SILICON_BRONZE_SWORD.get());
                        output.accept(ToolsRegistration.SILICON_BRONZE_PICKAXE.get());
                        output.accept(ToolsRegistration.SILICON_BRONZE_AXE.get());
                        output.accept(ToolsRegistration.SILICON_BRONZE_SHOVEL.get());
                        output.accept(ToolsRegistration.SILICON_BRONZE_HOE.get());

                        output.accept(ToolsRegistration.VEIN_GOLD_SWORD.get());
                        output.accept(ToolsRegistration.VEIN_GOLD_PICKAXE.get());
                        output.accept(ToolsRegistration.VEIN_GOLD_AXE.get());
                        output.accept(ToolsRegistration.VEIN_GOLD_SHOVEL.get());
                        output.accept(ToolsRegistration.VEIN_GOLD_HOE.get());

                        output.accept(ToolsRegistration.FLAM_IRON_SWORD.get());
                        output.accept(ToolsRegistration.FLAM_IRON_PICKAXE.get());
                        output.accept(ToolsRegistration.FLAM_IRON_AXE.get());
                        output.accept(ToolsRegistration.FLAM_IRON_SHOVEL.get());
                        output.accept(ToolsRegistration.FLAM_IRON_HOE.get());

                        // 盔甲
                        output.accept(ArmorRegistration.COPPER_HELMET.get());
                        output.accept(ArmorRegistration.COPPER_CHESTPLATE.get());
                        output.accept(ArmorRegistration.COPPER_LEGGINGS.get());
                        output.accept(ArmorRegistration.COPPER_BOOTS.get());

                        output.accept(ArmorRegistration.SILICON_BRONZE_HELMET.get());
                        output.accept(ArmorRegistration.SILICON_BRONZE_CHESTPLATE.get());
                        output.accept(ArmorRegistration.SILICON_BRONZE_LEGGINGS.get());
                        output.accept(ArmorRegistration.SILICON_BRONZE_BOOTS.get());

                        output.accept(ArmorRegistration.VEIN_GOLD_HELMET.get());
                        output.accept(ArmorRegistration.VEIN_GOLD_CHESTPLATE.get());
                        output.accept(ArmorRegistration.VEIN_GOLD_LEGGINGS.get());
                        output.accept(ArmorRegistration.VEIN_GOLD_BOOTS.get());

                        output.accept(ArmorRegistration.FLAM_IRON_HELMET.get());
                        output.accept(ArmorRegistration.FLAM_IRON_CHESTPLATE.get());
                        output.accept(ArmorRegistration.FLAM_IRON_LEGGINGS.get());
                        output.accept(ArmorRegistration.FLAM_IRON_BOOTS.get());

                        // 其他物品
                        output.accept(COPPER_NUGGET.get());
                        output.accept(SILICON_BRONZE_RAW.get());
                        output.accept(SILICON_BRONZE_INGOT.get());
                        output.accept(SILICON_BRONZE_NUGGET.get());
                        output.accept(SILICON_BRONZE_BLOCK_ITEM.get());
                        output.accept(VEIN_GOLD_RAW.get());
                        output.accept(VEIN_GOLD_INGOT.get());
                        output.accept(VEIN_GOLD_NUGGET.get());
                        output.accept(VEIN_GOLD_BLOCK_ITEM.get());
                        output.accept(FLAM_IRON_RAW.get());
                        output.accept(FLAM_IRON_INGOT.get());
                        output.accept(FLAM_IRON_NUGGET.get());
                        output.accept(FLAM_IRON_BLOCK_ITEM.get());

// 在displayItems方法中添加：
// 铜武器
                        output.accept(SimplySwordsRegistration.COPPER_LONGSWORD.get());
                        output.accept(SimplySwordsRegistration.COPPER_TWINBLADE.get());
                        output.accept(SimplySwordsRegistration.COPPER_RAPIER.get());
                        output.accept(SimplySwordsRegistration.COPPER_KATANA.get());
                        output.accept(SimplySwordsRegistration.COPPER_SAI.get());
                        output.accept(SimplySwordsRegistration.COPPER_SPEAR.get());
                        output.accept(SimplySwordsRegistration.COPPER_GLAIVE.get());
                        output.accept(SimplySwordsRegistration.COPPER_WARGLAIVE.get());
                        output.accept(SimplySwordsRegistration.COPPER_CUTLASS.get());
                        output.accept(SimplySwordsRegistration.COPPER_CLAYMORE.get());
                        output.accept(SimplySwordsRegistration.COPPER_GREATAXE.get());
                        output.accept(SimplySwordsRegistration.COPPER_GREATHAMMER.get());
                        output.accept(SimplySwordsRegistration.COPPER_CHAKRAM.get());
                        output.accept(SimplySwordsRegistration.COPPER_SCYTHE.get());
                        output.accept(SimplySwordsRegistration.COPPER_HALBERD.get());

// 硅青铜武器
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_LONGSWORD.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_TWINBLADE.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_RAPIER.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_KATANA.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_SAI.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_SPEAR.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_GLAIVE.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_WARGLAIVE.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_CUTLASS.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_CLAYMORE.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_GREATAXE.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_GREATHAMMER.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_CHAKRAM.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_SCYTHE.get());
                        output.accept(SimplySwordsRegistration.SILICON_BRONZE_HALBERD.get());

// 石脉金武器
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_LONGSWORD.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_TWINBLADE.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_RAPIER.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_KATANA.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_SAI.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_SPEAR.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_GLAIVE.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_WARGLAIVE.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_CUTLASS.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_CLAYMORE.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_GREATAXE.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_GREATHAMMER.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_CHAKRAM.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_SCYTHE.get());
                        output.accept(SimplySwordsRegistration.VEIN_GOLD_HALBERD.get());

// 炽玄铁武器
                        output.accept(SimplySwordsRegistration.FLAM_IRON_LONGSWORD.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_TWINBLADE.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_RAPIER.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_KATANA.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_SAI.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_SPEAR.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_GLAIVE.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_WARGLAIVE.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_CUTLASS.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_CLAYMORE.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_GREATAXE.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_GREATHAMMER.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_CHAKRAM.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_SCYTHE.get());
                        output.accept(SimplySwordsRegistration.FLAM_IRON_HALBERD.get());
                    })
                    .build()
    );
}