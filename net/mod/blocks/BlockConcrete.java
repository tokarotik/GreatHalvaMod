package net.mod.blocks;

import net.minecraft.src.*;
import net.mod.Blocks;

public class BlockConcrete extends BlockMeta {
	
	public static int[] textures = new int[] {
			Blocks.addBlocktexture("colored/concrete/black.png"),
			Blocks.addBlocktexture("colored/concrete/red.png"),
			Blocks.addBlocktexture("colored/concrete/green.png"),
			Blocks.addBlocktexture("colored/concrete/brown.png"),
			Blocks.addBlocktexture("colored/concrete/blue.png"),
			Blocks.addBlocktexture("colored/concrete/purple.png"),
			Blocks.addBlocktexture("colored/concrete/cyan.png"),
			Blocks.addBlocktexture("colored/concrete/silver.png"),
			Blocks.addBlocktexture("colored/concrete/gray.png"),
			Blocks.addBlocktexture("colored/concrete/pink.png"),
			Blocks.addBlocktexture("colored/concrete/lime.png"),
			Blocks.addBlocktexture("colored/concrete/yellow.png"),
			Blocks.addBlocktexture("colored/concrete/lightBlue.png"),
			Blocks.addBlocktexture("colored/concrete/magenta.png"),
			Blocks.addBlocktexture("colored/concrete/orange.png"),
			Blocks.addBlocktexture("colored/concrete/white.png")			
	};
	
	public BlockConcrete(int blockID) {
		super(blockID, Material.rock, ItemPickaxe.class, textures, 12.0f);
	}	
}
