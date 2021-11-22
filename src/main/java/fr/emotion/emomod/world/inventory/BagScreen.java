package fr.emotion.emomod.world.inventory;

import com.mojang.blaze3d.vertex.PoseStack;

import fr.emotion.emomod.inventory.container.BagContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.HopperScreen;
import net.minecraft.world.inventory.RecipeBookMenu;

public class BagScreen extends AbstractContainerScreen<BagContainer>
{
	private static final ResourceLocation BAG_GUI_SCREEN = new ResourceLocation(MainRegistry.MOD_ID, "textures/gui/bag.png");

	public BagScreen(BagContainer container, PlayerInventory inv, ITextComponent titleIn)
	{
		super(container, inv, titleIn);
		this.xSize = 176;
		this.ySize = 127;
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
		this.font.drawString(this.getTitle().getFormattedText(), 8, 4, 4210752);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		int xPos = (this.width - this.xSize) / 2;
		int yPos = (this.height - this.ySize) / 2;

		GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(BAG_GUI_SCREEN);

		this.blit(xPos, yPos, 0, 0, this.xSize, this.ySize);
	}


	@Override
	protected void renderBg(PoseStack p_97787_, float p_97788_, int p_97789_, int p_97790_)
	{
		// TODO Auto-generated method stub
		
	}
}
