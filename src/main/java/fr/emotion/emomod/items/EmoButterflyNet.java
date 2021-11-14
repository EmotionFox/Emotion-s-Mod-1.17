package fr.emotion.emomod.items;

import fr.emotion.emomod.entity.EntityButterfly;
import fr.emotion.emomod.init.ItemRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class EmoButterflyNet extends Item
{
	public EmoButterflyNet(Properties properties)
	{
		super(properties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
	{
		return 100;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
	{
		if (entity instanceof EntityButterfly)
		{
			ItemStack drop = null;

			switch (((EntityButterfly) entity).getButterflyType())
			{
			default:
			case 0:
				drop = ItemRegistry.BUTTERFLY_PINK.get().getDefaultInstance();
				break;
			case 1:
				drop = ItemRegistry.BUTTERFLY_BLUE.get().getDefaultInstance();
				break;
			case 2:
				drop = ItemRegistry.BUTTERFLY_GREEN.get().getDefaultInstance();
				break;
			case 3:
				drop = ItemRegistry.BUTTERFLY_BRIMSTONE.get().getDefaultInstance();
				break;
			}

			player.playSound(SoundEvents.FISH_SWIM, 1.0F, 1.0F);
			entity.level.addFreshEntity(new ItemEntity(entity.level, entity.position().x, entity.position().y, entity.position().z, drop));
			entity.setRemoved(RemovalReason.KILLED);

			if (player instanceof ServerPlayer)
				stack.setDamageValue(1);

			return true;
		}

		return super.onLeftClickEntity(stack, player, entity);
	}
}
