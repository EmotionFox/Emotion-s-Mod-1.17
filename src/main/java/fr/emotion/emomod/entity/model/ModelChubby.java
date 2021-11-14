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
public class ModelChubby<T extends Entity> extends EntityModel<T>
{
	private final ModelPart leftLeg1;
	private final ModelPart rightLeg1;
	private final ModelPart body;
	private final ModelPart rightLeg2;
	private final ModelPart leftLeg2;
	private final ModelPart head;

	public ModelChubby(ModelPart root)
	{
		this.leftLeg1 = root.getChild("leftLeg1");
		this.rightLeg1 = root.getChild("rightLeg1");
		this.body = root.getChild("body");
		this.rightLeg2 = root.getChild("rightLeg2");
		this.leftLeg2 = root.getChild("leftLeg2");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("leftLeg1", CubeListBuilder.create().texOffs(4, 20).mirror().addBox(-1.0F, -1.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 21.0F, 2.0F));

		partdefinition.addOrReplaceChild("rightLeg1", CubeListBuilder.create().texOffs(4, 25).mirror().addBox(0.0F, -1.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 21.0F, 2.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 17.5F, 0.5F));

		partdefinition.addOrReplaceChild("rightLeg2", CubeListBuilder.create().texOffs(0, 25).mirror().addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 21.0F, -1.0F));

		partdefinition.addOrReplaceChild("leftLeg2", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 21.0F, -1.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 14.5F, -2.5F));

		head.addOrReplaceChild("leftHorn", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, -1.5F, -0.5F));

		head.addOrReplaceChild("rightHorn", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, -1.5F, -0.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.head.xRot = headPitch / (180F / (float) Mth.PI);
		this.head.yRot = netHeadYaw / (180F / (float) Mth.PI);
		this.leftLeg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftLeg2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Mth.PI) * 1.4F * limbSwingAmount;
		this.rightLeg1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Mth.PI) * 1.4F * limbSwingAmount;
		this.rightLeg2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		leftLeg1.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg1.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg2.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg2.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
