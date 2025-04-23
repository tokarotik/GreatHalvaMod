package net.mod.items;

import net.minecraft.src.*;

public class ItemColored extends ItemBlock {

    public ItemColored(int id) {
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
