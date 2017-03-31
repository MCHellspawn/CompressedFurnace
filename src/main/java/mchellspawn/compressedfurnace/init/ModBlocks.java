package mchellspawn.compressedfurnace.init;

import mchellspawn.compressedfurnace.blocks.BlockCompressedFurnace;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block compressedfurnace;
	public static ItemBlock itmblkcompressedfurnace;

	public static void init() {
		compressedfurnace = new BlockCompressedFurnace();
		itmblkcompressedfurnace = new ItemBlock(compressedfurnace);
		mchellspawn.compressedfurnace.compressedfurnace.logger.info(compressedfurnace.getUnlocalizedName());
		mchellspawn.compressedfurnace.compressedfurnace.logger.info(compressedfurnace.getRegistryName());

	}
	
	public static void register() {
		GameRegistry.register(compressedfurnace);
		GameRegistry.register(itmblkcompressedfurnace, compressedfurnace.getRegistryName());
	}
	
	public static void registerRenders() {
		registerRender(compressedfurnace);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName(),"inventory"));
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Render for block " + block.getUnlocalizedName() + " registered.");
		
	}
}
