package net.mod;

import net.minecraft.src.*;

public class ItemCement extends ItemBlock {

    public ItemCement(int id) {
        super(id);
        setHasSubtypes(true);
    }

    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getItemNameIS(ItemStack itemstack) {
        return getItemName() + "." + itemstack.getItemDamage();
    }
}
