package net.armand2.sacks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.MISC, Items.DYED_SHULKER_BOX.brown())
                        .pattern("LLL")
                        .pattern("LCL")
                        .pattern("LLL")
                        .define('L', Items.LEATHER)
                        .define('C', Items.CHEST)
                        .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                        .group("misc")
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Sacks Recipes";
    }
}
