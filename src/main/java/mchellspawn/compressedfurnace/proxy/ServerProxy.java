package mchellspawn.compressedfurnace.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Server pre-init");
	}

	@Override
	public void Init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.Init(e);
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Server init");
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Server post-init");
	}

}
