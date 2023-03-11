package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // select * from student where email !=
    @Query("SELECT s from Student s where s.email = ?1") //getting an error here;
    // how did I solve it: Student should have been capitalized
    // Runs well in psql cmd with lower cases but I think the query is not the sql itself but something unique
    // to Spring and Student is taken from somewhere else
    Optional<Student> findStudentByEmail(String email);

}
