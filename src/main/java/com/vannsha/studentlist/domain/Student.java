package com.vannsha.studentlist.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Student {
    @Id
    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Integer phoneNumber;
    private String email;
    private String address;
    private Integer course;
    private String groupName;
}
