package fr.emotion.emomod.inventory.container;

import java.util.Optional;

import javax.annotation.Nullable;

import fr.emotion.emomod.items.EmoPendant;
import fr.emotion.emomod.items.EmoRing;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EmoPlayerContainer extends RecipeBookContainer<CraftingInventory>
{
	private static final String[] ARMOR_SLOT_TEXTURES = new String[]
	{ "item/empty_armor_slot_boots", "item/empty_armor_slot_leggings", "item/empty_armor_slot_chestplate", "item/empty_armor_slot_helmet" };
	private static final EquipmentSlotType[] VALID_EQUIPMENT_SLOTS = new EquipmentSlotType[]
	{ EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET };
	private final CraftingInventory craftingInventory = new CraftingInventory(this, 2, 2);
	private final CraftResultInventory craftingResultInventory = new CraftResultInventory();
	public final boolean isLocalWorld;
	private final PlayerEntity player;
	private Inventory emoInventory = new Inventory(2);

	public EmoPlayerContainer(PlayerInventory inv)
	{
		super((ContainerType<?>) null, 0);
		this.isLocalWorld = inv.player.world.isRemote;
		this.player = inv.player;
		this.addSlot(new CraftingResultSlot(inv.player, this.craftingInventory, this.craftingResultInventory, 0, 154, 28));

		for (int i = 0; i < 2; ++i)
		{
			for (int j = 0; j < 2; ++j)
			{
				this.addSlot(new Slot(this.craftingInventory, j + i * 2, 98 + j * 18, 18 + i * 18));
			}
		}

		for (int k = 0; k < 4; ++k)
		{
			final EquipmentSlotType equipmentslottype = VALID_EQUIPMENT_SLOTS[k];
			this.addSlot(new Slot(inv, 39 - k, 8, 8 + k * 18)
			{
				public int getSlotStackLimit()
				{
					return 1;
				}

				public boolean isItemValid(ItemStack stack)
				{
					return stack.canEquip(equipmentslottype, player);
				}

				public boolean canTakeStack(PlayerEntity playerIn)
				{
					ItemStack itemstack = this.getStack();
					return !itemstack.isEmpty() && !playerIn.isCreative() && EnchantmentHelper.hasBindingCurse(itemstack) ? false : super.canTakeStack(playerIn);
				}

				@Nullable
				@OnlyIn(Dist.CLIENT)
				public String getSlotTexture()
				{
					return ARMOR_SLOT_TEXTURES[equipmentslottype.getIndex()];
				}
			});
		}

		for (int l = 0; l < 3; ++l)
		{
			for (int j1 = 0; j1 < 9; ++j1)
			{
				this.addSlot(new Slot(inv, j1 + (l + 1) * 9, 8 + j1 * 18, 84 + l * 18));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1)
		{
			this.addSlot(new Slot(inv, i1, 8 + i1 * 18, 142));
		}

		this.addSlot(new Slot(inv, 40, 77, 62)
		{

			@Nullable
			@OnlyIn(Dist.CLIENT)
			public String getSlotTexture()
			{
				return "item/empty_armor_slot_shield";
			}
		});

		for (int i = 0; i < 2; i++)
		{
			this.addSlot(new Slot(emoInventory, i, 77, 8 + (i * 18))
			{
				@Override
				public int getSlotStackLimit()
				{
					return 1;
				}

				@Override
				public boolean isItemValid(ItemStack stack)
				{
					return this.getSlotIndex() == 0 ? stack.getItem() instanceof EmoPendant : stack.getItem() instanceof EmoRing;
				}

				@Override
				public boolean canTakeStack(PlayerEntity playerIn)
				{
					ItemStack stack = this.getStack();
					return !stack.isEmpty() && !playerIn.isCreative();
				}
			});
		}
	}

	public void func_201771_a(RecipeItemHelper p_201771_1_)
	{
		this.craftingInventory.fillStackedContents(p_201771_1_);
	}

	public void clear()
	{
		this.craftingResultInventory.clear();
		this.craftingInventory.clear();
	}

	public boolean matches(IRecipe<? super CraftingInventory> recipeIn)
	{
		return recipeIn.matches(this.craftingInventory, this.player.world);
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	public void onCraftMatrixChanged(IInventory inventoryIn)
	{
		this.func_217066_a(this.windowId, this.player.world, this.player, this.craftingInventory, this.craftingResultInventory);
	}

	protected void func_217066_a(int p_217066_0_, World p_217066_1_, PlayerEntity p_217066_2_, CraftingInventory p_217066_3_, CraftResultInventory p_217066_4_)
	{
		if (!p_217066_1_.isRemote)
		{
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) p_217066_2_;
			ItemStack itemstack = ItemStack.EMPTY;
			Optional<ICraftingRecipe> optional = p_217066_1_.getServer().getRecipeManager().getRecipe(IRecipeType.CRAFTING, p_217066_3_, p_217066_1_);
			if (optional.isPresent())
			{
				ICraftingRecipe icraftingrecipe = optional.get();
				if (p_217066_4_.canUseRecipe(p_217066_1_, serverplayerentity, icraftingrecipe))
				{
					itemstack = icraftingrecipe.getCraftingResult(p_217066_3_);
				}
			}

			p_217066_4_.setInventorySlotContents(0, itemstack);
			serverplayerentity.connection.sendPacket(new SSetSlotPacket(p_217066_0_, 0, itemstack));
		}
	}

	public void onContainerClosed(PlayerEntity playerIn)
	{
		super.onContainerClosed(playerIn);
		this.craftingResultInventory.clear();
		if (!playerIn.world.isRemote)
		{
			this.clearContainer(playerIn, playerIn.world, this.craftingInventory);
		}
	}

	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	{
		ItemStack newStack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack())
		{
			ItemStack stack = slot.getStack();
			newStack = stack.copy();
			EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(newStack);

			if (index == 0)
			{
				if (!this.mergeItemStack(stack, 9, 45, true))
					return ItemStack.EMPTY;

				slot.onSlotChange(stack, newStack);
			} else if (index >= 1 && index < 5)
			{
				if (!this.mergeItemStack(stack, 9, 45, false))
					return ItemStack.EMPTY;
			} else if (index >= 5 && index < 9)
			{
				if (!this.mergeItemStack(stack, 9, 45, false))
					return ItemStack.EMPTY;
			} else if (equipmentslottype.getSlotType() == EquipmentSlotType.Group.ARMOR && !this.inventorySlots.get(8 - equipmentslottype.getIndex()).getHasStack())
			{
				int i = 8 - equipmentslottype.getIndex();
				if (!this.mergeItemStack(stack, i, i + 1, false))
					return ItemStack.EMPTY;
			} else if (equipmentslottype == EquipmentSlotType.OFFHAND && !this.inventorySlots.get(45).getHasStack())
			{
				if (!this.mergeItemStack(stack, 45, 46, false))
					return ItemStack.EMPTY;
			} else if (stack.getItem() instanceof EmoPendant && !this.inventorySlots.get(46).getHasStack())
			{
				if (!this.mergeItemStack(stack, 46, 47, false))
					return ItemStack.EMPTY;
			} else if (stack.getItem() instanceof EmoRing && !this.inventorySlots.get(47).getHasStack())
			{
				if (!this.mergeItemStack(stack, 47, 48, false))
					return ItemStack.EMPTY;
			} else if (index >= 9 && index < 36)
			{
				if (!this.mergeItemStack(stack, 36, 45, false))
					return ItemStack.EMPTY;
			} else if (index >= 36 && index < 45)
			{
				if (!this.mergeItemStack(stack, 9, 36, false))
					return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(stack, 9, 45, false))
			{
				return ItemStack.EMPTY;
			}

			if (stack.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();

			if (stack.getCount() == newStack.getCount())
				return ItemStack.EMPTY;

			ItemStack itemstack2 = slot.onTake(playerIn, stack);

			if (index == 0)
				playerIn.dropItem(itemstack2, false);
		}

		return newStack;
	}

	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, PlayerEntity player)
	{
		if (slotId == 46 || slotId == 47)
		{
		}

		return super.slotClick(slotId, dragType, clickTypeIn, player);
	}

	public boolean canMergeSlot(ItemStack stack, Slot slotIn)
	{
		return slotIn.inventory != this.craftingResultInventory && super.canMergeSlot(stack, slotIn);
	}

	public int getOutputSlot()
	{
		return 0;
	}

	public int getWidth()
	{
		return this.craftingInventory.getWidth();
	}

	public int getHeight()
	{
		return this.craftingInventory.getHeight();
	}

	@OnlyIn(Dist.CLIENT)
	public int getSize()
	{
		return 5;
	}
}
