package com.example.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootapp.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
