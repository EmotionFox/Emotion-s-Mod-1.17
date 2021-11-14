package fr.emotion.emomod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.Level;

public class EntityMushroom extends AmbientCreature
{
	public EntityMushroom(EntityType<? extends AmbientCreature> type, Level worldIn)
	{
		super(type, worldIn);
	}
}
