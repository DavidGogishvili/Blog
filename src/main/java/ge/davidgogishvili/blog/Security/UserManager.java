package ge.davidgogishvili.blog.Security;

import ge.davidgogishvili.blog.Entities.Roles;
import ge.davidgogishvili.blog.Entities.UserDomain;
import ge.davidgogishvili.blog.Entities.UserRoles;
import ge.davidgogishvili.blog.Repositories.UserRepo;
import ge.davidgogishvili.blog.Repositories.UserRolesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserManager implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserRolesRepo userRolesRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDomain> user = userRepo.findAllByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        UserDomain userDetails = user.get();
        List<Roles> roles = new ArrayList<>();

        List<UserRoles> userRoles = userRolesRepo.findAllByUserId(userDetails.getId());
        for (UserRoles userRole : userRoles) {
            roles.add(userRole.getRole());
        }
        userDetails.setRolesList(roles);

        System.out.println("User " + username + " has logged in");

        return userDetails;
    }


    public static UserDomain getCurrentUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null) {
            throw new RuntimeException("Authentication required");
        }
        if (auth.getPrincipal() instanceof UserDomain user) {
            return user;
        }
        throw new RuntimeException("Anonymous user");
    }

//    public static Integer getCurrentUserProfileId() {
//        UserDomain currentUser = getCurrentUser();
//        return currentUser.getProfileId();
//    }

    public static Integer getCurrentUserId() {
        UserDomain currentUser = getCurrentUser();
        return currentUser.getId();
    }

}