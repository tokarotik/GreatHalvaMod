package net.mod;

import net.minecraft.src.*;



public class Blocks {
	public static final String PATH_BLOCKS_ASSETS = "/greathalva/blocks/";
	private static final String PATH_TERRAIN = "/terrain.png";
	
	private static final int[] planks_textures = new int[] {
			addBlocktexture("spruce_planks.png"), 
			addBlocktexture("birch_planks.png")
	};
	
	public static final Block HalvaBlock = (new BlockHalva(97, addBlocktexture("halva.png"), Material.glass, false)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("HalvaBlock");
	public static final Block CheeseBlock = (new BlockCheese(98, addBlocktexture("block_cheese.png"))).setHardness(0.3F).setStepSound(Block.soundClothFootstep).setBlockName("CheeseBlock");
	
	public static final Block GlassDoor = (new BlockGlassDoor(99, Material.wood, addBlocktexture("top_glass_door.png"), addBlocktexture("down_glass_door.png"))).setHardness(3.0F).setStepSound(Block.soundGlassFootstep).setBlockName("doorGlass").disableStats().disableNeighborNotifyOnMetadataChange();
	
	public static final Block SprucePlanks = (new BlockPlanks(100, planks_textures[0])).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setBlockName("wood").disableNeighborNotifyOnMetadataChange();
	public static final Block BirchPlanks =  (new BlockPlanks(101, planks_textures[1])).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setBlockName("wood").disableNeighborNotifyOnMetadataChange();
	
	public static final Block stairCompactPlanksSpruce = (new BlockStairs(102, SprucePlanks)).setBlockName("stairsWood").disableNeighborNotifyOnMetadataChange();
	public static final Block stairCompactPlanksBirch = (new BlockStairs(103, BirchPlanks)).setBlockName("stairsWood").disableNeighborNotifyOnMetadataChange();

	public static final Block ColouredCement = (new BlockCement(104)).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setBlockName("cement");
	
	
	public static void RegisterBlock() {
		ModLoader.RegisterBlock(HalvaBlock);
		ModLoader.RegisterBlock(CheeseBlock);
		ModLoader.RegisterBlock(SprucePlanks);
		ModLoader.RegisterBlock(BirchPlanks);
		ModLoader.RegisterBlock(stairCompactPlanksSpruce);
		ModLoader.RegisterBlock(stairCompactPlanksBirch);
		ModLoader.RegisterBlock(ColouredCement, ItemCement.class);
	}
	
	public static void AddName() {
        ModLoader.AddName(new ItemStack(ColouredCement, 1, 0), "Black Cement");
        ModLoader.AddName(new ItemStack(ColouredCement, 1, 1), "Blue Cement");
        ModLoader.AddName(new ItemStack(ColouredCement, 1, 2), "Brown Cement");
        ModLoader.AddName(new ItemStack(ColouredCement, 1, 3), "Cyan Cement");
		
		
		ModLoader.AddName(SprucePlanks, "Planks");
		ModLoader.AddName(BirchPlanks, "Planks");
		
		ModLoader.AddName(stairCompactPlanksSpruce, "Stairs");
		ModLoader.AddName(stairCompactPlanksBirch, "Stairs");
		
		ModLoader.AddName(HalvaBlock, "Halva");
		
		ModLoader.AddName(CheeseBlock, "Cheese");
		
		ModLoader.AddName(GlassDoor, "Glass Block Door. Stop! Your're cheater?");
	}
	
	public static void AddRecipe() {
		AddCementRecipes();
		
		ModLoader.AddRecipe(new ItemStack(HalvaBlock, 4), new Object[]{
			    "XX",
			    "XX",
			    Character.valueOf('X'), Block.dirt  
			});
		
		ModLoader.AddRecipe(new ItemStack(CheeseBlock, 1), new Object[]{
			    "XY", 
			    Character.valueOf('X'), Item.bucketMilk,  
			    Character.valueOf('Y'), Item.bucketWater
			});
	}
	
	public static void AddCementRecipes() {
		for (int i = 0; i < BlockCement.textures.length; i++)
		ModLoader.AddRecipe(new ItemStack(ColouredCement, 8, i), new Object[]{
			    "DXX",
			    "XXY",
			    "YYY",
			    Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, i),
			    Character.valueOf('X'), Block.sand,
			    Character.valueOf('Y'), Block.gravel 
			});		
	}

	
    public static int addBlocktexture(String path) {
		return ModLoader.addOverride(PATH_TERRAIN, PATH_BLOCKS_ASSETS + path);
    }
}
