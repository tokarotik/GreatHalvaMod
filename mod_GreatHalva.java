package net.minecraft.src;

import java.util.List;
import java.util.Map;

import net.mod.*;


public class mod_GreatHalva extends BaseMod{
	public static final String PATH_BLOCKS_ASSETS = "/greathalva/blocks/";
	private static final String PATH_ENTITIES_ASSETS = "/greathalva/entities/";
	
	public static final String[] boats_texture = new String[] {
			PATH_ENTITIES_ASSETS + "boat1.png",
			PATH_ENTITIES_ASSETS + "boat2.png"
	};
	
	
	public mod_GreatHalva() {		
		Items.AddName();
		Items.AddRecipe();
		
		Blocks.RegisterBlock();
		Blocks.AddName();
		Blocks.AddRecipe();

		ModLoader.RegisterEntityID(EntitySpruceBoat.class, "SpruceBoat", ModLoader.getUniqueEntityId());
		ModLoader.RegisterEntityID(EntityBirchBoat.class, "BirchBoat", ModLoader.getUniqueEntityId());
		
		replaceWoodsRecipes();
	}
	
	
	
	public String Version( ) {
		return "1.3";
	}
    
	public void AddRenderer(Map<Class<? extends Entity>, Render> map) {
    	map.put(EntitySpruceBoat.class, new RenderSpruceBoat());
    	map.put(EntityBirchBoat.class, new RenderBirchBoat());
    }
	
	
	private void replaceWoodsRecipes() {
		removeBlockRecipes(Block.planks);
		
		ModLoader.AddRecipe(new ItemStack(Block.planks, 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 0)}); // oak
		
		AddingCrafts(1, Blocks.SprucePlanks);    // spruce
		AddingCrafts(2, Blocks.BirchPlanks);    // birch
		
		AddIndividualCrafts();
	}
	
	private void AddIndividualCrafts() {
		 ModLoader.AddRecipe(new ItemStack(Blocks.stairCompactPlanksSpruce, 4), new Object[]{"#  ", "## ", "###", '#', Blocks.SprucePlanks});
		 ModLoader.AddRecipe(new ItemStack(Blocks.stairCompactPlanksBirch, 4), new Object[]{"#  ", "## ", "###", '#', Blocks.BirchPlanks});
		 
		 ModLoader.AddRecipe(new ItemStack(Items.SpruceBoatItem, 1), new Object[]{"# #", "###", '#', Blocks.SprucePlanks});
		 ModLoader.AddRecipe(new ItemStack(Items.BirchBoatItem, 1), new Object[]{"# #", "###", '#', Blocks.BirchPlanks});
	}
	
	private void AddingCrafts(int woodID, Block planks) {
		AddPlanksCommonCrafts(woodID, planks);
	}
	
	private void AddPlanksCommonCrafts(int woodID, Block BlockPlanks) {
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
	}

	
    @SuppressWarnings("unchecked")
	private void removeBlockRecipes(int removableBlockId) {
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
    
    private void removeBlockRecipes(Block removableBlock) {
        removeBlockRecipes(removableBlock.blockID);
    }
}
