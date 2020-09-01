
package net.forge.mods.strykerzmods.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.forge.mods.strykerzmods.StrykerzmodsModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@StrykerzmodsModElements.ModElement.Tag
public class Electric_armorArmorItem extends StrykerzmodsModElements.ModElement {
	@ObjectHolder("strykerzmods:electric_armor_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("strykerzmods:electric_armor_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("strykerzmods:electric_armor_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("strykerzmods:electric_armor_armor_boots")
	public static final Item boots = null;
	public Electric_armorArmorItem(StrykerzmodsModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 21;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{5, 8, 9, 5}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 13;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "electric_armor_armor";
			}

			public float getToughness() {
				return 3f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new Modelcustom_model().bipedHead;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "strykerzmods:textures/texture_casque.png";
			}
		}.setRegistryName("electric_armor_armor_helmet"));
	}
	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer bipedHead;
		public Modelcustom_model() {
			textureWidth = 32;
			textureHeight = 32;
			bipedHead = new ModelRenderer(this);
			bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
			bipedHead.setTextureOffset(0, 13).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 9.0F, 10.0F, 0.0F, false);
			bipedHead.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			bipedHead.setTextureOffset(0, 0).addBox(5.0F, -5.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			bipedHead.setTextureOffset(0, 0).addBox(-9.0F, -5.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			bipedHead.setTextureOffset(0, 0).addBox(8.0F, -5.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			bipedHead.setTextureOffset(28, 0).addBox(8.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bipedHead.setTextureOffset(28, 0).addBox(-9.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bipedHead.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
