package ge.davidgogishvili.blog.Controllers;


import ge.davidgogishvili.blog.Entities.UserDomain;
import ge.davidgogishvili.blog.Models.UserCreateModel;
import ge.davidgogishvili.blog.Repositories.UserRepo;
import ge.davidgogishvili.blog.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepo userRepo;


    @GetMapping("/find")
    public List<UserDomain> findUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/new")
    public UserDomain createUser(@RequestBody UserCreateModel userCreateModel){
        return userService.createUser(userCreateModel);
    }


}
