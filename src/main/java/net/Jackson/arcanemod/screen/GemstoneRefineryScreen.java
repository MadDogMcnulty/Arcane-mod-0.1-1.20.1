package net.Jackson.arcanemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.Jackson.arcanemod.ArcaneMod;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GemstoneRefineryScreen extends AbstractContainerScreen<GemstoneRefineryMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ArcaneMod.MOD_ID, "textures/gui/gemstone_refinery_gui.png");

    public GemstoneRefineryScreen(GemstoneRefineryMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;


    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE,x + 50, y + 34, 176, 0 ,22, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics GuiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(GuiGraphics);
        super.render(GuiGraphics, mouseX, mouseY, delta);
        renderTooltip(GuiGraphics, mouseX, mouseY);
    }
}

