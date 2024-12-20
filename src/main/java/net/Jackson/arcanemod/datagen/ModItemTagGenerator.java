package net.Jackson.arcanemod.datagen;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.ModBlocks;
import net.Jackson.arcanemod.item.ModItems;
import net.Jackson.arcanemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ArcaneMod.MOD_ID, existingFileHelper);
    }


    // Shimmer tag
    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Items.HAS_SHIMMER)
                .add(ModItems.SHIMMER_SYRINGE.get());

        this.tag(ModTags.Items.HAS_TAINTED)
                .add(ModItems.TAINTED_ROTTEN_FLESH.get())
                .add(ModItems.TAINTED_SEEDS.get())
                .add(ModItems.TAINTED_WHEAT.get());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.DYNASTIES_DYSTOPIA_MUSIC_DISC.get())
                .add(ModItems.MA_MEILLEURE_MUSIC_DISC.get())
                .add(ModItems.PLAYGROUND_MUSIC_DISC.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.DYNASTIES_DYSTOPIA_MUSIC_DISC.get())
                .add(ModItems.MA_MEILLEURE_MUSIC_DISC.get())
                .add(ModItems.PLAYGROUND_MUSIC_DISC.get());


    }


}
