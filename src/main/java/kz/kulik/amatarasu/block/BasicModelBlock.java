package kz.kulik.amatarasu.block;

import kz.kulik.amatarasu.Main;
import kz.kulik.amatarasu.tileentity.BasicTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Random;

public class BasicModelBlock extends Block implements ITileEntityProvider {

    public BasicModelBlock(){
        super(Material.anvil);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName(Main.MODID+".model");

        setLightLevel(3.0F);


    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new BasicTileEntity();
    }
    public int getRenderType(){
        return -1;
    }
    public boolean isOpaqueCube(){
        return false;
    }
    public boolean renderAsNormalBlock(){
        return false;
    }
}
