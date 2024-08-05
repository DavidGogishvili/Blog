package ge.davidgogishvili.blog.Controllers;

import ge.davidgogishvili.blog.Entities.UserDomain;
import ge.davidgogishvili.blog.Models.UserCreateModel;
import ge.davidgogishvili.blog.Repositories.UserRepo;
import ge.davidgogishvili.blog.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepo userRepo;


    @GetMapping("/find")
    public List<UserDomain> findUsers () {
        return userRepo.findAll();
    }

    @GetMapping("/find/{id}")
    public UserDomain users(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/find/byEmail/{email}")
    public Optional<UserDomain> users (@PathVariable String email) {
        return userService.getUsers(email);
    }

    @GetMapping("find/profile")
    public Optional<UserDomain> users () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.getUserByUsername(username);
    }

    @GetMapping("/current")
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication !=null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        }
        else  {
            return "Anonymous User";
        }
    }


    @PostMapping("/new")
    public UserDomain createUser(@RequestBody UserCreateModel userCreateModel) {
        return userService.createUser(userCreateModel);
    }


}
