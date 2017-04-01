package mchellspawn.compressedfurnace.items;

import mchellspawn.compressedfurnace.reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSmthStonePickaxe extends net.minecraft.item.ItemPickaxe {

	public static final Item.ToolMaterial smthstoneToolMaterial = EnumHelper.addToolMaterial("SMOOTHSTONE", 2, 500, 6, 2, 14);

	public ItemSmthStonePickaxe() {
		super(smthstoneToolMaterial);
		setUnlocalizedName(reference.compressedFurnaceItems.SMTHSTONEPICKAXE.getUnlocalizedName());
		setRegistryName(reference.compressedFurnaceItems.SMTHSTONEPICKAXE.getRegistryName());
		setCreativeTab(CreativeTabs.TOOLS);
		
	}
}
