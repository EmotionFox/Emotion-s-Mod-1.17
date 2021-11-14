package fr.emotion.emomod.entity;

import java.util.Map;

import com.google.common.collect.Maps;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.init.EntityTypeRegistry;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.Level;

public class EntityButterfly extends Bat
{
	private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(EntityButterfly.class, EntityDataSerializers.INT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_TYPE = Util.make(Maps.newHashMap(), (p_28140_) ->
	{
		p_28140_.put(0, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/butterfly/butterfly_pink.png"));
		p_28140_.put(1, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/butterfly/butterfly_blue.png"));
		p_28140_.put(2, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/butterfly/butterfly_green.png"));
		p_28140_.put(3, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/butterfly/butterfly_brimstone.png"));
	});
	
	public EntityButterfly(Level world)
	{
		this(EntityTypeRegistry.BUTTERFLY.get(), world);
	}

	public EntityButterfly(EntityType<? extends Bat> type, Level world)
	{
		super(type, world);
		this.setResting(false);
	}

	public ResourceLocation getResourceLocation()
	{
		return EntityButterfly.TEXTURE_BY_TYPE.getOrDefault(this.getButterflyType(), TEXTURE_BY_TYPE.get(0));
	}
	
	@Override
	protected void defineSynchedData()
	{
		super.defineSynchedData();
		this.entityData.define(DATA_TYPE_ID, this.random.nextInt(EntityButterfly.TEXTURE_BY_TYPE.size()));
	}

	public void setButterflyType(int type)
	{
		this.entityData.define(DATA_TYPE_ID, type);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putInt("Type", this.getButterflyType());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setButterflyType(tag.getInt("Type"));
	}

	public int getButterflyType()
	{
		return this.entityData.get(DATA_TYPE_ID);
	}

	@Override
	public SoundEvent getAmbientSound()
	{
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return null;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return null;
	}

	@Override
	public EntityDimensions getDimensions(Pose pos)
	{
		if (this.level.getDifficulty() == Difficulty.NORMAL)
			return EntityDimensions.fixed(0.3f, 0.3f);
		else if (this.level.getDifficulty() == Difficulty.HARD)
			return EntityDimensions.fixed(0.2f, 0.2f);
		else
			return EntityDimensions.fixed(0.5f, 0.5f);
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
