package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Comments;
import ge.davidgogishvili.blog.Entities.Posts;
import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Models.CommentCreateModel;
import ge.davidgogishvili.blog.Repositories.CommentsRepo;
import ge.davidgogishvili.blog.Repositories.PostsRepo;
import ge.davidgogishvili.blog.Repositories.ProfilesRepo;
import ge.davidgogishvili.blog.Security.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentsRepo commentsRepo;
    private final ProfilesRepo profilesRepo;
    private final PostsRepo postsRepo;

    @Override
    public Comments createComment(CommentCreateModel commentCreateModel, Integer postId) {
        Integer userId = UserManager.getCurrentUser().getId();
        Profiles profile = profilesRepo.findByUserId(userId);
        Posts post = postsRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comments comment = new Comments();
        comment.setContent(commentCreateModel.content());

        if (profile != null && profile.getName() != null) {
            comment.setCreatorName(profile.getName());
            comment.setProfileId(profile.getId());
        } else {
            comment.setCreatorName(UserManager.getCurrentUser().getUsername());
            comment.setProfileId(null);
        }
        comment.setPost(post);
        commentsRepo.save(comment);
        return comment;
    }







}

