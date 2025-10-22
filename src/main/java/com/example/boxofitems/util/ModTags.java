package com.example.boxofitems.util;

import com.example.boxofitems.BoxOfItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");


        private static TagKey<Block> tag(String name) {
//            return BlockTags.create(new ResourceLocation(BoxOfItems.MODID, name));  - deprecated
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BoxOfItems.MODID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BoxOfItems.MODID, name));
        }
    }
}
