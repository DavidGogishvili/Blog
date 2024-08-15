package ge.davidgogishvili.blog.Entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "public", name = "comments")
public class Comments extends BaseEntity {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="comments_seq-generator")
    @SequenceGenerator(name="comments_id_seq-generator", sequenceName="comments_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "content")
    private String content;

    @Column(name = "profile_id")
    private Integer profileId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts post;

}
