package mchellspawn.compressedfurnace.init;

import mchellspawn.compressedfurnace.blocks.BlockCompressedFurnace;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block compressedfurnace;

	public static void init() {
		compressedfurnace = new BlockCompressedFurnace();
	}
	
	public static void register() {
		GameRegistry.register(compressedfurnace);
	}
	
	public static void registerRenders() {
		registerRender(compressedfurnace);
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(),"inventory"));
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Render for block " + block.getUnlocalizedName() + "registered.");
	}
}
