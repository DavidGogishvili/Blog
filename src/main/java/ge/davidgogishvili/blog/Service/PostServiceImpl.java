package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Posts;
import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Models.PostCreateModel;
import ge.davidgogishvili.blog.Repositories.PostsRepo;
import ge.davidgogishvili.blog.Repositories.ProfilesRepo;
import ge.davidgogishvili.blog.Security.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostsRepo postsRepo;
    private final ProfilesRepo profilesRepo;


    @Override
    public Posts createPost(PostCreateModel postCreateModel) {
        Integer userId = UserManager.getCurrentUserId();
        Profiles profile = profilesRepo.findByUserId(userId);

        Posts post = new Posts();
        post.setTitle(postCreateModel.title());
        post.setContent(postCreateModel.content());
        post.setCategory(postCreateModel.category());
        post.setSubCategory(postCreateModel.subCategory());

        if (profile != null && profile.getName() != null) {
            post.setCreatorName(profile.getName());
            post.setProfileId(profile.getId());
        } else {
            post.setCreatorName(UserManager.getCurrentUser().getUsername());
            post.setProfileId(null);
        }

        postsRepo.save(post);
        return post;
    }


    @Override
    public List<Posts> getPostsByCurrentUser(){
        Integer userId = UserManager.getCurrentUserId();
        Profiles profile = profilesRepo.findByUserId(userId);

        if (profile != null) {
            return postsRepo.findByProfileId(profile.getId());
        } else {
            String username = UserManager.getCurrentUser().getUsername();
            return postsRepo.findByCreatorName(username);
        }
    }
}
