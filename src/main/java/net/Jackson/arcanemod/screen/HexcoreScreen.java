package net.Jackson.arcanemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.Jackson.arcanemod.ArcaneMod;
import net.Jackson.arcanemod.block.entity.HexcoreBlockEntity;
import net.Jackson.arcanemod.screen.element.ArcaneButton;
import net.Jackson.arcanemod.screen.element.ArcaneLabel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.awt.*;


public class HexcoreScreen extends AbstractContainerScreen<HexcoreMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ArcaneMod.MOD_ID, "textures/gui/hexcore_gui.png");

    public HexcoreScreen(HexcoreMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }




    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;

        HexcoreBlockEntity hexBlockEntity = menu.getBlockEntity();  // Now you can call getBlockEntity()

        // Custom button for runes
        ArcaneButton domination = new ArcaneButton(
                this.leftPos + 10,
                this.topPos + 10,
                80,
                20,
                Component.literal("Activate Rune"),
                new ResourceLocation("arcanemod", "textures/gui/world_rune_domination"),
                () -> menu.activateRune("Domination")
        );

        // Add the ArcaneLabel widget
        this.addRenderableWidget(new ArcaneLabel(
                this.leftPos + 10, // X position
                this.topPos + 30,  // Y position
                200,              // Width
                20,               // Height
                Component.literal(" "), // Initial message (can be empty)
                hexBlockEntity     // Pass the HexcoreBlockEntity
        ));


            // Handle the click

        // IF YOU OPEN TO THIS SCREEN YOU ARE TRYING TO MAKE A LABEL FOR THE MENU!!!!!!



    }



    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);


    }



    @Override
    public void render(GuiGraphics GuiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(GuiGraphics);
        super.render(GuiGraphics, mouseX, mouseY, delta);
        renderTooltip(GuiGraphics, mouseX, mouseY);
    }
}

