package ocean.chinacraft.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.screen.StoneMortarScreenHandler;

public class StoneMortarScreen extends HandledScreen<StoneMortarScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(
            Chinacraft.MODID,"textures/gui/stone_mortar_block.png");

    public StoneMortarScreen(StoneMortarScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices,mouseX,mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int x = (width - backgroundWidth) /2;
        int t = (height - backgroundHeight) / 2;
        drawTexture(matrices,x,y,0,0,backgroundWidth,backgroundHeight);
        if(handler.isCrafting()) {
            drawTexture(matrices, x + 73, y + 29, 176, 0, handler.getScaledProgress(), 19);
        }
    }
}
