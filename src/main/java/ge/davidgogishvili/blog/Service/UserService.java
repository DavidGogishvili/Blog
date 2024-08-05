package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.UserDomain;
import ge.davidgogishvili.blog.Models.UserCreateModel;

import java.util.Optional;

public interface UserService {

    UserDomain createUser(UserCreateModel userCreateModel);

    Optional<UserDomain> findAllByUsername(String username);
    Optional<UserDomain> findAllByEmail(String email);


    UserDomain getUser(Integer id);

    Optional<UserDomain> getUsers(String email);

    Optional<UserDomain> getUserByUsername(String username);
}
