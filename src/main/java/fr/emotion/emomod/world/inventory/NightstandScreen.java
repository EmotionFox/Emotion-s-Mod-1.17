package fr.emotion.emomod.world.inventory;

import com.mojang.blaze3d.platform.GlStateManager;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.inventory.container.NightstandContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NightstandScreen extends ContainerScreen<NightstandContainer>
{
	private static final ResourceLocation NIGHTSTAND_GUI_SCREEN = new ResourceLocation(MainRegistry.MOD_ID, "textures/gui/container/nightstand.png");
	private float[] color;

	public NightstandScreen(NightstandContainer screenContainer, PlayerInventory playerInventory, ITextComponent titleIn, float[] color)
	{
		super(screenContainer, playerInventory, titleIn);
		this.xSize = 176;
		this.ySize = 127;
		this.color = color;
	}

	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_)
	{
		this.renderBackground();
		super.render(p_render_1_, p_render_2_, p_render_3_);
		this.renderHoveredToolTip(p_render_1_, p_render_2_);
	}

	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.font.drawString(this.getTitle().getFormattedText(), 8, 4, 0);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 0);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		int xPos = (this.width - this.xSize) / 2;
		int yPos = (this.height - this.ySize) / 2;

		GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(NIGHTSTAND_GUI_SCREEN);
		this.blit(xPos, yPos, 0, 0, this.xSize, this.ySize);

		GlStateManager.color4f(color[0] / 255, color[1] / 255, color[2] / 255, 1.0f);
		this.blit(xPos, yPos, 0, 0, this.xSize, this.ySize);

		GlStateManager.disableTexture();
		GlStateManager.enableBlend();
		GlStateManager.disableAlphaTest();
		GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.shadeModel(7425);
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos((double) xPos + this.xSize, (double) yPos, (double) this.blitOffset).color(0, 0, 0, 0).endVertex();
		bufferbuilder.pos((double) xPos, (double) yPos, (double) this.blitOffset).color(0, 0, 0, 0).endVertex();
		bufferbuilder.pos((double) xPos, (double) yPos + this.ySize, (double) this.blitOffset).color(0, 0, 0, 255 / 2).endVertex();
		bufferbuilder.pos((double) xPos + this.xSize, (double) yPos + this.ySize, (double) this.blitOffset).color(0, 0, 0, 255 / 2).endVertex();
		tessellator.draw();
		GlStateManager.shadeModel(7424);
		GlStateManager.disableBlend();
		GlStateManager.enableAlphaTest();
		GlStateManager.enableTexture();
	}
}
