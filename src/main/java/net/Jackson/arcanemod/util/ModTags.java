package net.Jackson.arcanemod.util;

import net.Jackson.arcanemod.ArcaneMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> PILTOVER_BLOCK_TYPE = tag("piltover_block_type");
        public static final TagKey<Block> NEEDS_HEXTECH_TOOL = tag("needs_hextech_tool");



        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ArcaneMod.MOD_ID, name));


            }
    }

    public static class Items {

        public static final TagKey<Item> HAS_SHIMMER = tag("has_shimmer.json");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ArcaneMod.MOD_ID, name));
        }

        public static final TagKey<Item> HAS_TAINTED = Taintedtag("has_tainted.json");

        public static final TagKey<Item> Taintedtag(String name) {
            return ItemTags.create(new ResourceLocation(ArcaneMod.MOD_ID, name));
        }
    }


}
