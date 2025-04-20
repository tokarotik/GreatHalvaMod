package net.mod;

import org.lwjgl.opengl.GL11;
import net.minecraft.src.*;

public class RenderFallingCustom extends Render {
    private final RenderBlocks renderBlocks = new RenderBlocks();

    public RenderFallingCustom() {
        this.shadowSize = 0.5F;
    }

    public void doRenderFalling(EntityFalling var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        this.loadTexture("/terrain.png");
        Block var10 = Block.blocksList[var1.blockID];
        World var11 = var1.getWorld();
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        renderBlockFalling(var10, var11, MathHelper.floor_double(var1.posX), MathHelper.floor_double(var1.posY), MathHelper.floor_double(var1.posZ), var1.metadata);
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glPopMatrix();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.doRenderFalling((EntityFalling)var1, var2, var4, var6, var8, var9);
    }
    
    public void renderBlockFalling(Block block, World world, int x, int y, int z, int meta) {
        float f1 = 0.5F;
        float f2 = 1.0F;
        float f3 = 0.8F;
        float f4 = 0.6F;

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();

        float brightness = block.getBlockBrightness(world, x, y, z);
        float sideBrightness = block.getBlockBrightness(world, x, y - 1, z);
        if (sideBrightness < brightness) sideBrightness = brightness;

        tessellator.setColorOpaque_F(f1 * sideBrightness, f1 * sideBrightness, f1 * sideBrightness);
        renderBlocks.renderBottomFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(0, meta));

        sideBrightness = block.getBlockBrightness(world, x, y + 1, z);
        if (sideBrightness < brightness) sideBrightness = brightness;

        tessellator.setColorOpaque_F(f2 * sideBrightness, f2 * sideBrightness, f2 * sideBrightness);
        renderBlocks.renderTopFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(1, meta));

        sideBrightness = block.getBlockBrightness(world, x, y, z - 1);
        if (sideBrightness < brightness) sideBrightness = brightness;

        tessellator.setColorOpaque_F(f3 * sideBrightness, f3 * sideBrightness, f3 * sideBrightness);
        renderBlocks.renderEastFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(2, meta));

        sideBrightness = block.getBlockBrightness(world, x, y, z + 1);
        if (sideBrightness < brightness) sideBrightness = brightness;

        tessellator.setColorOpaque_F(f3 * sideBrightness, f3 * sideBrightness, f3 * sideBrightness);
        renderBlocks.renderWestFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(3, meta));

        sideBrightness = block.getBlockBrightness(world, x - 1, y, z);
        if (sideBrightness < brightness) sideBrightness = brightness;

        tessellator.setColorOpaque_F(f4 * sideBrightness, f4 * sideBrightness, f4 * sideBrightness);
        renderBlocks.renderNorthFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(4, meta));

        sideBrightness = block.getBlockBrightness(world, x + 1, y, z);
        if (sideBrightness < brightness) sideBrightness = brightness;

        tessellator.setColorOpaque_F(f4 * sideBrightness, f4 * sideBrightness, f4 * sideBrightness);
        renderBlocks.renderSouthFace(block, -0.5D, -0.5D, -0.5D, block.getBlockTextureFromSideAndMetadata(5, meta));

        tessellator.draw();
    }
}