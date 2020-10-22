package com.vannsha.studentlist.repo;

import com.vannsha.studentlist.domain.Student;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends ReactiveCrudRepository<Student, Long> {

}
