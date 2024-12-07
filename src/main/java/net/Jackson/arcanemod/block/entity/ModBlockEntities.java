package net.Jackson.arcanemod.block.entity;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArcaneMod.MOD_ID);


    public static final RegistryObject<BlockEntityType<GemstoneRefineryBlockEntity>> GEMSTONE_REFINERY_BE =
            BLOCK_ENTITIES.register("gemstone_refinery_be", () ->
                    BlockEntityType.Builder.of(GemstoneRefineryBlockEntity::new,
                            ModBlocks.GEMSTONE_REFINERY.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
