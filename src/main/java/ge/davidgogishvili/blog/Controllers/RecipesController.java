package ge.davidgogishvili.blog.Controllers;


import ge.davidgogishvili.blog.Entities.Recipes;
import ge.davidgogishvili.blog.Models.RecipeCreateModel;
import ge.davidgogishvili.blog.Repositories.RecipesRepo;
import ge.davidgogishvili.blog.Service.RecipesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipes")
public class RecipesController {


    private final RecipesService recipesService;
    private final RecipesRepo recipesRepo;


    @PostMapping("/new")
    public Recipes createRecipe(@RequestBody RecipeCreateModel recipeCreateModel) {
        return recipesService.createRecipe(recipeCreateModel);
    }

    @GetMapping("/find")
    public List<Recipes> findAll() {
       return recipesRepo.findAll();
    };
}
