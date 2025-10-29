package com.example.boxofitems.datagen;

import com.example.boxofitems.BoxOfItems;
import com.example.boxofitems.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BoxOfItems.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GLOWITE_BLOCK);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        blockWithItem(ModBlocks.GLOWITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_GLOWITE_ORE);
        blockWithItem(ModBlocks.SAND_GLOWITE_ORE);
        blockWithItem(ModBlocks.GRAVEL_GLOWITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
