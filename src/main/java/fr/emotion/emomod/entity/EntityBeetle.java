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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
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

public class EntityBeetle extends AmbientCreature
{
	private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(EntityBeetle.class, EntityDataSerializers.INT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_TYPE = Util.make(Maps.newHashMap(), (p_28140_) ->
	{
		p_28140_.put(0, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/beetle/beetle_brown.png"));
		p_28140_.put(1, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/beetle/beetle_green.png"));
		p_28140_.put(2, new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/beetle/beetle_blue.png"));
	});

	public EntityBeetle(Level level)
	{
		this(EntityTypeRegistry.BEETLE.get(), level);
	}

	public EntityBeetle(EntityType<? extends AmbientCreature> type, Level level)
	{
		super(type, level);
	}

	@Override
	public boolean canBeLeashed(Player player)
	{
		return false;
	}

	public ResourceLocation getResourceLocation()
	{
		return EntityBeetle.TEXTURE_BY_TYPE.getOrDefault(this.getBeetleType(), TEXTURE_BY_TYPE.get(0));
	}

	@Override
	protected void registerGoals()
	{
//		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 1.5F, 1.0D, 1.0D));
//		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0d));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3.0f));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes()
	{
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.15D);
	}

	@Override
	public boolean canCollideWith(Entity entityIn)
	{
		if (entityIn.getDimensions(Pose.STANDING).width > this.getDimensions(Pose.STANDING).width && entityIn.getDimensions(Pose.STANDING).height > this.getDimensions(Pose.STANDING).height)
		{
			this.hurt(DamageSource.IN_WALL, 2.5f);
			return true;
		} else
			return super.canCollideWith(entityIn);
	}

	@Override
	protected void defineSynchedData()
	{
		super.defineSynchedData();
		this.entityData.define(DATA_TYPE_ID, this.random.nextInt(TEXTURE_BY_TYPE.size()));
	}

	public void setBeetleType(int type)
	{
		this.entityData.define(DATA_TYPE_ID, type);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		super.addAdditionalSaveData(tag);
		tag.putInt("Type", this.getBeetleType());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		super.readAdditionalSaveData(tag);
		this.setBeetleType(tag.getInt("Type"));
	}

	public int getBeetleType()
	{
		return this.entityData.get(DATA_TYPE_ID);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn)
	{
		return 0.05f;
	}
}
