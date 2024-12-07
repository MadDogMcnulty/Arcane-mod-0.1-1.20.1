package net.Jackson.arcanemod.block;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.custom.GemstoneRefineryBlock;
import net.Jackson.arcanemod.block.custom.SoundBlock;
import net.Jackson.arcanemod.block.custom.TaintedWheatCropBlock;
import net.Jackson.arcanemod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArcaneMod.MOD_ID);



    public static final RegistryObject<Block> GEMSTONE_BLOCK = registerBlock("gemstone_block",
            () -> new Block (BlockBehaviour.Properties.copy(Blocks.SHROOMLIGHT).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PILTOVER_BLOCK = registerBlock("piltover_block",
            () -> new Block (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.POLISHED_DEEPSLATE)));

    public static final RegistryObject<Block> PILTOVER_STAIRS = registerBlock("piltover_stairs",
            () -> new StairBlock(() -> ModBlocks.PILTOVER_BLOCK.get().defaultBlockState(),
                    (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.DEEPSLATE_BRICKS))));

    public static final RegistryObject<Block> PILTOVER_SLAB = registerBlock("piltover_slab",
            () -> new SlabBlock (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.DEEPSLATE_BRICKS)));

    public static final RegistryObject<Block> PILTOVER_BUTTON = registerBlock("piltover_button",
            () -> new ButtonBlock (BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.MUD_BRICKS),
                    BlockSetType.IRON, 10, true));

    public static final RegistryObject<Block> PILTOVER_PRESSURE_PLATE = registerBlock("piltover_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> PILTOVER_FENCE = registerBlock("piltover_fence",
            () -> new FenceBlock (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.MUD_BRICKS)));

    public static final RegistryObject<Block> PILTOVER_FENCE_GATE = registerBlock("piltover_fence_gate",
            () -> new FenceGateBlock (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.MUD_BRICKS),
                    SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));

    public static final RegistryObject<Block> PILTOVER_WALL = registerBlock("piltover_wall",
            () -> new WallBlock (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.MUD_BRICKS)));

    public static final RegistryObject<Block> PILTOVER_DOOR = registerBlock("piltover_door",
            () -> new DoorBlock (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().sound(SoundType.MUD_BRICKS),
                    BlockSetType.DARK_OAK));

    public static final RegistryObject<Block> PILTOVER_TRAPDOOR = registerBlock("piltover_trapdoor",
            () -> new TrapDoorBlock (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().sound(SoundType.MUD_BRICKS),
                    BlockSetType.DARK_OAK));

    public static final RegistryObject<Block> TAINTED_WHEAT_CROP = BLOCKS.register("tainted_wheat_crop",
            () -> new TaintedWheatCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> TAINTED_FLOWER = registerBlock("tainted_flower",
            () -> new FlowerBlock(MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> POTTED_TAINTED_FLOWER = registerBlock("potted_tainted_flower",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.TAINTED_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));



    //Machines

    public static final RegistryObject<Block> GEMSTONE_REFINERY = registerBlock("gemstone_refinery",
            () -> new GemstoneRefineryBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));










    public static final RegistryObject<Block> GEMSTONE_ORE = registerBlock("gemstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> DEEPSLATE_GEMSTONE_ORE = registerBlock("deepslate_gemstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3,7)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,  toReturn);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
