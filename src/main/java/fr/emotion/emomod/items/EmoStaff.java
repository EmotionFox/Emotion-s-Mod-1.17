package fr.emotion.emomod.items;

import fr.emotion.emomod.entity.OrbSpellEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EmoStaff extends Item
{
	public EmoStaff(Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
	{
		InteractionHand offHand = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
		EmoSpellBook.SpellList spell = player.getItemInHand(offHand).getItem() instanceof EmoSpellBook ? ((EmoSpellBook) player.getItemInHand(offHand).getItem()).getSpell() : null;
		ItemStack stack = player.getItemInHand(hand);

		level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

		if (!level.isClientSide())
		{
			OrbSpellEntity orb = new OrbSpellEntity(spell, level);
			orb.setOwner(player);
			orb.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1F);
			level.addFreshEntity(orb);
		}

		player.awardStat(Stats.ITEM_USED.get(this));
		return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
	}
}
