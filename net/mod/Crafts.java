package net.mod;

import net.minecraft.src.*;
import net.mod.blocks.*;

public class Crafts {
	public static void AddCraft(ItemStack crafted, Object[] craft) {
		ModLoader.AddRecipe(crafted, craft);
	}
	
	public static void AddCraft(Block block, int count, int meta, Object[] craft) {
		AddCraft(new ItemStack(block, count, meta), craft);
	}
	
	public static void AddCraft(Block block, int count, Object[] craft) {
		AddCraft(new ItemStack(block, count), craft);
	}
	
	public static void AddCraft(Block block, Object[] craft) {
		AddCraft(new ItemStack(block, 1), craft);
	}
	
	public static void AddCraft(Item item, int count, int meta, Object[] craft) {
		AddCraft(new ItemStack(item, count, meta), craft);
	}
	
	public static void AddCraft(Item item, int count, Object[] craft) {
		AddCraft(new ItemStack(item, count), craft);
	}
	
	public static void AddCraft(Item item, Object[] craft) {
		AddCraft(new ItemStack(item, 1), craft);
	}
	
	public static void AddRecipe() {
		WoodenCrafts.replaceWoodsRecipes();
		
		AddCementRecipes();
		Add—hoppedConcreteRecipes();
		AddPackedConcreteRecipes();
		
		
		AddCraft(Blocks.HalvaBlock, 4, new Object[]{"XX", "XX", 'X', Block.dirt});
		AddCraft(Blocks.CheeseBlock, new Object[]{"XY", 'X', Item.bucketMilk,  'Y', Item.bucketWater});
		AddCraft(new ItemStack(Item.bone, 1), new Object[] {"X", 'X', Block.dirt});
		AddCraft(new ItemStack(Item.dyePowder, 64, 4), new Object[] {"XX", 'X', Block.dirt});
	}
	
	public static void AddCementRecipes() {
		for (int i = 0; i < BlockCement.textures.length; i++)
		{
			AddCraft(Blocks.ColoredCement, 8, i, new Object[]{
			    "DXX",
			    "XXY",
			    "YYY",
			    'D', new ItemStack(Item.dyePowder, 1, i),
			    'X', Block.sand,
			    'Y', Block.gravel 
			});
		}
	}
	
	public static void Add—hoppedConcreteRecipes() {
		for (int i = 0; i < BlockChoppedConcrete.textures.length; i++)
		{
			AddCraft(Blocks.ColoredChoppedConcrete, 9, i, new Object[]{
			    "XXX",
			    "XXX",
			    "XXX",
			    'X', new ItemStack(Blocks.ColoredConcrete, 1, i),
			});
		}		
	}
	
	public static void AddPackedConcreteRecipes() {
		for (int i = 0; i < BlockPackedConcrete.textures.length; i++)
		{
			AddCraft(Blocks.ColoredPackedConcrete, 4, i, new Object[]{
			    "XX",
			    "XX",
			    'X', new ItemStack(Blocks.ColoredConcrete, 1, i),
			});
		}		
	}
}
