package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.UserDomain;
import ge.davidgogishvili.blog.Models.UserCreateModel;
import ge.davidgogishvili.blog.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDomain createUser(UserCreateModel userCreateModel) {
        if (userRepo.existsByEmail(userCreateModel.email())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        var user = new UserDomain();
        user.setEmail(userCreateModel.email());
        user.setPassword(userCreateModel.password());
        user.setActive(true);
        userRepo.save(user);

        return user;
    }

    @Override
    public Optional<UserDomain> findAllByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDomain> findAllByEmail(String email) {
        return userRepo.findAllByEmail(email);
    }

    @Override
    public UserDomain getUser(Integer id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public Optional<UserDomain> getUsers(String email) {
        return userRepo.findAllByEmail(email);
    }

    @Override
    public Optional<UserDomain> getUserByUsername(String username) {
        return userRepo.findAllByEmail(username);
    }
}