package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.Enum.CardStatus;
import com.example.LibraryManagementSystem.Enum.Gender;
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

//        Student student = new Student();
//        student.setName(studentRequest.getName());
//        student.setAge(studentRequest.getAge());
//        student.setGender(studentRequest.getGender());
//        student.setEmail(studentRequest.getEmail());


       Student student = StudentTransformer.StudentRequestToStudent(studentRequest);
//                .name(studentRequest.getName())
//                .age(studentRequest.getAge())
//                .email(studentRequest.getEmail())
//                .gender(studentRequest.getGender())
//                .build();


//        LibraryCard libraryCard = new LibraryCard();
//
//        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
//        libraryCard.setCardStatus(CardStatus.ACTIVE);
//        libraryCard.setStudent(student);


        LibraryCard libraryCard = LibraryCard.builder()
                        .cardNo(String.valueOf(UUID.randomUUID()))
                        .cardStatus(CardStatus.ACTIVE)
                        .student(student)
                        .build();

        student.setLibraryCard(libraryCard);

        Student savedstudent = studentRepo.save(student);

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setName(savedstudent.getName());
        studentResponse.setEmail(savedstudent.getEmail());
        studentResponse.setMessage("You have been registered!!!!");

//        LibraryCardResponse cardResponse = new LibraryCardResponse();
//        cardResponse.setCardNo(savedstudent.getLibraryCard().getCardNo());
//        cardResponse.setIssueDate(savedstudent.getLibraryCard().getIssueDate());
//        cardResponse.setCardStatus(savedstudent.getLibraryCard().getCardStatus());

        LibraryCardResponse cardResponse = LibraryCardResponse.builder()
                        .cardNo(savedstudent.getLibraryCard().getCardNo())
                        .cardStatus(savedstudent.getLibraryCard().getCardStatus())
                        .issueDate(savedstudent.getLibraryCard().getIssueDate())
                        .build();
        studentResponse.setLibraryCardResponse(cardResponse);


        return studentResponse;

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
