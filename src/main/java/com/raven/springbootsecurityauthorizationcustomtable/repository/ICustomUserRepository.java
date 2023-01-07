package com.raven.springbootsecurityauthorizationcustomtable.repository;

import com.raven.springbootsecurityauthorizationcustomtable.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomUserRepository extends JpaRepository<CustomUser, Integer> {
    CustomUser findByEmail(String email);
}
