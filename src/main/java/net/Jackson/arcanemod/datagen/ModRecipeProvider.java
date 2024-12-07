package net.Jackson.arcanemod.datagen;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.ModBlocks;
import net.Jackson.arcanemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import java.util.List;
import java.util.function.Consumer;

// Groups gemstone shard smeltables
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GEMSTONE_SMELTABLES = List.of(ModItems.GEMSTONE_SHARD.get(),
            ModBlocks.GEMSTONE_ORE.get(),
            ModBlocks.DEEPSLATE_GEMSTONE_ORE.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeOutput) {

        //gemstone from shards
        oreSmelting(recipeOutput,               //instead of pwriter
                    GEMSTONE_SMELTABLES,        // ingredients
                    RecipeCategory.MISC,        // category
                    ModItems.GEMSTONE.get(),    //output
                    0.25f,                      //experience gained
                    250,                        //cooking time (ticks)
                    "gemstone");                //group name
        oreBlasting(recipeOutput,               //instead of pwriter
                GEMSTONE_SMELTABLES,
                RecipeCategory.MISC,
                ModItems.GEMSTONE.get(),
                0.25f,
                150,
                "gemstone");

        // gemstone block from gemstones
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEMSTONE_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GEMSTONE.get())
                .unlockedBy(getHasName(ModItems.GEMSTONE.get()), has(ModItems.GEMSTONE.get()))
                .save(recipeOutput, ArcaneMod.MOD_ID + ":gemstone_block_from_gemstones");

        // gemstones from gemstone block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GEMSTONE.get(), 9)
                .requires(ModBlocks.GEMSTONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GEMSTONE_BLOCK.get()), has(ModBlocks.GEMSTONE_BLOCK.get()))
                .save(recipeOutput, ArcaneMod.MOD_ID + ":gemstones_from_gemstone_block");

        // gemstone from shards
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GEMSTONE.get())
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.GEMSTONE_SHARD.get())
                .unlockedBy(getHasName(ModItems.GEMSTONE.get()), has(ModItems.GEMSTONE.get()))
                .save(recipeOutput, ArcaneMod.MOD_ID + ":gemstone_from_shards");


    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, ArcaneMod.MOD_ID + ":" + (pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }

}
