package net.mod;

import net.minecraft.src.*;


public class BlockCement extends Block {
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
        super(var1, textures[13], Material.sand);
        
        for (int i = 0;i < ItemDye.dyeColorNames.length; i++) {
        	System.out.println("Blocks.addBlocktexture(\"coloured/cement/" + ItemDye.dyeColorNames[i] + ".png\"),");
        }
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
    	int index = 0;
    	
        if (meta < 14) {
        	index = meta;
        }
        
        else if (meta > 14) {
        	index = 13;
        }
        
        return BlockCement.textures[index];
    }

    public int damageDropped(int meta) {
        return meta;
    }


    protected int getDropMetadata(int meta) {
        return meta;
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
}
