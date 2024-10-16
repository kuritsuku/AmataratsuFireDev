package kz.kulik.amatarasu;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import kz.kulik.amatarasu.block.BasicModelBlock;
import kz.kulik.amatarasu.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import kz.kulik.amatarasu.tileentity.BasicTileEntity;
import net.minecraft.block.Block;


@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME)
public class Main {
    public static final String MODID = "amatarasu";
    public static final String NAME = "amatarasu";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(clientSide = "kz.kulik.amatarasu.proxy.ClientProxy", serverSide = "kz.kulik.amatarasu.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Block basic_obj;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);



        basic_obj = new BasicModelBlock();
        GameRegistry.registerBlock(basic_obj,"LPL");
        GameRegistry.registerTileEntity(BasicTileEntity.class,"Tileentity");

    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);

    }



}
