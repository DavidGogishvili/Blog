package ge.davidgogishvili.blog.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(schema = "public", name = "users")
public class UserDomain extends BaseEntity implements UserDetails {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="users_seq-generator")
    @SequenceGenerator(name="users_id_seq-generator", sequenceName="users_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private Boolean isActive;


    @Transient
    private List<Roles> rolesList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (rolesList == null) {
            return new ArrayList<>();
        }
        return rolesList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }



}
