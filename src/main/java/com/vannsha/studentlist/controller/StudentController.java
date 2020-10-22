package com.vannsha.studentlist.controller;

import com.vannsha.studentlist.domain.Student;
import com.vannsha.studentlist.servise.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/students")
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
    public Mono<Student> add(@Valid @RequestBody Student student) {
        return studentService.add(student);
    }


    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<Map<String, String>> handleWebExchangeBindException(WebExchangeBindException ex) {
        Map<String, String> messageMap = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> {
            messageMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageMap);
    }

}
