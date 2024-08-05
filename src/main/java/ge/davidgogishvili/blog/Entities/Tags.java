package ge.davidgogishvili.blog.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "public", name = "users")
public class Tags extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_seq-generator")
    @SequenceGenerator(name = "tags_seq-generator", sequenceName = "tags_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private Integer userId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserDomain users;



}