package net.mod;

import net.minecraft.src.*;

public class ItemConcrete extends ItemBlock {

    public ItemConcrete(int id) {
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
