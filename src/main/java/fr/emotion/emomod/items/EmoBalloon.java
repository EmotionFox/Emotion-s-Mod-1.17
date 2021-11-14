package fr.emotion.emomod.items;

import fr.emotion.emomod.init.ItemRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EmoBalloon extends Item
{
	public EmoBalloon(Properties properties)
	{
		super(properties);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected)
	{
		super.inventoryTick(stack, level, entity, itemSlot, isSelected);

		if (entity instanceof Player)
		{
			Player player = (Player) entity;

			if (!player.isCreative() && isSelected)
			{
				if (this == ItemRegistry.PURPURA_RED_BALLOON.get())
				{
					if (player.isCrouching())
						player.setDeltaMovement(player.getDeltaMovement().multiply(1.07D, 0.8D, 1.07D));
					else
						player.setDeltaMovement(player.getDeltaMovement().add(1.04D, 0.5D, 1.04D));
				} else if (!player.isInWater() && !player.isInLava() && this == ItemRegistry.PURPURA_GREEN_BALLOON.get())
				{
					if (player.isCrouching())
						player.setDeltaMovement(player.getDeltaMovement().multiply(0.0D, 0.7D, 0.0D));
					else
						player.setDeltaMovement(player.getDeltaMovement().add(0.0D, 0.084D, 0.0D));
				} else if (!player.isInWater() && !player.isInLava() && this == ItemRegistry.PURPURA_BLUE_BALLOON.get())
				{
					player.setDeltaMovement(player.getDeltaMovement().add(0.0D, 0.07D, 0.0D));
				}
			}
		}
	}
}
