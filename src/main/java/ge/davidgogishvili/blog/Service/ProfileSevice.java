package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Models.ProfileCreateModel;

public interface ProfileSevice {

    Profiles createProfile(ProfileCreateModel profileCreateModel);

    Profiles findProfilesById(Integer id);

}
