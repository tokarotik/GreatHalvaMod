package net.mod.blocks;
import net.minecraft.src.*;


public class BlockPlanks extends Block {
    public BlockPlanks(int var1, int var2) {
        super(var1, var2, Material.wood);
    }
    
    public float blockStrength(EntityPlayer player) {
        ItemStack heldItem = player.getCurrentEquippedItem();
        if (heldItem != null && heldItem.getItem() instanceof ItemAxe) {
        	ItemAxe axe = (ItemAxe) heldItem.getItem();
        	
        	return Math.abs((this.blockHardness - axe.getMaterial().getEfficiencyOnProperMaterial()) + 1.0f) / 19.0f;
        }

        return super.blockStrength(player);
    }
}
