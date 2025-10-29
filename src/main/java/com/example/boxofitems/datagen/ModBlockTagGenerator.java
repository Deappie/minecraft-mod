package com.example.boxofitems.datagen;

import com.example.boxofitems.BoxOfItems;
import com.example.boxofitems.blocks.ModBlocks;
import com.example.boxofitems.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {


    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BoxOfItems.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.GLOWITE_ORE.get(),
                        ModBlocks.DEEPSLATE_GLOWITE_ORE.get(),
                        ModBlocks.GRAVEL_GLOWITE_ORE.get(),
                        ModBlocks.SAND_GLOWITE_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GLOWITE_ORE.get(),
                        ModBlocks.DEEPSLATE_GLOWITE_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get(),
                        ModBlocks.GLOWITE_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.GRAVEL_GLOWITE_ORE.get(),
                        ModBlocks.SAND_GLOWITE_ORE.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GLOWITE_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SAND_GLOWITE_ORE.get(),
                        ModBlocks.GRAVEL_GLOWITE_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.DEEPSLATE_GLOWITE_ORE.get());
    }
}
