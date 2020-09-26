package net.forge.mods.strykerzmods.procedures;

import net.minecraft.entity.Entity;

import net.forge.mods.strykerzmods.StrykerzmodsModVariables;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;

@StrykerzmodsModElements.ModElement.Tag
public class MoneyKeyKOnKeyReleasedProcedure extends StrykerzmodsModElements.ModElement {
	public MoneyKeyKOnKeyReleasedProcedure(StrykerzmodsModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MoneyKeyKOnKeyReleased!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (false);
			entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MoneyOverlay = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
