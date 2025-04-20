package net.mod;

import java.util.Random;

import net.minecraft.src.*;


public class BlockCement extends Block {
	public static boolean fallInstantly = false;
	
	static int[] textures = new int[] {
			Blocks.addBlocktexture("coloured/cement/black.png"),
			Blocks.addBlocktexture("coloured/cement/red.png"),
			Blocks.addBlocktexture("coloured/cement/green.png"),
			Blocks.addBlocktexture("coloured/cement/brown.png"),
			Blocks.addBlocktexture("coloured/cement/blue.png"),
			Blocks.addBlocktexture("coloured/cement/purple.png"),
			Blocks.addBlocktexture("coloured/cement/cyan.png"),
			Blocks.addBlocktexture("coloured/cement/silver.png"),
			Blocks.addBlocktexture("coloured/cement/gray.png"),
			Blocks.addBlocktexture("coloured/cement/pink.png"),
			Blocks.addBlocktexture("coloured/cement/lime.png"),
			Blocks.addBlocktexture("coloured/cement/yellow.png"),
			Blocks.addBlocktexture("coloured/cement/lightBlue.png"),
			Blocks.addBlocktexture("coloured/cement/magenta.png"),
			Blocks.addBlocktexture("coloured/cement/orange.png"),
			Blocks.addBlocktexture("coloured/cement/white.png")
	};
	
    public BlockCement(int var1) {
        super(var1, textures[1], Material.sand);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
    	int index = 0;
    	
        if (meta < 16) {
        	index = meta;
        }
        
        return BlockCement.textures[index];
    }

    public int damageDropped(int meta) {
        return meta;
    }


    protected int getDropMetadata(int meta) {
        return meta;
    }
    
    public int idDropped(int var1, Random var2) {
    	return this.blockID;
    }
    
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving) {
        if (entityliving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityliving;
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack != null) {
                int meta = itemstack.getItemDamage();
                world.setBlockMetadataWithNotify(x, y, z, meta);
           }
        }
    }
    
    public float blockStrength(EntityPlayer player) {
        ItemStack heldItem = player.getCurrentEquippedItem();
        if (heldItem != null && heldItem.getItem() instanceof ItemSpade) {
        	ItemSpade shovel = (ItemSpade) heldItem.getItem();
        	
        	return Math.abs((this.blockHardness - shovel.getMaterial().getEfficiencyOnProperMaterial()) + 1.0f) / 13.0f;
        }

        return super.blockStrength(player);
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
            world.setBlockWithNotify(x, y, z, Block.dirt.blockID);
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
