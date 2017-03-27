package mchellspawn.compressedfurnace;

import org.apache.logging.log4j.Logger;

import mchellspawn.compressedfurnace.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = reference.MODID, version = reference.VERSION, name = reference.MODNAME, useMetadata = true, acceptedMinecraftVersions = "[1.10.2]")
public class compressedfurnace
{
	@Instance
	public static compressedfurnace instance;

	@SidedProxy(clientSide = reference.CLIENTPROXY, serverSide = reference.SERVERPROXY)
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        // some example code
        
        logger = event.getModLog();
        proxy.preInit(event);
        
    }
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        proxy.Init(event);
    }

	@EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
        // some example code
        proxy.postInit(event);
    }
}
