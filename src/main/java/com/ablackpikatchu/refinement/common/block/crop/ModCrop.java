package com.ablackpikatchu.refinement.common.block.crop;

import java.util.Random;

import com.ablackpikatchu.refinement.Refinement;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.minecraftforge.registries.ForgeRegistries;

public class ModCrop extends CropsBlock {
	
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };
	
	private final ResourceLocation seed;
	private final ResourceLocation resource;
	private final boolean canBonemeal;
	private final ResourceLocation bonemealItem;
	
	public ModCrop(Properties properties, ResourceLocation seed, ResourceLocation resource, boolean canBonemeal) {
		super(properties);
		this.seed = seed;
		this.resource = resource;
		this.canBonemeal = canBonemeal;
		this.bonemealItem = new ResourceLocation(Refinement.MOD_ID, "refined_bonemeal");
	}

	public ModCrop(Properties properties, ResourceLocation seed, ResourceLocation resource, boolean canBonemeal, ResourceLocation bonemealItem) {
		super(properties);
		this.seed = seed;
		this.resource = resource;
		this.canBonemeal = canBonemeal;
		this.bonemealItem = bonemealItem;
	}
	
	public Item getSeedItem() {
		return ForgeRegistries.ITEMS.getValue(this.seed);
	}
	
	public Item getResourceItem() {
		return ForgeRegistries.ITEMS.getValue(this.resource);
	}
	
	public Item getBonemealItem() {
		return ForgeRegistries.ITEMS.getValue(this.bonemealItem);
	}
	
	@Override
	protected IItemProvider getBaseSeedId() {
		return this.getSeedItem();
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
	}

	@Override
	public ActionResultType use(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand,
			BlockRayTraceResult result) {
		
		if (this.getAge(state) == 7) {
			ItemStack drops = new ItemStack(this.getResourceItem());
			level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), drops));
			level.setBlockAndUpdate(pos, state.setValue(this.getAgeProperty(), 0));
			return ActionResultType.SUCCESS;
		}
		
		ItemStack stack = player.getItemInHand(hand);
		
		if (stack.getItem() == this.getBonemealItem() && level instanceof ServerWorld) {
			this.performBonemeal((ServerWorld) level, new Random(), pos, state);
			stack.shrink(1);
			return ActionResultType.CONSUME;
		}

		return ActionResultType.FAIL;
	}
	
	@Override
	public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_,
			boolean p_176473_4_) {
		return this.canBonemeal;
	}

}
