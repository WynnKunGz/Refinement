package com.ablackpikatchu.refinement.data.common.recipes;

import java.util.HashMap;

import javax.annotation.Nullable;

import com.ablackpikatchu.refinement.Refinement;
import com.ablackpikatchu.refinement.core.init.ItemInit;
import com.ablackpikatchu.refinement.core.init.TagInit;
import com.ablackpikatchu.refinement.datafixers.util.recipe.Output;
import com.ablackpikatchu.refinement.datafixers.util.recipe.shaped.KeyIngredient;
import com.ablackpikatchu.refinement.datafixers.util.recipe.shaped.Pattern;

import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.RegistryObject;

public class ShapedRecipes {

	protected static HashMap<ShapedRecipeBuilder, ResourceLocation> shapedRecipes = new HashMap<>();

	public static HashMap<ShapedRecipeBuilder, ResourceLocation> shapedRecipes() {

		newShapedRecipe(new Output(ItemInit.SPEED_UPGRADE.get(), 2), new Pattern("RD#", "PNP", "#DR"),
				machineStuff(itemName(ItemInit.SPEED_UPGRADE.get())),
				new KeyIngredient('#', ItemInit.REFINED_CARBON_INGOT.get()),
				new KeyIngredient('N', ItemInit.REFINED_NETHERITE_INGOT.get()),
				new KeyIngredient('D', ItemInit.REFINED_DIAMOND.get()),
				new KeyIngredient('P', ItemInit.MACHINE_PARTS.get()),
				new KeyIngredient('R', ItemInit.REFINED_IRON_INGOT.get()));

		newShapedRecipe(new Output(ItemInit.MACHINE_FRAME.get(), 1), new Pattern("CRC", "WFW", "CRC"),
				machineStuff(itemName(ItemInit.MACHINE_FRAME.get())),
				new KeyIngredient('C', ItemInit.REFINED_IRON_INGOT.get()),
				new KeyIngredient('R', ItemInit.MACHINE_PARTS.get()), new KeyIngredient('F', Items.FURNACE),
				new KeyIngredient('W', ItemInit.REFINED_GOLD_COGWHEEL.get()));

		newShapedRecipe(new Output(ItemInit.MACHINE_PARTS.get(), 4), new Pattern("CRC", "GDG", "CRC"),
				machineStuff(itemName(ItemInit.MACHINE_PARTS.get())),
				new KeyIngredient('C', ItemInit.REFINED_IRON_COGWHEEL),
				new KeyIngredient('R', ItemInit.REFINED_IRON_INGOT.get()),
				new KeyIngredient('G', ItemInit.REFINED_GOLD_INGOT.get()),
				new KeyIngredient('D', ItemInit.REFINED_DIAMOND.get()));
		
		newShapedRecipe(new Output(ItemInit.GRINDER.get(), 1), new Pattern("RPR", "DFD", "RPR"),
				machineStuff(itemName(ItemInit.GRINDER.get())),
				new KeyIngredient('P', ItemInit.MACHINE_PARTS),
				new KeyIngredient('R', ItemInit.REFINED_IRON_INGOT.get()),
				new KeyIngredient('D', ItemInit.REFINED_DIAMOND_COGWHEEL.get()),
				new KeyIngredient('F', ItemInit.MACHINE_FRAME.get()));
		
		newShapedRecipe(new Output(ItemInit.MIXER.get(), 1), new Pattern("RPR", "DFD", "RMR"),
				machineStuff(itemName(ItemInit.MIXER.get())),
				new KeyIngredient('P', ItemInit.MACHINE_PARTS),
				new KeyIngredient('R', ItemInit.REFINED_IRON_INGOT.get()),
				new KeyIngredient('D', ItemInit.REFINED_DIAMOND_COGWHEEL.get()),
				new KeyIngredient('F', ItemInit.MACHINE_FRAME.get()),
				new KeyIngredient('M', ItemInit.MIXING_BOWL.get()));
		
		newShapedRecipe(new Output(ItemInit.MOLD_PRESS.get(), 1), new Pattern("RPR", "DFD", "R#R"),
				machineStuff(itemName(ItemInit.MOLD_PRESS.get())),
				new KeyIngredient('P', ItemInit.MACHINE_PARTS),
				new KeyIngredient('R', ItemInit.REFINED_IRON_INGOT.get()),
				new KeyIngredient('D', ItemInit.REFINED_IRON_COGWHEEL.get()),
				new KeyIngredient('F', ItemInit.MACHINE_FRAME.get()),
				new KeyIngredient('#', ItemInit.REFINED_DIAMOND.get()));
		
		newShapedRecipe(new Output(ItemInit.VACCUMULATOR.get(), 1), new Pattern("I#I", "PMP", "IBI"),
				machineStuff(itemName(ItemInit.VACCUMULATOR.get())),
				new KeyIngredient('I', TagInit.Items.IRON_INGOT),
				new KeyIngredient('#', ItemInit.MAGNET.get()),
				new KeyIngredient('P', ItemInit.MACHINE_PARTS.get()),
				new KeyIngredient('M', ItemInit.MACHINE_FRAME.get()),
				new KeyIngredient('B', TagInit.Items.IRON_STORAGE));

		newShapedRecipe(new Output(ItemInit.MAGNET.get(), 1), new Pattern(" # ", "G G", "R B"),
				tools(itemName(ItemInit.MAGNET.get())), new KeyIngredient('#', Items.IRON_BLOCK),
				new KeyIngredient('G', Items.GOLD_INGOT), new KeyIngredient('R', Items.REDSTONE_BLOCK),
				new KeyIngredient('B', Items.BLUE_DYE));
		
		newShapedRecipe(new Output(ItemInit.GRIT_PAPER.get(), 1), new Pattern("III", "PPP", "   "),
				tools(itemName(ItemInit.GRIT_PAPER.get())), new KeyIngredient('I', ItemInit.GRIT),
				new KeyIngredient('P', Items.PAPER));
		
		newShapedRecipe(new Output(ItemInit.IRON_GRIT_PAPER.get(), 1), new Pattern("III", "PPP", "   "),
				tools(itemName(ItemInit.IRON_GRIT_PAPER.get())), new KeyIngredient('I', ItemInit.IRON_INFUSED_GRIT),
				new KeyIngredient('P', Items.PAPER));
		
		newShapedRecipe(new Output(ItemInit.DIAMOND_GRIT_PAPER.get(), 1), new Pattern("III", "PPP", "   "),
				tools(itemName(ItemInit.DIAMOND_GRIT_PAPER.get())), new KeyIngredient('I', ItemInit.DIAMOND_INFUSED_GRIT),
				new KeyIngredient('P', Items.PAPER));
		
		newShapedRecipe(new Output(ItemInit.NETHERITE_GRIT_PAPER.get(), 1), new Pattern("III", "PPP", "   "),
				tools(itemName(ItemInit.NETHERITE_GRIT_PAPER.get())), new KeyIngredient('I', ItemInit.NETHERITE_INFUSED_GRIT),
				new KeyIngredient('P', Items.PAPER));

		newShapedRecipe(new Output(ItemInit.UNFIRED_COGWHEEL_MOLD.get(), 1), new Pattern("###", "#I#", "###"),
				molds(itemName(ItemInit.UNFIRED_COGWHEEL_MOLD)), new KeyIngredient('#', Items.CLAY_BALL),
				new KeyIngredient('I', TagInit.Items.COGWHEELS));

		newShapedRecipe(new Output(ItemInit.UNFIRED_GEM_MOLD.get(), 1), new Pattern("###", "#I#", "###"),
				molds(itemName(ItemInit.UNFIRED_GEM_MOLD)), new KeyIngredient('#', Items.CLAY_BALL),
				new KeyIngredient('I', TagInit.Items.GEMS));

		newShapedRecipe(new Output(ItemInit.UNFIRED_INGOT_MOLD.get(), 1), new Pattern("###", "#I#", "###"),
				molds(itemName(ItemInit.UNFIRED_INGOT_MOLD)), new KeyIngredient('#', Items.CLAY_BALL),
				new KeyIngredient('I', TagInit.Items.INGOTS));

		newShapedRecipe(new Output(ItemInit.GRIT.get(), 6), new Pattern("SGS", "GSG", " B "),
				mixingBowl(itemName(ItemInit.GRIT)), new KeyIngredient('S', Items.SAND),
				new KeyIngredient('G', Items.GRAVEL), new KeyIngredient('B', ItemInit.MIXING_BOWL));
		
		newShapedRecipe(new Output(ItemInit.IRON_INFUSED_GRIT.get(), 2), new Pattern(" G ", " R ", " B "),
				mixingBowl(itemName(ItemInit.IRON_INFUSED_GRIT)), new KeyIngredient('G', ItemInit.REFINED_IRON_DUST),
				new KeyIngredient('R', ItemInit.GRIT), new KeyIngredient('B', ItemInit.MIXING_BOWL));
		
		newShapedRecipe(new Output(ItemInit.DIAMOND_INFUSED_GRIT.get(), 2), new Pattern(" G ", " R ", " B "),
				mixingBowl(itemName(ItemInit.DIAMOND_INFUSED_GRIT)), new KeyIngredient('G', ItemInit.REFINED_DIAMOND_DUST),
				new KeyIngredient('R', ItemInit.GRIT), new KeyIngredient('B', ItemInit.MIXING_BOWL));
		
		newShapedRecipe(new Output(ItemInit.NETHERITE_INFUSED_GRIT.get(), 2), new Pattern(" G ", " R ", " B "),
				mixingBowl(itemName(ItemInit.NETHERITE_INFUSED_GRIT)), new KeyIngredient('G', ItemInit.REFINED_NETHERITE_DUST),
				new KeyIngredient('R', ItemInit.GRIT), new KeyIngredient('B', ItemInit.MIXING_BOWL));

		shapedRecipes.forEach((recipe, name) -> {
			recipe.unlockedBy("has_item", has(Items.AIR));
		});

		return shapedRecipes;

	}

