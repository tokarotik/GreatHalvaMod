package net.minecraft.src;

import java.util.List;
import java.util.Map;

import net.mod.*;


public class mod_GreatHalva extends BaseMod{
	private static int[] planks_textures = new int[]
		{
			ModLoader.addOverride("/terrain.png", "/greathalva/spruce_planks.png"), 
			ModLoader.addOverride("/terrain.png", "/greathalva/birch_planks.png")
		};
	
	
	public static final Block HalvaBlock = (new BlockHalva(97, ModLoader.addOverride("/terrain.png", "/greathalva/halva.png"), Material.glass, false)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("HalvaBlock");
	public static final Block CheeseBlock = (new BlockCheese(98, ModLoader.addOverride("/terrain.png", "/greathalva/block_cheese.png"))).setHardness(0.3F).setStepSound(Block.soundClothFootstep).setBlockName("CheeseBlock");
	
	public static final Block GlassDoor = (new BlockGlassDoor(99, Material.wood, ModLoader.addOverride("/terrain.png", "/greathalva/top_glass_door.png"), ModLoader.addOverride("/terrain.png", "/greathalva/down_glass_door.png"))).setHardness(3.0F).setStepSound(Block.soundGlassFootstep).setBlockName("doorGlass").disableStats().disableNeighborNotifyOnMetadataChange();
	
	public static final Block SprucePlanks = (new BlockPlanks(100, planks_textures[0])).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setBlockName("wood").disableNeighborNotifyOnMetadataChange();
	public static final Block BirchPlanks =  (new BlockPlanks(101, planks_textures[1])).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setBlockName("wood").disableNeighborNotifyOnMetadataChange();
	
	public static final Block stairCompactPlanksSpruce = (new BlockStairs(102, SprucePlanks)).setBlockName("stairsWood").disableNeighborNotifyOnMetadataChange();
	public static final Block stairCompactPlanksBirch = (new BlockStairs(103, BirchPlanks)).setBlockName("stairsWood").disableNeighborNotifyOnMetadataChange();
	
	public static final Item GlassDoorItem = (new ItemCustomDoor(5000, Material.wood, GlassDoor)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/greathalva/item_glass_door.png")).setItemName("doorGlass");
	public static final Item SpruceBoatItem = new ItemSpruceBoat(5001).setIconIndex(ModLoader.addOverride("/gui/items.png", "/greathalva/boat_spruce.png")).setItemName("spruceBoat");
	public static final Item BirchBoatItem = new ItemBirchBoat(5002).setIconIndex(ModLoader.addOverride("/gui/items.png", "/greathalva/boat_birch.png")).setItemName("birchBoat");;
	public static final Item CheeseFood = (new ItemCookie(5003, 2, false, 16)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/greathalva/cheese.png")).setItemName("cheese");
	
	
	private static Block[] mod_burn_blocks = new Block[]
			{
					SprucePlanks,
					BirchPlanks,
					stairCompactPlanksSpruce,
					stairCompactPlanksBirch
			};
	
	
	public mod_GreatHalva() {		
		ModLoader.RegisterBlock(HalvaBlock);
		ModLoader.RegisterBlock(CheeseBlock);
		ModLoader.RegisterBlock(SprucePlanks);
		ModLoader.RegisterBlock(BirchPlanks);
		ModLoader.RegisterBlock(stairCompactPlanksSpruce);
		ModLoader.RegisterBlock(stairCompactPlanksBirch);
		
		
		ModLoader.AddName(SprucePlanks, "Planks");
		ModLoader.AddName(BirchPlanks, "Planks");
		
		ModLoader.AddName(stairCompactPlanksSpruce, "Stairs");
		ModLoader.AddName(stairCompactPlanksBirch, "Stairs");
		
		ModLoader.AddName(HalvaBlock, "Halva");
		
		ModLoader.AddName(CheeseBlock, "Cheese");
		ModLoader.AddName(CheeseFood, "Cheese Head");
		
		ModLoader.AddName(GlassDoor, "Glass Block Door. Stop! Your're cheater?");
		ModLoader.AddName(GlassDoorItem, "Glass Door");
		
		ModLoader.AddName(SpruceBoatItem, "Boat");
		ModLoader.AddName(BirchBoatItem, "Boat");
		

		ModLoader.RegisterEntityID(EntitySpruceBoat.class, "SpruceBoat", ModLoader.getUniqueEntityId());
		ModLoader.RegisterEntityID(EntityBirchBoat.class, "BirchBoat", ModLoader.getUniqueEntityId());
		
		ModLoader.AddRecipe(new ItemStack(HalvaBlock, 4), new Object[]{
			    "XX",
			    "XX",
			    Character.valueOf('X'), Block.dirt  
			});
		
		ModLoader.AddRecipe(new ItemStack(GlassDoorItem, 1), new Object[]{
			    "XX",
			    "XX",
			    "XX",
			    Character.valueOf('X'), Block.glass  
			});
		
		
		ModLoader.AddRecipe(new ItemStack(CheeseBlock, 1), new Object[]{
			    "XY", 
			    Character.valueOf('X'), Item.bucketMilk,  
			    Character.valueOf('Y'), Item.bucketWater
			});
		
		ModLoader.AddRecipe(new ItemStack(CheeseFood, 9), new Object[]{
				"XY", 
			    Character.valueOf('X'), CheeseBlock,  
			    Character.valueOf('Y'), Item.arrow
			});		

		replaceWoodsRecipes();
		//addToBurnAndMine(mod_burn_blocks);
	}
	
	
	
	public String Version( ) {
		return "1.6";
	}
    
	public void AddRenderer(Map<Class<? extends Entity>, Render> map) {
    	map.put(EntitySpruceBoat.class, new RenderSpruceBoat());
    	map.put(EntityBirchBoat.class, new RenderBirchBoat());
    }
	
	
	private void replaceWoodsRecipes() {
		removingBlocksRecipes();
		
		ModLoader.AddRecipe(new ItemStack(Block.planks, 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.wood, 1, 0)}); // oak
		
		AddingCrafts(1, SprucePlanks);    // spruce
		AddingCrafts(2, BirchPlanks);    // birch
		
		AddIndividualCrafts();
	}
	
	private void AddIndividualCrafts() {
		 ModLoader.AddRecipe(new ItemStack(stairCompactPlanksSpruce, 4), new Object[]{"#  ", "## ", "###", '#', SprucePlanks});
		 ModLoader.AddRecipe(new ItemStack(stairCompactPlanksBirch, 4), new Object[]{"#  ", "## ", "###", '#', BirchPlanks});
		 
		 ModLoader.AddRecipe(new ItemStack(SpruceBoatItem, 1), new Object[]{"# #", "###", '#', SprucePlanks});
		 ModLoader.AddRecipe(new ItemStack(BirchBoatItem, 1), new Object[]{"# #", "###", '#', BirchPlanks});
	}
	
	private void AddingCrafts(int woodID, Block planks) {
		AddPlanksCommonCrafts(woodID, planks);
		AddCustomPlanksCrafts(planks);
	}
	
	private void AddCustomPlanksCrafts(Block planks) {} // EMPTY
	
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
	
	private void removingBlocksRecipes() {
		removeBlockRecipes(Block.planks);
	}
	
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
    
    private void addToBurnAndMine(Block[] blocks) {
    	for (int i = 0; i < blocks.length; i++) {
    		this.addToBurnAndMine(blocks[i]);
    	}
    }
    
    private void addToBurnAndMine(Block block) {
    	Block.fire.setBurnRate(block.blockID, 5, 20);
    	
    	
    }
   

}
