package mchellspawn.compressedfurnace.blocks;

import mchellspawn.compressedfurnace.compressedfurnace;
import mchellspawn.compressedfurnace.reference;
import mchellspawn.compressedfurnace.util;
import mchellspawn.compressedfurnace.titleentities.CompressedFurnaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCompressedFurnace extends Block implements ITileEntityProvider {

	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	public static final PropertyBool ACTIVE = PropertyBool.create("active");

	public BlockCompressedFurnace() {
		super(Material.ROCK);
		setUnlocalizedName(reference.compressedFurnaceBlocks.COMPRESSEDFURNACE.getUnlocalizedName());
		setRegistryName(reference.compressedFurnaceBlocks.COMPRESSEDFURNACE.getRegistryName());
		setCreativeTab(compressedfurnace.CREATIVE_TAB_MAIN);
		setHardness(2.0f);
		setResistance(15.0f);
		setHarvestLevel("pickaxe", 1);
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, false));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		worldIn.setBlockState(pos, state.withProperty(FACING, util.getFacingFromEntity(pos, placer)).withProperty(ACTIVE, false), 2);
		TileEntity te = worldIn.getTileEntity(pos);
		if (te instanceof CompressedFurnaceTileEntity) {
			CompressedFurnaceTileEntity teinstance = (CompressedFurnaceTileEntity) te;
		}
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		TileEntity te = worldIn.getTileEntity(pos);
		if (te instanceof CompressedFurnaceTileEntity) {
			CompressedFurnaceTileEntity teinstance = (CompressedFurnaceTileEntity) te;
			return super.getActualState(state, worldIn, pos).withProperty(ACTIVE, teinstance.getActive());
		} else {
			return super.getActualState(state, worldIn, pos);
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		//super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);

		if (!worldIn.isRemote) {
			Boolean curActive = worldIn.getBlockState(pos).getValue(ACTIVE);
			mchellspawn.compressedfurnace.compressedfurnace.logger.info("Block Active = " + curActive);
			Boolean active = !curActive;
			mchellspawn.compressedfurnace.compressedfurnace.logger.info("Block Active = " + active);

			worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(ACTIVE, active));
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			
			TileEntity te = worldIn.getTileEntity(pos);
			if (te instanceof CompressedFurnaceTileEntity) {
				CompressedFurnaceTileEntity teinstance = (CompressedFurnaceTileEntity) te;
				teinstance.setActive(active);
			}
		}
		return true;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getFront((meta > 8) ? meta - 8 : meta);
		return getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int facingbits = state.getValue(FACING).getIndex();
		return facingbits;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING, ACTIVE);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new CompressedFurnaceTileEntity();
	}
}
