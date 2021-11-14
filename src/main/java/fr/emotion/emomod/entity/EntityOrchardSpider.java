package fr.emotion.emomod.entity;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class EntityOrchardSpider extends Spider
{
	public EntityOrchardSpider(EntityType<? extends Spider> type, Level world)
	{
		super(type, world);
	}

	public static AttributeSupplier.Builder createOrchardSpider()
	{
		return Spider.createAttributes().add(Attributes.MAX_HEALTH, 12.0d).add(Attributes.MOVEMENT_SPEED, 0.4f);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn)
	{
		return 0.25f;
	}

//	@Override
//	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn)
//	{
//		int i = MathHelper.floor(this.posX);
//		int j = MathHelper.floor(this.getBoundingBox().minY);
//		int k = MathHelper.floor(this.posZ);
//		BlockPos blockpos = new BlockPos(i, j, k);
//		return this.world.getLight(blockpos) > 8;
//	}
}
