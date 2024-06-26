
package com.thevale.trenchcoatmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.thevale.trenchcoatmod.item.BrownCoatItem;
import com.thevale.trenchcoatmod.TrenchcoatmodModElements;

@TrenchcoatmodModElements.ModElement.Tag
public class TrenchcoatsItemGroup extends TrenchcoatmodModElements.ModElement {
	public TrenchcoatsItemGroup(TrenchcoatmodModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtrenchcoats") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BrownCoatItem.body);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
