package net.forge.mods.strykerzmods.procedures;

import net.minecraft.entity.Entity;

import net.forge.mods.strykerzmods.StrykerzmodsModVariables;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;

@StrykerzmodsModElements.ModElement.Tag
public class ConditionMoneyOverlayOnProcedure extends StrykerzmodsModElements.ModElement {
	public ConditionMoneyOverlayOnProcedure(StrykerzmodsModElements instance) {
		super(instance, 2);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ConditionMoneyOverlayOn!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (((entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new StrykerzmodsModVariables.PlayerVariables())).MoneyOverlay) == (true));
	}
}
