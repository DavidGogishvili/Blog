package ge.davidgogishvili.blog.Repositories;

import ge.davidgogishvili.blog.Entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comments, Integer> {
}
