package com.example.LibraryManagementSystem.dto.responsedto;

import com.example.LibraryManagementSystem.Enum.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {


    String title;

    int noOfPages;

    Genre genre;

    double cost;

    String authorName;
}
