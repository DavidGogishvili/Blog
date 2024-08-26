package ge.davidgogishvili.blog.Service;


import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Entities.Recipes;
import ge.davidgogishvili.blog.Models.RecipeCreateModel;
import ge.davidgogishvili.blog.Repositories.ProfilesRepo;
import ge.davidgogishvili.blog.Repositories.RecipesRepo;
import ge.davidgogishvili.blog.Security.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipesServiceImpl implements RecipesService {


    private final RecipesRepo recipesRepo;
    private final ProfilesRepo profilesRepo;


    @Override
    public Recipes createRecipe(RecipeCreateModel recipeCreateModel) {
        Integer userId = UserManager.getCurrentUserId();
        Profiles profile = profilesRepo.findByUserId(userId);

        Recipes recipes = new Recipes();
        recipes.setTitle(recipeCreateModel.title());
        recipes.setContent(recipeCreateModel.content());

        if (profile != null && profile.getName() !=null) {
            recipes.setCreatorName(profile.getName());
            recipes.setProfileId(profile.getId());
        } else  {
            recipes.setCreatorName(UserManager.getCurrentUser().getUsername());
            recipes.setProfileId(null);
        }
        recipesRepo.save(recipes);
        return recipes;
    }
}
