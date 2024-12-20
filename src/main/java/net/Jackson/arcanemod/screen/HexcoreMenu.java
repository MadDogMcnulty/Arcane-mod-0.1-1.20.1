package net.Jackson.arcanemod.screen;

import net.Jackson.arcanemod.block.entity.HexcoreBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class HexcoreMenu extends AbstractContainerMenu {

    private final HexcoreBlockEntity hexblockEntity; // Non-static block entity
    private final ContainerData data;

    // Constructor used for the server-side menu
    public HexcoreMenu(int containerId, Inventory playerInventory, HexcoreBlockEntity blockEntity, ContainerData data) {
        super(ModMenuTypes.HEXCORE_MENU.get(), containerId);
        this.hexblockEntity = blockEntity;
        this.data = data;
    }

    // Constructor used for the client-side menu
    public HexcoreMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory,
                (HexcoreBlockEntity) playerInventory.player.level().getBlockEntity(extraData.readBlockPos()),
                new ContainerData() {
                    @Override
                    public int get(int index) { return 0; }
                    @Override
                    public void set(int index, int value) {}
                    @Override
                    public int getCount() { return 0; }
                }
        );
    }

    public HexcoreBlockEntity getBlockEntity() {
        return this.hexblockEntity; // returns the HexcoreBlockEntity instance
    }


    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        boolean valid = stillValid(ContainerLevelAccess.create(hexblockEntity.getLevel(), hexblockEntity.getBlockPos()),
                player,
                hexblockEntity.getBlockState().getBlock());
        if (!valid) {
            System.out.println("Hexcore Menu invalidated!");
        }
        return valid;
    }


    private void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        for (int hotbar = 0; hotbar < 9; ++hotbar) {
            this.addSlot(new Slot(playerInventory, hotbar, 8 + hotbar * 18, 142));
        }
    }

    public void activateRune(String runeName) {
        hexblockEntity.activateRune(runeName);
    }

    public void acceptRunes() {
        hexblockEntity.acceptRunes();
    }

    public void clearRunes() {
        hexblockEntity.clearRunes();
    }
}

