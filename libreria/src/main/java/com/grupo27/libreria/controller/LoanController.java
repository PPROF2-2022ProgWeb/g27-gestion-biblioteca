package com.grupo27.libreria.controller;


import com.grupo27.libreria.model.Book;
import com.grupo27.libreria.model.Loan;
import com.grupo27.libreria.service.BookService;
import com.grupo27.libreria.service.LoanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin
@ControllerAdvice
@RestController
@RequestMapping("/loans")
@Data
public class LoanController {


    /* Attributes */
    @Autowired
    private LoanService loanService;
    private final Logger LOGGER = Logger.getLogger(String.valueOf(LoanController.class));


    /* Methods */
    /* GET */

    @ApiOperation(value = "Search by Id in Loans entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Loan.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("id/{id}")
    public Optional<Loan> findById(@PathVariable Long id) {
        LOGGER.info("Search by Id in Loans entity");
        return loanService.findById(id);//.orElse(null);
    }


    @ApiOperation(value = "List of all Loans by book"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Loan.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("book/{title}")
    public List<Loan> listLoansByBook(@PathVariable String title) {
        LOGGER.info("List of all Loans by book");
        return loanService.listLoansByBook(title);
    }

    @ApiOperation(value = "List of all Loans by user"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Loan.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("user")
    public List<Loan> listLoansByUser(@RequestParam(required = true) String name, @RequestParam(required = true) String lastName){
        LOGGER.info("List of all Loans by user");
        return loanService.listLoansByUser(name, lastName);
    }


    @ApiOperation(value = "List of all Loans"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Loan.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping()
    public List<Loan> findAll() {
        LOGGER.info("List of all Loans");
        return loanService.findAll();
    }

    @ApiOperation(value = "List of all Loans by date range"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Loan.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("date")
    public List<Loan> listLoansByDate(@RequestParam(required = false) String dateOut, @RequestParam(required = false) String dateReturn){
        LOGGER.info("List of all Loans by date");
        return loanService.listLoansByDate(dateOut, dateReturn);
    }

    @ApiOperation(value = "List of available loans filtered by user and dates"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Loan.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("....")
    public List<Loan> listLoansByUserAndDate(@RequestParam(required = false) String name, @RequestParam(required = false) String lastName, @RequestParam(required = false) String dateOut, @RequestParam(required = false) String dateReturn) {

        List<Loan> filteredLoans = new ArrayList<>();

        if (dateOut != null && dateReturn != null && name != null && lastName != null) {
            List<Loan> filteredByDate =  loanService.listLoansByDate(dateOut, dateReturn);
            for (Loan l : filteredByDate) {
                if (l.getUser().getName().equalsIgnoreCase(name) && l.getUser().getLastName().equalsIgnoreCase(lastName)) {
                    filteredLoans.add(l);
                }
            }
        }

        if (dateOut != null && dateReturn != null && name == null && lastName == null) {
            filteredLoans = loanService.listLoansByDate(dateOut, dateReturn);
        }

        if (dateOut == null && dateReturn == null && name != null && lastName != null) {
            filteredLoans = loanService.listLoansByUser(name, lastName);
        }

        return filteredLoans;
    }


    /* POST */
    /*
    @ApiOperation(value = "Insertion of a new registry in Products entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = Product.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product p) {
        ResponseEntity<Product> resp;
        if (productService.findProductByName(p.getName()).isPresent()) {
            resp = new ResponseEntity("The product is already registered!", HttpStatus.CONFLICT);
            LOGGER.info("The product is already registered!");
        } else {
            resp = new ResponseEntity<Product>(productService.save(p), HttpStatus.CREATED);
            LOGGER.info("Product registered correctly");
        }
        return resp;
    }
    */

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
            LOGGER.info("Product not found!");
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
            LOGGER.info("Product not found!");
        }
        return resp;
    }*/
}
