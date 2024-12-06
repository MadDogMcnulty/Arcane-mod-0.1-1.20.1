package net.Jackson.arcanemod.item;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier HEX = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_HEXTECH_TOOL, () -> Ingredient.of(ModItems.REFINED_GEMSTONE.get())),
            new ResourceLocation(ArcaneMod.MOD_ID, "gemstone"),
            List.of(Tiers.DIAMOND) /*<- Lesser than Hex tools*/,
            List.of(Tiers.NETHERITE) /*<- Greater than Hex tools*/);
}
