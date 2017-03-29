package mchellspawn.compressedfurnace.proxy;

import java.io.File;

import mchellspawn.compressedfurnace.init.ModBlocks;
import mchellspawn.compressedfurnace.init.ModItems;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent e) {
		//Setup config file handler
		File directory = e.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "compressedfurnace.cfg"));
		config.getConfigFile();
		
		ModItems.init();
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Items initialized");
		ModBlocks.init();
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Blocks initialized");
		
		ModItems.register();
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Items registered");
		ModBlocks.register();
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Blocks registered");

	}
	
	public void Init(FMLInitializationEvent e) {
	}
	
	public void postInit(FMLPostInitializationEvent e){
	}
	
}
