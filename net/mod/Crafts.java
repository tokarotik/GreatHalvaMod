package net.mod;

import net.minecraft.src.*;

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
		
		AddCraft(Blocks.HalvaBlock, 4, new Object[]{"XX", "XX", 'X', Block.dirt});
		AddCraft(Blocks.CheeseBlock, new Object[]{"XY", 'X', Item.bucketMilk,  'Y', Item.bucketWater});
		AddCraft(new ItemStack(Block.blockSteel, 1), new Object[] {"X", 'X', Block.dirt});
	}
	
	public static void AddCementRecipes() {
		for (int i = 0; i < BlockCement.textures.length; i++)
		{
			AddCraft(Blocks.ColouredCement, 8, i, new Object[]{
			    "DXX",
			    "XXY",
			    "YYY",
			    'D', new ItemStack(Item.dyePowder, 1, i),
			    'X', Block.sand,
			    'Y', Block.gravel 
			});
		}
	}
	
}
