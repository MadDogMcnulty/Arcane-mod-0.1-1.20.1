package net.Jackson.arcanemod.item;


import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArcaneMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> ARCANE_TAB = CREATIVE_MODE_TABS.register("arcane_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GEMSTONE.get()))
                .title(Component.translatable("creativetab.arcane_tab"))
                .displayItems((pParameters, pOutput) -> {

                      pOutput.accept(ModBlocks.GEMSTONE_ORE.get());
                      pOutput.accept(ModBlocks.DEEPSLATE_GEMSTONE_ORE.get());
                      pOutput.accept(ModBlocks.GEMSTONE_BLOCK.get());
                      pOutput.accept(ModBlocks.SOUND_BLOCK.get());

                      pOutput.accept(ModBlocks.PILTOVER_BLOCK.get());
                      pOutput.accept(ModBlocks.PILTOVER_FENCE.get());
                      pOutput.accept(ModBlocks.PILTOVER_FENCE_GATE.get());
                      pOutput.accept(ModBlocks.PILTOVER_DOOR.get());
                      pOutput.accept(ModBlocks.PILTOVER_TRAPDOOR.get());
                      pOutput.accept(ModBlocks.PILTOVER_WALL.get());
                      pOutput.accept(ModBlocks.PILTOVER_STAIRS.get());
                      pOutput.accept(ModBlocks.PILTOVER_BUTTON.get());
                      pOutput.accept(ModBlocks.PILTOVER_PRESSURE_PLATE.get());
                      pOutput.accept(ModBlocks.PILTOVER_SLAB.get());

                    //Machines
                      pOutput.accept(ModBlocks.GEMSTONE_REFINERY.get());

                      pOutput.accept(ModItems.ZDRIVE.get());
                      pOutput.accept(ModItems.GEMSTONE.get());
                      pOutput.accept(ModItems.REFINED_GEMSTONE.get());
                      pOutput.accept(ModItems.GEMSTONE_SHARD.get());
                      pOutput.accept(ModItems.GEMSTONE_SHARD_PILE.get());
                      pOutput.accept(ModItems.WORLD_RUNE_ACCELERATE.get());
                      pOutput.accept(ModItems.WORLD_RUNE_PRECISION.get());
                      pOutput.accept(ModItems.WORLD_RUNE_DOMINATION.get());
                      pOutput.accept(ModItems.WORLD_RUNE_SORCERY.get());
                      pOutput.accept(ModItems.WORLD_RUNE_RESOLVE.get());


                      //Hextech tools
                      pOutput.accept(ModItems.HEXTECH_SWORD.get());
                      pOutput.accept(ModItems.HEXTECH_PICKAXE.get());
                      pOutput.accept(ModItems.HEXTECH_AXE.get());
                      pOutput.accept(ModItems.HEXTECH_SHOVEL.get());
                      pOutput.accept(ModItems.HEXTECH_HOE.get());

                      //Hextech armor if i get around to it
//                      pOutput.accept(ModItems.HEXTECH_HELMET.get());
//                      pOutput.accept(ModItems.HEXTECH_CHESTPLATE.get());
//                      pOutput.accept(ModItems.HEXTECH_LEGGINGS.get());
//                      pOutput.accept(ModItems.HEXTECH_BOOTS.get());


                      //Hex Tainted stuff

                      pOutput.accept(ModItems.TAINTED_ROTTEN_FLESH.get());
                      pOutput.accept(ModItems.TAINTED_SEEDS.get());
                      pOutput.accept(ModItems.TAINTED_WHEAT.get());
                      pOutput.accept(ModBlocks.TAINTED_FLOWER.get());

                      //Shimmer
                      pOutput.accept(ModItems.SHIMMER_SYRINGE.get());

                      //Music Discs
                      pOutput.accept(ModItems.DYNASTIES_DYSTOPIA_MUSIC_DISC.get());





                })
                .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
