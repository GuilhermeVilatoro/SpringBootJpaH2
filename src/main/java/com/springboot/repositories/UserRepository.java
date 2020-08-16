package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}