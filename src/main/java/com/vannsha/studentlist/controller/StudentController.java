package com.vannsha.studentlist.controller;

import com.vannsha.studentlist.domain.Student;
import com.vannsha.studentlist.servise.StudentService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Flux<Student> list() {
        return studentService.list();
    }

    @PostMapping
    public Mono<Student> add(@RequestBody Student student) {
        return studentService.add(student);
    }
}
