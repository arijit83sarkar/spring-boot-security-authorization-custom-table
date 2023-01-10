package com.raven.springbootsecurityauthorizationcustomtable.repository;

import com.raven.springbootsecurityauthorizationcustomtable.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}
