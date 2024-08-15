package ge.davidgogishvili.blog.Entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(schema = "public", name = "profiles" )
public class Profiles extends BaseEntity {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="profiles_seq-generator")
    @SequenceGenerator(name="profiles_id_seq-generator", sequenceName="profiles_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "user_id")
    private Integer userId;


}
