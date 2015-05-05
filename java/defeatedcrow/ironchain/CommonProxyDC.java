package defeatedcrow.ironchain;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.ironchain.block.tileentity.*;
import defeatedcrow.ironchain.client.gui.GuiRHopper;
import defeatedcrow.ironchain.client.model.ModelBipedThin;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class CommonProxyDC implements IGuiHandler{
	
	public int addArmor(String armor)
	{
		return 0;
	}
	
	public int getRenderID()
	{
		return -1;
	}
	
	public ModelBipedThin getArmorModel(int slot)
	{
		return null;
	}
	
	public void registerRenderers(){}
	
	public void registerTile() {
		GameRegistry.registerTileEntity(TileEntityRHopper.class, "TileEntityRHopper");
		GameRegistry.registerTileEntity(TileRHopperGold.class, "TileEntityRHopperGold");
		GameRegistry.registerTileEntity(TileRHopperBlack.class, "TileEntityRHopperBlack");
		GameRegistry.registerTileEntity(TilePositiveHopperBlack.class, "TilePHopperBlack");
		GameRegistry.registerTileEntity(TilePositiveHopperGold.class, "TilePHopperGold");
		GameRegistry.registerTileEntity(TileFloodLight.class, "TileEntityFloodLight");
		GameRegistry.registerTileEntity(TileBarriarCorn.class, "TileEntityBarriarCorn");
	}

	public World getClientWorld() {
		
		return null;
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity tileentity = world.getTileEntity(x, y, z);
		InventoryPlayer inventoryPlayer = player.inventory;
		if (tileentity != null && tileentity instanceof TileEntityRHopper && ID == DCsIronChain.guiIdRHopper) {
			return new ContainerRHopper(inventoryPlayer, (TileEntityRHopper) tileentity);
		}
		else
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity tileentity = world.getTileEntity(x, y, z);
		InventoryPlayer inventoryPlayer = player.inventory;
		if (tileentity != null && tileentity instanceof TileEntityRHopper && ID == DCsIronChain.guiIdRHopper) {
			return new GuiRHopper(inventoryPlayer, (TileEntityRHopper) tileentity);
		}
		else
		{
			return null;
		}
	}

}
