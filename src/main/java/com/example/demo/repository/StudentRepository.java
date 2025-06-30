package com.example.demo.repository;

import com.example.demo.entity.Join.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface StudentRepository extends RevisionRepository<Student, Long, Long>, JpaRepository<Student, Long> {
}
