package fr.emotion.emomod.items.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelViridisArmor extends BipedModel<LivingEntity>
{
	public RendererModel wShoulder;
	public RendererModel sShoulder;
	public RendererModel eShoulder;
	public RendererModel nShoulder;
	public RendererModel leftArm;
	public RendererModel topTorso;
	public RendererModel rightArm;
	public RendererModel eShoulder2;
	public RendererModel sShoulder2;
	public RendererModel nShoulder2;
	public RendererModel wShoulder2;
	public RendererModel head;
	public RendererModel leftLeg;
	public RendererModel rightLeg;
	public RendererModel downTorso;

	public ModelViridisArmor()
	{
		super();

		this.textureWidth = 64;
		this.textureHeight = 64;

		this.nShoulder = new RendererModel(this, 1, 39);
		this.nShoulder.setRotationPoint(-1.5F, -3.0F, -3.0F);
		this.nShoulder.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.eShoulder = new RendererModel(this, 1, 42);
		this.eShoulder.setRotationPoint(-2.5F, -3.0F, -3.0F);
		this.eShoulder.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
		this.leftArm = new RendererModel(this, 41, 1);
		this.leftArm.setRotationPoint(0.5F, 0.0F, 0.0F);
		this.leftArm.addBox(-2.0F, -2.5F, -2.5F, 5, 14, 5, 0.0F);
		this.sShoulder = new RendererModel(this, 1, 39);
		this.sShoulder.setRotationPoint(-1.5F, -3.0F, 2.0F);
		this.sShoulder.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.head = new RendererModel(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-5.0F, -9.0F, -5.0F, 10, 10, 10, 0.0F);
		this.downTorso = new RendererModel(this, 20, 26);
		this.downTorso.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.downTorso.addBox(-5.0F, 5.5F, -3.0F, 10, 7, 6, 0.0F);
		this.eShoulder2 = new RendererModel(this, 1, 42);
		this.eShoulder2.setRotationPoint(-3.5F, -4.0F, -3.0F);
		this.eShoulder2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
		this.topTorso = new RendererModel(this, 19, 38);
		this.topTorso.setRotationPoint(0.0F, 0.0F, 0F);
		this.topTorso.addBox(-5.5F, -0.5F, -3.5F, 11, 6, 7, 0.0F);
		this.rightArm = new RendererModel(this, 41, 1);
		this.rightArm.setRotationPoint(-0.5F, 0F, 0.0F);
		this.rightArm.addBox(-3.0F, -2.5F, -2.5F, 5, 14, 5, 0.0F);
		this.wShoulder = new RendererModel(this, 1, 42);
		this.wShoulder.setRotationPoint(2.5F, -4.0F, -3.0F);
		this.wShoulder.addBox(0.0F, 0.0F, 0.0F, 1, 2, 6, 0.0F);
		this.sShoulder2 = new RendererModel(this, 1, 39);
		this.sShoulder2.setRotationPoint(-2.5F, -3.0F, 2.0F);
		this.sShoulder2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.leftLeg = new RendererModel(this, 0, 20);
		this.leftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leftLeg.addBox(-2.5F, -0.5F, -2.5F, 5, 13, 5, 0.0F);
		this.rightLeg = new RendererModel(this, 0, 20);
		this.rightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rightLeg.addBox(-2.5F, -0.5F, -2.5F, 5, 13, 5, 0.0F);
		this.nShoulder2 = new RendererModel(this, 1, 39);
		this.nShoulder2.setRotationPoint(-2.5F, -3.0F, -3.0F);
		this.nShoulder2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.wShoulder2 = new RendererModel(this, 1, 42);
		this.wShoulder2.setRotationPoint(1.5F, -3.0F, -3.0F);
		this.wShoulder2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
		this.leftArm.addChild(this.nShoulder);
		this.leftArm.addChild(this.eShoulder);
		this.leftArm.addChild(this.sShoulder);
		this.topTorso.addChild(this.downTorso);
		this.rightArm.addChild(this.eShoulder2);
		this.leftArm.addChild(this.wShoulder);
		this.rightArm.addChild(this.sShoulder2);
		this.rightArm.addChild(this.nShoulder2);
		this.rightArm.addChild(this.wShoulder2);

		this.bipedHead.addChild(head);
		this.bipedBody.addChild(topTorso);
		this.bipedLeftArm.addChild(leftArm);
		this.bipedRightArm.addChild(rightArm);
		this.bipedLeftLeg.addChild(leftLeg);
		this.bipedRightLeg.addChild(rightLeg);
	}

	@Override
	public void render(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
}
