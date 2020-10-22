package com.vannsha.studentlist;

import com.vannsha.studentlist.controller.StudentController;
import com.vannsha.studentlist.domain.Student;
import com.vannsha.studentlist.servise.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = StudentController.class)
public class StudentControllerTest {

    @MockBean
    StudentService studentService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void list() {
        webTestClient.get()
                .uri("/students")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Student.class);
    }

    @Test
    void add() {
        Student student = Student.builder()
                .name("Ivan")
                .surname("Kyrylov")
                .dateOfBirth(LocalDate.of(1997, 10, 9))
                .phoneNumber("+38-000-000-00-00")
                .email("username@mail.com")
                .address("Ukraine")
                .course(1)
                .groupName("ІПЗ-228").build();

        Mono<Student> studentMono = Mono.just(student);
        Mockito.when(studentService.add(student)).thenReturn(studentMono);

        webTestClient.post()
                .uri("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(student), Student.class)
                    .exchange()
                    .expectStatus().isOk()
                    .expectHeader().contentType(MediaType.APPLICATION_JSON)
                    .expectBody()
                .jsonPath("$.name").isEqualTo(student.getName())
                .jsonPath("$.surname").isEqualTo(student.getSurname())
                .jsonPath("$.dateOfBirth").isEqualTo(student.getDateOfBirth().toString())
                .jsonPath("$.phoneNumber").isEqualTo(student.getPhoneNumber())
                .jsonPath("$.email").isEqualTo(student.getEmail())
                .jsonPath("$.address").isEqualTo(student.getAddress())
                .jsonPath("$.course").isEqualTo(student.getCourse())
                .jsonPath("$.groupName").isEqualTo(student.getGroupName());
    }
}