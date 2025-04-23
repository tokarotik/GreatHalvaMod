package net.mod.blocks;

import java.util.Random;


import net.minecraft.src.*;
import net.mod.Blocks;
import net.mod.entities.EntityFalling;

public class BlockCement extends BlockMeta {
	public static boolean fallInstantly = false;
	
	public static int[] textures = new int[] {
			Blocks.addBlocktexture("colored/cement/black.png"),
			Blocks.addBlocktexture("colored/cement/red.png"),
			Blocks.addBlocktexture("colored/cement/green.png"),
			Blocks.addBlocktexture("colored/cement/brown.png"),
			Blocks.addBlocktexture("colored/cement/blue.png"),
			Blocks.addBlocktexture("colored/cement/purple.png"),
			Blocks.addBlocktexture("colored/cement/cyan.png"),
			Blocks.addBlocktexture("colored/cement/silver.png"),
			Blocks.addBlocktexture("colored/cement/gray.png"),
			Blocks.addBlocktexture("colored/cement/pink.png"),
			Blocks.addBlocktexture("colored/cement/lime.png"),
			Blocks.addBlocktexture("colored/cement/yellow.png"),
			Blocks.addBlocktexture("colored/cement/lightBlue.png"),
			Blocks.addBlocktexture("colored/cement/magenta.png"),
			Blocks.addBlocktexture("colored/cement/orange.png"),
			Blocks.addBlocktexture("colored/cement/white.png")
	};  
	

    public BlockCement(int var1) {
        super(var1, Material.sand, ItemSpade.class, textures, 13.0f);
    }


    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, this.tickRate());
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, this.tickRate());
    }

    public void updateTick(World world, int x, int y, int z, Random var5) {
        this.tryToFall(world, x, y, z);
        if (isTouchingWater(world, x, y, z)) {
        	int meta = world.getBlockMetadata(x, y, z); 
            world.setBlockAndMetadataWithNotify(x, y, z, Blocks.ColoredConcrete.blockID, meta);
        }
    }

    private boolean isTouchingWater(World world, int x, int y, int z) {
        return isWater(world, x + 1, y, z) ||
               isWater(world, x - 1, y, z) ||
               isWater(world, x, y + 1, z) ||
               isWater(world, x, y - 1, z) ||
               isWater(world, x, y, z + 1) ||
               isWater(world, x, y, z - 1);
    }

    private boolean isWater(World world, int x, int y, int z) {
        int blockID = world.getBlockId(x, y, z);
        return blockID == Block.waterMoving.blockID || blockID == Block.waterStill.blockID;
    }
    
    private void tryToFall(World world, int x, int y, int z) {
        if (canFallBelow(world, x, y - 1, z) && y >= 0) {
            int meta = world.getBlockMetadata(x, y, z);
            byte range = 32;

            if (!fallInstantly && world.checkChunksExist(x - range, y - range, z - range, x + range, y + range, z + range)) {
            	System.out.print("meta: ");
            	System.out.println(meta);
                EntityFalling entity = new EntityFalling(world, x + 0.5D, y + 0.5D, z + 0.5D, this.blockID, meta);
                world.setBlockWithNotify(x, y, z, 0);
                world.entityJoinedWorld(entity);
            } else {
                world.setBlockWithNotify(x, y, z, 0);
                while (canFallBelow(world, x, --y, z) && y > 0) {}
                if (y > 0) {
                    world.setBlockAndMetadataWithNotify(x, y + 1, z, this.blockID, meta);
                }
            }
        }
    }
    
    public int tickRate() {
        return 3;
    }

    public static boolean canFallBelow(World var0, int var1, int var2, int var3) {
        int var4 = var0.getBlockId(var1, var2, var3);
        if (var4 == 0) {
            return true;
        } else if (var4 == Block.fire.blockID) {
            return true;
        } else {
            Material var5 = Block.blocksList[var4].blockMaterial;
            if (var5 == Material.water) {
                return true;
            } else {
                return var5 == Material.lava;
            }
        }
    }

}
