package com.example.LibraryManagementSystem.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    String name;

    String email;

    String message;

    String cardIssueNo;



}
