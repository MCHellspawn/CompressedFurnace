package mchellspawn.compressedfurnace.blocks;

import mchellspawn.compressedfurnace.reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCompressedFurnace extends Block {
	
	public BlockCompressedFurnace() {
		super(Material.ROCK);
		setUnlocalizedName(reference.compressedFurnaceBlocks.COMPRESSEDFURNACE.getUnlocalizedName());
		setRegistryName(reference.compressedFurnaceBlocks.COMPRESSEDFURNACE.getRegistryName());
	}
}
