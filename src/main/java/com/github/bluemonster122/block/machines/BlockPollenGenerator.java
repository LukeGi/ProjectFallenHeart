package com.github.bluemonster122.block.machines;

import com.github.bluemonster122.block.PFHTileBlock;
import com.github.bluemonster122.tileentity.TileEntityPollenGenerator;
import com.github.bluemonster122.util.ModInfo;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockPollenGenerator extends PFHTileBlock {
    public BlockPollenGenerator() {
        super(Material.IRON);
        setRegistryName(ModInfo.MOD_ID, "pollen_generator");
        setUnlocalizedName(getRegistryName().getResourcePath());
        setTickRandomly(true);
    }

    @Override
    public int tickRate(World worldIn) {
        return 1;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.addChatComponentMessage(new TextComponentString(Integer.toString(getTE(worldIn, pos).battery.getEnergyStored())));
        }
        return true;
    }

    public TileEntityPollenGenerator getTE(World world, BlockPos pos) {
        return (TileEntityPollenGenerator) world.getTileEntity(pos);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if (getTE(worldIn, pos).battery.generate(100, true) != 0) {
                int energyGenerated = 0;
                for (int i = -5; i < 6; i++) {
                    for (int j = -5; j < 6; j++) {
                        for (int k = -1; k < 2; k++) {
                            IBlockState sstate = worldIn.getBlockState(pos.add(i, k, j));
                            if (sstate.getBlock() instanceof BlockFlower || (sstate.getBlock() instanceof BlockDoublePlant && !(sstate.equals(Blocks.DOUBLE_PLANT.getDefaultState().withProperty(BlockDoublePlant.VARIANT, BlockDoublePlant.EnumPlantType.GRASS))))) {
                                energyGenerated += rand.nextInt(5);
                            }
                        }
                    }
                }
                getTE(worldIn, pos).battery.generate(energyGenerated, false);
            }
        }
    }

    @Override
    public Class<? extends TileEntity> getTileClass() {
        return TileEntityPollenGenerator.class;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPollenGenerator();
    }
}
