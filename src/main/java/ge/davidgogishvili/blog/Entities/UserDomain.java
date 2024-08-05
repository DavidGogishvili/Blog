package ge.davidgogishvili.blog.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)

@Data
@Entity
@Table(schema = "public", name = "users")
public class UserDomain extends BaseEntity implements UserDetails {
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="users_seq-generator")
    @SequenceGenerator(name="users_seq-generator", sequenceName="users_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column (name = "isActive")
    private Boolean active;


    @Transient
    private List <Roles> roleList;


    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Profiles> profiles;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonIgnore

    private List<Categories> categories;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @JsonIgnore

    private List<Tags> tags;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if ( roleList == null) {
            return new ArrayList<>();
        }
        return roleList;
    }

    @Override
    public void preInsert() {
        setCreatedAt(LocalDateTime.now());
    }

    @Override
    public void preChange() {
        setChangedAt(LocalDateTime.now());

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
