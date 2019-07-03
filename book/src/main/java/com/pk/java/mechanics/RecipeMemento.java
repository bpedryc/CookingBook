package com.pk.java.mechanics;
import java.util.HashMap;

public class RecipeMemento {

	private HashMap<Integer,Recipe> recipe;
	
	public RecipeMemento(HashMap<Integer,Recipe> recipe)
	{
		this.recipe = recipe;
	}
	
	public HashMap<Integer,Recipe> getRecipe()
	{
		return recipe;
	}
	
}
