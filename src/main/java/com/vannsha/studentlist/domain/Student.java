package com.vannsha.studentlist.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vannsha.studentlist.validator.Adult;
import com.vannsha.studentlist.validator.CorrectEmail;
import com.vannsha.studentlist.validator.CorrectPhoneNumber;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
public class Student {
    public Student(@JsonProperty("id") Long id,
                   @JsonProperty("name") @NotBlank(message = "{name.empty}") String name,
                   @JsonProperty("surname") @NotBlank(message = "{surname.empty}") String surname,
                   @JsonProperty("dateOfBirth") @Adult(message = "{dateOfBirth.adult}") LocalDate dateOfBirth,
                   @JsonProperty("phoneNumber") @CorrectPhoneNumber(message = "{phone.incorrect}") String phoneNumber,
                   @JsonProperty("email") @CorrectEmail(message = "{email.incorrect}") @Size(max = 100, message = "{email.maxsize}") String email,
                   @JsonProperty("address") String address,
                   @JsonProperty("course") Integer course,
                   @JsonProperty("groupName") String groupName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.course = course;
        this.groupName = groupName;
    }

    @Id
    private Long id;

    @NotBlank(message = "{name.empty}")
    private String name;

    @NotBlank(message = "{surname.empty}")
    private String surname;

    @Adult(message = "{dateOfBirth.adult}")
    private LocalDate dateOfBirth;

    @CorrectPhoneNumber(message = "{phone.incorrect}")
    private String phoneNumber;


    @Size(max = 100, message = "{email.maxsize}")
    @CorrectEmail(message = "{email.incorrect}")
    private String email;

    private String address;

    private Integer course;

    private String groupName;
}
