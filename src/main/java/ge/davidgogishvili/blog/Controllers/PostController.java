package ge.davidgogishvili.blog.Controllers;


import ge.davidgogishvili.blog.Entities.Posts;
import ge.davidgogishvili.blog.Models.PostCreateModel;
import ge.davidgogishvili.blog.Repositories.PostsRepo;
import ge.davidgogishvili.blog.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {


    private final PostService postService;
    private final PostsRepo postsRepo;

    @PostMapping("/new")
    public Posts createPost(@RequestBody PostCreateModel postCreateModel) {
        return postService.createPost(postCreateModel);
    }

    @GetMapping("/find")
    public List<Posts> findAllPosts() {
        return postsRepo.findAll();
    }

    @GetMapping("/getCurrentUsersPosts")
    public ResponseEntity<List<Posts>> getCurrentUsersPosts() {
        List <Posts> posts = postService.getPostsByCurrentUser();
        return ResponseEntity.ok(posts);
    }
}
