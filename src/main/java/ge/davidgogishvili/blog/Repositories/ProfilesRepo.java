package ge.davidgogishvili.blog.Repositories;

import ge.davidgogishvili.blog.Entities.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepo extends JpaRepository<Profiles, Integer> {
    Profiles findByUserId(Integer currentUserId);

}
