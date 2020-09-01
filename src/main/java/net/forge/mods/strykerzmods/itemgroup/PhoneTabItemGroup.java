
package net.forge.mods.strykerzmods.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.forge.mods.strykerzmods.item.PhoneItem;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

@StrykerzmodsModElements.ModElement.Tag
public class PhoneTabItemGroup extends StrykerzmodsModElements.ModElement {
	public PhoneTabItemGroup(StrykerzmodsModElements instance) {
		super(instance, 45);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabphone_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PhoneItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
