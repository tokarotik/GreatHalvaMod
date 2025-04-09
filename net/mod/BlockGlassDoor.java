package net.mod;
import net.minecraft.src.*;

import java.util.Random;


public class BlockGlassDoor extends BlockDoor {
    private int topTextureIndex;
    private int bottomTextureIndex;
	
    public BlockGlassDoor(int id, Material material, int topTextureIndex, int bottomTextureIndex) {
        super(id, material);
        this.topTextureIndex = topTextureIndex;
        this.bottomTextureIndex = bottomTextureIndex;
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int meta) {
        boolean isTopPart = (meta & 8) != 0; // Bitwise check for top half
        return isTopPart ? topTextureIndex : bottomTextureIndex;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.isBlockNormalCube(x, y - 1, z);
    }
    
    public int idDropped(int var1, Random var2) {
    	return mod_GreatHalva.GlassDoorItem.shiftedIndex;

    }
}
