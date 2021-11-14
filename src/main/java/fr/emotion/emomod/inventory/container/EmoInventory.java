package fr.emotion.emomod.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EmoInventory implements IInventory
{
	public final NonNullList<ItemStack> inventory = NonNullList.withSize(2, ItemStack.EMPTY);
	private int timesChanged;
	
	@Override
	public void clear()
	{
		this.inventory.clear();
	}

	@Override
	public int getSizeInventory()
	{
		return inventory.size();
	}

	@Override
	public boolean isEmpty()
	{
		return inventory.isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return inventory.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		return !this.inventory.get(index).isEmpty() ? ItemStackHelper.getAndSplit(this.inventory, index, count) : ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		return this.inventory.set(index, ItemStack.EMPTY);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		this.inventory.set(index, stack);
	}

	@Override
	public void markDirty()
	{
		this.timesChanged++;
	}

	@OnlyIn(Dist.CLIENT)
	public int getTimesChanged()
	{
		return this.timesChanged;
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player)
	{
		if (player.isAlive())
			return false;
		else
			return !(player.getDistanceSq(player) > 64.0D);
	}

}
