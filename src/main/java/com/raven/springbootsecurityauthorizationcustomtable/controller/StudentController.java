package com.raven.springbootsecurityauthorizationcustomtable.controller;

import com.raven.springbootsecurityauthorizationcustomtable.model.Student;
import com.raven.springbootsecurityauthorizationcustomtable.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/registerStudent")
    public ResponseEntity<String> registerStudent(@RequestBody Student _student) {
        ResponseEntity<String> responseEntity = this.studentService
                .registerStudent(_student);

        return responseEntity;
    }

    @GetMapping("/myCourses")
    public String myCourses() {
        return "Enrolled courses:" +
                "<ul>" +
                "<li>Full Stack JAVA Developer (85% done)</li>" +
                "<li>Microservices with Spring Boot (55 % done)</li>" +
                "<li>Docker guide : Beginner to Master (65% done)</li>" +
                "</ul>";
    }
}
