package mchellspawn.compressedfurnace.titleentities;

import javax.annotation.Nullable;

import mchellspawn.compressedfurnace.blocks.BlockCompressedFurnace;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CompressedFurnaceTileEntity extends TileEntity implements ITickable {
	
	public static NBTTagCompound nbtcompound = new NBTTagCompound();
	
	private boolean active = false;

	@Override
	public void update() {
		//this.worldObj.setBlockState(this.pos, this.worldObj.getBlockState(this.pos).withProperty(BlockCompressedFurnace.ACTIVE, active));
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
	
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
	{
	    return (oldState.getBlock() != newSate.getBlock());
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
		this.setActive(compound.getBoolean("active"));
		
		mchellspawn.compressedfurnace.compressedfurnace.logger.info("State = " + compound.getBoolean("active"));		
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setBoolean("active", this.active);
		
		return compound;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public boolean getActive() {
		return this.active;
	}
}
