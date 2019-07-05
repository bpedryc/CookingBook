package com.pk.java.mechanics;
import java.util.List;
import java.util.ArrayList;

public class Recipe {
	private String author;
	private String title;
	private String rating;
	private String prep_time;
	private List<String> ingredients = new ArrayList<String>();
	private String description;
	private int id;
	
	private Recipe(final Builder builder)
	{
		this.author = builder.author;
		this.title = builder.title;
		this.rating = builder.rating;
		this.prep_time = builder.prep_time;
		this.description = builder.description;
		this.id = builder.id;
		this.ingredients = builder.ingredients;
	}
	
	public String getAuthor()
	{
		return author;
	}

	public String getTitle()
	{
		return title;
	}
	
	public String getRating()
	{
		return rating;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getPrep_time()
	{
		return prep_time;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public List<String> getIngredients()
	{
		return ingredients;
	}
	
	public static class Builder
	{
		
		private String author;
		private String title;
		private String rating;
		private String prep_time;
		private List<String> ingredients = new ArrayList<String>();
		private String description;
		private final int id;
		
		public Builder(final int id)
		{
			this.id = id;
		}
		
		public Builder author(final String author)
		{
			this.author = author;
			return this;
		}
		
		public Builder title(final String title)
		{
			this.title = title;
			return this;
		}
		
		public Builder rating(final String rating)
		{
			this.rating = rating;
			return this;
		}
		
		public Builder prep_time(final String prep_time)
		{
			this.prep_time = prep_time;
			return this;
		}
		
		public Builder ingredients(List<String> ingredients)
		{
			this.ingredients = ingredients;
			return this;
		}
		
		public Builder description(final String description)
		{
			this.description = description;
			return this;
		}
		
		public Recipe build()
		{
			return new Recipe(this);
		}
		
		
	}
	
   	public String toString() {
   		return "Przepis [title=" + title + ", author=" + author +", rating="+rating+ ", desc=" + description
   				+ ", prep_time=" + prep_time + ", vec="+ ingredients+"]";
   	}
	
}
