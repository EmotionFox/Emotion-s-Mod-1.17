package fr.emotion.emomod.dispenser;

import fr.emotion.emomod.blocks.DispenserInteract;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;

public class InteractBehavior implements DispenseItemBehavior
{
	@Override
	public ItemStack dispense(BlockSource source, ItemStack stack)
	{
		BlockPos sourcePos = source.getPos();
		BlockPos targetPos = sourcePos.relative(source.getBlockState().getValue(DispenserBlock.FACING));
		Block targetBlock = source.getLevel().getBlockState(targetPos).getBlock();

		if (targetBlock instanceof DispenserInteract)
		{
			source.getLevel().blockEvent(targetPos, targetBlock, 1000, 0);
			source.getLevel().blockEvent(targetPos, targetBlock, 2005, 0);

			return ((DispenserInteract) targetBlock).react(source.getLevel(), source, stack);
		}
		return (new DefaultDispenseItemBehavior()).dispense(source, stack);
	}
}
