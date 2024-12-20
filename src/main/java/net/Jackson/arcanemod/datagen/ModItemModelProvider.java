package net.Jackson.arcanemod.datagen;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.ModBlocks;
import net.Jackson.arcanemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ArcaneMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GEMSTONE);
        simpleItem(ModItems.GEMSTONE_SHARD);
        simpleItem(ModItems.GEMSTONE_SHARD_PILE);
        simpleItem(ModItems.REFINED_GEMSTONE);
        simpleItem(ModItems.SHIMMER_SYRINGE);
        simpleItem(ModItems.TAINTED_ROTTEN_FLESH);
        simpleItem(ModItems.TAINTED_SEEDS);
        simpleItem(ModItems.TAINTED_WHEAT);
        simpleItem(ModItems.WORLD_RUNE_ACCELERATE);
        simpleItem(ModItems.WORLD_RUNE_DOMINATION);
        simpleItem(ModItems.WORLD_RUNE_PRECISION);
        simpleItem(ModItems.WORLD_RUNE_RESOLVE);
        simpleItem(ModItems.WORLD_RUNE_SORCERY);

        simpleItem(ModItems.DYNASTIES_DYSTOPIA_MUSIC_DISC);
        simpleItem(ModItems.MA_MEILLEURE_MUSIC_DISC);
        simpleItem(ModItems.PLAYGROUND_MUSIC_DISC);

        simpleBlockItem(ModBlocks.PILTOVER_DOOR);

        fenceItem(ModBlocks.PILTOVER_FENCE, ModBlocks.PILTOVER_BLOCK);
        buttonItem(ModBlocks.PILTOVER_BUTTON, ModBlocks.PILTOVER_BLOCK);
        wallItem(ModBlocks.PILTOVER_WALL, ModBlocks.PILTOVER_BLOCK);
        trapdoorBottom("piltover_trapdoor", modLoc("block/piltover_trapdoor"));
        wallInventory("piltover_wall", modLoc("block/piltover_block"));

        evenSimplerBlockItem(ModBlocks.PILTOVER_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.PILTOVER_STAIRS);
        evenSimplerBlockItem(ModBlocks.PILTOVER_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.PILTOVER_SLAB);

        trapdoorItem(ModBlocks.PILTOVER_TRAPDOOR);

        handheldItem(ModItems.HEXTECH_SWORD);
        handheldItem(ModItems.HEXTECH_PICKAXE);
        handheldItem(ModItems.HEXTECH_AXE);
        handheldItem(ModItems.HEXTECH_SHOVEL);
        handheldItem(ModItems.HEXTECH_HOE);

        simpleBlockItemBlockTexture(ModBlocks.TAINTED_FLOWER);


    }

//  builds the pathing for items
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ArcaneMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ArcaneMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));

    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent((ForgeRegistries.BLOCKS.getKey(block.get()).getPath()),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(ArcaneMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(ArcaneMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", new ResourceLocation(ArcaneMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                 new ResourceLocation("item/handheld")).texture("layer0",
                 new ResourceLocation(ArcaneMod.MOD_ID, "item/" + item.getId().getPath()));
    }


    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ArcaneMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ArcaneMod.MOD_ID, "block/" + item.getId().getPath()));
    }





}
