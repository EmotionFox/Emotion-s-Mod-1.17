package fr.emotion.emomod.inventory.container;

import javax.annotation.Nullable;

import fr.emotion.emomod.blocks.EmoNightstand;
import fr.emotion.emomod.init.ContainerTypeRegistry;
import fr.emotion.emomod.tileentity.TileEntityNightstand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class NightstandContainer extends Container
{
	private TileEntity tileEntity;
	private int containerSlots = 0;

	public NightstandContainer(int id, World world, BlockPos pos, PlayerInventory playerInventory)
	{
		super(ContainerTypeRegistry.NIGHTSTAND, id);
		this.tileEntity = world.getTileEntity(pos);

		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h ->
		{
			containerSlots = h.getSlots();

			for (int i = 0; i < h.getSlots(); i++)
			{
				addSlot(new SlotItemHandler(h, i, 44 + (i * 18) + (i > 1 ? 18 : 0), 14));
			}
		});

		for (int y = 0; y < 3; ++y)
		{
			for (int x = 0; x < 9; ++x)
			{
				this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + (x * 18), 45 + (y * 18)));
			}
		}

		for (int k = 0; k < 9; ++k)
		{
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 103));
		}
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	{
		Slot slot = this.getSlot(index);

		if (!slot.canTakeStack(playerIn))
			return slot.getStack();

		if (!slot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack stack = slot.getStack();
		ItemStack newStack = stack.copy();

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
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return this.isUsable(playerIn);
	}

	protected boolean isUsable(PlayerEntity playerIn)
	{
		return IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()).applyOrElse((block, pos) ->
		{
			return !(block.getBlockState(pos).getBlock() instanceof EmoNightstand) ? false
					: playerIn.getDistanceSq((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D;
		}, true);
	}

	@Nullable
	public TileEntityNightstand getTileEntity()
	{
		if (this.tileEntity instanceof TileEntityNightstand)
			return (TileEntityNightstand) this.tileEntity;
		else
			return null;
	}
}
