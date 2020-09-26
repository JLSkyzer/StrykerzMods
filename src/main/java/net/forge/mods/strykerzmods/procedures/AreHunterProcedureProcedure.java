package net.forge.mods.strykerzmods.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.forge.mods.strykerzmods.StrykerzmodsModVariables;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;

@StrykerzmodsModElements.ModElement.Tag
public class AreHunterProcedureProcedure extends StrykerzmodsModElements.ModElement {
	public AreHunterProcedureProcedure(StrykerzmodsModElements instance) {
		super(instance, 80);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AreHunterProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new StrykerzmodsModVariables.PlayerVariables())).AreHunter) == (false))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AreHunter = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("\u00A7k\u00A71|\u00A7r\u00A7bHunter\u00A7k\u00A71| \u00A7r\u00A7fVous etes deja hunter"), (false));
			}
		}
	}
}
