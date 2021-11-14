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
public class ModelBeetle<T extends Entity> extends EntityModel<T>
{
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightFrontLeg;
	private final ModelPart rightBackLeg;
	private final ModelPart leftFrontLeg;
	private final ModelPart leftBackLeg;

	public ModelBeetle(ModelPart root)
	{
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.rightFrontLeg = root.getChild("rightFrontLeg");
		this.rightBackLeg = root.getChild("rightBackLeg");
		this.leftFrontLeg = root.getChild("leftFrontLeg");
		this.leftBackLeg = root.getChild("leftBackLeg");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 5).addBox(-0.5F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 5).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 23.5F, -2.0F));

		head.addOrReplaceChild("rightAntenna_r1", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -2.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -0.5F, 0.3655F, 0.147F, -0.3655F));

		head.addOrReplaceChild("leftAntenna_r1", CubeListBuilder.create().texOffs(2, 8).addBox(0.0F, -2.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, -0.5F, 0.3655F, -0.147F, 0.3655F));

		partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(8, 9).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 23.5F, -0.5F, 0.0F, 0.0F, -0.5672F));

		partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create().texOffs(7, 10).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 23.5F, 1.5F, 0.0F, 0.0F, -0.5672F));

		partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(4, 9).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.5F, -0.5F, 0.0F, 0.0F, 0.5672F));

		partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create().texOffs(4, 10).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.5F, 1.5F, 0.0F, 0.0F, 0.6144F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.head.xRot = headPitch * ((float) Mth.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Mth.PI / 180F);
		this.leftFrontLeg.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightFrontLeg.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leftBackLeg.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.rightBackLeg.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
		rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
		rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
		leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
		leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
