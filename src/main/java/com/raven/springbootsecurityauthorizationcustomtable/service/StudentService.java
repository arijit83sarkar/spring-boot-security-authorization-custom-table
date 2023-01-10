package com.raven.springbootsecurityauthorizationcustomtable.service;

import com.raven.springbootsecurityauthorizationcustomtable.model.Student;
import com.raven.springbootsecurityauthorizationcustomtable.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements UserDetailsService {
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<String> registerStudent(Student _student) {
        ResponseEntity<String> responseEntity;

        try {
            Student employeeSaved = this.studentRepository.save(_student);
            responseEntity = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Student details are successfully saved.");
        } catch (Exception exception) {
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while saving : " + exception.getMessage());
        }

        return responseEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
