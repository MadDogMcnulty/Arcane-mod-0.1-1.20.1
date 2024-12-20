package net.Jackson.arcanemod.datagen;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.ModBlocks;
import net.Jackson.arcanemod.block.custom.TaintedWheatCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ArcaneMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //custom models
        blockWithItem(ModBlocks.GEMSTONE_BLOCK);
        blockWithItem(ModBlocks.PILTOVER_BLOCK);
        blockWithItem(ModBlocks.GEMSTONE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_GEMSTONE_ORE);

        //custom blocks
        blockWithItem(ModBlocks.SOUND_BLOCK);

        simpleBlockWithItem(ModBlocks.GEMSTONE_REFINERY.get(),
            new ModelFile.UncheckedModelFile(modLoc("block/gemstone_refinery")));

        simpleBlockWithItem(ModBlocks.HEXCORE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/hexcore")));

        stairsBlock(((StairBlock) ModBlocks.PILTOVER_STAIRS.get()), blockTexture(ModBlocks.PILTOVER_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.PILTOVER_SLAB.get()), blockTexture(ModBlocks.PILTOVER_BLOCK.get()),
                blockTexture(ModBlocks.PILTOVER_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PILTOVER_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PILTOVER_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.PILTOVER_BUTTON.get()), blockTexture(ModBlocks.PILTOVER_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.PILTOVER_WALL.get()), blockTexture(ModBlocks.PILTOVER_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.PILTOVER_FENCE.get()), blockTexture(ModBlocks.PILTOVER_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PILTOVER_FENCE_GATE.get()), blockTexture(ModBlocks.PILTOVER_BLOCK.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.PILTOVER_DOOR.get()), modLoc("block/piltover_door_bottom"),
                modLoc("block/piltover_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PILTOVER_TRAPDOOR.get()),
                modLoc("block/piltover_trapdoor"), true, "cutout");


        makeTaintedWheatCrop((CropBlock) ModBlocks.TAINTED_WHEAT_CROP.get(),
                "tainted_wheat_stage", "tainted_wheat_stage");


        simpleBlockWithItem(ModBlocks.TAINTED_FLOWER.get(), models().cross(blockTexture(ModBlocks.TAINTED_FLOWER.get()).getPath(),
                blockTexture(ModBlocks.TAINTED_FLOWER.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_TAINTED_FLOWER.get(), models().singleTexture("potted_tainted_flower", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.TAINTED_FLOWER.get())).renderType("cutout"));

    }

    public void makeTaintedWheatCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> wheatStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] wheatStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TaintedWheatCropBlock) block).getAgeProperty()),
                new ResourceLocation(ArcaneMod.MOD_ID, "block/" + textureName + state.getValue(((TaintedWheatCropBlock) block)
                        .getAgeProperty()))).renderType("cutout"));

        return models;
    }



    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll((blockRegistryObject.get())));
    }



}
