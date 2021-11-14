package fr.emotion.emomod.items;

import fr.emotion.emomod.entity.OrbSpellEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class EmoStaff extends Item
{
	public EmoStaff(Properties properties)
	{
		super(properties);
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		Hand otherHand = handIn == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;
		EmoSpellBook.SpellList spell = playerIn.getHeldItem(otherHand).getItem() instanceof EmoSpellBook ? ((EmoSpellBook) playerIn.getHeldItem(otherHand).getItem()).getSpell() : null;
		ItemStack itemStack = playerIn.getHeldItem(handIn);

		if (spell == null)
			return new ActionResult<>(ActionResultType.FAIL, itemStack);

		worldIn.playSound((PlayerEntity) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote)
		{
			OrbSpellEntity orbEntity = new OrbSpellEntity(spell, worldIn, playerIn);
			orbEntity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.5F, 1F);
			worldIn.addEntity(orbEntity);
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		return new ActionResult<>(ActionResultType.SUCCESS, itemStack);
	}
}
