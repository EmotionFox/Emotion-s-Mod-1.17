package fr.emotion.emomod.event;

import java.text.DecimalFormat;

import com.mojang.blaze3d.systems.RenderSystem;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.blocks.basic.BasicFlowingFluidBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EmotionOverlayEvent
{
	private float width;
	private int height;
	private int color = 14737632; // White DECIMAL

	float alpha = 0f;

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onRenderOverlay(RenderGameOverlayEvent e)
	{
		if (!e.isCancelable() && e.getType() == ElementType.DEBUG)
		{
			Minecraft mc = Minecraft.getInstance();
			Level world = mc.level;
			Player player = mc.player;

			if (world.getBlockState(player.blockPosition().above()).getBlock() instanceof BasicFlowingFluidBlock && player.isEyeInFluid(FluidTags.WATER))
			{
				// mc.textureManager.bindTexture(new
				// ResourceLocation(MainRegistry.MOD_ID +
				// ":textures/gui/icons.png"));
				mc.textureManager.getTexture(new ResourceLocation(MainRegistry.MOD_ID, "textures/misc/ancient_water.png"));

				if (alpha + 0.01f <= 1f)
				{
					RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
					alpha += 0.01f;
				}

				mc.gui.blit(e.getMatrixStack(), 0, 0, 0, 0, mc.getWindow().getWidth(), mc.getWindow().getHeight());
//				mc.ingameGUI.drawCenteredString(mc.fontRenderer, "FUCK YOU!", mc.mainWindow.getWidth() / 2, mc.mainWindow.getHeight() / 2, color);
			} else
				alpha = 0f;
		}

		// Custom Entity Health Bar
		if (!e.isCancelable() && e.getType() == ElementType.ALL)
		{
			Minecraft mc = Minecraft.getInstance();

			if (mc.crosshairPickEntity != null)
			{
				Entity target = mc.crosshairPickEntity;

				if (target instanceof LivingEntity)
				{
					if (target instanceof Animal)
					{
						height = 9; // Height on the screen in pixel
						color = 45597; // Lime Color DECIMAL
					} else if (target instanceof Player)
					{
						height = 23; // Height on the screen in pixel
						color = 1802938; // Cyan Color DECIMAL
					} else
					{
						height = 16; // Height on the screen in pixel
						color = 9520012; // Purple Color DECIMAL
					}

					LivingEntity looked = (LivingEntity) target;
					DecimalFormat df = new DecimalFormat("0.0");
					float life = looked.getHealth() / looked.getMaxHealth();
					String name = looked.getDisplayName().getString();
					width = life * 71;

					if (target instanceof EnderDragon || target instanceof WitherBoss)
					{
					} else if (target instanceof Player)
					{
						name = ((Player) looked).getName().getString();
					}

					if (!mc.player.isCreative())
					{
						int posX = e.getWindow().getGuiScaledWidth() / 2 - 36;
						int posY = e.getWindow().getGuiScaledHeight() - 70;

						mc.textureManager.getTexture(new ResourceLocation(MainRegistry.MOD_ID + ":textures/gui/icons.png"));
						mc.gui.blit(e.getMatrixStack(), posX, posY, 0, 0, 73, 9);
						mc.gui.blit(e.getMatrixStack(), posX + 1, posY + 1, 0, height, (int) width, 7);
						Gui.drawCenteredString(e.getMatrixStack(), mc.font, "" + name + " [" + df.format(looked.getHealth()) + "]", posX + 36, posY - 10, color);
					}
				}
			}
		}
	}
}
