package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.Enum.Genre;
import com.example.LibraryManagementSystem.Exceptions.AuthorNotFoundException;
import com.example.LibraryManagementSystem.dto.responsedto.BookResponseDto;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){

        try{
            String response = bookService.addBook(book);
            return response;
        }
        catch(Exception e){
            return e.getMessage();
        }
    }


    @GetMapping("/get-by-genre-cost")
    public List<BookResponseDto> getBookByGenreAndCostGreaterThan(@RequestParam("genre") String genre,
                                                                  @RequestParam("cost") double cost){
        return bookService.getBookByGenreAndCostGreaterThan(genre,cost);
    }

    @GetMapping("/get-by-genre-cost-hql")
    public List<BookResponseDto> getBookByGenreAndCostGreaterThanhql(@RequestParam("genre") Genre genre,
                                                                  @RequestParam("cost") double cost){
        return bookService.getBookByGenreAndCostGreaterThanhql(genre,cost);
    }

}
