package net.minecraft.src;

import java.util.Random;

public class BlockCheese extends Block {
    protected BlockCheese(int var1, int var2) {
        super(var1, var2, Material.clay);
    }
    
    public int idDropped(int var1, Random var2) {
        return mod_GreatHalva.CheeseBlock.blockID;
   }
}
