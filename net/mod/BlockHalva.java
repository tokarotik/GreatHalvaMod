package net.mod;
import net.minecraft.src.*;

import java.util.Random;


public class BlockHalva extends BlockBreakable {
    public BlockHalva(int var1, int var2, Material var3, boolean var4) {
        super(var1, var2, var3, var4);
        //disableNeighborNotifyOnMetadataChange();
    }

    public int idDropped(int var1, Random var2) {
        return mod_GreatHalva.HalvaBlock.blockID;
    }
}
