package fr.emotion.emomod.enchantment;

import fr.emotion.emomod.MainRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MainRegistry.MOD_ID)
public class EnchantmentBloodSucking extends Enchantment
{
	public EnchantmentBloodSucking(Rarity rarityIn, EnchantmentCategory typeIn, EquipmentSlot[] slots)
	{
		super(rarityIn, typeIn, slots);
	}

	@Override
	public int getMaxLevel()
	{
		return 3;
	}

	@Override
	public int getMinCost(int enchantmentLevel)
	{
		return 30 * (enchantmentLevel - 1);
	}

	@Override
	public int getMaxCost(int enchantmentLevel)
	{
		return super.getMinCost(enchantmentLevel) + 50;
	}

	// Suck The Blood From Entity
	@Override
	public void doPostHurt(LivingEntity user, Entity target, int level)
	{
		if (target instanceof LivingEntity)
		{
			LivingEntity entity = (LivingEntity) target;
			float health = user.getHealth();
			float targetHealth = entity.getHealth();
			float pourcent = (100 / 3) * level;
			float gainHealth = targetHealth * pourcent / 100;

			if (!user.swinging)
				user.setHealth(health + gainHealth);
		}
	}
}
