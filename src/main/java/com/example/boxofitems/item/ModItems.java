package com.example.boxofitems.item;

import com.example.boxofitems.BoxOfItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BoxOfItems.MODID);

    public static final RegistryObject<Item> BeeCat = ITEMS.register("beecat",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RawBeeCat = ITEMS.register("rawbeecat",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
