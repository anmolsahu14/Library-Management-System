package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.Enum.Genre;
import com.example.LibraryManagementSystem.Exceptions.AuthorNotFoundException;
import com.example.LibraryManagementSystem.dto.responsedto.BookResponseDto;
import com.example.LibraryManagementSystem.model.Author;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.repositary.AuthorRepository;
import com.example.LibraryManagementSystem.repositary.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String addBook(Book book) {
        Optional<Author> authoroptional = authorRepository.findById(book.getAuthor().getId());

        if (authoroptional.isEmpty()) {
            throw new AuthorNotFoundException("Invalid author id!!!");
        }
        Author author = authoroptional.get();
        book.setAuthor(author);
        author.getBooks().add(book);

        authorRepository.save(author);
        return "Book added successfully!!!!";

    }

    public List<BookResponseDto> getBookByGenreAndCostGreaterThan(String genre, double cost) {

        // List<Book> book = bookRepository.findAll();

        List<Book> books = bookRepository.getBookByGenreAndCostGreaterThan(genre, cost);

        //prepare the response,convert model to dto

        List<BookResponseDto> response = new ArrayList<>();
        for (Book book : books) {
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setTitle(book.getTitle());
            bookResponseDto.setCost(book.getCost());
            bookResponseDto.setGenre(book.getGenre());
            bookResponseDto.setNoOfPages(book.getNoOfPages());
            bookResponseDto.setAuthorName(book.getAuthor().getName());
            response.add(bookResponseDto);
        }

        return response;
    }

    public List<BookResponseDto> getBookByGenreAndCostGreaterThanhql(Genre genre, double cost) {

        List<Book> books = bookRepository.getBookByGenreAndCostGreaterThanhql(genre, cost);

        //prepare the response,convert model to dto

        List<BookResponseDto> response = new ArrayList<>();
        for (Book book : books) {
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setTitle(book.getTitle());
            bookResponseDto.setCost(book.getCost());
            bookResponseDto.setGenre(book.getGenre());
            bookResponseDto.setNoOfPages(book.getNoOfPages());
            bookResponseDto.setAuthorName(book.getAuthor().getName());
            response.add(bookResponseDto);
        }

        return response;


    }
}
