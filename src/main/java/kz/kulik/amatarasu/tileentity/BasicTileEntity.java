package kz.kulik.amatarasu.tileentity;

import kz.kulik.amatarasu.Main;
import kz.kulik.amatarasu.particle.CustomParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class BasicTileEntity extends TileEntity {
    public BasicTileEntity(){




    }

    private boolean isRotating = true;

    public boolean isRotating() {
        return isRotating;
    }

    public void toggleRotation() {
        isRotating = !isRotating;
    }
}
