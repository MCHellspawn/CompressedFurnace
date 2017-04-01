package mchellspawn.compressedfurnace;

import mchellspawn.compressedfurnace.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class compressedfurnacetab extends CreativeTabs {

	public compressedfurnacetab() {
		super("tabCompressedFurnace");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.compressedfurnace);
	}	
}
