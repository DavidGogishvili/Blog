package ge.davidgogishvili.blog.Controllers;


import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Models.ProfileCreateModel;
import ge.davidgogishvili.blog.Repositories.ProfilesRepo;
import ge.davidgogishvili.blog.Service.ProfileSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfilesRepo profilesRepo;
    private final ProfileSevice profileSevice;


    @GetMapping("/find")
    public List<Profiles> findProfiles() {
        return profilesRepo.findAll();
    }


    @PostMapping("/create")
    public Profiles createProfile(@RequestBody ProfileCreateModel profileCreateModel) {
        return profileSevice.createProfile(profileCreateModel);
    }

    @GetMapping("/find/{id}")
    public Profiles profilesList(@PathVariable Integer id) {
        return profileSevice.findProfilesById(id);
    }

}

