package net.forge.mods.strykerzmods.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.forge.mods.strykerzmods.item.Billet500Item;
import net.forge.mods.strykerzmods.StrykerzmodsModVariables;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;

@StrykerzmodsModElements.ModElement.Tag
public class Retirer500Procedure extends StrykerzmodsModElements.ModElement {
	public Retirer500Procedure(StrykerzmodsModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Retirer500!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new StrykerzmodsModVariables.PlayerVariables())).money) >= 500)) {
			{
				double _setval = (double) (((entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new StrykerzmodsModVariables.PlayerVariables())).money) - 500);
				entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.money = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Billet500Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
