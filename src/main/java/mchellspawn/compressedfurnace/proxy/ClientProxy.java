package mchellspawn.compressedfurnace.proxy;

import mchellspawn.compressedfurnace.init.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
		System.out.println("I am CLIENT pre-init!!");
		
	}

	@Override
	public void Init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.Init(e);
		System.out.println("I am CLIENT init!!");
		ModItems.registerRenders();		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
		System.out.println("I am CLIENT post-init!!");
	}

}
