package mchellspawn.compressedfurnace.proxy;

import mchellspawn.compressedfurnace.reference;
import mchellspawn.compressedfurnace.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
		System.out.println("I am CLIENT pre-init!!");
		ModItems.registerRenders();			
	}

	@Override
	public void Init(FMLInitializationEvent e) {
		super.Init(e);
		System.out.println("I am CLIENT init!!");
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		System.out.println("I am CLIENT post-init!!");
	}

}
