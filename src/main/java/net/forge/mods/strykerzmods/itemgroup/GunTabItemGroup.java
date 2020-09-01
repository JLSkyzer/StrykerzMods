
package net.forge.mods.strykerzmods.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.forge.mods.strykerzmods.item.Ak47Item;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

@StrykerzmodsModElements.ModElement.Tag
public class GunTabItemGroup extends StrykerzmodsModElements.ModElement {
	public GunTabItemGroup(StrykerzmodsModElements instance) {
		super(instance, 56);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabgun_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Ak47Item.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
