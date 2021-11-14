package fr.emotion.emomod.blocks;

import net.minecraft.core.BlockSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface DispenserInteract
{
	public ItemStack react(Level level, BlockSource source, ItemStack stackIn);
}
