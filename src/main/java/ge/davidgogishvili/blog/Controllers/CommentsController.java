package ge.davidgogishvili.blog.Controllers;

import ge.davidgogishvili.blog.Entities.Comments;
import ge.davidgogishvili.blog.Models.CommentCreateModel;
import ge.davidgogishvili.blog.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentsController {

    private final CommentService commentService;

    @PostMapping("/new")
    public Comments createComment(@RequestBody CommentCreateModel commentCreateModel,
                                  @RequestParam(required = false) Integer postId,
                                  @RequestParam(required = false) Integer recipeId) {
        return commentService.createComment(commentCreateModel, postId, recipeId);
    }

}
