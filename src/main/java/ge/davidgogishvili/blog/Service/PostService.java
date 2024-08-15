package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Posts;
import ge.davidgogishvili.blog.Models.PostCreateModel;

import java.util.List;

public interface PostService {
    Posts createPost(PostCreateModel postCreateModel);

    List <Posts> getPostsByCurrentUser();
}
