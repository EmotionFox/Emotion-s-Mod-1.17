package fr.emotion.emomod.dimension;

import java.util.function.BiFunction;

import fr.emotion.emomod.init.DimensionRegistry;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

public class EmomodDimension extends ModDimension
{
	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory()
	{
		if (this.getRegistryName().equals(DimensionRegistry.DREAM_TYPE))
			return DreamDimension::new;
		else
			return NightmareDimension::new;
	}
}
