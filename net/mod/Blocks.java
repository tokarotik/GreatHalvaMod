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

	public static final Block ColoredCement = (new BlockCement(104)).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setBlockName("cement");
	public static final Block ColoredConcrete = (new BlockConcrete(105)).setHardness(2F).setStepSound(Block.soundStoneFootstep).setBlockName("concrete");
	
	public static void RegisterBlock() {
		ModLoader.RegisterBlock(HalvaBlock);
		ModLoader.RegisterBlock(CheeseBlock);
		ModLoader.RegisterBlock(SprucePlanks);
		ModLoader.RegisterBlock(BirchPlanks);
		ModLoader.RegisterBlock(stairCompactPlanksSpruce);
		ModLoader.RegisterBlock(stairCompactPlanksBirch);
		
		ModLoader.RegisterBlock(ColoredCement, ItemCement.class);
		ModLoader.RegisterBlock(ColoredConcrete, ItemConcrete.class);
	}
	
	public static void AddName() {
		AddCementName();
		AddConcreteName();
		
		ModLoader.AddName(SprucePlanks, "Planks");
		ModLoader.AddName(BirchPlanks, "Planks");
		
		ModLoader.AddName(stairCompactPlanksSpruce, "Stairs");
		ModLoader.AddName(stairCompactPlanksBirch, "Stairs");
		
		ModLoader.AddName(HalvaBlock, "Halva");
		
		ModLoader.AddName(CheeseBlock, "Cheese");
		
		ModLoader.AddName(GlassDoor, "Glass Block Door. Stop! Your're cheater?");
	}
	
	public static void AddCementName() {
		for (int i = 0; i < BlockCement.textures.length; i++) {
			String color = ItemDye.dyeColorNames[i];
			String UppestColor = color.substring(0, 1).toUpperCase() + color.substring(1);
			ModLoader.AddName(new ItemStack(ColoredCement, 1, i), UppestColor + " Cement");
			
		}
	}
	
	public static void AddConcreteName() {
		for (int i = 0; i < BlockCement.textures.length; i++) {
			String color = ItemDye.dyeColorNames[i];
			String UppestColor = color.substring(0, 1).toUpperCase() + color.substring(1);
			ModLoader.AddName(new ItemStack(ColoredConcrete, 1, i), UppestColor + " Concrete");
			
		}
	}

	
    public static int addBlocktexture(String path) {
		return ModLoader.addOverride(PATH_TERRAIN, PATH_BLOCKS_ASSETS + path);
    }
}
