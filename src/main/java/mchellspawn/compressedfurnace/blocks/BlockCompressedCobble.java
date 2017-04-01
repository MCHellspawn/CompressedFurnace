package mchellspawn.compressedfurnace.blocks;

import mchellspawn.compressedfurnace.compressedfurnace;
import mchellspawn.compressedfurnace.reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;

public class BlockCompressedCobble extends Block {
	
	public BlockCompressedCobble() {
		super(Material.ROCK);
		setUnlocalizedName(reference.compressedFurnaceBlocks.COMPRESSEDCOBBLE.getUnlocalizedName());
		setRegistryName(reference.compressedFurnaceBlocks.COMPRESSEDCOBBLE.getRegistryName());
		setCreativeTab(compressedfurnace.CREATIVE_TAB_MAIN);
        setHardness(2.0f);
        setResistance(15.0f);
        setHarvestLevel("pickaxe", 1);
	}
}
