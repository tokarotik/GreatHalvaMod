package net.minecraft.src;

public class ItemBirchBoat extends Item {
	 public ItemBirchBoat(int id) {
		        super(id);
		        this.maxStackSize = 1;
		
		    }

		    @Override
		    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		        float f = 1.0F;


		        Vec3D lookVec = player.getLookVec();

		    
		        double x = player.posX + lookVec.xCoord * 2.0D;
		        double y = player.posY + player.getEyeHeight() + lookVec.yCoord * 2.0D;
		        double z = player.posZ + lookVec.zCoord * 2.0D;

		        EntityBirchBoat boat = new EntityBirchBoat(world, x, y, z);
		        if (!world.multiplayerWorld) {
		            world.entityJoinedWorld(boat);
		        }


		        stack.stackSize--;
		        

		        return stack;
		    }
		}

