package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.Enum.CardStatus;
import com.example.LibraryManagementSystem.Enum.Gender;
import com.example.LibraryManagementSystem.Transformer.LibraryCardTransformer;
import com.example.LibraryManagementSystem.Transformer.StudentTransformer;
import com.example.LibraryManagementSystem.dto.requestdto.StudentRequest;
import com.example.LibraryManagementSystem.dto.responsedto.LibraryCardResponse;
import com.example.LibraryManagementSystem.dto.responsedto.StudentResponse;
import com.example.LibraryManagementSystem.model.LibraryCard;
import com.example.LibraryManagementSystem.model.Student;
import com.example.LibraryManagementSystem.repositary.StudentRepo;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import org.hibernate.boot.CacheRegionDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public StudentResponse addStudent(StudentRequest studentRequest) {

        //dto to model

        Student student = StudentTransformer.StudentRequestToStudent(studentRequest);
        LibraryCard card = LibraryCardTransformer.prepareLibraryCard();
        card.setStudent(student);
        student.setLibraryCard(card);
        Student savedstudent = studentRepo.save(student);

         return  StudentTransformer.StudentToStudentResponse(savedstudent);

        // studentResponse.setLibraryCardResponse(cardResponse);


    }

    public StudentResponse getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepo.findById(regNo);
        if(studentOptional.isPresent()){
            return StudentTransformer.StudentToStudentResponse(studentOptional.get());
        }
        return null;
    }

    public List<String> getAllMales() {

        List<String>names = new ArrayList<>();
        List<Student>students = studentRepo.findByGender(Gender.MALE);
        for(Student s:students){
            names.add(s.getName());
        }
        return names;
    }

    public Student StudentToStudentResponse(StudentRequest studentRequest){

         return  Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();


    }
}
