package metalmith;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.spongepowered.asm.launch.MixinBootstrap;
import metalmith.items.ArmorRegistration;
import metalmith.items.ItemsRegistration;
import metalmith.items.ToolsRegistration;
import metalmith.items.SimplySwordsRegistration; // 新增导入

@Mod("metalmith")
public class Metalmith {
    public static final String MOD_ID = "metalmith";

    // 通过构造函数参数获取 FMLJavaModLoadingContext
    public Metalmith(FMLJavaModLoadingContext context) {
        MixinBootstrap.init();
        IEventBus modEventBus = context.getModEventBus();

        // 注册工具、盔甲和物品
        ToolsRegistration.TOOLS.register(modEventBus);
        ArmorRegistration.ARMOR_ITEMS.register(modEventBus);
        ItemsRegistration.ITEMS.register(modEventBus);
        ItemsRegistration.CREATIVE_TABS.register(modEventBus);
        ItemsRegistration.BLOCKS.register(modEventBus);
        
        // 注册Simply Swords联动武器
        SimplySwordsRegistration.ITEMS.register(modEventBus); // 新增注册
    }
}