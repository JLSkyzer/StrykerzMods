package net.forge.mods.strykerzmods.procedures;

import net.minecraft.entity.Entity;

import net.forge.mods.strykerzmods.StrykerzmodsModVariables;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;

@StrykerzmodsModElements.ModElement.Tag
public class MoneyKeyKOnKeyPressedProcedure extends StrykerzmodsModElements.ModElement {
	public MoneyKeyKOnKeyPressedProcedure(StrykerzmodsModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MoneyKeyKOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MoneyOverlay = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
