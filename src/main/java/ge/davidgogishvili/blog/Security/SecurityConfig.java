package ge.davidgogishvili.blog.Security;

import ge.davidgogishvili.blog.Repositories.UserRepo;
import ge.davidgogishvili.blog.Repositories.UserRolesRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserRepo userRepo;
    private final UserRolesRepo userRolesRepo;

    public SecurityConfig(UserRepo userRepo, UserRolesRepo userRolesRepo) {
        this.userRepo = userRepo;
        this.userRolesRepo = userRolesRepo;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        (authorize) -> authorize
                                .requestMatchers( "/users/**", "profiles/**", "posts/**").permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .exceptionHandling( (c) -> c.authenticationEntryPoint(
                        (request,  response,  authException) -> response.sendError(401, "Forbidden") ));

        ;
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }



    @Bean
    public UserDetailsService userDetailsService() {
        return new UserManager(userRepo, userRolesRepo);
    }
}
