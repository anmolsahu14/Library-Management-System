package com.example.LibraryManagementSystem.Transformer;

import com.example.LibraryManagementSystem.Enum.CardStatus;
import com.example.LibraryManagementSystem.model.LibraryCard;
import com.example.LibraryManagementSystem.model.Student;

import java.util.UUID;

public class LibraryCardTransformer {

    public static LibraryCard prepareLibraryCard(){

        return LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .build();

    }
}
