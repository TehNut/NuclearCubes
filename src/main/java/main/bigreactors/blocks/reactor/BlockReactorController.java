package main.bigreactors.blocks.reactor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.bigreactors.BigReactors;
import main.bigreactors.ModInformation;
import main.bigreactors.tileentities.reactor.TileEntityReactorController;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockReactorController extends BlockContainer {

	private IIcon casingTex;
	private IIcon controllerOn;
	private IIcon controllerIdle;

	public BlockReactorController() {
		super(Material.iron);
		this.setBlockName(ModInformation.ID + ".reactor.controller");
		this.setBlockTextureName(ModInformation.ID + ":machines/reactor/reactorController_off");
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(BigReactors.tabBigReactors);
		this.setHardness(7);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (side == 1 || side == 0) {
			return this.casingTex;
		} else {
			return this.blockIcon;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon(ModInformation.ID + ":machines/reactor/reactorController_off");
		this.controllerOn = icon.registerIcon(ModInformation.ID + ":machines/reactor/reactorController_on");
		this.controllerIdle = icon.registerIcon(ModInformation.ID + ":machines/reactor/reactorController_idle");
		this.casingTex = icon.registerIcon(ModInformation.ID + ":machines/reactor/reactorCasing_default");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

		TileEntityReactorController tile = (TileEntityReactorController) world.getTileEntity(x, y, z);

		if (!world.isRemote && tile instanceof TileEntityReactorController) {
			player.openGui(BigReactors.instance, 0, world, x, y, z);
		}
		return true;
	}

}