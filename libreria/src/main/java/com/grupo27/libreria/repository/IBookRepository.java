package com.grupo27.libreria.repository;

import com.grupo27.libreria.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Optional<Book> findBookByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.category = ?1")
    List<Book> listBooksByCategory(String category);

    @Query("SELECT b FROM Book b WHERE b.author = ?1")
    List<Book> listBooksByAuthor(String author);
}
