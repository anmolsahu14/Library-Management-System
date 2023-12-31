package com.example.LibraryManagementSystem.repositary;

import com.example.LibraryManagementSystem.Enum.Genre;
import com.example.LibraryManagementSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from book where genre = :genre and cost > :cost", nativeQuery = true)
    List<Book> getBookByGenreAndCostGreaterThan(String genre, double cost);

    @Query(value = "select b from Book b where b.genre = :genre and b.cost > :cost")
    List<Book> getBookByGenreAndCostGreaterThanhql(Genre genre, double cost);



}
