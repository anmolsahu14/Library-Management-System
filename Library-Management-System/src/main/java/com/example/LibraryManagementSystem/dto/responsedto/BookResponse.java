package com.example.LibraryManagementSystem.dto.responsedto;

import com.example.LibraryManagementSystem.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {


    String title;

    int noOfPages;

    Genre genre;

    double cost;

    String authorName;
}
