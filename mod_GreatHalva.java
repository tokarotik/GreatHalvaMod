package net.minecraft.src;

import java.util.Map;

import net.mod.*;


public class mod_GreatHalva extends BaseMod{	
	public mod_GreatHalva() {		
		Items.AddName();
		Items.AddRecipe();
		
		Blocks.RegisterBlock();
		Blocks.AddName();

		Entities.RegisterEntity();
		
		Crafts.AddRecipe();
	}
	
	
	
	public String Version( ) {
		return "1.4";
	}
    
	public void AddRenderer(Map<Class<? extends Entity>, Render> map) {
    	Entities.AddRender(map);
    }
}
