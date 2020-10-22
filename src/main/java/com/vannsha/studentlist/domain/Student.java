package com.vannsha.studentlist.domain;

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
