package com.vannsha.studentlist.servise;

import com.vannsha.studentlist.domain.Student;
import com.vannsha.studentlist.repo.StudentRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Flux<Student> list() {
        return studentRepo.findAll();
    }

    public Mono<Student> add(Student student) {
        return studentRepo.save(student);
    }

    public Mono<Student> update(Student student) {
       return studentRepo.findById(student.getId())
               .map(s -> student)
               .flatMap(studentRepo::save);
    }
}
