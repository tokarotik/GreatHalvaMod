package net.mod.blocks;


import net.minecraft.src.*;
import net.mod.Blocks;

public class BlockPackedConcrete extends BlockMeta {
	
	public static int[] textures = new int[] {
			Blocks.addBlocktexture("colored/packed_concrete/black.png"),
			Blocks.addBlocktexture("colored/packed_concrete/red.png"),
			Blocks.addBlocktexture("colored/packed_concrete/green.png"),
			Blocks.addBlocktexture("colored/packed_concrete/brown.png"),
			Blocks.addBlocktexture("colored/packed_concrete/blue.png"),
			Blocks.addBlocktexture("colored/packed_concrete/purple.png"),
			Blocks.addBlocktexture("colored/packed_concrete/cyan.png"),
			Blocks.addBlocktexture("colored/packed_concrete/silver.png"),
			Blocks.addBlocktexture("colored/packed_concrete/gray.png"),
			Blocks.addBlocktexture("colored/packed_concrete/pink.png"),
			Blocks.addBlocktexture("colored/packed_concrete/lime.png"),
			Blocks.addBlocktexture("colored/packed_concrete/yellow.png"),
			Blocks.addBlocktexture("colored/packed_concrete/lightBlue.png"),
			Blocks.addBlocktexture("colored/packed_concrete/magenta.png"),
			Blocks.addBlocktexture("colored/packed_concrete/orange.png"),
			Blocks.addBlocktexture("colored/packed_concrete/white.png")			
	};
	
	public BlockPackedConcrete(int blockID) {
		super(blockID, Material.rock, ItemPickaxe.class, textures, 20.0f);
	}	
}
