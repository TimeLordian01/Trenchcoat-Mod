
package com.thevale.trenchcoatmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import com.thevale.trenchcoatmod.itemgroup.TrenchcoatsItemGroup;
import com.thevale.trenchcoatmod.TrenchcoatmodModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TrenchcoatmodModElements.ModElement.Tag
public class OrangeCoatItem extends TrenchcoatmodModElements.ModElement {

	@ObjectHolder("trenchcoatmod:orange_coat_chestplate")
	public static final Item body = null;


	public OrangeCoatItem(TrenchcoatmodModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "orange_coat";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(TrenchcoatsItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new ModelTrenchcoat().Body;
				armorModel.bipedLeftArm = new ModelTrenchcoat().LeftArm;
				armorModel.bipedRightArm = new ModelTrenchcoat().RightArm;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "trenchcoatmod:textures/orange_coat.png";
			}
		}.setRegistryName("orange_coat_chestplate"));
	}

	// Made with Blockbench 4.10.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelTrenchcoat extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer RightArm;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;

		public ModelTrenchcoat() {
			textureWidth = 64;
			textureHeight = 64;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.setTextureOffset(32, 30).addBox(-4.0F, -0.5F, -2.5F, 3.0F, 13.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(32, 16).addBox(1.0F, -0.5F, -2.5F, 3.0F, 13.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(12, 25).addBox(3.0F, -0.5F, -1.5F, 1.0F, 13.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(0, 30).addBox(-4.0F, -0.5F, -1.5F, 1.0F, 13.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(22, 46).addBox(-3.0F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(45, 43).addBox(2.0F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(0, 0).addBox(-4.0F, -0.5F, 1.5F, 8.0F, 13.0F, 1.0F, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			RightArm.setTextureOffset(25, 0).addBox(-3.5F, -2.5F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, false);
			RightArm.setTextureOffset(20, 20).addBox(0.5F, -2.5F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, false);
			RightArm.setTextureOffset(18, 0).addBox(-2.5F, -2.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			RightArm.setTextureOffset(8, 41).addBox(-2.5F, -2.5F, -2.5F, 3.0F, 11.0F, 1.0F, 0.0F, false);
			RightArm.setTextureOffset(40, 34).addBox(-2.5F, -2.5F, 1.5F, 3.0F, 11.0F, 1.0F, 0.0F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			LeftArm.setTextureOffset(40, 10).addBox(-0.5F, -2.5F, 1.5F, 3.0F, 11.0F, 1.0F, 0.0F, false);
			LeftArm.setTextureOffset(13, 9).addBox(2.5F, -2.5F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, false);
			LeftArm.setTextureOffset(40, 22).addBox(-0.5F, -2.5F, -2.5F, 3.0F, 11.0F, 1.0F, 0.0F, false);
			LeftArm.setTextureOffset(18, 0).addBox(-0.5F, -2.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			LeftArm.setTextureOffset(0, 14).addBox(-1.5F, -2.5F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightLeg.setTextureOffset(37, 0).addBox(-2.1F, 0.5F, 1.5F, 4.0F, 9.0F, 1.0F, 0.0F, false);
			RightLeg.setTextureOffset(0, 46).addBox(-2.1F, 0.5F, -0.5F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftLeg.setTextureOffset(16, 44).addBox(1.1F, 0.5F, -0.5F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			LeftLeg.setTextureOffset(20, 36).addBox(-1.9F, 0.5F, 1.5F, 4.0F, 9.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
