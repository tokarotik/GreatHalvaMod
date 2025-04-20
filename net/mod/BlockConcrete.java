package net.mod;

import java.util.Random;

import net.minecraft.src.*;

public class BlockConcrete extends Block {
	
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
		super(blockID, textures[0], Material.rock);
	}
	
    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
    	int index = 0;
    	
        if (meta < 16) {
        	index = meta;
        }
        
        return textures[index];
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
        if (heldItem != null && heldItem.getItem() instanceof ItemPickaxe) {
        	ItemPickaxe item = (ItemPickaxe) heldItem.getItem();
        	
        	return Math.abs((this.blockHardness - item.getMaterial().getEfficiencyOnProperMaterial()) + 1.0f) / 12.0f;
        }

        return super.blockStrength(player);
    }
}
