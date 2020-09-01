
package net.forge.mods.strykerzmods.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.forge.mods.strykerzmods.procedures.ConditionMoneyOverlayOnProcedure;
import net.forge.mods.strykerzmods.StrykerzmodsModVariables;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import com.google.common.collect.ImmutableMap;

@StrykerzmodsModElements.ModElement.Tag
public class MoneyOverlayOverlay extends StrykerzmodsModElements.ModElement {
	public MoneyOverlayOverlay(StrykerzmodsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (ConditionMoneyOverlayOnProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft
						.getInstance().fontRenderer
								.drawString(
										"\u00A7eTa money: \u00A7a"
												+ ((entity.getCapability(StrykerzmodsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new StrykerzmodsModVariables.PlayerVariables())).money)
												+ " $",
										posX + 77, posY + 14, -1);
			}
		}
	}
}
