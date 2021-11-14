package fr.emotion.emomod.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntitySittable extends AmbientCreature
{
	public double blockPosX;
	public double blockPosY;
	public double blockPosZ;
	public int lifeTime = 0;

	public EntitySittable(EntityType<? extends AmbientCreature> entityTypeIn, Level worldIn)
	{
		super(entityTypeIn, worldIn);
		this.noPhysics = true;
		this.blocksBuilding = true;
		this.setNoGravity(true);
	}

	public EntitySittable(EntityType<? extends AmbientCreature> entityTypeIn, Level worldIn, Player player, Double x, Double y, Double z)
	{
		this(entityTypeIn, worldIn);
		this.blockPosX = x;
		this.blockPosY = y;
		this.blockPosZ = z;
		this.setPos(x + 0.5D, y + 0.5D, z + 0.5D); // Get the center
	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand)
	{
		player.startRiding(this, true);
		return InteractionResult.SUCCESS;
	}

	@Override
	public void tick()
	{
		if (this.lifeTime >= 50 && !this.hasExactlyOnePlayerPassenger())
			this.kill();
		else if (this.lifeTime < 50)
			this.lifeTime++;

		super.tick();
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag)
	{
		this.blockPosX = tag.getDouble("blockPosX");
		this.blockPosY = tag.getDouble("blockPosY");
		this.blockPosZ = tag.getDouble("blockPosZ");
		this.lifeTime = tag.getInt("lifeTime");
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag)
	{
		tag.putDouble("blockPosX", this.blockPosX);
		tag.putDouble("blockPosY", this.blockPosY);
		tag.putDouble("blockPosZ", this.blockPosZ);
		tag.putInt("lifeTime", this.lifeTime);
	}
}
