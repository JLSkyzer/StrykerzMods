package net.forge.mods.strykerzmods.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;
import java.util.HashMap;

@StrykerzmodsModElements.ModElement.Tag
public class RechercherProcedureProcedure extends StrykerzmodsModElements.ModElement {
	public RechercherProcedureProcedure(StrykerzmodsModElements instance) {
		super(instance, 77);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RechercherProcedure!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				System.err.println("Failed to load dependency guistate for procedure RechercherProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:RechercherBar");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("none"))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("nothing"), (false));
			}
		}
	}
}
