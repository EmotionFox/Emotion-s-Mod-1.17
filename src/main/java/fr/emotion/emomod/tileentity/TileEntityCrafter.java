package fr.emotion.emomod.tileentity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import fr.emotion.emomod.blocks.EmoCrafter;
import fr.emotion.emomod.init.TileEntityTypeRegistry;
import fr.emotion.emomod.inventory.container.CrafterContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.HopperBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventoryProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.HopperTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class TileEntityCrafter extends TileEntity implements ITickableTileEntity, INamedContainerProvider
{
	private String recipeId;
	private int craftingTime = 0;
	public static final int minCraftingTime = 52;
	private boolean isCrafting = false;
	private boolean isWaiting = false;
	private ItemStack resultStack = ItemStack.EMPTY;
	private List<ItemStack[]> ingredientList = new ArrayList<ItemStack[]>();

	public TileEntityCrafter()
	{
		super(TileEntityTypeRegistry.CRAFTER);
	}

	@Override
	public CompoundNBT getUpdateTag()
	{
		CompoundNBT tag = super.getUpdateTag();

		if (this.recipeId != null)
			tag.putString("RecipeId", this.recipeId);

		tag.putInt("CraftingTime", this.craftingTime);
		tag.putBoolean("IsCrafting", this.isCrafting);
		tag.putBoolean("IsWaiting", this.isWaiting);
		tag.putInt("ResultItem", Item.getIdFromItem(this.resultStack.getItem()));

		return tag;
	}

	@Override
	public void handleUpdateTag(CompoundNBT tag)
	{
		this.read(tag);
	}

	private void sendUpdates(boolean notify)
	{
		if (notify)
			world.markAndNotifyBlock(pos, world.getChunkAt(pos), getBlockState(), getBlockState(), 3);
		this.markDirty();
	}

	@Override
	public void read(CompoundNBT compound)
	{
		super.read(compound);

		this.recipeId = compound.getString("RecipeId");
		this.craftingTime = compound.getInt("CraftingTime");
		this.isCrafting = compound.getBoolean("IsCrafting");
		this.isWaiting = compound.getBoolean("IsWaiting");
		this.resultStack = new ItemStack(Item.getItemById(compound.getInt("ResultItem")), 1);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		super.write(compound);

		if (this.recipeId != null)
			compound.putString("RecipeId", this.recipeId);

		compound.putInt("CraftingTime", this.craftingTime);
		compound.putBoolean("IsCrafting", this.isCrafting);
		compound.putBoolean("IsWaiting", this.isWaiting);
		compound.putInt("ResultItem", Item.getIdFromItem(this.resultStack.getItem()));
		return compound;
	}

	@SuppressWarnings("resource")
	@Override
	public void tick()
	{
		if (!this.getWorld().isRemote)
		{
			if (this.getBlockState().get(EmoCrafter.ENABLED) && this.recipeId != null && !this.recipeId.isEmpty() && this.resultStack != null && this.resultStack != ItemStack.EMPTY)
			{
				if (this.isCrafting)
				{
					if (!this.getBlockState().get(EmoCrafter.CRAFTING))
					{
						this.getWorld().setBlockState(this.getPos(), this.getBlockState().with(EmoCrafter.CRAFTING, Boolean.valueOf(true)), 2);
					}

					if (this.craftingTime >= minCraftingTime)
					{
						this.craftingTime = 0;
						this.sendUpdates(false);

						boolean push = this.pushCraft();

						if (!push)
						{
							this.isCrafting = false;
							this.isWaiting = true;
							this.sendUpdates(true);
							return;
						}

						boolean request = this.requestItem();

						if (!request)
						{
							this.isCrafting = false;
							this.sendUpdates(true);
							return;
						}
					}

					this.craftingTime += 1;
					this.sendUpdates(false);
				} else if (this.isWaiting)
				{
					if (this.getBlockState().get(EmoCrafter.CRAFTING))
					{
						this.getWorld().setBlockState(this.getPos(), this.getBlockState().with(EmoCrafter.CRAFTING, Boolean.valueOf(false)), 2);
					}

					if (this.pushCraft())
					{
						this.isWaiting = false;
						this.sendUpdates(true);
					}
				} else
				{
					if (this.getBlockState().get(EmoCrafter.CRAFTING))
					{
						this.getWorld().setBlockState(this.getPos(), this.getBlockState().with(EmoCrafter.CRAFTING, Boolean.valueOf(false)), 2);
					}

					if (this.requestItem())
					{
						this.isCrafting = true;
						this.sendUpdates(true);
					}
				}
			}
		}
	}

	@SuppressWarnings("resource")
	public boolean requestItem()
	{
		if (!this.getWorld().isRemote && this.getWorld().getBlockState(this.getPos().up()).getBlock() instanceof HopperBlock)
		{
			IInventory blockInventory = getInventoryAtPosition(this.getWorld(), this.getPos().up());

			if (blockInventory == null || blockInventory.isEmpty())
				return false;

			List<ItemStack[]> newList = new ArrayList<ItemStack[]>();
			int listIndex = 0;

			for (int size = 0; size < ingredientList.size(); size++)
			{
				for (int length = 0; length < ingredientList.get(size).length; length++)
				{
					int[] findIndex = this.checkIn(newList, ingredientList.get(size)[length]);
					ItemStack[] newStack;

					if (findIndex != null)
					{
						newStack = new ItemStack[newList.get(findIndex[0]).length];

						for (int i = 0; i < newStack.length; i++)
						{
							if (i == findIndex[1])
								newStack[i] = new ItemStack(newList.get(findIndex[0])[i].getItem(), newList.get(findIndex[0])[i].getCount() + 1);
							else
								newStack[i] = newList.get(findIndex[0])[i];
						}

						newList.set(findIndex[0], newStack);
					} else
					{
						if (length == 0)
						{
							newList.add(new ItemStack[]
							{ ingredientList.get(size)[length] });
							listIndex++;
						} else
						{
							newStack = new ItemStack[newList.get(listIndex - 1).length + 1];

							for (int i = 0; i < newStack.length; i++)
							{
								if (i < newStack.length - 1)
									newStack[i] = newList.get(listIndex - 1)[i];
								else
									newStack[i] = ingredientList.get(size)[length];
							}

							newList.set(listIndex - 1, newStack);
						}
					}
				}
			}

			Boolean[] matching = new Boolean[newList.size()];
			int total = 0;

			for (int size = 0; size < newList.size(); size++)
			{
				for (int sizeInventory = 0; sizeInventory < blockInventory.getSizeInventory(); sizeInventory++)
				{
					for (int length = 0; length < newList.get(size).length; length++)
					{
						ItemStack stack = newList.get(size)[length];
						ItemStack invStack = blockInventory.getStackInSlot(sizeInventory);

						if (invStack.getItem() == stack.getItem())
						{
							if (invStack.getCount() + total >= stack.getCount())
							{
								matching[size] = true;
							} else
								total += invStack.getCount();
						}
					}
				}

				total = 0;
			}

			for (int i = 0; i < matching.length; i++)
			{
				if (matching[i] == null)
					return false;
			}

			for (int size = 0; size < newList.size(); size++)
			{
				for (int sizeInventory = 0; sizeInventory < blockInventory.getSizeInventory(); sizeInventory++)
				{
					for (int length = 0; length < newList.get(size).length; length++)
					{
						ItemStack stack = newList.get(size)[length];
						ItemStack invStack = blockInventory.getStackInSlot(sizeInventory);

						if (invStack.getItem() == stack.getItem())
						{
							if (invStack.getCount() + total >= stack.getCount())
							{
								int dif = (invStack.getCount() + total) - stack.getCount();

								if (dif <= 0)
									blockInventory.setInventorySlotContents(sizeInventory, ItemStack.EMPTY);
								else
									blockInventory.decrStackSize(sizeInventory, stack.getCount());
							} else
							{
								total += invStack.getCount();
								blockInventory.setInventorySlotContents(sizeInventory, ItemStack.EMPTY);
							}
						}
					}
				}

				total = 0;
			}

			return true;
		}

		return false;
	}

	@SuppressWarnings("resource")
	public boolean pushCraft()
	{
		if (!this.getWorld().isRemote && this.getWorld().getBlockState(this.getPos().down()).getBlock() instanceof HopperBlock)
		{
			IInventory inventory = getInventoryAtPosition(this.getWorld(), this.getPos().down());

			if (inventory == null || !this.getWorld().getBlockState(this.getPos().down()).get(HopperBlock.ENABLED) || this.resultStack == null)
				return false;

			ItemStack result = new ItemStack(this.resultStack.getItem(), this.resultStack.getCount());
			ItemStack rest = HopperTileEntity.putStackInInventoryAllSlots(null, inventory, result, null);

			if (rest != result)
			{
				this.sendUpdates(true);
				return true;
			}
		}

		return false;
	}

	@Nullable
	public int[] checkIn(List<ItemStack[]> list, ItemStack stack)
	{
		for (int size = 0; size < list.size(); size++)
		{
			for (int length = 0; length < list.get(size).length; length++)
			{
				if (stack.getItem() == list.get(size)[length].getItem())
				{
					return new int[]
					{ size, length };
				}
			}
		}

		return null;
	}

	public void setIngredient(List<ItemStack[]> ingredients, String recipeId, ItemStack resultStack)
	{
		this.ingredientList = ingredients;
		this.recipeId = recipeId;
		this.resultStack = resultStack;
		this.sendUpdates(false);
	}

	@Nullable
	public static IInventory getInventoryAtPosition(World worldIn, BlockPos pos)
	{
		IInventory inventory = null;
		BlockState blockstate = worldIn.getBlockState(pos);
		Block block = blockstate.getBlock();

		if (block instanceof ISidedInventoryProvider)
		{
			inventory = ((ISidedInventoryProvider) block).createInventory(blockstate, worldIn, pos);
		} else if (blockstate.hasTileEntity())
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof IInventory)
			{
				inventory = (IInventory) tileentity;
				if (inventory instanceof ChestTileEntity && block instanceof ChestBlock)
					inventory = ChestBlock.getInventory(blockstate, worldIn, pos, true);
			}
		}

		if (inventory == null)
		{
			List<Entity> list = worldIn.getEntitiesInAABBexcluding((Entity) null, new AxisAlignedBB(pos.getX() - 0.5D, pos.getY() - 0.5D, pos.getZ() - 0.5D, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D), EntityPredicates.HAS_INVENTORY);
			if (!list.isEmpty())
				inventory = (IInventory) list.get(worldIn.rand.nextInt(list.size()));
		}

		return inventory;
	}

	public boolean isCrafting()
	{
		return this.isCrafting;
	}

	public ItemStack getResult()
	{
		return this.resultStack;
	}

	@Nullable
	public String getRecipe()
	{
		return this.recipeId;
	}

	@Override
	public ITextComponent getDisplayName()
	{
		return new TranslationTextComponent("container.emomod.crafter");
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity player)
	{
		return new CrafterContainer(windowId, this.getWorld(), this.getPos(), player);
	}
}
