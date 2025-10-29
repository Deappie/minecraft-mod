package com.example.boxofitems.datagen;

import com.example.boxofitems.BoxOfItems;
import com.example.boxofitems.blocks.ModBlocks;
import com.example.boxofitems.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GLOWITE_SMELTABLES = List.of(ModItems.GLOWITE.get(),
            ModBlocks.GLOWITE_ORE.get(),
            ModBlocks.SAND_GLOWITE_ORE.get(),
            ModBlocks.GRAVEL_GLOWITE_ORE.get(),
            ModBlocks.DEEPSLATE_GLOWITE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, GLOWITE_SMELTABLES, RecipeCategory.MISC, ModItems.GLOWITE.get(), 0.25f, 200, "glowite");
        oreBlasting(pWriter, GLOWITE_SMELTABLES, RecipeCategory.MISC, ModItems.GLOWITE.get(), 0.25f, 100, "glowite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GLOWITE_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GLOWITE.get())
                .unlockedBy(getHasName(ModItems.GLOWITE.get()), has(ModItems.GLOWITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GLOWITE.get(), 9)
                .requires(ModBlocks.GLOWITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GLOWITE_BLOCK.get()), has(ModBlocks.GLOWITE_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer,
                    BoxOfItems.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
