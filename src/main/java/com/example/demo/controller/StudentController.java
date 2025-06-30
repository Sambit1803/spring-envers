package com.example.demo.controller;

import com.example.demo.Util.StudentRequest;
import com.example.demo.entity.Join.Student;
import com.example.demo.entity.Join.Subject;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public StudentController(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping
    public List<Student> getgetStudent() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody StudentRequest request) {
        Subject subject = subjectRepository.findById(request.getSubjectId()).get();

        Student student = new Student();
        student.setSubject(subject);
        student.setName(request.getStudentName());
        return studentRepository.save(student);
    }
}
