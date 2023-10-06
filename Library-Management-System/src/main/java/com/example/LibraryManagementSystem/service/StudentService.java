package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.Enum.CardStatus;
import com.example.LibraryManagementSystem.model.LibraryCard;
import com.example.LibraryManagementSystem.model.Student;
import com.example.LibraryManagementSystem.repositary.StudentRepo;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import org.hibernate.boot.CacheRegionDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public String addStudent(Student student) {

        LibraryCard libraryCard = new LibraryCard();

        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);

        Student savedstudent = studentRepo.save(student);
        return "Student saved successfully!!!";
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepo.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
}
