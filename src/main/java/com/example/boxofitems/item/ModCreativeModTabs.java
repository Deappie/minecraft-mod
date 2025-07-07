package com.example.boxofitems.item;

import com.example.boxofitems.BoxOfItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BoxOfItems.MODID);

    public static final RegistryObject<CreativeModeTab> Box_Of_Items = CREATIVE_MODE_TABS.register("boxofitems",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BeeCat.get()))
                    .title(Component.translatable("creativetab.boxofitems"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BeeCat.get());
                        pOutput.accept(ModItems.RawBeeCat.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
