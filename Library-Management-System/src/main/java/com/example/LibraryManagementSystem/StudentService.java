package com.example.LibraryManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired StudentRepo studentRepo;
    public Student addStudent(Student student) {

        Student savedstudent = studentRepo.save(student);
        return savedstudent;
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepo.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
}
