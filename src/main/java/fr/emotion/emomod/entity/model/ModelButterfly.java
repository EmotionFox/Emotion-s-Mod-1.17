package fr.emotion.emomod.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelButterfly<T extends Entity> extends EntityModel<T>
{
	private final ModelPart body;
	private final ModelPart lWing;
	private final ModelPart rWing;

	public ModelButterfly(ModelPart root)
	{
		this.body = root.getChild("body");
		this.lWing = root.getChild("lWing");
		this.rWing = root.getChild("rWing");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, -4.0F));

		partdefinition.addOrReplaceChild("lWing", CubeListBuilder.create().texOffs(-8, 9).mirror().addBox(0.0F, 0.0F, -4.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 21.0F, 0.0F));

		partdefinition.addOrReplaceChild("rWing", CubeListBuilder.create().texOffs(-8, 9).addBox(-7.0F, 0.0F, -4.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 21.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 18, 17);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.lWing.zRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rWing.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		body.render(poseStack, buffer, packedLight, packedOverlay);
		lWing.render(poseStack, buffer, packedLight, packedOverlay);
		rWing.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
