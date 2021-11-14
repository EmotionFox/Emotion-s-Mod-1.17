package fr.emotion.emomod.items;

import fr.emotion.emomod.inventory.container.BagContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class EmoBag extends Item
{
	public EmoBag(Properties properties)
	{
		super(properties);
	}

	public IItemHandler getInventory(ItemStack stack)
	{
		ItemStackHandler stackHandler = new ItemStackHandler(9);
		stackHandler.deserializeNBT(stack.getOrCreateTag().getCompound("Inventory"));
		return stackHandler;
	}

	public void saveInventory(ItemStack stack, IItemHandler handler)
	{
		if (handler instanceof ItemStackHandler)
		{
			stack.getOrCreateTag().put("Inventory", ((ItemStackHandler) handler).serializeNBT());
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		if (!worldIn.isRemote)
			playerIn.openContainer(new SimpleNamedContainerProvider((id, playerInventory, player) -> new BagContainer(id, playerInventory), new TranslationTextComponent("container.emomod.bag")));

		return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
	}
}
