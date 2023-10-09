package com.example.LibraryManagementSystem.Transformer;

import com.example.LibraryManagementSystem.dto.requestdto.StudentRequest;
import com.example.LibraryManagementSystem.dto.responsedto.StudentResponse;
import com.example.LibraryManagementSystem.model.Student;

public class StudentTransformer {

    public static Student StudentRequestToStudent(StudentRequest studentRequest){

        return  Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }

    public static StudentResponse StudentToStudentResponse(Student student){

    }
}
