
package net.forge.mods.strykerzmods.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.forge.mods.strykerzmods.procedures.MagazineRightClickedInAirProcedure;
import net.forge.mods.strykerzmods.itemgroup.GunTabItemGroup;
import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import java.util.Map;
import java.util.HashMap;

@StrykerzmodsModElements.ModElement.Tag
public class MagazineItem extends StrykerzmodsModElements.ModElement {
	@ObjectHolder("strykerzmods:magazine")
	public static final Item block = null;
	public MagazineItem(StrykerzmodsModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(GunTabItemGroup.tab).maxStackSize(3));
			setRegistryName("magazine");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MagazineRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
