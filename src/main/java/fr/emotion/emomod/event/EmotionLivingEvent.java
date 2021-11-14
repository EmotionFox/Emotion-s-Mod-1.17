package fr.emotion.emomod.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EmotionLivingEvent
{
	@SubscribeEvent
	public void livingDamage(LivingDamageEvent e)
	{
		if (e.getSource() == DamageSource.OUT_OF_WORLD && e.getEntity().dimension == DimensionType.byName(DimensionRegistry.DREAM_TYPE) && e.getEntity() instanceof ServerPlayerEntity)
		{
			TeleportationTools.teleport((ServerPlayerEntity) e.getEntity(), DimensionType.OVERWORLD, e.getEntity().getPosition());
		} else if (e.getSource().getTrueSource() instanceof LivingEntity)
		{
			LivingEntity attacker = (LivingEntity) e.getSource().getTrueSource();
			ItemStack handled = attacker.getHeldItemMainhand();

			if (handled.getItem() == ItemRegistry.PURPURA_SWORD)
			{
				ListNBT tagList = handled.getEnchantmentTagList();

				for (int i = 0; i < tagList.size(); i++)
				{
					CompoundNBT idTag = tagList.getCompound(i);

					if (idTag.getString("id").equals("emomod:blood_sucking"))
					{
						LivingEntity target = e.getEntityLiving();
						float gain = 0;

						if (target.getHealth() - e.getAmount() < e.getAmount())
							gain = (target.getHealth() / 3) * idTag.getShort("lvl");
						else
							gain = (e.getAmount() / 3) * idTag.getShort("lvl");

						attacker.setHealth(attacker.getHealth() + gain);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void livingFall(LivingFallEvent e)
	{
		if (e.getEntity() instanceof PlayerEntity)
		{
			PlayerEntity player = (PlayerEntity) e.getEntity();

			if (player.getHeldItemMainhand().getItem() instanceof EmoBalloon)
				e.setCanceled(true);
			else if (player instanceof ServerPlayerEntity && player.dimension == DimensionType.byName(DimensionRegistry.DREAM_TYPE) && player.fallDistance > 4f)
			{
				TeleportationTools.teleport((ServerPlayerEntity) player, DimensionType.OVERWORLD, player.getPosition());
			}
		}
	}

	boolean teleport = false;
	List<PlayerEntity> players = new ArrayList<PlayerEntity>();

	@SubscribeEvent
	public void onWakeUp(PlayerWakeUpEvent e)
	{
		PlayerEntity player = e.getPlayer();

		if (player.dimension == DimensionType.OVERWORLD)
		{
			for (int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if (player.inventory.getStackInSlot(i).getItem() == ItemRegistry.DREAM_STONE)
				{
					players.add(player);
					teleport = true;
				}
			}
		}
	}

	int serverTick = 0;

	@SubscribeEvent
	public void onServerTick(ServerTickEvent e)
	{
		if (teleport)
		{
			serverTick++;

			if (serverTick >= 15)
			{
				for (PlayerEntity player : players)
				{
					if (!player.world.isRemote())
						TeleportationTools.teleport((ServerPlayerEntity) player, DimensionType.byName(DimensionRegistry.DREAM_TYPE), player.getPosition());
				}

				players.clear();
				teleport = false;
				serverTick = 0;
			}
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void renderFog(RenderFogEvent e)
	{
		if (e.getInfo().getRenderViewEntity() instanceof PlayerEntity && !((PlayerEntity) e.getInfo().getRenderViewEntity()).isCreative() && e.getInfo().getRenderViewEntity().dimension == DimensionType.byName(DimensionRegistry.NIGHTMARE_HELL_TYPE))
		{
			float light = e.getInfo().getRenderViewEntity().getEntityWorld().getLight(e.getInfo().getRenderViewEntity().getPosition());
			float percent = light * 100 / 15;

			GL11.glFogi(GL11.GL_FOG_MODE, GL15.GL_LINEAR);
			GL11.glFogf(GL11.GL_FOG_START, percent * 5F / 100);
			GL11.glFogf(GL11.GL_FOG_END, percent * 30f / 100);

			if (GL.getCapabilities().GL_NV_fog_distance)
				GL11.glFogi(34138, 34139);
		}
	}

	public static final int radius = 10;
	boolean light = false;
	boolean up = true;
	float red = 0.0f;
	int fogTick = 0;
	double minDistance = -1d;

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void fogColor(FogColors e)
	{
		if (e.getInfo().getRenderViewEntity() != null && e.getInfo().getRenderViewEntity() instanceof PlayerEntity && e.getInfo().getRenderViewEntity().dimension == DimensionType.byName(DimensionRegistry.NIGHTMARE_HELL_TYPE))
		{
			if (fogTick >= 60)
			{
				PlayerEntity player = (PlayerEntity) e.getInfo().getRenderViewEntity();
				List<ZombieEntity> zombies = player.getEntityWorld().getEntitiesWithinAABB(ZombieEntity.class, AxisAlignedBB.func_216363_a(MutableBoundingBox.createProper(player.getPosition().getX() - radius, player.getPosition().getY() - radius,
						player.getPosition().getZ() - radius, player.getPosition().getX() + radius, player.getPosition().getY() + radius, player.getPosition().getZ() + radius)));
				minDistance = -1d;

				for (ZombieEntity zombie : zombies)
				{
					double distance = zombie.getDistanceSq(player);

					if (minDistance == -1d || distance < minDistance)
						minDistance = distance;
				}

				if (!light && zombies.size() > 0)
				{
					red = 0.0f;
					up = true;
					light = true;
				} else if (zombies.size() <= 0)
				{
					light = false;
					up = true;
					red = 0.0f;
				}

				fogTick = 0;
			}

			if (light)
			{
				if (up && red <= 0.5f)
					red += minDistance < 10d ? 0.05f : 0.01f;
				else
					up = false;

				if (!up && red >= 0.0f)
					red -= minDistance < 10d ? 0.05f : 0.01f;
				else
					up = true;
			}

			e.setRed(red);
			e.setGreen(0.0f);
			e.setBlue(0.0f);
		}

		fogTick++;
	}
}
