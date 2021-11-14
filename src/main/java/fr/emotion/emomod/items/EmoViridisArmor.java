package fr.emotion.emomod.items;

import fr.emotion.emomod.MainRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;

public class EmoViridisArmor extends ArmorItem implements IItemRenderProperties
{
	public EmoViridisArmor(ArmorMaterial mat, EquipmentSlot slot, Properties builder)
	{
		super(mat, slot, builder);
	}

	@Override
	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A _default)
	{
		return IItemRenderProperties.super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
	}

//	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
//	{
//		ModelViridisArmor armorModel = new ModelViridisArmor();
//
//		if (armorModel != null && entityLiving.world.isRemote())
//		{
//			armorModel.head.showModel = armorSlot == EquipmentSlotType.HEAD;
//			armorModel.topTorso.showModel = armorSlot == EquipmentSlotType.CHEST;
//			armorModel.rightArm.showModel = armorSlot == EquipmentSlotType.CHEST;
//			armorModel.leftArm.showModel = armorSlot == EquipmentSlotType.CHEST;
//			armorModel.rightLeg.showModel = armorSlot == EquipmentSlotType.LEGS || armorSlot == EquipmentSlotType.FEET;
//			armorModel.leftLeg.showModel = armorSlot == EquipmentSlotType.LEGS || armorSlot == EquipmentSlotType.FEET;
//
//			armorModel.isSneak = entityLiving.isSneaking();
//			armorModel.isSitting = entityLiving.isOnePlayerRiding();
//			armorModel.isChild = entityLiving.isChild();
//			armorModel.swingProgress = entityLiving.swingProgress;
//
//			armorModel.rightArmPose = BipedModel.ArmPose.EMPTY;
//			armorModel.leftArmPose = BipedModel.ArmPose.EMPTY;
//
//			PlayerEntity player = (PlayerEntity) entityLiving;
//			ItemStack mainHand = player.getHeldItemMainhand();
//			ItemStack offHand = player.getHeldItemOffhand();
//
//			if (mainHand != null)
//			{
//				armorModel.rightArmPose = BipedModel.ArmPose.ITEM;
//
//				if (player.getItemInUseCount() > 0)
//				{
//					UseAction enumAction = mainHand.getUseAction();
//
//					if (enumAction == UseAction.BOW)
//					{
//						armorModel.rightArmPose = BipedModel.ArmPose.BOW_AND_ARROW;
//					} else if (enumAction == UseAction.BLOCK)
//					{
//						armorModel.rightArmPose = BipedModel.ArmPose.BLOCK;
//					}
//				}
//				return (A) armorModel;
//			}
//
//			if (offHand != null)
//			{
//				armorModel.leftArmPose = BipedModel.ArmPose.ITEM;
//
//				if (player.getItemInUseCount() > 0)
//				{
//					UseAction enumAction = offHand.getUseAction();
//
//					if (enumAction == UseAction.BOW)
//					{
//						armorModel.leftArmPose = BipedModel.ArmPose.BOW_AND_ARROW;
//					} else if (enumAction == UseAction.BLOCK)
//					{
//						armorModel.leftArmPose = BipedModel.ArmPose.BLOCK;
//					}
//				}
//				return (A) armorModel;
//			}
//		}
//		return (A) armorModel;
//	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type)
	{
		if (slot == EquipmentSlot.LEGS)
			return MainRegistry.MOD_ID + ":textures/models/armor/viridis_layer_2.png";

		return MainRegistry.MOD_ID + ":textures/models/armor/viridis_layer_1.png";
	}
}
