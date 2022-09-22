package com.grupo27.library.repository;

import com.grupo27.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Optional<Book> findBookByTitle(String title);
    
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> listBooksByTitle(@Param("title") String title);
    
    @Query("SELECT b FROM Book b WHERE b.category LIKE %:category%")
    List<Book> listBooksByCategory(@Param("category") String category);

    @Query("SELECT b FROM Book b WHERE b.author LIKE %:author%")
    List<Book> listBooksByAuthor(@Param("author") String author);
}
