package fr.emotion.emomod.items;

import fr.emotion.emomod.entity.EntityButterfly;
import fr.emotion.emomod.init.ItemRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EmoButterfly extends Item
{
	public EmoButterfly(Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		EntityButterfly butterfly = new EntityButterfly(level);
		Vec3 pos = player.position();
		Item held = player.getItemInHand(hand).getItem();
		int type = held == ItemRegistry.BUTTERFLY_PINK.get() ? 0 : held == ItemRegistry.BUTTERFLY_BLUE.get() ? 1 : held == ItemRegistry.BUTTERFLY_GREEN.get() ? 2 : held == ItemRegistry.BUTTERFLY_BRIMSTONE.get() ? 3 : 0;

		butterfly.setPos(pos);
		butterfly.setXRot(player.xRotO);
		butterfly.setYRot(player.yRotO);
		butterfly.setButterflyType(type);
		boolean isSpawn = level.addFreshEntity(butterfly);

		if (!player.isCreative() && isSpawn)
			player.getItemInHand(hand).shrink(1);

		return new InteractionResultHolder<ItemStack>(isSpawn ? InteractionResult.SUCCESS : InteractionResult.FAIL, player.getItemInHand(hand));
	}
}
