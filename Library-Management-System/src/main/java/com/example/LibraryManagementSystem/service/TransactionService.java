package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.Enum.StudentNotFoundException;
import com.example.LibraryManagementSystem.Enum.TransactionStatus;
import com.example.LibraryManagementSystem.Exceptions.BookNotAvailableException;
import com.example.LibraryManagementSystem.dto.responsedto.IssueBookResponse;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.Student;
import com.example.LibraryManagementSystem.model.Transaction;
import com.example.LibraryManagementSystem.repositary.BookRepository;
import com.example.LibraryManagementSystem.repositary.StudentRepo;
import com.example.LibraryManagementSystem.repositary.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepo transactionRepo;


    public IssueBookResponse issueBook(int bookId,int studentId) {

        Optional<Student> studentOptional = studentRepo.findById(studentId);

        if(studentOptional.isEmpty()){
            throw new StudentNotFoundException("Invalid Student Id!!!!!");
        }

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){

            throw new BookNotAvailableException(("Invalid book Id!!!!"));
        }

        Book book = optionalBook.get();
        if(book.isIssued()){
            throw new BookNotAvailableException(("Book already issued!!!"));
        }
        Student student = studentOptional.get();

        Transaction transaction = Transaction.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .transactionStatus(TransactionStatus.SUCCESS)
                .book(book)
                .libraryCard(student.getLibraryCard())
                .build();

        Transaction savedTransaction = transactionRepo.save(transaction);

        book.setIssued(true);
        book.getTransactions().add(savedTransaction );


        student.getLibraryCard().getTransactions().add(savedTransaction );


       Book savedBook = bookRepository.save(book);
       Student savedStudent = studentRepo.save(student);


       return IssueBookResponse.builder()
               .bookName(savedBook.getTitle())
               .transactionStatus(savedTransaction.getTransactionStatus())
               .transactionTime(savedTransaction.getTransactionTime())
               .transactionNumber(savedTransaction.getTransactionNumber())
               .studentName(savedStudent.getName())
               .libraryCardNumber(savedStudent.getLibraryCard().getCardNo())
               .authorName(savedBook.getAuthor().getName())
               .build();


    }
}
