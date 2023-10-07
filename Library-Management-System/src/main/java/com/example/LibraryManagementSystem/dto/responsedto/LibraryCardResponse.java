package com.example.LibraryManagementSystem.dto.responsedto;

import com.example.LibraryManagementSystem.Enum.CardStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCardResponse {

    String cardNo;

    CardStatus cardStatus;

    String issueDate;

    LibraryCardResponse libraryCardResponse;
}
