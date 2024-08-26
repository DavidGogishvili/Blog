package ge.davidgogishvili.blog.Service;


import ge.davidgogishvili.blog.Entities.Comments;
import ge.davidgogishvili.blog.Models.CommentCreateModel;

public interface CommentService {

    Comments createComment(CommentCreateModel createModel, Integer postId, Integer recipeId);

}
