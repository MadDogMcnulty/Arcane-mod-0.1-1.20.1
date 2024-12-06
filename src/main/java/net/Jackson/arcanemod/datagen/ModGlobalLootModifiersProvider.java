package net.Jackson.arcanemod.datagen;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.item.ModItems;
import net.Jackson.arcanemod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ArcaneMod.MOD_ID);
    }

    @Override
    protected void start() {
        // Add moditems to vanilla drops


            add("tainted_seeds_from_grass", new AddItemModifier(new LootItemCondition[]{
                    LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                    LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.TAINTED_SEEDS.get()));

        add("tainted_flesh_from_zombie", new AddItemModifier(new LootItemCondition[ ]{
                        new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                        LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.TAINTED_ROTTEN_FLESH.get()));

        add("shimmer_syringe_from_mineshaft", new AddItemModifier(new LootItemCondition[ ]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()}, ModItems.SHIMMER_SYRINGE.get()));


        add("shimmer_syringe_from_village", new AddItemModifier(new LootItemCondition[ ]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()}, ModItems.SHIMMER_SYRINGE.get()));
    }
}
