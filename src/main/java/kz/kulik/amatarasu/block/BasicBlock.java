package kz.kulik.amatarasu.block;

import kz.kulik.amatarasu.tileentity.BasicTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BasicBlock extends Block {
    public BasicBlock(){
        super(Material.anvil);
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new BasicTileEntity();
    }
}
