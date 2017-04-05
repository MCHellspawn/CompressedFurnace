package mchellspawn.compressedfurnace.titleentities;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class CompressedFurnaceTileEntity extends TileEntity implements ITickable {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override 
	@Nullable 
	public SPacketUpdateTileEntity getUpdatePacket() 
	{ 
		NBTTagCompound nbtTagCompound = new NBTTagCompound(); 
		writeToNBT(nbtTagCompound); 
		int metadata = getBlockMetadata(); 
		return new SPacketUpdateTileEntity(this.pos, metadata, nbtTagCompound); 
	} 
	 
	@Override 
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) { 
		readFromNBT(pkt.getNbtCompound()); 
	} 

	/* Creates a tag containing the TileEntity information, used by vanilla to transmit from server to client */ 
	@Override 
	public NBTTagCompound getUpdateTag() 
	{ 
	   NBTTagCompound nbtTagCompound = new NBTTagCompound(); 
	   writeToNBT(nbtTagCompound); 
	   return nbtTagCompound; 
	} 
		 
	/* Populates this TileEntity with information from the tag, used by vanilla to transmit from server to client */ 
	@Override 
	public void handleUpdateTag(NBTTagCompound tag) 
	{ 
	  this.readFromNBT(tag); 
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		return super.writeToNBT(compound);
	} 
	
	

}
