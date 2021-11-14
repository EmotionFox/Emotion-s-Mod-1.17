package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.enchantment.EnchantmentBloodSucking;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = MainRegistry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnchantmentRegistry
{
	public static final ResourceLocation BLOOD_SUCKING_LOCATION = new ResourceLocation(MainRegistry.MOD_ID, "blood_sucking");

	@ObjectHolder(MainRegistry.MOD_ID + ":blood_sucking")
	public static Enchantment BLOOD_SUCKING = null;

	@SubscribeEvent
	public static void registerEnchantment(final RegistryEvent.Register<Enchantment> e)
	{
		e.getRegistry().register(new EnchantmentBloodSucking(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND}).setRegistryName(MainRegistry.MOD_ID + ":blood_sucking"));
	}
}
