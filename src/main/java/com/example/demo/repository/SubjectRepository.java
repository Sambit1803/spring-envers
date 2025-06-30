package com.example.demo.repository;

import com.example.demo.entity.Join.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface SubjectRepository extends RevisionRepository<Subject, Long, Long>, JpaRepository<Subject, Long> {
}
