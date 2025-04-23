package net.mod;

import net.minecraft.src.*;
import net.mod.items.ItemBirchBoat;
import net.mod.items.ItemCustomDoor;
import net.mod.items.ItemSpruceBoat;

public class Items {
	private static final String PATH_ITEMS_ASSETS = "/greathalva/items/";
	private static final String PATH_ITEMS = "/gui/items.png";
	
	public static final Item GlassDoorItem = (new ItemCustomDoor(5000, Material.wood, Blocks.GlassDoor)).setIconIndex(addItemtexture("item_glass_door.png")).setItemName("doorGlass");
	public static final Item SpruceBoatItem = new ItemSpruceBoat(5001).setIconIndex(addItemtexture("boat_spruce.png")).setItemName("spruceBoat");
	public static final Item BirchBoatItem = new ItemBirchBoat(5002).setIconIndex(addItemtexture("boat_birch.png")).setItemName("birchBoat");;
	public static final Item CheeseFood = (new ItemCookie(5003, 2, false, 16)).setIconIndex(addItemtexture("cheese.png")).setItemName("cheese");
	
	
	public static void AddName() {
		ModLoader.AddName(CheeseFood, "Cheese Head");
		
		ModLoader.AddName(GlassDoorItem, "Glass Door");
		
		ModLoader.AddName(SpruceBoatItem, "Boat");
		ModLoader.AddName(BirchBoatItem, "Boat");
	}
	
	public static void AddRecipe() {
		ModLoader.AddRecipe(new ItemStack(GlassDoorItem, 1), new Object[]{
			    "XX",
			    "XX",
			    "XX",
			    Character.valueOf('X'), Block.glass  
			});
		
		ModLoader.AddRecipe(new ItemStack(CheeseFood, 9), new Object[]{
				"XY", 
			    Character.valueOf('X'), Blocks.CheeseBlock,  
			    Character.valueOf('Y'), Item.arrow
			});		
	}
	
    public static int addItemtexture(String path) {
		return ModLoader.addOverride(PATH_ITEMS, PATH_ITEMS_ASSETS + path);
    }
}
