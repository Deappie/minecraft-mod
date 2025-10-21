package com.example.boxofitems.item;

import com.example.boxofitems.BoxOfItems;
import com.example.boxofitems.blocks.ModBlocks;
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

    public static final RegistryObject<CreativeModeTab> BOX_OF_ITEMS_TAB = CREATIVE_MODE_TABS.register(
            "boxofitems",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GLOWITE.get()))
                    .title(Component.translatable("creativetab.box_of_items_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.GLOWITE.get());

                        pOutput.accept(ModBlocks.GLOWITE_BLOCK.get());

                        pOutput.accept(ModBlocks.GLOWITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_GLOWITE_ORE.get());
                        pOutput.accept(ModBlocks.SAND_GLOWITE_ORE.get());
                        pOutput.accept(ModBlocks.GRAVEL_GLOWITE_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