	public static void newShapedRecipe(Output output, Pattern pattern, ResourceLocation name,
			KeyIngredient... ingredients) {
		ShapedRecipeBuilder recipe = new ShapedRecipeBuilder(output.getItem(), output.getCount());
		pattern.getShapedRecipePattern(recipe);
		for (KeyIngredient ingredient : ingredients) {
			ingredient.getShapedRecipe(recipe);
		}
		shapedRecipes.put(recipe, name);

	}

	public static ResourceLocation machineStuff(@Nullable String name) {
		return new ResourceLocation(Refinement.MOD_ID, "machine_stuff/" + name);
	}

	public static ResourceLocation mixingBowl(@Nullable String name) {
		return new ResourceLocation(Refinement.MOD_ID, "mixing_bowl/" + name);
	}

	public static ResourceLocation tools(@Nullable String name) {
		return new ResourceLocation(Refinement.MOD_ID, "tools/" + name);
	}

	public static ResourceLocation molds(@Nullable String name) {
		return new ResourceLocation(Refinement.MOD_ID, "molds/" + name);
	}

	public static String itemName(Item item) {
		return item.getRegistryName().getPath();
	}

	public static String itemName(RegistryObject<Item> item) {
		return item.get().getRegistryName().getPath();
	}

	protected static InventoryChangeTrigger.Instance has(IItemProvider p_200403_0_) {
		return inventoryTrigger(ItemPredicate.Builder.item().of(p_200403_0_).build());
	}

	protected static InventoryChangeTrigger.Instance inventoryTrigger(ItemPredicate... p_200405_0_) {
		return new InventoryChangeTrigger.Instance(EntityPredicate.AndPredicate.ANY, MinMaxBounds.IntBound.ANY,
				MinMaxBounds.IntBound.ANY, MinMaxBounds.IntBound.ANY, p_200405_0_);
	}

}
