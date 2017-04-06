package mchellspawn.compressedfurnace.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecepies {

	public static void registerRecipies() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedfurnace, 1), "CCC", "C C", "CCC", 'C', ModBlocks.compressedcobble);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedcobble, 1), "CCC", "CCC", "CCC", 'C', Blocks.COBBLESTONE);
	}
}
