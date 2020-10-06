
package net.forge.mods.strykerzmods.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.forge.mods.strykerzmods.StrykerzmodsModElements;

@StrykerzmodsModElements.ModElement.Tag
public class TestPainting extends StrykerzmodsModElements.ModElement {
	public TestPainting(StrykerzmodsModElements instance) {
		super(instance, 75);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerTileEntity(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 32).setRegistryName("test"));
	}
}
