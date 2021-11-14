package fr.emotion.emomod.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Nullable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

public abstract class RecipeCreator
{
	private static final String comment = "  \"_comment\": \"Edited For Emotion's Mod\",\n";

	public static boolean fileExist(File file)
	{
		if (file.exists())
			return true;
		else
		{
			try
			{
				file.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}

			return false;
		}
	}

	public static void shaped(@Nullable String group, String[] pattern, RecipeInput ingredient, IItemProvider result, int recipeCount){ shaped(group, pattern, new RecipeInput[] {ingredient}, new ItemStack(result), recipeCount); }
	public static void shaped(@Nullable String group, String[] pattern, RecipeInput ingredient, ItemStack result, int recipeCount){ shaped(group, pattern, new RecipeInput[] {ingredient}, result, recipeCount); }
	public static void shaped(@Nullable String group, String[] pattern, RecipeInput[] ingredient, IItemProvider result, int recipeCount){ shaped(group, pattern, ingredient, new ItemStack(result), recipeCount); }
	
	public static void shaped(@Nullable String group, String[] pattern, RecipeInput[] ingredients, ItemStack result, int recipeCount)
	{
		Path path = Paths.get("B:/Users/micka_000/Documents/Minecraft Modding/EmotionMod/src/main/resources/data/emomod/recipes/emo_shaped_" + result.getItem().getRegistryName().getPath() + "_"
				+ recipeCount + ".json");
		String recipe = "";

		if (fileExist(path.toFile()))
			return;

		try (Writer writer = new FileWriter(path.toFile()); BufferedWriter bw = new BufferedWriter(writer))
		{
			recipe += "{\n" + comment + "  \"type\": \"minecraft:crafting_shaped\",\n";

			if (group != null && !group.isEmpty())
				recipe += "  \"group\": \"" + group + "\",\n";

			recipe += "  \"pattern\": [\n";

			for (int lenght = 0; lenght < pattern.length; lenght++)
			{
				recipe += "    \"" + pattern[lenght] + "\"";

				if (lenght != pattern.length - 1)
					recipe += ",";

				recipe += "\n";
			}

			recipe += "  ],\n  \"key\": {\n";

			for (int index = 0; index < ingredients.length; index++)
			{
				recipe += "    \"" + ingredients[index].getKey() + "\": {\n      \"" + ingredients[index].getTag() + "\": \"" + ingredients[index].getName() + "\"\n    }";

				if (index != ingredients.length - 1)
					recipe += ",";

				recipe += "\n";
			}

			recipe += "  },\n" + getResult(result);

			bw.write(recipe);
			bw.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void shapeless(@Nullable String group, IItemProvider ingredient, IItemProvider result, int recipeCount){ shapeless(group, new IItemProvider[] {ingredient}, new ItemStack(result), recipeCount); }
	public static void shapeless(@Nullable String group, IItemProvider ingredient, ItemStack result, int recipeCount){ shapeless(group, new IItemProvider[] {ingredient}, result, recipeCount); }
	public static void shapeless(@Nullable String group, IItemProvider[] ingredient, IItemProvider result, int recipeCount){ shapeless(group, ingredient, new ItemStack(result), recipeCount); }
	
	public static void shapeless(@Nullable String group, IItemProvider[] ingredients, ItemStack result, int recipeCount)
	{
		Path path = Paths.get("B:/Users/micka_000/Documents/Minecraft Modding/EmotionMod/src/main/resources/data/emomod/recipes/emo_shapeless_" + result.getItem().getRegistryName().getPath() + "_"
				+ recipeCount + ".json");
		String recipe = "";

		if (fileExist(path.toFile()))
			return;

		try (Writer writer = new FileWriter(path.toFile()); BufferedWriter bw = new BufferedWriter(writer))
		{
			recipe += "{\n" + comment + "  \"type\": \"minecraft:crafting_shapeless\",\n";

			if (group != null && !group.isEmpty())
				recipe += "  \"group\": \"" + group + "\",\n";

			recipe += "  \"ingredients\": [\n";

			for (int lenght = 0; lenght < ingredients.length; lenght++)
			{
				recipe += "    {\n      \"item\": \"" + ingredients[lenght].asItem().getRegistryName().toString() + "\"\n    }";

				if (lenght != ingredients.length - 1)
					recipe += ",";

				recipe += "\n";
			}

			recipe += "  ],\n" + getResult(result);

			bw.write(recipe);
			bw.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void stonecutting(@Nullable String group, IItemProvider ingredient, ItemStack result, int recipeCount)
	{
		Path path = Paths.get("B:/Users/micka_000/Documents/Minecraft Modding/EmotionMod/src/main/resources/data/emomod/recipes/emo_stonecutting_" + result.getItem().getRegistryName().getPath() + "_"
				+ recipeCount + ".json");
		String recipe = "";

		if (fileExist(path.toFile()))
			return;

		try (Writer writer = new FileWriter(path.toFile()); BufferedWriter bw = new BufferedWriter(writer))
		{
			recipe += "{\n" + comment + "  \"type\": \"minecraft:stonecutting\",\n";

			if (group != null && !group.isEmpty())
				recipe += "  \"group\": \"" + group + "\",\n";

			recipe += "  \"ingredient\": {\n    \"item\": \"" + ingredient.asItem().getRegistryName().toString() + "\"\n  },\n";

			recipe += getResult(result, true);

			bw.write(recipe);
			bw.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void campfire(@Nullable String group, IItemProvider ingredient, IItemProvider result, int recipeCount, float exp, int... cookingtime){ cookingRecipe("campfire_cooking", group, ingredient, result, recipeCount, exp, cookingtime.length > 0 ? cookingtime[0] : 600); }
	public static void smelting(@Nullable String group, IItemProvider ingredient, IItemProvider result, int recipeCount, float exp, int... cookingtime){ cookingRecipe("smelting", group, ingredient, result, recipeCount, exp, cookingtime.length > 0 ? cookingtime[0] : 200); }
	public static void smoking(@Nullable String group, IItemProvider ingredient, IItemProvider result, int recipeCount, float exp, int... cookingtime){ cookingRecipe("smoking", group, ingredient, result, recipeCount, exp, cookingtime.length > 0 ? cookingtime[0] : 100); }
	public static void blasting(@Nullable String group, IItemProvider ingredient, IItemProvider result, int recipeCount, float exp, int... cookingtime){ cookingRecipe("blasting", group, ingredient, result, recipeCount, exp, cookingtime.length > 0 ? cookingtime[0] : 100); }

	private static void cookingRecipe(String type, @Nullable String group, IItemProvider ingredient, IItemProvider result, int recipeCount, float exp, int cookingtime)
	{
		Path path = Paths.get("B:/Users/micka_000/Documents/Minecraft Modding/EmotionMod/src/main/resources/data/emomod/recipes/emo_" + type + "_" + result.asItem().getRegistryName().getPath() + "_"
				+ recipeCount + ".json");
		String recipe = "";

		if (fileExist(path.toFile()))
			return;

		try (Writer writer = new FileWriter(path.toFile()); BufferedWriter bw = new BufferedWriter(writer))
		{
			recipe += "{\n" + comment + "  \"type\": \"minecraft:" + type + "\",\n";

			if (group != null && !group.isEmpty())
				recipe += "  \"group\": \"" + group + "\",\n";

			recipe += "  \"ingredient\": {\n    \"item\": \"" + ingredient.asItem().getRegistryName().toString() + "\"\n  },\n";

			recipe += getResult(result.asItem(), exp, cookingtime);

			bw.write(recipe);
			bw.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	
	private static String getResult(ItemStack result)
	{
		String str = "  \"result\": {\n    \"item\": \"" + result.getItem().getRegistryName().toString() + "\"";

		if (result.getCount() > 1)
			str += ",\n    \"count\": " + result.getCount();

		str += "\n  }\n}";

		return str;
	}

	private static String getResult(ItemStack result, boolean stonecutting)
	{
		return "  \"result\": \"" + result.getItem().getRegistryName().toString() + "\",\n  \"count\": " + result.getCount() + "\n}";
	}
	
	private static String getResult(Item result, float exp, int cookingtime)
	{
		return "  \"result\": \"" + result.getRegistryName().toString() + "\",\n  \"experience\": " + Float.toString(exp) + ",\n  \"cookingtime\": " + Integer.toString(cookingtime) + "\n}";
	}
}
