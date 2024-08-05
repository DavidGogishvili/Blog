package ge.davidgogishvili.blog.Repositories;


import ge.davidgogishvili.blog.Entities.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserDomain, Integer> {
    Optional<UserDomain> findAllByEmail(String email);

    boolean existsByEmail(String email);
}
