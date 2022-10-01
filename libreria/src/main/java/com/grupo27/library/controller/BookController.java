package com.grupo27.library.controller;


import com.grupo27.library.model.Book;
import com.grupo27.library.service.IEntityService;
import com.grupo27.library.service.impl.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@ControllerAdvice
@RestController
@RequestMapping("/books")
@Data
public class BookController {

    private IEntityService<Book> bookService;
    private Logger LOGGER = Logger.getLogger(String.valueOf(BookController.class));;

    /* Methods */
    @Autowired
    public BookController(@Qualifier("bookService")IEntityService<Book> bookService) {
        this.bookService = bookService;
    }

    /* GET */

    @ApiOperation(value = "Search by Id in Books entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Book.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("id/{id}")
    public Optional<Book> findById(@PathVariable Long id) {
        LOGGER.info("Search by Id in Books entity");
        return bookService.findById(id);//.orElse(null);
    }

    @ApiOperation(value = "Search by title in Books entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Book.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("title/exact/{title}")
    public Optional<Book> findBookByTitle(@PathVariable String title) {
        LOGGER.info("Search by title Books entity");
        return ((BookService)bookService).findBookByTitle(title);
    }

    @ApiOperation(value = "List of all Books by title pattern"
    ,notes = "")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Book.class ),
        @ApiResponse(code = 400, message = "Bad Request", response = String.class),
        @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("title/{title}")
    public List<Book> searchBooksByTitleLike(@PathVariable String title) {
    LOGGER.info("List of all Books by title");
    return ((BookService)bookService).listBooksByTitle(title);
    }

    @ApiOperation(value = "List of all Books by category"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Book.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("category/{category}")
    public List<Book> listBooksByCategory(@PathVariable String category) {
        LOGGER.info("List of all Books by category");
        return ((BookService)bookService).listBooksByCategory(category);
    }

    @ApiOperation(value = "List of all Books by author"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Book.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("author/{author}")
    public List<Book> listBooksByAuthor(@PathVariable String author){
        LOGGER.info("List of all Books by author");
        return ((BookService)bookService).listBooksByAuthor(author);
    }


    @ApiOperation(value = "List of all Books"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Book.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping()
    public List<Book> findAll() {
        LOGGER.info("List of all Books");
        return bookService.findAll();
    }



    /* POST */

    @ApiOperation(value = "Insertion of a new registry in Books entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Book.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Book b) {
        ResponseEntity<Book> resp;
        if (((BookService)bookService).findBookByTitle(b.getTitle()).isPresent()) {
            resp = new ResponseEntity("The book is already registered!", HttpStatus.CONFLICT);
            LOGGER.info("The book is already registered!");
        } else {
            resp = new ResponseEntity<Book>(bookService.save(b), HttpStatus.CREATED);
            LOGGER.info("Book registered correctly");
        }
        return resp;
    }


    /* PUT */
    /*
    @ApiOperation(value = "Update by id of a record in Products entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Product.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product newP) throws BadRequestException {
        ResponseEntity<Product> resp = null;

        if(productService.findById(newP.getId()).isPresent()) {
            resp = new ResponseEntity(productService.update(newP), HttpStatus.OK);
            LOGGER.info("Product updated successfully");
        }else{
            resp = new ResponseEntity("Product not found!", HttpStatus.NOT_FOUND);
            LOGGER.error("Product not found!");
        }
        return resp;
    }
    */


    /* DELETE */
    /*
    @ApiOperation(value = "Deletion of a record in Products entity by id"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Product.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        ResponseEntity resp;

        if (productService.findById(id).isPresent()) {
            productService.delete(id);
            resp = new ResponseEntity(HttpStatus.NO_CONTENT);
            LOGGER.info("Product deleted successfully");
        } else {
            resp = new ResponseEntity("Product not found!", HttpStatus.NOT_FOUND);
            LOGGER.error("Product not found!");
        }
        return resp;
    }*/
}
