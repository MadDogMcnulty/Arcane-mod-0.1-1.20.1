package net.Jackson.arcanemod.screen.element;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ArcaneButton extends AbstractWidget {

    private final ResourceLocation texture;
    private final Runnable onClick;

    public ArcaneButton(int x, int y, int width, int height, Component message, ResourceLocation texture, Runnable onClick) {
        super(x, y, width, height, message);
        this.texture = texture;
        this.onClick = onClick;
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        // Bind and render the button texture
        RenderSystem.setShaderTexture(0, texture);

        // Choose the texture offset based on hover state
        int textureYOffset = this.isHoveredOrFocused() ? height : 0;
        guiGraphics.blit(texture, getX(), getY(), 0, textureYOffset, width, height);

        // Render the button text centered
        int textColor = this.isHoveredOrFocused() ? 0xFFFFA0 : 0xE0E0E0;
        guiGraphics.drawCenteredString(
                Minecraft.getInstance().gui.getFont(),  // Use the FontRenderer from GuiGraphics
                this.getMessage(),
                this.getX() + this.width / 2,
                this.getY() + (this.height - 8) / 2,
                textColor
        );
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.isHoveredOrFocused()) {
            this.onClick.run();
            return true;
        }
        return false;
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
        narrationElementOutput.add(NarratedElementType.TITLE, this.getMessage());
    }
}
