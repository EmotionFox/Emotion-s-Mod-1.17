package fr.emotion.emomod.inventory.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import fr.emotion.emomod.init.BlockRegistry;
import fr.emotion.emomod.init.ContainerTypeRegistry;
import fr.emotion.emomod.tileentity.TileEntityCrafter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrafterContainer extends Container
{
	private NonNullList<RecipeSlot> defaultSlots = NonNullList.create();
	private NonNullList<RecipeSlot> currentSlots = NonNullList.create();
	private NonNullList<IngredientSlot> craftingSlots = NonNullList.create();
	private World world;
	private TileEntityCrafter tileEntity;
	public PlayerEntity player;

	public CrafterContainer(int id, World world, BlockPos pos, PlayerEntity player)
	{
		super(ContainerTypeRegistry.CRAFTER, id);
		this.world = world;

		if (world.getTileEntity(pos) instanceof TileEntityCrafter)
			tileEntity = (TileEntityCrafter) world.getTileEntity(pos);

		this.player = player;
		boolean flag = tileEntity.getRecipe() == null ? false : !tileEntity.getRecipe().isEmpty() ? true : false;

		this.init(flag);
	}

	public void init(boolean hasRecipe)
	{
		Collection<IRecipe<?>> recipes = this.world.getRecipeManager().getRecipes();

		int xGap = 18;
		int yGap = 18;
		int xIndex = 0;
		int yIndex = 0;

		int index = 0;
		int page = 0;

		for (IRecipe<?> recipe : recipes)
		{
			if (recipe.getType() == IRecipeType.CRAFTING)
			{
				defaultSlots.add(new RecipeSlot(this, this.world.getRecipeManager().getRecipe(recipe.getId()).get(), page));
				index++;

				if (index >= 45)
				{
					index = 0;
					page++;
				}
			}
		}

		// this.maxPage = page;

		for (int i = 0; i < 9; i++)
		{
			IngredientSlot slot = new IngredientSlot();
			craftingSlots.add(slot);
			this.addSlot(slot);
			slot.xPos = -59 + (xIndex * xGap);
			slot.yPos = 36 + (yIndex * yGap);

			xIndex++;

			if (xIndex >= 3)
			{
				xIndex = 0;
				yIndex++;
			}
		}

		xIndex = 0;
		yIndex = 0;

		for (int i = 0; i < 45; i++)
		{
			RecipeSlot slot = new RecipeSlot(this);
			currentSlots.add(slot);
			this.addSlot(slot);
			slot.xPos = 9 + (xIndex * xGap);
			slot.yPos = 18 + (yIndex * yGap);

			index++;
			xIndex++;

			if (xIndex >= 9)
			{
				xIndex = 0;
				yIndex++;
			}
		}

		this.setInventory(0);

		if (hasRecipe)
		{
			IRecipe<?> recipe = this.world.getRecipeManager().getRecipe(new ResourceLocation(this.getTileEntity().getRecipe())).get();

			if (recipe.getSerializer() == IRecipeSerializer.CRAFTING_SHAPED)
				this.setCraft((ShapedRecipe) recipe, false);
			else
				this.setCraft(recipe, false);
		}
	}

	public void setCraft(IRecipe<?> recipe, boolean reset)
	{
		List<ItemStack[]> ingredients = new ArrayList<ItemStack[]>();

		for (int i = 0; i < craftingSlots.size(); i++)
		{
			if (i < recipe.getIngredients().size())
			{
				if (recipe.getIngredients().get(i).getMatchingStacks().length <= 0)
					craftingSlots.get(i).setIngredients(new ItemStack[]
					{ ItemStack.EMPTY });
				else
				{
					craftingSlots.get(i).setIngredients(recipe.getIngredients().get(i).getMatchingStacks());
					ingredients.add(recipe.getIngredients().get(i).getMatchingStacks());
				}
			} else
			{
				craftingSlots.get(i).setIngredients(new ItemStack[]
				{ ItemStack.EMPTY });
			}
		}

		if (reset)
			this.tileEntity.setIngredient(ingredients, recipe.getId().toString(), recipe.getRecipeOutput());
	}

	public void setCraft(ShapedRecipe recipe, boolean reset)
	{
		List<ItemStack[]> ingredients = new ArrayList<ItemStack[]>();

		int width = 0;
		int height = 0;
		int ingredient = 0;

		for (int i = 0; i < craftingSlots.size(); i++)
		{
			if (width < recipe.getRecipeWidth() && height < recipe.getRecipeHeight())
			{
				if (recipe.getIngredients().get(ingredient).getMatchingStacks().length <= 0)
					craftingSlots.get(i).setIngredients(new ItemStack[]
					{ ItemStack.EMPTY });
				else
				{
					craftingSlots.get(i).setIngredients(recipe.getIngredients().get(ingredient).getMatchingStacks());
					ingredients.add(recipe.getIngredients().get(ingredient).getMatchingStacks());
				}

				ingredient++;
			} else
			{
				craftingSlots.get(i).setIngredients(new ItemStack[]
				{ ItemStack.EMPTY });
				;
			}

			width++;

			if (width >= 3)
			{
				width = 0;
				height++;
			}
		}

		if (reset)
			this.tileEntity.setIngredient(ingredients, recipe.getId().toString(), recipe.getRecipeOutput());
	}

	public void setInventory(int page, String... tags)
	{
		if (this.defaultSlots.isEmpty())
			return;

		NonNullList<IRecipe<?>> recipeList = NonNullList.create();

		if (tags.length > 0)
		{
			int count = 0;
			int newPage = 0;

			for (int i = 0; i < this.defaultSlots.size(); i++)
			{
				RecipeSlot slot = this.defaultSlots.get(i);
				String id = slot.getRecipeId().split(":")[0].toLowerCase();
				String name = slot.getRecipeId().split(":")[1].toLowerCase();

				boolean hasTag = false;

				for (String tag : tags)
				{
					if (tag.toLowerCase().equals(id))
					{
						hasTag = true;
					} else if (name.contains("_"))
					{
						for (int j = 0; j < name.split("_").length; j++)
						{
							if (name.split("_")[j].contains(tag.toLowerCase()))
								hasTag = true;
						}
					} else if (name.contains(tag.toLowerCase()))
					{
						hasTag = true;
					}
				}

				if (hasTag)
				{
					if (newPage == page)
						recipeList.add(slot.recipe);

					count++;

					if (count >= 45)
					{
						count = 0;
						newPage++;
					}
				}
			}

			for (int i = 0; i < 45; i++)
			{
				if (i >= recipeList.size())
					this.currentSlots.get(i).setRecipe(null);
				else
					this.currentSlots.get(i).setRecipe(recipeList.get(i));
			}
		}

		for (int i = 0; i < 45; i++)
		{
			if (tags.length > 0)
			{
				if (i >= recipeList.size())
					this.currentSlots.get(i).setRecipe(null);
				else
					this.currentSlots.get(i).setRecipe(recipeList.get(i));
			} else
			{
				int index = page <= 0 ? i : i * page;

				if (index >= this.defaultSlots.size())
					this.currentSlots.get(i).setRecipe(null);
				else
					this.currentSlots.get(i).setRecipe(this.defaultSlots.get(index).getRecipe());
			}
		}
	}

	public void tick()
	{
		for (int i = 0; i < this.craftingSlots.size(); i++)
		{
			this.craftingSlots.get(i).tick();
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerIn, BlockRegistry.CRAFTER);
	}

	public TileEntityCrafter getTileEntity()
	{
		if (this.tileEntity instanceof TileEntityCrafter)
			return (TileEntityCrafter) this.tileEntity;
		return null;
	}

	public int getMaxPage()
	{
		return Math.round(this.defaultSlots.size() / 45);
	}

	public class RecipeSlot extends Slot
	{
		private IRecipe<?> recipe;
		private CrafterContainer parent;
		private int page;

		public RecipeSlot(CrafterContainer parent, @Nullable IRecipe<?> recipe, int page)
		{
			this(parent);
			this.recipe = recipe;
			this.page = page;
			this.putStack(recipe.getRecipeOutput());
		}

		public RecipeSlot(CrafterContainer parent)
		{
			super(new Inventory(1), 0, 0, 0);
			this.parent = parent;
		}

		@Override
		public void putStack(ItemStack stack)
		{
			this.inventory.setInventorySlotContents(0, stack);
		}

		@Override
		public boolean canTakeStack(PlayerEntity playerIn)
		{
			if (this.recipe != null)
			{
				if (this.recipe.getSerializer() == IRecipeSerializer.CRAFTING_SHAPED)
					this.parent.setCraft((ShapedRecipe) this.recipe, true);
				else
					this.parent.setCraft(this.recipe, true);

				if (this.parent.player != null)
					player.playSound(SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, 1.0f, 1.0f);
			}

			return false;
		}

		@Override
		public boolean isItemValid(ItemStack stack)
		{
			return false;
		}

		public void setRecipe(@Nullable IRecipe<?> recipe)
		{
			this.recipe = recipe;

			if (this.recipe != null)
				this.putStack(recipe.getRecipeOutput());
			else
				this.putStack(ItemStack.EMPTY);
		}

		public void setPage(int page)
		{
			this.page = page;
		}

		public String getRecipeId()
		{
			if (this.recipe != null)
				return this.recipe.getId().toString();
			else
				return "";
		}

		@Nullable
		public IRecipe<?> getRecipe()
		{
			return this.recipe;
		}

		public int getPage()
		{
			return this.page;
		}
	}

	public class IngredientSlot extends Slot
	{
		private ItemStack[] ingredients = new ItemStack[]
		{ ItemStack.EMPTY };
		int current = 0;
		int tick = 0;

		public IngredientSlot()
		{
			super(new Inventory(1), 0, 0, 0);
		}

		public void tick()
		{
			if (tick >= 16)
			{
				if (ingredients.length <= 0)
					return;
				else if (current >= ingredients.length)
					current = 0;

				this.putStack(ingredients[current]);

				tick = 0;
				current++;
			}

			tick++;
		}

		@Override
		public void putStack(ItemStack stack)
		{
			this.inventory.setInventorySlotContents(0, stack);
			this.onSlotChanged();
		}

		@Override
		public boolean canTakeStack(PlayerEntity playerIn)
		{
			return false;
		}

		@Override
		public boolean isItemValid(ItemStack stack)
		{
			return false;
		}

		public void setIngredients(ItemStack[] ingredients)
		{
			this.ingredients = ingredients;
			this.putStack(ingredients[0]);
		}
	}
}
