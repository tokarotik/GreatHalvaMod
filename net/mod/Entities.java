package net.mod;

import java.util.Map;

import net.minecraft.src.Entity;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Render;
import net.mod.entities.EntityBirchBoat;
import net.mod.entities.EntityFalling;
import net.mod.entities.EntitySpruceBoat;

public class Entities {
	private static final String PATH_ENTITIES_ASSETS = "/greathalva/entities/";
	
	public static final String[] boats_texture = new String[] {
			PATH_ENTITIES_ASSETS + "boat1.png",
			PATH_ENTITIES_ASSETS + "boat2.png"
	};
	
	private static final Class[] entity_boats = new Class[] {
			EntitySpruceBoat.class,
			EntityBirchBoat.class
	};
	
	public static void RegisterEntity() {
		ModLoader.RegisterEntityID(entity_boats[0], "SpruceBoat", ModLoader.getUniqueEntityId());
		ModLoader.RegisterEntityID(entity_boats[1], "BirchBoat", ModLoader.getUniqueEntityId());
	}
	
	public static void AddRender(Map<Class<? extends Entity>, Render> map) {
    	map.put(entity_boats[0], new RenderSpruceBoat());
    	map.put(entity_boats[1], new RenderBirchBoat());
    	map.put(EntityFalling.class, new RenderFallingCustom());
	}
}
