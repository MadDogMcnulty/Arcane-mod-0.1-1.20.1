package net.Jackson.arcanemod.datagen;

import net.Jackson.arcanemod.block.ModBlocks;
import net.Jackson.arcanemod.block.custom.TaintedWheatCropBlock;
import net.Jackson.arcanemod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PILTOVER_BLOCK.get());
        this.dropSelf(ModBlocks.GEMSTONE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.GEMSTONE_REFINERY.get());
        this.dropSelf(ModBlocks.HEXCORE.get());

        this.add(ModBlocks.GEMSTONE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.GEMSTONE_ORE.get(), ModItems.GEMSTONE_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_GEMSTONE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_GEMSTONE_ORE.get(), ModItems.GEMSTONE_SHARD.get()));

        this.dropSelf(ModBlocks.PILTOVER_FENCE.get());
        this.dropSelf(ModBlocks.PILTOVER_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PILTOVER_WALL.get());
        this.dropSelf(ModBlocks.PILTOVER_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PILTOVER_BUTTON.get());
        this.dropSelf(ModBlocks.PILTOVER_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PILTOVER_STAIRS.get());

        this.add(ModBlocks.PILTOVER_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PILTOVER_SLAB.get()));
        this.add(ModBlocks.PILTOVER_DOOR.get(),
                block -> createDoorTable(ModBlocks.PILTOVER_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TAINTED_WHEAT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TaintedWheatCropBlock.AGE, 5));

        this.add(ModBlocks.TAINTED_WHEAT_CROP.get(), createCropDrops(ModBlocks.TAINTED_WHEAT_CROP.get(),
                ModItems.TAINTED_WHEAT.get(), ModItems.TAINTED_SEEDS.get(), lootitemcondition$builder));

        this.dropSelf(ModBlocks.TAINTED_FLOWER.get());
        this.add(ModBlocks.POTTED_TAINTED_FLOWER.get(), createPotFlowerItemTable(ModBlocks.TAINTED_FLOWER.get()));


    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                (LootPoolEntryContainer.Builder)
                        this.applyExplosionDecay(pBlock,
                                LootItem.lootTableItem(item)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
