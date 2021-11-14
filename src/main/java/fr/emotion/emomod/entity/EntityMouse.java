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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityMouse extends AmbientCreature
{
	private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(EntityMouse.class, EntityDataSerializers.INT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_TYPE = Util.make(Maps.newHashMap(), (p_28140_) ->
	{
		p_28140_.put(0, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/mouse/mouse_white.png"));
		p_28140_.put(1, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/mouse/mouse_brown.png"));
		p_28140_.put(2, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/mouse/mouse_ginger.png"));
		p_28140_.put(3, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/mouse/mouse_black.png"));
		p_28140_.put(4, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/mouse/mouse_khaki.png"));
	});
	
	public EntityMouse(Level level)
	{
		this(EntityTypeRegistry.MOUSE.get(), level);
	}

	public EntityMouse(EntityType<? extends AmbientCreature> type, Level level)
	{
		super(type, level);
	}

	@Override
	public boolean canBeLeashed(Player p_27406_)
	{
		return false;
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 3.0f));
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
	}
	
	public ResourceLocation getResourceLocation()
	{
		return EntityBeetle.TEXTURE_BY_TYPE.getOrDefault(this.getMouseType(), TEXTURE_BY_TYPE.get(0));
	}

	public static AttributeSupplier.Builder createAttributes()
	{
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0d).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	protected void defineSynchedData()
	{
		super.defineSynchedData();
		this.entityData.define(DATA_TYPE_ID, this.random.nextInt(TEXTURE_BY_TYPE.size()));
	}

	public void setMouseType(int type)
	{
		this.entityData.set(DATA_TYPE_ID, type);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putInt("Type", this.getMouseType());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setMouseType(tag.getInt("Type"));
	}

	public int getMouseType()
	{
		return this.entityData.get(DATA_TYPE_ID);
	}

	@Override
	protected SoundEvent getAmbientSound()
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

//	@Override
//	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn)
//	{
//		int i = MathHelper.floor(this.posX);
//		int j = MathHelper.floor(this.getBoundingBox().minY);
//		int k = MathHelper.floor(this.posZ);
//		BlockPos blockpos = new BlockPos(i, j, k);
//		return this.world.getLight(blockpos) > 8;
//	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn)
	{
		return 0.1f;
	}
}
