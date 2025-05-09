package net.mod;
import net.minecraft.src.*;
import net.mod.entities.EntitySpruceBoat;

import org.lwjgl.opengl.GL11;

public class RenderSpruceBoat extends Render {
    protected ModelBase modelBoat;
    protected String boat_texture;

    public RenderSpruceBoat() {
        this.shadowSize = 0.5F;
        this.modelBoat = new ModelBoat();
        this.boat_texture = Entities.boats_texture[0];
    }

    public void func_157_a(EntitySpruceBoat CustomBoat, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glRotatef(180.0F - var8, 0.0F, 1.0F, 0.0F);
        float var10 = (float)CustomBoat.boatTimeSinceHit - var9;
        float var11 = (float)CustomBoat.boatCurrentDamage - var9;
        if (var11 < 0.0F) {
            var11 = 0.0F;
        }

        if (var10 > 0.0F) {
            GL11.glRotatef(MathHelper.sin(var10) * var10 * var11 / 10.0F * (float)CustomBoat.boatRockDirection, 1.0F, 0.0F, 0.0F);
        }

        this.loadTexture("/terrain.png");
        float var12 = 0.75F;
        GL11.glScalef(var12, var12, var12);
        GL11.glScalef(1.0F / var12, 1.0F / var12, 1.0F / var12);
        this.loadTexture(this.boat_texture);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelBoat.render(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_157_a((EntitySpruceBoat)var1, var2, var4, var6, var8, var9);
    }
}

