package com.example.LibraryManagementSystem.dto.responsedto;

import com.example.LibraryManagementSystem.Enum.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueBookResponse {

    String transactionNumber;

    // @CreationTimestamp
    String transactionTime;

    TransactionStatus transactionStatus;

    BookResponse bookResponseDto;

    StudentResponse studentResponse;

    LibraryCardResponse libraryCardResponse;

    String bookName;

    String authorName;

    String studentName;

    String libraryCardNumber;


}
