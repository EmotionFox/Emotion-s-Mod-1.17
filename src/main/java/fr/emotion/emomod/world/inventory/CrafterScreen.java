package fr.emotion.emomod.world.inventory;

import java.util.Objects;

import com.mojang.blaze3d.platform.GlStateManager;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.inventory.container.CrafterContainer;
import fr.emotion.emomod.network.EmomodPacketHandler;
import fr.emotion.emomod.network.PacketCrafter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrafterScreen extends ContainerScreen<CrafterContainer>
{
	private static final ResourceLocation CRAFTER_GUI_SCREEN = new ResourceLocation(MainRegistry.MOD_ID, "textures/gui/container/crafter.png");
	int craftWidth = 68;
	int craftHeight = 69;
	int buttonWidth = 14;
	int buttonHeight = 14;
	int arrowWidth = 10;
	int arrowHeight = 10;

	int b1X, b2X = 0;
	int b1Y, b2Y = 0;

	boolean b1 = true;
	boolean b2 = false;
	boolean b1h = false;
	boolean b2h = false;

	public int currentPage = 0;
	public int maxPage = 0;

	public String[] tags;

	private TextFieldWidget searchField;

	public CrafterScreen(CrafterContainer container, PlayerInventory inv, ITextComponent title)
	{
		super(container, inv, title);
		this.ySize = 114;
		this.xSize = 195;
		this.init();
	}

	@Override
	public void tick()
	{
		this.container.tick();

		this.maxPage = this.container.getMaxPage();

		if (this.searchField != null)
			this.searchField.tick();
	}

	@Override
	protected void init()
	{
		super.init();
		this.searchField = new TextFieldWidget(this.font, this.guiLeft + 10, this.guiTop + 6, 80, 9, I18n.format("itemGroup.search"));
		this.searchField.setMaxStringLength(50);
		this.searchField.setEnableBackgroundDrawing(false);
		this.searchField.setVisible(true);
		this.searchField.setTextColor(16777215);
		this.children.add(this.searchField);
	}

	@Override
	public void resize(Minecraft p_resize_1_, int p_resize_2_, int p_resize_3_)
	{
		String s = this.searchField.getText();
		super.resize(p_resize_1_, p_resize_2_, p_resize_3_);
		this.searchField.setText(s);

		if (!this.searchField.getText().isEmpty())
			this.setInventory();
	}

	@Override
	public boolean charTyped(char character, int value)
	{
		String s = this.searchField.getText();

		if (this.searchField.charTyped(character, value))
		{
			if (!Objects.equals(s, this.searchField.getText()))
				this.setInventory();

			return true;
		} else
			return super.charTyped(character, value);
	}

	@Override
	public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_)
	{
		String s = this.searchField.getText();
		if (this.searchField.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_))
		{
			if (!Objects.equals(s, this.searchField.getText()))
				this.setInventory();

			return true;
		} else
		{
			return this.searchField.isFocused() && this.searchField.getVisible() && p_keyPressed_1_ != 256 ? true : super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
		}
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton)
	{
		if (mouseX >= b1X && mouseX < b1X + buttonWidth && mouseY >= b1Y && mouseY < b1Y + buttonHeight)
			this.changePage(false);
		else if (mouseX >= b2X && mouseX < b2X + buttonWidth && mouseY >= b2Y && mouseY < b2Y + buttonHeight)
			this.changePage(true);

		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public void mouseMoved(double mouseX, double mouseY)
	{
		if (mouseX >= b1X && mouseX < b1X + buttonWidth && mouseY >= b1Y && mouseY < b1Y + buttonHeight)
		{
			b2h = false;

			if (!this.b1)
			{
				b1h = true;
			}
		} else if (mouseX >= b2X && mouseX < b2X + buttonWidth && mouseY >= b2Y && mouseY < b2Y + buttonHeight)
		{
			b1h = false;

			if (!this.b2)
			{
				b2h = true;
			}
		} else
		{
			b1h = false;
			b2h = false;
		}

		super.mouseMoved(mouseX, mouseY);
	}

	@Override
	public boolean mouseScrolled(double mouseX, double mouseY, double scroll)
	{
		this.changePage(scroll >= 1 ? false : true);
		this.setInventory();

		return super.mouseScrolled(mouseX, mouseY, scroll);
	}

	public void changePage(boolean up)
	{
		if (up)
		{
			if (this.currentPage < this.maxPage)
			{
				this.playerInventory.player.playSound(SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, 1.0f, 1.0f);
				this.currentPage++;
				this.setInventory();
			}

			if (this.currentPage == this.maxPage)
				this.b2 = true;
			else if (this.currentPage > 0)
				this.b1 = false;
		} else
		{
			if (this.currentPage > 0)
			{
				this.playerInventory.player.playSound(SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, 1.0f, 1.0f);
				this.currentPage--;
				this.setInventory();
			}

			if (this.currentPage == 0)
				this.b1 = true;
			else if (this.currentPage < this.maxPage)
				this.b2 = false;
		}
	}

	public void setInventory()
	{
		this.tags = new String[this.searchField.getText().split("\\s+").length];

		for (int i = 0; i < this.searchField.getText().split("\\s+").length; i++)
		{
			this.tags[i] = this.searchField.getText().split("\\s+")[i];
		}

		this.container.setInventory(this.currentPage, this.tags);
		EmomodPacketHandler.INSTANCE.sendToServer(new PacketCrafter(this.currentPage, this.tags));
	}

	public void render(int mouseX, int mouseY, float partialTicks)
	{
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String page = this.getTitle().getFormattedText() + " - " + this.currentPage + "/" + this.maxPage;
		this.font.drawString("Recipe Plan", -(this.craftWidth + this.font.getStringWidth("Recipe Plan")) / 2, 21.0f - 2.0f, 16777215);
		this.font.drawStringWithShadow(page, (this.xSize / 2) - (this.font.getStringWidth(page) / 2), -9, 16777215);
	}

	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		int xPos = (this.width - this.xSize) / 2;
		int yPos = (this.height - this.ySize) / 2;
		int craftX = ((this.width - this.xSize) / 2) - this.craftWidth;
		int craftY = ((this.height - this.ySize) / 2) + 28;

		b1X = ((this.width + this.xSize) / 2) - 21;
		b1Y = ((this.height - this.ySize) / 2) + 17;
		b2X = ((this.width + this.xSize) / 2) - 21;
		b2Y = ((this.height - this.ySize) / 2) + 93;

		int labelX = craftX;
		int labelY = craftY - 11;
		int labelWidth = labelX + this.craftWidth;
		int labelHeight = craftY + 2;

		GlStateManager.disableTexture();
		GlStateManager.enableBlend();
		GlStateManager.disableAlphaTest();
		GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.shadeModel(7425);
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos((double) labelWidth, (double) labelY, (double) this.blitOffset).color(0, 0, 0, 0).endVertex();
		bufferbuilder.pos((double) labelX, (double) labelY, (double) this.blitOffset).color(0, 0, 0, 0).endVertex();
		bufferbuilder.pos((double) labelX, (double) labelHeight, (double) this.blitOffset).color(255, 255, 255, 255).endVertex();
		bufferbuilder.pos((double) labelWidth, (double) labelHeight, (double) this.blitOffset).color(255, 255, 255, 255).endVertex();
		tessellator.draw();
		GlStateManager.shadeModel(7424);
		GlStateManager.disableBlend();
		GlStateManager.enableAlphaTest();
		GlStateManager.enableTexture();

		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(CRAFTER_GUI_SCREEN);

		this.blit(xPos, yPos, 0, 0, this.xSize, this.ySize);
		this.blit(craftX, craftY, 0, this.ySize, this.craftWidth, this.craftHeight);
		this.blit(b1X, b1Y, 256 - buttonWidth, 0 + (b1 ? this.buttonHeight : !b1 && b1h ? this.buttonHeight * 2 : 0), this.buttonWidth, this.buttonHeight);
		this.blit(b2X, b2Y, 256 - buttonWidth, 0 + (b2 ? this.buttonHeight : !b2 && b2h ? this.buttonHeight * 2 : 0), this.buttonWidth, this.buttonHeight);
		this.blit(b1X + 2, b1Y + 2, this.xSize, 0 + (b1 ? this.arrowHeight : !b1 && b1h ? this.arrowHeight * 2 : 0), this.arrowWidth, this.arrowHeight);
		this.blit(b2X + 2, b2Y + 2, this.xSize + this.arrowWidth, 0 + (b2 ? this.arrowHeight : !b2 && b2h ? this.arrowHeight * 2 : 0), this.arrowWidth, this.arrowHeight);

		this.searchField.render(mouseX, mouseY, partialTicks);
	}
}
