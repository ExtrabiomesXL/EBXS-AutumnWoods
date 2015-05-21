package extrabiomes.autumn.handlers;

import java.util.List;

import com.google.common.collect.Lists;

import extrabiomes.autumn.stuff.Element;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;

public class RecipeHandler {

	public static void init() {
		writeAutumnRecipes();
	}
	
	private static void writeAutumnRecipes() {
		final IRecipe recipe = new ShapelessRecipes(
				new ItemStack(Element.PLANK_AUTUMN.get().getItem(), 4, 0), 
				Lists.newArrayList(Element.LOG_AUTUMN.get())
			);
		addRecipe(recipe);
	}
	
	private static void addRecipe(IRecipe recipe) {
		CraftingManager.getInstance().getRecipeList().add(0, recipe);
	}

}
