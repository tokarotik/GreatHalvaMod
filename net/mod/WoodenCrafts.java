package net.mod;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.IRecipe;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.ShapedRecipes;
import net.minecraft.src.ShapelessRecipes;

public class WoodenCrafts {
	public static void replaceWoodsRecipes() {
		removeBlockRecipes(Block.planks);
		
		ModLoader.AddRecipe(new ItemStack(Block.planks, 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 0)}); // oak
		
		AddingCrafts(1, Blocks.SprucePlanks);    // spruce
		AddingCrafts(2, Blocks.BirchPlanks);    // birch
		
		AddIndividualCrafts();
	}
	
	private static void AddIndividualCrafts() {
		 ModLoader.AddRecipe(new ItemStack(Blocks.stairCompactPlanksSpruce, 4), new Object[]{"#  ", "## ", "###", '#', Blocks.SprucePlanks});
		 ModLoader.AddRecipe(new ItemStack(Blocks.stairCompactPlanksBirch, 4), new Object[]{"#  ", "## ", "###", '#', Blocks.BirchPlanks});
		 
		 ModLoader.AddRecipe(new ItemStack(Items.SpruceBoatItem, 1), new Object[]{"# #", "###", '#', Blocks.SprucePlanks});
		 ModLoader.AddRecipe(new ItemStack(Items.BirchBoatItem, 1), new Object[]{"# #", "###", '#', Blocks.BirchPlanks});
	}
	
	private static void AddingCrafts(int woodID, Block planks) {
		AddPlanksCommonCrafts(woodID, planks);
	}
	
	private static void AddPlanksCommonCrafts(int woodID, Block BlockPlanks) {
		Block planks = BlockPlanks;
		ModLoader.AddRecipe(new ItemStack(BlockPlanks, 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.wood, 1, woodID)});
		
		ModLoader.AddRecipe(new ItemStack(Block.musicBlock, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), planks, Character.valueOf('X'), Item.redstone});
		ModLoader.AddRecipe(new ItemStack(Block.jukebox, 1), new Object[]{"###", "#X#", "###", '#', planks, Character.valueOf('X'), Item.diamond});
		ModLoader.AddRecipe(new ItemStack(Item.stick, 4), new Object[] {"#","#", '#', planks});
		ModLoader.AddRecipe(new ItemStack(Block.bookShelf, 1), new Object[]{"###", "XXX", "###", '#', planks, 'X', Item.book});
		ModLoader.AddRecipe(new ItemStack(Item.bowlEmpty, 4), new Object[]{"# #", " # ", '#', planks});
		ModLoader.AddRecipe(new ItemStack(Block.pistonBase, 1), new Object[]{"TTT", "#X#", "#R#", '#', Block.cobblestone, 'X', Item.ingotIron, 'R', Item.redstone, 'T', planks});
		ModLoader.AddRecipe(new ItemStack(Item.bed, 1), new Object[]{"###", "XXX", '#', Block.cloth, 'X', planks});
		ModLoader.AddRecipe(new ItemStack(Block.workbench, 1), new Object[]{"XX", "XX", 'X', planks});
		Crafts.AddCraft(Item.pickaxeWood, new Object[]{"XXX", " Y ", " Y ", 'X', planks, 'Y', Item.stick});
		Crafts.AddCraft(Item.axeWood, new Object[]{"XX ", "XY ", " Y ", 'X', planks, 'Y', Item.stick});
		Crafts.AddCraft(Item.shovelWood, new Object[]{"X", "Y", "Y", 'X', planks, 'Y', Item.stick});
		Crafts.AddCraft(Item.hoeWood, new Object[]{"XX ", " Y ", " Y ", 'X', planks, 'Y', Item.stick});
		Crafts.AddCraft(Item.swordWood, new Object[]{"X", "X", "Y", 'X', planks, 'Y', Item.stick});
	}

	
    @SuppressWarnings("unchecked")
	private static void removeBlockRecipes(int removableBlockId) {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        for (int i = 0; i < recipes.size(); i++) {
            IRecipe recipe = recipes.get(i);
            if (recipe instanceof ShapelessRecipes || recipe instanceof ShapedRecipes) {
                ItemStack output = recipe.getRecipeOutput();
                if (output != null && output.itemID == removableBlockId) {
                    recipes.remove(i);
                    i--;
                }
            }
        }
    }
    
    private static void removeBlockRecipes(Block removableBlock) {
        removeBlockRecipes(removableBlock.blockID);
    }
}
