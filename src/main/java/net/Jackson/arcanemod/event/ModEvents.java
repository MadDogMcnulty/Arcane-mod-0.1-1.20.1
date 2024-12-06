package net.Jackson.arcanemod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import java.util.List;

@Mod.EventBusSubscriber(modid = ArcaneMod.MOD_ID)

public class ModEvents {


// Cleric Trading
// My vision is to have villagers primarily sell shimmer/chem related stuff, wandering trader can sell gemstones
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1
            trades.get(1).add((Entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 28),
                    new ItemStack(ModItems.SHIMMER_SYRINGE.get(), 2),
                    10,15,0.02f));

            // Level 2
            trades.get(2).add((Entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    new ItemStack(ModItems.TAINTED_ROTTEN_FLESH.get(), 3),
                    10,22,0.04f));

        }

        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.SHARPNESS, 2));

            // Level 1 - enchanted book for wheat
            trades.get(1).add((Entity, randomSource) -> new MerchantOffer(
                    new ItemStack(ModItems.TAINTED_WHEAT.get(), 20),
                    enchantedBook, 10,15,0.02f));
        }
    }

    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((Entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 27),
                new ItemStack(ModItems.GEMSTONE_SHARD.get(), 4),
                1,2,0.2f));

        genericTrades.add((Entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 35),
                new ItemStack(ModItems.GEMSTONE.get(), 1),
                1,2,0.2f));

        rareTrades.add((Entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 50),
                new ItemStack(ModItems.WORLD_RUNE_ACCELERATE.get(), 1),
                1,2,0.2f));

        rareTrades.add((Entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 64),
                new ItemStack(ModItems.WORLD_RUNE_RESOLVE.get(), 1),
                1,2,0.2f));

    }

}
