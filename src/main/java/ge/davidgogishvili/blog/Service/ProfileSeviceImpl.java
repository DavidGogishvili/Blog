package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Models.ProfileCreateModel;
import ge.davidgogishvili.blog.Repositories.ProfilesRepo;
import ge.davidgogishvili.blog.Security.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileSeviceImpl implements ProfileSevice {

    private final ProfilesRepo profilesRepo;

    @Override
    public Profiles createProfile(ProfileCreateModel profileCreateModel) {
        Integer currentUserId = UserManager.getCurrentUserId();
        Profiles existingProfile = profilesRepo.findByUserId(currentUserId);
        if (
                existingProfile != null
        ) {
            throw new RuntimeException("პროფილი უკვე არსებობს");
        }

        Profiles profile = new Profiles();
        profile.setName(profileCreateModel.name());
        profile.setLastName(profileCreateModel.lastName());
        profile.setAddress(profileCreateModel.address());
        profile.setDateOfBirth(profileCreateModel.dateOfBirth());
        profile.setGender(profileCreateModel.gender());
        profile.setAge(profileCreateModel.age());
        profile.setPhoneNumber(profileCreateModel.phoneNumber());
        profile.setUserId(currentUserId);
        profilesRepo.save(profile);
        return profile;
    }

    @Override
    public Profiles findProfilesById(Integer id) {
        return profilesRepo.findById(id).orElseThrow();

    }
}
