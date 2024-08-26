package ge.davidgogishvili.blog.Controllers;


import ge.davidgogishvili.blog.Entities.Recipes;
import ge.davidgogishvili.blog.Models.RecipeCreateModel;
import ge.davidgogishvili.blog.Service.RecipesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipes")
public class RecipesController {


    private final RecipesService recipesService;


    @PostMapping("/new")
    public Recipes createRecipe(@RequestBody RecipeCreateModel recipeCreateModel) {
        return recipesService.createRecipe(recipeCreateModel);
    }
}
