package kz.kulik.amatarasu.render;

import kz.kulik.amatarasu.Main;
import kz.kulik.amatarasu.block.BasicModelBlock;
import kz.kulik.amatarasu.proxy.ClientProxy;
import kz.kulik.amatarasu.tileentity.BasicTileEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RenderBasicBlock extends TileEntitySpecialRenderer {
    public static final ResourceLocation texture1 = new ResourceLocation(Main.MODID ,"models/compressed_steel.png");
    public static final ResourceLocation texture2 = new ResourceLocation(Main.MODID ,"models/amber_crystal.png");

    final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(Main.MODID, "models/cube.obj"));

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
        render((BasicTileEntity) tile, x, y, z, f);
    }
    private void render(BasicTileEntity tile, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);


        GL11.glPushMatrix();
        bindTexture(texture1);
        model.renderPart("tesseract");
        GL11.glPopMatrix();


        //blyat ne trogat eto xerny
        GL11.glPushMatrix();
        GL11.glTranslatef(+ 0.5F, 0.0F,  + 0.5F);
        long time = System.currentTimeMillis();
        float rotation = (time % 3600L) / 10.0F;
        GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, 0.0F, -0.5F);

        GL11.glDisable(GL11.GL_LIGHTING);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,240,240);

        bindTexture(texture2);

        model.renderPart("Cube");

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);

        GL11.glPopMatrix();


        GL11.glPopMatrix();
    }
}

