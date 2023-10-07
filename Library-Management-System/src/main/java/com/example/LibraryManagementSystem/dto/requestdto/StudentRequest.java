package com.example.LibraryManagementSystem.dto.requestdto;

import com.example.LibraryManagementSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    String name;

    int age;

    String email;

    Gender gender;
}
