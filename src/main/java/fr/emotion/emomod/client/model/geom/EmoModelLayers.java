package fr.emotion.emomod.client.model.geom;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.world.level.block.state.properties.PotType;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class EmoModelLayers
{
	public static final ModelLayerLocation BETTLE = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "beetle"), "main");
	public static final ModelLayerLocation BOAR = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "boar"), "main");
	public static final ModelLayerLocation BUTTERFLY = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "butterfly"), "main");
	public static final ModelLayerLocation CHUBBY = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "chubby"), "main");
	public static final ModelLayerLocation LIGHTNING_BUG = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "lightning_bug"), "main");
	public static final ModelLayerLocation MOUSE = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "mouse"), "main");
	public static final ModelLayerLocation MUSHROOM = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "mushroom"), "main");
	public static final ModelLayerLocation PLAYER_VIRIDIS_INNER_ARMOR = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "player_viridis"), "inner_armor");
	public static final ModelLayerLocation PLAYER_VIRIDIS_OUTER_ARMOR = new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "player_viridis"), "outer_armor");
	
	public static ModelLayerLocation createPotModelName(PotType type)
	{
		ResourceLocation location = new ResourceLocation(MainRegistry.MOD_ID, type.name());
		return new ModelLayerLocation(new ResourceLocation(location.getNamespace(), "pot/" + location.getPath()), "main");
	}
}
