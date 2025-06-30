package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface UserRepository extends RevisionRepository<User, Long, Long>, JpaRepository<User, Long> {
}