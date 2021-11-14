package fr.emotion.emomod.client.renderer.tileentity;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import fr.emotion.emomod.blockentity.PotBlockEntity;
import fr.emotion.emomod.client.model.geom.EmoModelLayers;
import fr.emotion.emomod.world.level.block.state.properties.PotType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TileEntityPotRenderer implements BlockEntityRenderer<PotBlockEntity>
{
	private final Map<PotType, TileEntityPotRenderer.PotModel> potModels;

	public TileEntityPotRenderer(BlockEntityRendererProvider.Context context)
	{
		this.potModels = PotType.values().collect(ImmutableMap.toImmutableMap((type) ->
		{
			return type;
		}, (type) ->
		{
			return new TileEntityPotRenderer.PotModel(context.bakeLayer(EmoModelLayers.createPotModelName(type)));
		}));
	}

	@Override
	public void render(PotBlockEntity blockEntity, float p_112308_, PoseStack pos, MultiBufferSource buffer, int packedLight, int packedOverlay)
	{
		
	}

//	@Override
//	public void render(TileEntityPot tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage)
//	{
//		if (destroyStage >= 0)
//		{
//			GlStateManager.matrixMode(5890);
//			GlStateManager.pushMatrix();
//			GlStateManager.matrixMode(5888);
//		} else
//		{
//			GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//		}
//
//		GlStateManager.pushMatrix();
//		GlStateManager.enableBlend();
//		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
//		GlStateManager.translated(x, y, z);
//
//		String folder = tileEntityIn.getContentsType().split("_")[1];
//
//		if (tileEntityIn.isAnimated())
//			this.bindTexture(new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/pot/" + folder + "/" + tileEntityIn.getContentsType() + "_" + tileEntityIn.getFrame() + ".png"));
//		else
//			this.bindTexture(new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/pot/" + tileEntityIn.getContentsType() + ".png"));
//
//		model.render(tileEntityIn.getContentsLevel());
//
//		GlStateManager.disableBlend();
//		GlStateManager.popMatrix();
//
//		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//
//		if (destroyStage >= 0)
//		{
//			GlStateManager.matrixMode(5890);
//			GlStateManager.popMatrix();
//			GlStateManager.matrixMode(5888);
//		}
//	}

	@OnlyIn(Dist.CLIENT)
	public static final class PotModel extends Model
	{
		private int contentsLevel;
		private final ModelPart pot;
		private final ModelPart cap;
		private final ModelPart contents;

		private int lastLevel = -1;

		public PotModel(ModelPart root)
		{
			super(RenderType::entityCutoutNoCull);
			this.pot = root.getChild("pot");
			this.cap = root.getChild("cap");
			this.contents = root.getChild("contents");
		}

		public void setContentsLevel(int contentsLevel)
		{
			this.contentsLevel = contentsLevel;
		}

		@Override
		public void renderToBuffer(PoseStack pose, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
		{
			if (lastLevel == -1 || lastLevel != contentsLevel)
			{
				lastLevel = contentsLevel;
				contents.render(pose, buffer, packedLight, packedOverlay);
			}

			pot.render(pose, buffer, packedLight, packedOverlay);
			cap.render(pose, buffer, packedLight, packedOverlay);
		}

//		public PotModel()
//		{
//			this.textureWidth = 64;
//			this.textureHeight = 36;
		//
//			pot = new RendererModel(this, 0, 16);
//			pot.setTextureSize(64, 36);
//			pot.addBox(3F, 0f, 3F, 10, 10, 10, true);
		//
//			cap = new RendererModel(this, 40, 27);
//			cap.setTextureSize(64, 36);
//			cap.addBox(5f, 8f, 5f, 6, 3, 6, true);
//		}
		//
//		public void render(int contentsLevel)
//		{
//			if (lastLevel == -1 || lastLevel != contentsLevel)
//			{
//				lastLevel = contentsLevel;
//				contents = new RendererModel(this, 0, 0);
//				contents.setTextureSize(64, 36);
//				contents.addBox(4f, 1f, 4f, 8, 2 * contentsLevel, 8, true);
//			}
		//
//			pot.render(0.0625F);
//			cap.render(0.0625f);
//			contents.render(0.0625f);
//		}
	}
}
