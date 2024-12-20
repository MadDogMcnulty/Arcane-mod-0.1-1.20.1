package net.Jackson.arcanemod.block.entity;

import net.Jackson.arcanemod.item.ModItems;
import net.Jackson.arcanemod.screen.HexcoreMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HexcoreBlockEntity extends BlockEntity implements MenuProvider {

    public final List<String> selectedRunes = new ArrayList<>(); // Stores activated runes
    private boolean effectApplied = false;

    protected final ContainerData data;

    public HexcoreBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.HEXCORE_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                if (pIndex == 0) {
                    return selectedRunes.size(); // Return the current rune count
                }
                return 0;
            }

            @Override
            public void set(int pIndex, int pValue) {
                if (pIndex == 0) {
                    // You can handle the rune count or other data updates here if needed
                }
            }

            @Override
            public int getCount() {
                return 1; // You only need to track one value here (the rune count)
            }
        };
    }

    // In HexcoreBlockEntity class
    public void drops() {
        // Logic to drop items when the block is removed.
        // Example: Drop items stored in the block, or any custom drops.
        if (this.getLevel() != null && !this.getLevel().isClientSide) {
            // Create a list of items to drop
            ItemStack itemStack = new ItemStack(ModItems.REFINED_GEMSTONE.get()); // Just an example item
            Block.popResource(this.getLevel(), this.getBlockPos(), itemStack);
        }
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("block.arcanemod.hexcore");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new HexcoreMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("rune_count", selectedRunes.size());
        for (int i = 0; i < selectedRunes.size(); i++) {
            pTag.putString("rune_" + i, selectedRunes.get(i));
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        selectedRunes.clear();
        int count = pTag.getInt("rune_count");
        for (int i = 0; i < count; i++) {
            selectedRunes.add(pTag.getString("rune_" + i));
        }
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (effectApplied) {
            return;
        }

        if (canApplyEffect()) {
            applyEffect(pLevel, pPos);
        }
    }

    /**
     * Adds a rune to the selection.
     * @param runeName The name of the rune activated by the button.
     */
    public void activateRune(String runeName) {
        if (selectedRunes.size() < 3) {
            selectedRunes.add(runeName);
        }
    }

    /**
     * Clears the selected runes.
     */
    public void clearRunes() {
        selectedRunes.clear();
    }


    /**
     * Processes the selected runes to check for valid effects.
     */
    public void acceptRunes() {
        if (canApplyEffect()) {
            effectApplied = true;
        }
    }

    private boolean canApplyEffect() {
        return selectedRunes.size() == 3;
    }

    private void applyEffect(Level pLevel, BlockPos pPos) {
        Map<String, Runnable> runeEffects = new HashMap<>();
        runeEffects.put("Domination+Resolve+Sorcery", () -> {
            // Example effect logic
            // Apply an effect, trigger an event, or perform any necessary action
            System.out.println("Effect Applied: Domination + Resolve + Sorcery");
        });

        String combinedRunes = getCombinedRunes();

        if (runeEffects.containsKey(combinedRunes)) {
            runeEffects.get(combinedRunes).run();
        }

        clearRunes();
        effectApplied = false;
    }

    private String getCombinedRunes() {
        return String.join("+", selectedRunes);
    }
}
