package net.mod.blocks;

import java.util.Random;

import net.minecraft.src.*;
import net.mod.Blocks;

public class BlockMeta extends Block {
	private int[] textures;
	protected Class<? extends ItemTool> tool;
	protected float hardness;
	
	public BlockMeta(int blockID, Material material, Class<? extends ItemTool> tool, int[] textures, float hardness) {
		super(blockID, textures[0], material);
		
		this.tool = tool;
		this.hardness = hardness;
		this.textures = textures;
	}
	
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
    	int index = 0;
    	
        if (meta < textures.length) {
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

        if (heldItem != null) {
            Item item = heldItem.getItem();

            if (item instanceof ItemTool) {
                if (item.getClass().equals(this.tool)) {
                    ItemTool toolItem = (ItemTool) item;
                    float efficiency = toolItem.getMaterial().getEfficiencyOnProperMaterial();

                    return Math.abs((this.blockHardness - efficiency) + 1.0f) / this.hardness;
                }
            }
        }
        return super.blockStrength(player);
    }
}
