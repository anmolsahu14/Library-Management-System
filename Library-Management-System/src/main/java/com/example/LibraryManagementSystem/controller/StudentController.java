package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.requestdto.StudentRequest;
import com.example.LibraryManagementSystem.dto.responsedto.StudentResponse;
import com.example.LibraryManagementSystem.model.Student;
import com.example.LibraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

   @Autowired
   StudentService studentService;
   @PostMapping("/add")
   public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
       StudentResponse response = studentService.addStudent(studentRequest);
       return new ResponseEntity(response, HttpStatus.CREATED);
   }

   @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
       StudentResponse student = studentService.getStudent(regNo);
       if(student != null){
           return new ResponseEntity(student,HttpStatus.FOUND);
       }
       return new ResponseEntity("Invalid ID!!",HttpStatus.BAD_REQUEST);
   }

   @GetMapping("/get-males")
    public List<String> getAllMales(){
       List<String>males = studentService.getAllMales();
       return males;

   }


}
