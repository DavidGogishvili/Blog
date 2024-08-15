package ge.davidgogishvili.blog.Controllers;


import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Models.ProfileCreateModel;
import ge.davidgogishvili.blog.Repositories.ProfilesRepo;
import ge.davidgogishvili.blog.Service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfilesRepo profilesRepo;

    @GetMapping("/find")
    public List<Profiles> findProfiles() {
        return profilesRepo.findAll();
    }

    @PostMapping("/new")
    public Profiles createProfile(@RequestBody ProfileCreateModel profileCreateModel) {
        return profileService.createProfile(profileCreateModel);
    }
}
