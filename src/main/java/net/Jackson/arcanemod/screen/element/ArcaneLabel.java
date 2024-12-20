package net.Jackson.arcanemod.screen.element;

import net.Jackson.arcanemod.block.entity.HexcoreBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ArcaneLabel extends AbstractWidget {
private final HexcoreBlockEntity blockEntity;


    public ArcaneLabel(int pX, int pY, int pWidth, int pHeight, Component pMessage, HexcoreBlockEntity blockEntity) {
        super(pX, pY, pWidth, pHeight, pMessage);
        this.blockEntity = blockEntity;



    }



    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {

        // Combine the selected runes into a string
        List<String> runes = blockEntity.selectedRunes;
        String runeText = runes.isEmpty() ? "No Runes Selected" : String.join(" + ", runes);


        // Draw the label
        guiGraphics.drawString(
                Minecraft.getInstance().font, // Font renderer
                runeText,                // Text content
                this.getX(),             // X position
                this.getY(),             // Y position
                0xFFFFFF                 // White color
        );
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
        this.defaultButtonNarrationText(narrationElementOutput);
    }
}
