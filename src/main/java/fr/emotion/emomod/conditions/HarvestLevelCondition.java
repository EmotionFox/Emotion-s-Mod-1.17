package fr.emotion.emomod.conditions;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public class HarvestLevelCondition implements LootItemCondition
{
	private final String tool;
	private final int minLevel;
	private final int maxLevel;
	private final String type;

	private HarvestLevelCondition(String tool, int minLevel, int maxLevel, String type)
	{
		this.tool = tool;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.type = type;
	}
	
	@Override
	public boolean test(LootContext context)
	{
		if (context.hasParam(LootContextParams.TOOL) && context.hasParam(LootContextParams.THIS_ENTITY) && context.hasParam(LootContextParams.BLOCK_STATE))
		{
			ItemStack itemStack = context.getParamOrNull(LootContextParams.TOOL);
			Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);

			if (entity != null && entity instanceof Player)
			{
				int harvestLevel = itemStack.getHarvestLevel(ToolType.get(tool), (Player) entity, context.getParamOrNull(LootContextParams.BLOCK_STATE));
				
				switch (this.type)
				{
				default:
				case "equal":
					return harvestLevel == this.minLevel;
				case "strictly_higher":
					return this.maxLevel != -2 ? harvestLevel > this.minLevel && harvestLevel < this.maxLevel : harvestLevel > this.minLevel;
				case "higher":
					return this.maxLevel != -2 ? harvestLevel >= this.minLevel && harvestLevel <= this.maxLevel : harvestLevel >= this.minLevel;
				case "strictly_lower":
					return harvestLevel < this.minLevel;
				case "lower":
					return harvestLevel <= this.minLevel;
				case "nevermind":
					return false;
				}
			}
		}

		return false;
	}

	public static ILootCondition.IBuilder builder(String tool, int minLevel, int maxLevel, String type)
	{
		return () ->
		{
			return new HarvestLevelCondition(tool, minLevel, maxLevel, type);
		};
	}

	public static class Serializer extends ILootCondition.AbstractSerializer<HarvestLevelCondition>
	{
		public Serializer()
		{
			super(new ResourceLocation(MainRegistry.MOD_ID, "harvest_level"), HarvestLevelCondition.class);
		}

		@Override
		public void serialize(JsonObject json, HarvestLevelCondition value, JsonSerializationContext context)
		{
			json.addProperty("tool", value.tool);
			json.addProperty("min", value.minLevel);
			json.addProperty("max", value.maxLevel);
			json.addProperty("type", value.type);
		}

		@Override
		public HarvestLevelCondition deserialize(JsonObject json, JsonDeserializationContext context)
		{
			int max = json.has("max") ? JSONUtils.getInt(json, "max") : -2;
			String type = json.has("type") ? JSONUtils.getString(json, "type") : "nevermind";
			return new HarvestLevelCondition(JSONUtils.getString(json, "tool"), JSONUtils.getInt(json, "min"), max, type);
		}
	}
}
