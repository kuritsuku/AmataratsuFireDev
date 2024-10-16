package kz.kulik.amatarasu.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import kz.kulik.amatarasu.render.RenderBasicBlock;
import kz.kulik.amatarasu.tileentity.BasicTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;


public class ClientProxy extends CommonProxy {

    public static int[] displayList = new int[1];

    public static int displayListBase;
    public static int displayListTop;



    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);




    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ClientRegistry.bindTileEntitySpecialRenderer(BasicTileEntity.class, new RenderBasicBlock());
        models();

    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);

    }



    public void models(){


        //displayList[0] = GLAllocation.generateDisplayLists(1);
        //GL11.glNewList(displayList[0], GL11.GL_COMPILE);
        //GL11.glEndList();

        //Blocks
        ClientRegistry.bindTileEntitySpecialRenderer(BasicTileEntity.class, new RenderBasicBlock());
        //MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlockObj.block_obj), new RenderItemBlockObj());

    }

}
