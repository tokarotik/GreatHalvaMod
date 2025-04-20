package net.mod;

import net.minecraft.src.*;


public class EntityFalling extends Entity {
    public int blockID;
    public int metadata = 0;
    public int fallTime = 0;

    public EntityFalling(World world) {
        super(world);
    }

    public EntityFalling(World world, double x, double y, double z, int blockID, int meta) {
        super(world);
        this.blockID = blockID;
        this.metadata = meta;
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
        this.setPosition(x, y, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void entityInit() {}

    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    public void onUpdate() {
        if (this.blockID == 0) {
            this.setEntityDead();
            return;
        }

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.fallTime;
        this.motionY -= 0.03999999910593033D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.98D;
        this.motionY *= 0.98D;
        this.motionZ *= 0.98D;

        int x = MathHelper.floor_double(this.posX);
        int y = MathHelper.floor_double(this.posY);
        int z = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getBlockId(x, y, z) == this.blockID) {
            this.worldObj.setBlockAndMetadataWithNotify(x, y, z, 0, this.metadata);
        }

        if (this.onGround) {
            this.motionX *= 0.7D;
            this.motionZ *= 0.7D;
            this.motionY *= -0.5D;
            this.setEntityDead();

            if (
                (!this.worldObj.canBlockBePlacedAt(this.blockID, x, y, z, true, 1) ||
                BlockSand.canFallBelow(this.worldObj, x, y - 1, z) ||
                !this.worldObj.setBlockAndMetadataWithNotify(x, y, z, this.blockID, this.metadata)) &&
                !this.worldObj.multiplayerWorld
            ) {
                this.dropItem(this.blockID, 1, this.metadata);
            }
        } else if (this.fallTime > 100 && !this.worldObj.multiplayerWorld) {
            this.dropItem(this.blockID, 1, this.metadata);
            this.setEntityDead();
        }
    }

    protected void writeEntityToNBT(NBTTagCompound tag) {
        tag.setByte("Tile", (byte)this.blockID);
        tag.setByte("Meta", (byte)this.metadata);
    }

    protected void readEntityFromNBT(NBTTagCompound tag) {
        this.blockID = tag.getByte("Tile") & 255;
        this.metadata = tag.getByte("Meta") & 15;
    }

    public float getShadowSize() {
        return 0.0F;
    }

    public World getWorld() {
        return this.worldObj;
    }
}

