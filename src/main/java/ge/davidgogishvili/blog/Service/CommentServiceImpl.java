package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Comments;
import ge.davidgogishvili.blog.Entities.Posts;
import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Entities.Recipes;
import ge.davidgogishvili.blog.Models.CommentCreateModel;
import ge.davidgogishvili.blog.Repositories.CommentsRepo;
import ge.davidgogishvili.blog.Repositories.PostsRepo;
import ge.davidgogishvili.blog.Repositories.ProfilesRepo;
import ge.davidgogishvili.blog.Repositories.RecipesRepo;
import ge.davidgogishvili.blog.Security.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentsRepo commentsRepo;
    private final ProfilesRepo profilesRepo;
    private final PostsRepo postsRepo;
    private final RecipesRepo recipesRepo;


    @Override
    public Comments createComment(CommentCreateModel commentCreateModel, Integer postId, Integer recipeId) {
        Integer userId = UserManager.getCurrentUser().getId();
        Profiles profile = profilesRepo.findByUserId(userId);

        Comments comments = new Comments();
        comments.setContent(commentCreateModel.content());

        if (profile != null && profile.getName() !=null) {
            comments.setCreatorName(profile.getName());
            comments.setProfileId(profile.getId());
        } else {
            comments.setCreatorName(UserManager.getCurrentUser().getUsername());
            comments.setProfileId(null);
        }

        if (postId != null) {
            Posts post = postsRepo.findById(postId)
                    .orElseThrow(() -> new RuntimeException("Post not found"));
            comments.setPost(post);
        } else if (recipeId != null) {
            Recipes recipe = recipesRepo.findById(recipeId)
                    .orElseThrow(() -> new RuntimeException("Recipe not found"));
            comments.setRecipe(recipe);
        } else {
            throw new RuntimeException("Post or recipe not found");
        }
        commentsRepo.save(comments);
        return comments;
    }







}

