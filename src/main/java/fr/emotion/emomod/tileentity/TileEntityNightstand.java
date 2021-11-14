package fr.emotion.emomod.tileentity;

import fr.emotion.emomod.init.TileEntityTypeRegistry;
import fr.emotion.emomod.inventory.container.NightstandContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityNightstand extends TileEntity implements INamedContainerProvider
{
	private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
	private float[] color = new float[]
	{ 0.0f, 255.0f, 0.0f};

	public TileEntityNightstand(float[] color)
	{
		this();
		this.color = color;
	}

	public TileEntityNightstand()
	{
		super(TileEntityTypeRegistry.NIGHTSTAND);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void read(CompoundNBT compound)
	{
		CompoundNBT inventory = compound.getCompound("Inventory");
		handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(inventory));
		super.read(compound);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		handler.ifPresent(h ->
		{
			CompoundNBT nbt = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
			compound.put("Inventory", nbt);
		});

		return super.write(compound);
	}

	private IItemHandler createHandler()
	{
		return new ItemStackHandler(4)
		{
			@Override
			protected void onContentsChanged(int slot)
			{
				markDirty();
			}
		};
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side)
	{
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return handler.cast();

		return super.getCapability(cap, side);
	}

	@Override
	public ITextComponent getDisplayName()
	{
		return new TranslationTextComponent("container.emomod.nightstand");
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity player)
	{
		return new NightstandContainer(windowId, this.getWorld(), this.getPos(), playerInventory);
	}

	public float[] getColor()
	{
		return this.color;
	}
}
