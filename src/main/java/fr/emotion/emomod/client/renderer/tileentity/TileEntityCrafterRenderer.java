package fr.emotion.emomod.client.renderer.tileentity;

import com.mojang.blaze3d.platform.GlStateManager;

import fr.emotion.emomod.blocks.EmoCrafter;
import fr.emotion.emomod.tileentity.TileEntityCrafter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class TileEntityCrafterRenderer extends TileEntityRenderer<TileEntityCrafter>
{
	@Override
	public void render(TileEntityCrafter tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage)
	{
		if (this.getWorld().getBlockState(tileEntityIn.getPos()).get(EmoCrafter.ENABLED))
		{
			if (this.getWorld().isAirBlock(tileEntityIn.getPos().south()))
			{
				GlStateManager.pushMatrix();
				GlStateManager.translatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 1.0F);
				GlStateManager.scalef(0.5F, 0.5F, 0.5F);
				GlStateManager.rotatef(180.0f, 0.0f, 1.0f, 0.0f);
				Minecraft.getInstance().getItemRenderer().renderItem(tileEntityIn.getResult(), ItemCameraTransforms.TransformType.FIXED);
				GlStateManager.popMatrix();
			}

			if (this.getWorld().isAirBlock(tileEntityIn.getPos().north()))
			{
				GlStateManager.pushMatrix();
				GlStateManager.translatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.0F);
				GlStateManager.scalef(0.5F, 0.5F, 0.5F);
				GlStateManager.rotatef(0.0f, 0.0f, 1.0f, 0.0f);
				Minecraft.getInstance().getItemRenderer().renderItem(tileEntityIn.getResult(), ItemCameraTransforms.TransformType.FIXED);
				GlStateManager.popMatrix();
			}

			if (this.getWorld().isAirBlock(tileEntityIn.getPos().east()))
			{
				GlStateManager.pushMatrix();
				GlStateManager.translatef((float) x + 1.0F, (float) y + 0.5F, (float) z + 0.5F);
				GlStateManager.scalef(0.5F, 0.5F, 0.5F);
				GlStateManager.rotatef(270.0f, 0.0f, 1.0f, 0.0f);
				Minecraft.getInstance().getItemRenderer().renderItem(tileEntityIn.getResult(), ItemCameraTransforms.TransformType.FIXED);
				GlStateManager.popMatrix();
			}

			if (this.getWorld().isAirBlock(tileEntityIn.getPos().west()))
			{
				GlStateManager.pushMatrix();
				GlStateManager.translatef((float) x, (float) y + 0.5F, (float) z + 0.5F);
				GlStateManager.scalef(0.5F, 0.5F, 0.5F);
				GlStateManager.rotatef(90.0f, 0.0f, 1.0f, 0.0f);
				Minecraft.getInstance().getItemRenderer().renderItem(tileEntityIn.getResult(), ItemCameraTransforms.TransformType.FIXED);
				GlStateManager.popMatrix();
			}
		}
	}
}
