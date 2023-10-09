package com.example.LibraryManagementSystem.Transformer;

import com.example.LibraryManagementSystem.dto.requestdto.StudentRequest;
import com.example.LibraryManagementSystem.dto.responsedto.LibraryCardResponse;
import com.example.LibraryManagementSystem.dto.responsedto.StudentResponse;
import com.example.LibraryManagementSystem.model.LibraryCard;
import com.example.LibraryManagementSystem.model.Student;
import lombok.experimental.UtilityClass;


public class StudentTransformer {

    public static Student StudentRequestToStudent(StudentRequest studentRequest){
       // LibraryCard card = LibraryCardTransformer.prepareCardFromStudent(student);

        return  Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }

    public static StudentResponse StudentToStudentResponse(Student student){

        LibraryCardResponse cardResponse = LibraryCardResponse.builder()
                .cardNo(student.getLibraryCard().getCardNo())
                .cardStatus(student.getLibraryCard().getCardStatus())
                .issueDate(student.getLibraryCard().getIssueDate())
                .build();

        return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .libraryCardResponse(cardResponse)
                .build();
    }
}
