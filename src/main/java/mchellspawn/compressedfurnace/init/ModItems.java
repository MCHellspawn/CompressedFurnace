package mchellspawn.compressedfurnace.init;

import mchellspawn.compressedfurnace.reference;
import mchellspawn.compressedfurnace.items.ItemSmthStonePickaxe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item smthstonepickaxe;

	public static void init(){
		smthstonepickaxe = new ItemSmthStonePickaxe();
	}
	
	public static void postInit() {
		GameRegistry.addRecipe(new ItemStack(smthstonepickaxe, 1), new Object[] { "III", " S ", " S ", 'I', Blocks.STONE, 'S', Items.STICK });
	}

	public static void register() {
		GameRegistry.register(smthstonepickaxe);
	}
	
	public static void registerRenders() {
		registerRender(smthstonepickaxe);
	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Render for item " + item.getUnlocalizedName() + "registered.");
	}
}
