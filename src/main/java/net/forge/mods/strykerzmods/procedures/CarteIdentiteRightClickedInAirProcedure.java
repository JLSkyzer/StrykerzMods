package net.forge.mods.strykerzmods.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;

@StrykerzmodsModElements.ModElement.Tag
public class CarteIdentiteRightClickedInAirProcedure extends StrykerzmodsModElements.ModElement {
	public CarteIdentiteRightClickedInAirProcedure(StrykerzmodsModElements instance) {
		super(instance, 8);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure CarteIdentiteRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure CarteIdentiteRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((((itemstack).getDisplayName().getString())).equals("Carte Identit\u00E9"))) {
			((itemstack))
					.setDisplayName(new StringTextComponent((("Carte d'identit\u00E9 de \u00A7e") + "" + ((entity.getDisplayName().getString())))));
			((itemstack)).addEnchantment(Enchantments.PROTECTION, (int) 10);
		}
	}
}
