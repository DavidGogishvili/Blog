package ge.davidgogishvili.blog.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(schema = "public", name = "posts" )

public class Posts extends BaseEntity {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="posts_seq-generator")
    @SequenceGenerator(name="posts_id_seq-generator", sequenceName="posts_id_seq", allocationSize = 1)
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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comments> comments;


}
