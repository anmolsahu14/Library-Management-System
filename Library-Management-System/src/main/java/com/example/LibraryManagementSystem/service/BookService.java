package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.Exceptions.AuthorNotFoundException;
import com.example.LibraryManagementSystem.model.Author;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.repositary.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book) {
        Optional<Author> authoroptional = authorRepository.findById(book.getAuthor().getId());

        if(authoroptional.isEmpty()){
            throw new AuthorNotFoundException("Invalid author id!!!");
        }
        Author author = authoroptional.get();
        book.setAuthor(author);
        author.getBooks().add(book);

        authorRepository.save(author);
        return "Book added successfully!!!!";

    }
}
