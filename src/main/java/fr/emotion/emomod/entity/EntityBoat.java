package fr.emotion.emomod.entity;

import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.EntityTypeRegistry;
import fr.emotion.emomod.init.ItemRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;

public class EntityBoat extends Boat
{
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(EntityBoat.class, EntityDataSerializers.INT);

	public EntityBoat(EntityType<? extends Boat> p_38290_, Level p_38291_)
	{
		super(p_38290_, p_38291_);
	}

	public EntityBoat(FMLPlayMessages.SpawnEntity packet, Level level)
	{
		super(EntityTypeRegistry.BOAT.get(), level);
	}
	
	public EntityBoat(Level level, double x, double y, double z)
	{
		super(level, x, y, z);
	}

	@Override
	protected void defineSynchedData()
	{
		super.defineSynchedData();
		this.entityData.define(DATA_ID_TYPE, EntityBoat.EmoType.CHERRY.ordinal());
	}

	@Override
	public Item getDropItem()
	{
		switch (this.getEmoType())
		{
		case CHERRY:
		default:
			return ItemRegistry.CHERRY_BOAT.get();
		case PEAR:
			return ItemRegistry.PEAR_BOAT.get();
		case ORANGE:
			return ItemRegistry.ORANGE_BOAT.get();
		case ATLAS:
			return ItemRegistry.ATLAS_BOAT.get();
		case PINE:
			return ItemRegistry.PINE_BOAT.get();
		case COCO:
			return ItemRegistry.COCO_BOAT.get();
		case DREAM:
			return ItemRegistry.DREAM_BOAT.get();
		}
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag tag)
	{
		tag.putString("Type", this.getEmoType().getName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag)
	{
		if (tag.contains("Type", 8))
		{
			this.setEmoType(EntityBoat.EmoType.byName(tag.getString("Type")));
		}
	}

	@Override
	public ItemEntity spawnAtLocation(ItemLike itemLike)
	{
		itemLike = this.getEmoType().getPlanks();
		return spawnAtLocation(itemLike, 0);
	}

	public void setEmoType(EntityBoat.EmoType type)
	{
		this.entityData.set(DATA_ID_TYPE, type.ordinal());
	}

	public EntityBoat.EmoType getEmoType()
	{
		return EntityBoat.EmoType.byId(this.entityData.get(DATA_ID_TYPE));
	}

	public static enum EmoType
	{
		CHERRY(BlockRegistry.PLANKS_CHERRY.get(), "cherry"), PEAR(BlockRegistry.PLANKS_PEAR.get(), "pear"), ORANGE(BlockRegistry.PLANKS_ORANGE.get(), "orange"), ATLAS(BlockRegistry.PLANKS_ATLAS.get(), "atlas"),
		PINE(BlockRegistry.PLANKS_PINE.get(), "pine"), COCO(BlockRegistry.PLANKS_COCO.get(), "coco"), DREAM(BlockRegistry.PLANKS_DREAM.get(), "dream");

		private final String name;
		private final Block planks;

		private EmoType(Block block, String name)
		{
			this.name = name;
			this.planks = block;
		}

		public String getName()
		{
			return this.name;
		}

		public Block getPlanks()
		{
			return this.planks;
		}

		public String toString()
		{
			return this.name;
		}

		public static EntityBoat.EmoType byId(int id)
		{
			EntityBoat.EmoType[] aEntityBoat$type = values();
			if (id < 0 || id >= aEntityBoat$type.length)
			{
				id = 0;
			}

			return aEntityBoat$type[id];
		}

		public static EntityBoat.EmoType byName(String name)
		{
			EntityBoat.EmoType[] aEntityBoat$type = values();

			for (int i = 0; i < aEntityBoat$type.length; ++i)
			{
				if (aEntityBoat$type[i].getName().equals(name))
				{
					return aEntityBoat$type[i];
				}
			}

			return aEntityBoat$type[0];
		}
	}
}
