package mchellspawn.compressedfurnace.init;

import mchellspawn.compressedfurnace.reference;
import mchellspawn.compressedfurnace.items.ItemCompressedFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item compressedfurnace;
	
	public static void init(){
		compressedfurnace = new ItemCompressedFurnace();
	}

	public static void register() {
		GameRegistry.register(compressedfurnace);
	}
	
	public static void registerRenders() {
		registerRender(compressedfurnace);
		
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(reference.MODID + ":" + item.getUnlocalizedName(), "inventory"));
	}
}
