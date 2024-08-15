package ge.davidgogishvili.blog.Repositories;

import ge.davidgogishvili.blog.Entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepo extends JpaRepository<Posts, Integer> {

    List<Posts> findByProfileId(Integer profileId);

    List<Posts> findByCreatorName(String creatorName);
}
