package fr.emotion.emomod.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelBoar<T extends Entity> extends AgeableListModel<T>
{
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart body;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;
	private final ModelPart LeftHindLeg;
	private final ModelPart RightHindLeg;

	public ModelBoar(ModelPart root)
	{
		this.head = root.getChild("head");
		this.tail = root.getChild("tail");
		this.body = root.getChild("body");
		this.LeftFrontLeg = root.getChild("LeftFrontLeg");
		this.RightFrontLeg = root.getChild("RightFrontLeg");
		this.LeftHindLeg = root.getChild("LeftHindLeg");
		this.RightHindLeg = root.getChild("RightHindLeg");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(27, 27).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(26, 42).addBox(-1.5F, 1.0F, -9.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(16, 27)
						.addBox(3.0F, 0.0F, -4.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(-4.0F, 0.0F, -4.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(39, 42)
						.addBox(2.0F, -6.0F, -5.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(37, 10).addBox(-4.0F, -6.0F, -5.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, -8.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 7.0F));

		tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 48).addBox(-1.0F, -4.5355F, 8.4645F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.4645F, -3.5355F, -0.7854F, 0.0F, 0.0F));

		tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(37, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -8.0F, 10.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(-1.0F, -6.0F, -8.0F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(13, 40).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 20.0F, -6.5F));

		partdefinition.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(0, 40).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 20.0F, -6.5F));

		partdefinition.addOrReplaceChild("LeftHindLeg", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 20.0F, 6.5F));

		partdefinition.addOrReplaceChild("RightHindLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 20.0F, 6.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.head.xRot = headPitch * ((float) Math.PI / 180F);
		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.LeftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.RightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.LeftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.RightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.tail.yRot = Mth.cos(limbSwing * 0.6662F) * 1F * limbSwingAmount;
	}

	@Override
	protected Iterable<ModelPart> headParts()
	{
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelPart> bodyParts()
	{
		return ImmutableList.of(this.body, this.RightHindLeg, this.LeftHindLeg, this.RightFrontLeg, this.LeftFrontLeg, this.tail);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		head.render(poseStack, buffer, packedLight, packedOverlay);
		tail.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		LeftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
		RightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
		LeftHindLeg.render(poseStack, buffer, packedLight, packedOverlay);
		RightHindLeg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
