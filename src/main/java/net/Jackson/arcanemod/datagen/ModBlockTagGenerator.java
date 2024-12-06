package net.Jackson.arcanemod.datagen;

import net.Jackson.arcanemod.ArcaneMod;

import net.Jackson.arcanemod.block.ModBlocks;
import net.Jackson.arcanemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ArcaneMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.PILTOVER_BLOCK_TYPE)
                .add(ModBlocks.PILTOVER_BLOCK.get());
                //.addTag(Tags.Blocks.Whateveryouwant); for if you want to add tags to this tag


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PILTOVER_BLOCK.get(),
                        ModBlocks.GEMSTONE_BLOCK.get(),
                        ModBlocks.GEMSTONE_ORE.get(),
                        ModBlocks.DEEPSLATE_GEMSTONE_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PILTOVER_BLOCK.get(),
                        ModBlocks.GEMSTONE_BLOCK.get(),
                        ModBlocks.GEMSTONE_ORE.get(),
                        ModBlocks.DEEPSLATE_GEMSTONE_ORE.get()
                );

        this.tag(ModTags.Blocks.NEEDS_HEXTECH_TOOL)
                .add(ModBlocks.SOUND_BLOCK.get());


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.PILTOVER_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PILTOVER_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.PILTOVER_WALL.get());





    }
}
