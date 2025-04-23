package net.mod;

import net.minecraft.src.*;
import net.mod.blocks.*;

public class Smelting{	
	public void AddSmelting(int blockID, ItemStack itemstack) {
		ModLoader.AddSmelting(blockID, itemstack);
	}
	
	public void AddSmelting(Block block, Block result, int count, int meta) {
		AddSmelting(block.blockID, new ItemStack(result, count, meta));
	}
	
	public void AddSmelting(Block block, Block result, int count) {
		AddSmelting(block.blockID, new ItemStack(result, count));
	}
	
	public void AddSmelting(Block block, Item result, int count, int meta) {
		AddSmelting(block.blockID, new ItemStack(result, count, meta));
	}
	
	public void AddSmelting(Block block, Item result, int count) {
		AddSmelting(block.blockID, new ItemStack(result, count));
	}
	
	public void AddSmelting(Block block, ItemStack itemstack) {
		AddSmelting(block.blockID, itemstack);
	}

	
	public void AddSmelting(Item item, ItemStack itemstack) {
		AddSmelting(item.shiftedIndex, itemstack);
	}
	
	public void AddSmelting(Item item, Block result, int count, int meta) {
		AddSmelting(item.shiftedIndex, new ItemStack(result, count, meta));
	}
	
	public void AddSmelting(Item item, Block result, int count) {
		AddSmelting(item.shiftedIndex, new ItemStack(result, count));
	}
	
	public void AddSmelting(Item item, Item result, int count, int meta) {
		AddSmelting(item.shiftedIndex, new ItemStack(result, count, meta));
	}
	
	public void AddSmelting(Item item, Item result, int count) {
		AddSmelting(item.shiftedIndex, new ItemStack(result, count));
	}
	
	
	
	public static void RegisterSmelting() {
		
	}
	
}