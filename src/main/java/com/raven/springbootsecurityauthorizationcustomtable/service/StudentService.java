package com.raven.springbootsecurityauthorizationcustomtable.service;

import com.raven.springbootsecurityauthorizationcustomtable.model.Student;
import com.raven.springbootsecurityauthorizationcustomtable.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements UserDetailsService {
    private final IStudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentService(IStudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<String> registerStudent(Student _student) {
        ResponseEntity<String> responseEntity;

        try {
            // PASSWORD ENCRYPTION
            String _pwd = this.passwordEncoder.encode(_student.getPwd());
            _student.setPwd(_pwd);

            Student studentSaved = this.studentRepository.save(_student);
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
        String _username, _password;
        List<GrantedAuthority> _authorities;

        Student student = this.studentRepository.findByEmail(username);
        if (student != null) {
            _username = student.getEmail();
            _password = student.getPwd();
            _authorities = new ArrayList<>();
            _authorities.add(new SimpleGrantedAuthority(student.getRole()));
        } else {
            throw new UsernameNotFoundException("Student not found with : " + username);
        }

        return new User(_username, _password, _authorities);
    }
}
