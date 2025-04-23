package net.mod.blocks;
import net.minecraft.src.*;
import net.mod.Blocks;

import java.util.Random;

public class BlockCheese extends Block {
    public BlockCheese(int var1, int var2) {
        super(var1, var2, Material.clay);
    }
    
    public int idDropped(int var1, Random var2) {
        return Blocks.CheeseBlock.blockID;
   }
}
