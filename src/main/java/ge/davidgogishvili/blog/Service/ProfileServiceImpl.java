package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Models.ProfileCreateModel;
import ge.davidgogishvili.blog.Repositories.ProfilesRepo;
import ge.davidgogishvili.blog.Security.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfilesRepo profilesRepo;

    @Override
    public Profiles createProfile(ProfileCreateModel profileCreateModel) {

        Integer currentUserId = UserManager.getCurrentUserId();
        Profiles existingProfile = profilesRepo.findByUserId(currentUserId);
        if (existingProfile != null) {
            throw new IllegalStateException("აღნიშნულ იუზერს უკვე აქვს პროფილი");
        }
        Profiles profile = new Profiles();
        profile.setName(profileCreateModel.name());
        profile.setLastName(profileCreateModel.lastName());
        profile.setDateOfBirth(profileCreateModel.dateOfBirth());
        profile.setAge(Period.between(profileCreateModel.dateOfBirth(), LocalDate.now()).getYears());
        profile.setPhoneNumber(profileCreateModel.phoneNumber());
        profile.setAddress(profileCreateModel.address());
        profile.setGender(profileCreateModel.gender());
        profile.setUserId(currentUserId);
        profilesRepo.save(profile);
        return profile;
    }
}
