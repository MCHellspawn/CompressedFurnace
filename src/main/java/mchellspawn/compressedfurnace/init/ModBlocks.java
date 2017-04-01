package mchellspawn.compressedfurnace.init;

import mchellspawn.compressedfurnace.blocks.BlockCompressedCobble;
import mchellspawn.compressedfurnace.blocks.BlockCompressedFurnace;
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
		GameRegistry.addRecipe(new ItemStack(compressedfurnace, 1), "CCC", "C C", "CCC", 'C', ModBlocks.compressedcobble);
		GameRegistry.addRecipe(new ItemStack(compressedcobble, 1), "CCC", "CCC", "CCC", 'C', Blocks.COBBLESTONE);
	}
	
	public static void register() {
		GameRegistry.register(compressedfurnace);
		GameRegistry.register(new ItemBlock(compressedfurnace), compressedfurnace.getRegistryName());
		GameRegistry.register(compressedcobble);
		GameRegistry.register(new ItemBlock(compressedcobble), compressedcobble.getRegistryName());

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
