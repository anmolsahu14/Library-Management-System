package com.example.LibraryManagementSystem.Transformer;

import com.example.LibraryManagementSystem.dto.responsedto.BookResponse;
import com.example.LibraryManagementSystem.model.Book;

public class BookTransformer {

    public static BookResponse BookToBookResponse(Book book){

        return BookResponse.builder()
                .authorName(book.getAuthor().getName())
                .cost(book.getCost())
                .genre(book.getGenre())
                .noOfPages(book.getNoOfPages())
                .title(book.getTitle())
                .build();
    }
}
