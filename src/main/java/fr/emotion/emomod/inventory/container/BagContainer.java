package fr.emotion.emomod.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BagContainer implements Container
{
	private final ItemStack item;
	private final IItemHandler itemHandler;
	private int blocked = -1;

	public BagContainer(int id, PlayerInventory playerInventory)
	{
		super(ContainerTypeRegistry.BAG, id);
		this.item = getHeldItem(playerInventory.player);
		this.itemHandler = ((EmoBag) this.item.getItem()).getInventory(this.item);

		for (int i = 0; i < this.itemHandler.getSlots(); ++i)
		{
			int x = 8 + 18 * i;
			addSlot(new SlotItemHandler(this.itemHandler, i, x, 14));
		}

		for (int y = 0; y < 3; ++y)
		{
			for (int x = 0; x < 9; ++x)
			{
				addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 45 + y * 18));
			}
		}

		for (int x = 0; x < 9; ++x)
		{
			Slot slot = addSlot(new Slot(playerInventory, x, 8 + x * 18, 103)
			{
				@Override
				public boolean canTakeStack(PlayerEntity playerIn)
				{
					return slotNumber != blocked;
				}
			});

			if (x == playerInventory.currentItem && ItemStack.areItemStacksEqual(playerInventory.getCurrentItem(), this.item))
			{
				blocked = slot.slotNumber;
			}
		}
	}

	private static ItemStack getHeldItem(PlayerEntity player)
	{
		if (isBackpack(player.getHeldItemMainhand()))
			return player.getHeldItemMainhand();
		if (isBackpack(player.getHeldItemOffhand()))
			return player.getHeldItemOffhand();
		return ItemStack.EMPTY;
	}

	@Override
	public void onContainerClosed(PlayerEntity playerIn)
	{
		super.onContainerClosed(playerIn);
		((EmoBag) this.item.getItem()).saveInventory(this.item, this.itemHandler);
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	{
		Slot slot = this.getSlot(index);

		if (!slot.canTakeStack(playerIn))
			return slot.getStack();

		if (index == blocked || !slot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack stack = slot.getStack();
		ItemStack newStack = stack.copy();

		int containerSlots = itemHandler.getSlots();

		if (index < containerSlots)
		{
			if (!this.mergeItemStack(stack, containerSlots, this.inventorySlots.size(), true))
				return ItemStack.EMPTY;

			slot.onSlotChanged();
		}
		else if (!this.mergeItemStack(stack, 0, containerSlots, false))
			return ItemStack.EMPTY;

		if (stack.isEmpty())
			slot.putStack(ItemStack.EMPTY);
		else
			slot.onSlotChanged();

		return slot.onTake(playerIn, newStack);
	}

	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, PlayerEntity player)
	{
		if (slotId < 0 || slotId > inventorySlots.size())
			return super.slotClick(slotId, dragType, clickTypeIn, player);

		Slot slot = inventorySlots.get(slotId);

		if (!canTake(slotId, slot, dragType, player, clickTypeIn))
			return slot.getStack();

		return super.slotClick(slotId, dragType, clickTypeIn, player);
	}

	private static boolean isBackpack(ItemStack stack)
	{
		return stack.getItem() instanceof EmoBag;
	}

	private boolean canTake(int slotId, Slot slot, int button, PlayerEntity player, ClickType clickType)
	{
		if (slotId == blocked || slotId <= itemHandler.getSlots() - 1 && isBackpack(player.inventory.getItemStack()))
			return false;

		if (clickType == ClickType.SWAP)
		{
			int hotbarId = itemHandler.getSlots() + 27 + button;

			if (blocked == hotbarId)
				return false;

			Slot hotbarSlot = getSlot(hotbarId);

			if (slotId <= itemHandler.getSlots() - 1)
				return !isBackpack(slot.getStack()) && !isBackpack(hotbarSlot.getStack());
		}

		return true;
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return true;
	}
}
