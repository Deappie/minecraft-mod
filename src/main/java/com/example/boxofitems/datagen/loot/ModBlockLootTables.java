package com.example.boxofitems.datagen.loot;

import com.example.boxofitems.blocks.ModBlocks;
import com.example.boxofitems.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.GLOWITE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.GLOWITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.GLOWITE_ORE.get(), ModItems.GLOWITE.get()));
        this.add(ModBlocks.DEEPSLATE_GLOWITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_GLOWITE_ORE.get(), ModItems.GLOWITE.get()));
        this.add(ModBlocks.SAND_GLOWITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SAND_GLOWITE_ORE.get(), ModItems.GLOWITE.get()));
        this.add(ModBlocks.GRAVEL_GLOWITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.GRAVEL_GLOWITE_ORE.get(), ModItems.GLOWITE.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
