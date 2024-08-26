package ge.davidgogishvili.blog.Repositories;

import ge.davidgogishvili.blog.Entities.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepo extends JpaRepository <Recipes, Integer> {

}
