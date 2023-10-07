package com.example.LibraryManagementSystem.model;

import com.example.LibraryManagementSystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    int noOfPages;


    @Enumerated(EnumType.STRING)
    Genre genre;

    boolean issued;

    double cost;

    @ManyToOne
    @JoinColumn
    Author author;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();






}
