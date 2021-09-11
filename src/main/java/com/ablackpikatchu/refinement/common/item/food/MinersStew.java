package com.ablackpikatchu.refinement.common.item.food;

import com.ablackpikatchu.refinement.core.init.DamageSourcesInit;
import com.ablackpikatchu.refinement.core.itemgroup.RefinementItemGroup;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MinersStew extends Item {

	public MinersStew() {
		super(new Item.Properties()
				.food(new Food.Builder().nutrition(6).saturationMod(13.3f).alwaysEat().fast().build())
				.rarity(Rarity.RARE).tab(RefinementItemGroup.REFINEMENT).stacksTo(1));
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		if (player.hasEffect(Effects.DIG_SPEED) && player.hasEffect(Effects.NIGHT_VISION))
			return ActionResult.fail(player.getItemInHand(hand));

		return super.use(world, player, hand);
	}
	
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
		
		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entity;
			
			player.addEffect(new EffectInstance(Effects.DIG_SPEED, 9600, 0));
			player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 9600, 0));
			player.hurt(DamageSourcesInit.MINERS_STEW_DAMAGE, 8.0F);
			player.addItem(new ItemStack(Items.BOWL));
		}
		
		return super.finishUsingItem(stack, world, entity);
	}

}