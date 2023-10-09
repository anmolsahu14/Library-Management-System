package com.example.LibraryManagementSystem.dto.responsedto;

import com.example.LibraryManagementSystem.model.LibraryCard;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {

    String name;

    String email;

    String message;

    LibraryCardResponse libraryCardResponse;

}
