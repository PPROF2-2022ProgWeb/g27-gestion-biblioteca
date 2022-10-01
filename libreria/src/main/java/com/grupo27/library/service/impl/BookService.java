package com.grupo27.library.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo27.library.model.Book;
import com.grupo27.library.repository.IBookRepository;
import com.grupo27.library.service.IEntityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Data
@Service("bookService")
public class BookService implements IEntityService<Book> {
    @Autowired
    private IBookRepository bookRepository;
    private final Logger LOGGER = Logger.getLogger((String.valueOf(BookService.class)));
    @Autowired
    private ObjectMapper mapper;


    public Optional<Book> findById(Long id) {
        LOGGER.info("Search by id in Books entity");
        Optional<Book> b = bookRepository.findById(id);
        if(b.isPresent()) {
            LOGGER.info("Book founded");
        } else {
            LOGGER.info("The id does not match with any existing book");
        }
        return b;
    }

    public Book save(Book book)  {
        bookRepository.save(mapper.convertValue(book, Book.class));
        LOGGER.info("Book saved successfully");
        return book;
    }


    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        LOGGER.info("List of all available books");
        return books;
    }


    public Book update(Book newBook) {
        Book book = bookRepository.findById(newBook.getId()).get();
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setCategory(newBook.getCategory());
        book.setDescription(newBook.getDescription());
        book.setAvailable(newBook.getAvailable());
        book.setDate(newBook.getDate());
        book.setEdit(newBook.getEdit());
        book.setLang(newBook.getLang());
        book.setPages(newBook.getPages());
        //book.setLoans(newBook.getLoans());
        book.setLang(newBook.getLang());

        LOGGER.info("Book with ID: "+ book.getId() + " has been updated");
        bookRepository.save(book);
        return book;
    }


    public void delete(Long id) {
        if(bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
            LOGGER.info("Book deleted correctly!");
        } else {
            LOGGER.info("Book was not found!");
        }
    }


    public Optional<Book> findBookByTitle(String title) {
        LOGGER.info("Search by title in Book entity");
        Optional<Book> book = bookRepository.findBookByTitle(title);
        if(book.isEmpty()) {
            LOGGER.info("Book not found");
        }
        return book;
    }

    public List<Book> listBooksByTitle(String title){
        LOGGER.info("List of all books by title");
        return bookRepository.listBooksByTitle(title);
    }

    public List<Book> listBooksByCategory(String category){
        LOGGER.info("List of all books by category");
        return bookRepository.listBooksByCategory(category);
    }

    public List<Book> listBooksByAuthor(String author){
        LOGGER.info("List of all books by author");
        return bookRepository.listBooksByAuthor(author);
    }
}
