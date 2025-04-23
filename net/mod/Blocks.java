package net.mod;

import net.minecraft.src.*;
import net.mod.blocks.*;
import net.mod.items.ItemColored;



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
	public static final Block ColoredChoppedConcrete = (new BlockChoppedConcrete(106)).setHardness(2F).setStepSound(Block.soundPowderFootstep).setBlockName("cooked_concrete");
	public static final Block ColoredPackedConcrete = (new BlockPackedConcrete(107)).setHardness(2F).setStepSound(Block.soundPowderFootstep).setBlockName("packed_concrete");
	
	static final Block[] ColoredBlocks = new Block[]{
			ColoredCement,
			ColoredConcrete,
			ColoredChoppedConcrete,
			ColoredPackedConcrete
	};
	
	
	public static void RegisterBlock() {
		RegisterColoredBlock();
		
		ModLoader.RegisterBlock(HalvaBlock);
		ModLoader.RegisterBlock(CheeseBlock);
		ModLoader.RegisterBlock(SprucePlanks);
		ModLoader.RegisterBlock(BirchPlanks);
		ModLoader.RegisterBlock(stairCompactPlanksSpruce);
		ModLoader.RegisterBlock(stairCompactPlanksBirch);
	}
	
	
	public static void RegisterColoredBlock() {
		for (int i = 0; i < ColoredBlocks.length; i++) {
			ModLoader.RegisterBlock(ColoredBlocks[i], ItemColored.class);
		}
	}
	
	
	public static void AddName() {
		AddColoredNames();
		
		ModLoader.AddName(SprucePlanks, "Planks");
		ModLoader.AddName(BirchPlanks, "Planks");
		
		ModLoader.AddName(stairCompactPlanksSpruce, "Stairs");
		ModLoader.AddName(stairCompactPlanksBirch, "Stairs");
		
		ModLoader.AddName(HalvaBlock, "Halva");
		
		ModLoader.AddName(CheeseBlock, "Cheese");
		
		ModLoader.AddName(GlassDoor, "Glass Block Door. Stop! Your're cheater?");
	}
	
	public static void AddColoredNames() {
		AddColoredName(ColoredCement, "Cement");
		AddColoredName(ColoredConcrete, "Concrete");
		AddColoredName(ColoredChoppedConcrete, "Chopped Concrete");
		AddColoredName(ColoredPackedConcrete, "Packed Concrete");
	}

	
	public static void AddColoredName(Block colored, String name) {
		for (int i = 0; i < ItemDye.dyeColorNames.length; i++) {
			String color = ItemDye.dyeColorNames[i];
			
			String colorName = color;
			if (color == "silver") {colorName = "light Gray";}
			if (color == "lightBlue") {colorName = "light Blue";}
			
			String UppestColor = colorName.substring(0, 1).toUpperCase() + colorName.substring(1);
			ModLoader.AddName(new ItemStack(colored, 1, i), UppestColor + " " + name);
			
		}		
	}

	
    public static int addBlocktexture(String path) {
		return ModLoader.addOverride(PATH_TERRAIN, PATH_BLOCKS_ASSETS + path);
    }
}
