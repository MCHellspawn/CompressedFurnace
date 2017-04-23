package mchellspawn.compressedfurnace.proxy;

import mchellspawn.compressedfurnace.reference;
import mchellspawn.compressedfurnace.init.ModBlocks;
import mchellspawn.compressedfurnace.init.ModItems;
import mchellspawn.compressedfurnace.init.ModRecepies;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Client pre-init");
		ModItems.registerRenders();			
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Item renders registered");
		ModBlocks.registerRenders();			
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Block renders registered");
	}

	@Override
	public void Init(FMLInitializationEvent e) {
		super.Init(e);
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Client init");
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Client post-init");
		ModItems.postInit();
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Item post init complete");
		ModRecepies.registerRecipies();
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Receipies registered");		
		ModBlocks.postInit();
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Block post init complete");

	}

}
