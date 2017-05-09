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
import net.minecraftforge.fml.relauncher.SideOnly;

public class CompressedFurnaceTileEntity extends TileEntity implements ITickable {
	
	public static NBTTagCompound nbtcompound = new NBTTagCompound();
	
	private boolean active;
	private int burntime;
	
	public CompressedFurnaceTileEntity() {
		burntime = 0;
		active = false;
	}

	@Override
	public void update() {
		Boolean isDirty = false;
		
		if (active && burntime > 0) {
			burntime--;		
			isDirty = true;
			mchellspawn.compressedfurnace.compressedfurnace.logger.info("State/Burntime = " + active + "/" + burntime);		
		}

		if (active && burntime == 0) {
			setActive(false);
			isDirty = true;
			
			mchellspawn.compressedfurnace.compressedfurnace.logger.info("State/Burntime = " + active + "/" + burntime);
			mchellspawn.compressedfurnace.compressedfurnace.logger.info("Timeout");
		}
		
		if (!active) {
			Boolean blockactive = getWorld().getBlockState(getPos()).getValue(BlockCompressedFurnace.ACTIVE);
			mchellspawn.compressedfurnace.compressedfurnace.logger.info("Blockstate = " + blockactive);		
			mchellspawn.compressedfurnace.compressedfurnace.logger.info("State/Burntime = " + active + "/" + burntime);		
		}
		
		if(isDirty) {
			final IBlockState state = getWorld().getBlockState(getPos()); 
			getWorld().notifyBlockUpdate(getPos(), state, state.withProperty(BlockCompressedFurnace.ACTIVE, active), 3);
		
			markDirty();
		}
	}

	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
	{
	    return (oldState.getBlock() != newSate.getBlock());
	}
	
	@Override 
	public SPacketUpdateTileEntity getUpdatePacket() { 
		NBTTagCompound nbtTagCompound = new NBTTagCompound(); 
		writeToNBT(nbtTagCompound); 
		int metadata = getBlockMetadata(); 
		return new SPacketUpdateTileEntity(this.pos, metadata, nbtTagCompound); 
	} 
		 
	@Override 
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) { 
		readFromNBT(pkt.getNbtCompound()); 

		final IBlockState state = getWorld().getBlockState(getPos()); 
		getWorld().notifyBlockUpdate(getPos(), state, state, 3);

		mchellspawn.compressedfurnace.compressedfurnace.logger.info("Burntime = " + burntime);
	} 

	@Override 
	public NBTTagCompound getUpdateTag() { 
		NBTTagCompound nbtTagCompound = new NBTTagCompound(); 
		writeToNBT(nbtTagCompound); 
		return nbtTagCompound; 
	} 
		 
	@Override 
	public void handleUpdateTag(NBTTagCompound tag) { 
		readFromNBT(tag);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.active = compound.getBoolean("active");
		this.burntime = compound.getInteger("burntime");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("active", this.active);
		compound.setInteger("burntime", this.burntime);
		
		return compound;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
		if (active) {
			burntime = 200;
		} else {
			burntime = 0;
		}
		//markDirty();
		
		//final IBlockState state = getWorld().getBlockState(getPos()); 
		//getWorld().notifyBlockUpdate(getPos(), state, state, 3);		
	}
	
	public boolean getActive() {
		return this.active;
	}
}
