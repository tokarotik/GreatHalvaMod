package net.mod.blocks;


import net.minecraft.src.*;
import net.mod.Blocks;

public class BlockChoppedConcrete extends BlockMeta {
	
	public static int[] textures = new int[] {
			Blocks.addBlocktexture("colored/chopped_concrete/black.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/red.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/green.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/brown.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/blue.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/purple.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/cyan.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/silver.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/gray.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/pink.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/lime.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/yellow.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/lightBlue.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/magenta.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/orange.png"),
			Blocks.addBlocktexture("colored/chopped_concrete/white.png")			
	};
	
	public BlockChoppedConcrete(int blockID) {
		super(blockID, Material.rock, ItemPickaxe.class, textures, 20.0f);
	}	
}
