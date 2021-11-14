package fr.emotion.emomod.world.level.block.state.properties;

import java.util.Set;
import java.util.stream.Stream;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;

public class PotType
{
	private static final Set<PotType> VALUES = new ObjectArraySet<>();
	public static final PotType APPLE = register(new PotType("apple"));
	public static final PotType BLACKCURRANT = register(new PotType("blackcurrant"));
	public static final PotType BLUEBERRY = register(new PotType("blueberry"));
	public static final PotType CHERRY = register(new PotType("cherry"));
	public static final PotType CHOCOLATE = register(new PotType("chocolate"));
	public static final PotType ORANGE = register(new PotType("orange"));
	public static final PotType PEAR = register(new PotType("pear"));
	public static final PotType REDCURRANT = register(new PotType("redcurrant"));
	public static final PotType STRAWBERRY = register(new PotType("strawberry"));
	public static final PotType DREAMCURRANT = register(new PotType("dreamcurrant"));
	public static final PotType WATER = register(new PotType("water"));
	public static final PotType LAVA = register(new PotType("laval"));
	public static final PotType MILK = register(new PotType("milk"));
	public static final PotType GLASS = register(new PotType("glass"));
	private final String name;
	
	protected PotType(String name)
	{
		this.name = name;
	}
	
	public static PotType register(PotType name)
	{
		VALUES.add(name);
		return name;
	}
	
	public static Stream<PotType> values()
	{
		return VALUES.stream();
	}
	
	public String name()
	{
		return this.name;
	}
	
	public static PotType create(String name)
	{
		return new PotType(name);
	}
}
