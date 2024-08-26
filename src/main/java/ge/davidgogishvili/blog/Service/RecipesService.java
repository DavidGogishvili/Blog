package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Recipes;
import ge.davidgogishvili.blog.Models.RecipeCreateModel;

public interface RecipesService {

    Recipes createRecipe(RecipeCreateModel recipeCreateModel);
}
