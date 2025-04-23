package net.mod.blocks;
import net.minecraft.src.*;
import net.mod.Blocks;

import java.util.Random;


public class BlockHalva extends BlockBreakable {
    public BlockHalva(int var1, int var2, Material var3, boolean var4) {
        super(var1, var2, var3, var4);
    }

    public int idDropped(int var1, Random var2) {
        return Blocks.HalvaBlock.blockID;
    }
}
