package ge.davidgogishvili.blog.Service;

import ge.davidgogishvili.blog.Entities.Profiles;
import ge.davidgogishvili.blog.Models.ProfileCreateModel;

public interface ProfileService {
    Profiles createProfile(ProfileCreateModel profileCreateModel);
}
