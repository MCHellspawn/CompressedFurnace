package mchellspawn.compressedfurnace.init;

import mchellspawn.compressedfurnace.reference;
import mchellspawn.compressedfurnace.blocks.BlockCompressedCobble;
import mchellspawn.compressedfurnace.blocks.BlockCompressedFurnace;
import mchellspawn.compressedfurnace.titleentities.CompressedFurnaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block compressedfurnace;
	public static Block compressedcobble;

	
	public static void init() {
		compressedfurnace = new BlockCompressedFurnace();
		compressedcobble = new BlockCompressedCobble();
	}

	public static void postInit() {
	}
	
	public static void register() {
		GameRegistry.register(compressedfurnace);
		GameRegistry.register(compressedcobble);
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Blocks registered.");		

		GameRegistry.register(new ItemBlock(compressedfurnace), compressedfurnace.getRegistryName());
		GameRegistry.register(new ItemBlock(compressedcobble), compressedcobble.getRegistryName());
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("ItemBlocks registered.");		

		GameRegistry.registerTileEntity(CompressedFurnaceTileEntity.class, reference.MODID + "_compressedfurnace");
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("TileEntities registered.");		
	}
	
	public static void registerRenders() {
		registerRender(compressedfurnace);
		registerRender(compressedcobble);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName(),"inventory"));
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Render for block " + block.getUnlocalizedName() + " registered.");		
	}
}
