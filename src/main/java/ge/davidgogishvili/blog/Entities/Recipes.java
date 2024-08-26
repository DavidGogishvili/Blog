package ge.davidgogishvili.blog.Entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(schema = "public", name = "recipes")
public class Recipes extends BaseEntity {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipes_seq_generator")
    @SequenceGenerator(name = "recipes_id_seq_generator", sequenceName = "recipes_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "profile_id")
    private Integer profileId;


    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comments> comments;
    
}
