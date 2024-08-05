package ge.davidgogishvili.blog.Models;

import java.time.LocalDate;

public record ProfileCreateModel(


    String name,

    String lastName,

    String address,

    LocalDate dateOfBirth,

    String gender,

    Integer age,

    String phoneNumber

) {
}
