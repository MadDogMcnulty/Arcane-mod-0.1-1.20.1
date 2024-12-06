package net.Jackson.arcanemod.item;

import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.ModBlocks;
import net.Jackson.arcanemod.item.custom.*;
import net.Jackson.arcanemod.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArcaneMod.MOD_ID);

    //Hextech adjacent
    public static final RegistryObject<Item> GEMSTONE_SHARD = ITEMS.register("gemstone_shard",
            () -> new FuelItem(new Item.Properties(), 1000));
    public static final RegistryObject<Item> GEMSTONE_SHARD_PILE = ITEMS.register("gemstone_shard_pile",
            () -> new FuelItem(new Item.Properties(), 4000));

    public static final RegistryObject<Item> GEMSTONE = ITEMS.register("gemstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REFINED_GEMSTONE = ITEMS.register("refined_gemstone",
            () -> new RefinedGemstoneItem(new Item.Properties()));

    public static final RegistryObject<Item> WORLD_RUNE_ACCELERATE = ITEMS.register("world_rune_accelerate",
            () -> new AccelerateRuneItem(new Item.Properties()));

    public static final RegistryObject<Item> WORLD_RUNE_PRECISION = ITEMS.register("world_rune_precision",
            () -> new PrecisionRuneItem(new Item.Properties()));

    public static final RegistryObject<Item> WORLD_RUNE_DOMINATION = ITEMS.register("world_rune_domination",
            () -> new DominationRuneItem(new Item.Properties()));

    public static final RegistryObject<Item> WORLD_RUNE_SORCERY = ITEMS.register("world_rune_sorcery",
            () -> new SorceryRuneItem(new Item.Properties()));

    public static final RegistryObject<Item> WORLD_RUNE_RESOLVE = ITEMS.register("world_rune_resolve",
            () -> new ResolveRuneItem(new Item.Properties()));

    public static final RegistryObject<Item> ZDRIVE = ITEMS.register("zdrive",
            () -> new Item(new Item.Properties().stacksTo(1)));

    //Music Discs
    public static final RegistryObject<Item> DYNASTIES_DYSTOPIA_MUSIC_DISC = ITEMS.register("dynasties_dystopia_music_disc",
            () -> new RecordItem(6, ModSounds.DYNASTIES_DYSTOPIA, new Item.Properties().stacksTo(1),3096));

    //Hextech Tools
    public static final RegistryObject<Item> HEXTECH_SWORD = ITEMS.register("hextech_sword",
            () -> new SwordItem(ModToolTiers.HEX, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> HEXTECH_PICKAXE = ITEMS.register("hextech_pickaxe",
            () -> new PickaxeItem(ModToolTiers.HEX, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> HEXTECH_AXE = ITEMS.register("hextech_axe",
            () -> new AxeItem(ModToolTiers.HEX, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> HEXTECH_SHOVEL = ITEMS.register("hextech_shovel",
            () -> new ShovelItem(ModToolTiers.HEX, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> HEXTECH_HOE = ITEMS.register("hextech_hoe",
            () -> new HoeItem(ModToolTiers.HEX, 0, 0, new Item.Properties()));

    //Hextech armor
    public static final RegistryObject<Item> HEXTECH_HELMET = ITEMS.register("hextech_helmet",
            () -> new ArmorItem(ModArmorMaterials.GEMSTONE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HEXTECH_CHESTPLATE = ITEMS.register("hextech_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GEMSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HEXTECH_LEGGINGS = ITEMS.register("hextech_leggings",
            () -> new ArmorItem(ModArmorMaterials.GEMSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HEXTECH_BOOTS = ITEMS.register("hextech_boots",
            () -> new ArmorItem(ModArmorMaterials.GEMSTONE, ArmorItem.Type.BOOTS, new Item.Properties()));


    //Hex Tainted items

    public static final RegistryObject<Item> TAINTED_ROTTEN_FLESH = ITEMS.register("tainted_rotten_flesh",
            () -> new Item(new Item.Properties().food(ModFoods.TAINTED_ROTTEN_FLESH)));

    //Crops
    public static final RegistryObject<Item> TAINTED_SEEDS = ITEMS.register("tainted_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TAINTED_WHEAT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> TAINTED_WHEAT = ITEMS.register("tainted_wheat",
            () -> new Item(new Item.Properties()));

    //Shimmer Items
    public static final RegistryObject<Item> SHIMMER_SYRINGE = ITEMS.register("shimmer_syringe",
            () -> new Item(new Item.Properties().food(ModFoods.SHIMMER_SYRINGE)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
