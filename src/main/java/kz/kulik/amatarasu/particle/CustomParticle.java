package kz.kulik.amatarasu.particle;

import kz.kulik.amatarasu.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class CustomParticle extends EntityFX {
    private final ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/particles/soul.png");

    public CustomParticle(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);

        // Настройка базовых свойств партикла
        this.particleMaxAge = 1;
        this.particleGravity = 0;
    }

    @Override
    public void renderParticle(Tessellator tessellator, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {

        // Привязка текстуры
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

        // Рисуем партикл с использованием текущей текстуры
        float scale = 0.1F * this.particleScale;
        float xPos = (float) (this.prevPosX + (this.posX - this.prevPosX) * partialTicks - interpPosX);
        float yPos = (float) (this.prevPosY + (this.posY - this.prevPosY) * partialTicks - interpPosY);
        float zPos = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - interpPosZ);

        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
        tessellator.addVertexWithUV(xPos - rotationX * scale - rotationXY * scale, yPos - rotationZ * scale, zPos - rotationYZ * scale - rotationXZ * scale, 0, 1);
        tessellator.addVertexWithUV(xPos - rotationX * scale + rotationXY * scale, yPos + rotationZ * scale, zPos - rotationYZ * scale + rotationXZ * scale, 1, 1);
        tessellator.addVertexWithUV(xPos + rotationX * scale + rotationXY * scale, yPos + rotationZ * scale, zPos + rotationYZ * scale + rotationXZ * scale, 1, 0);
        tessellator.addVertexWithUV(xPos + rotationX * scale - rotationXY * scale, yPos - rotationZ * scale, zPos + rotationYZ * scale - rotationXZ * scale, 0, 0);
        tessellator.draw();
    }

    @Override
    public int getFXLayer() {
        // Возвращает слой текстуры, используемый для рендера
        return 3; // Это позволяет нам использовать кастомные текстуры вместо стандартных
    }
}

