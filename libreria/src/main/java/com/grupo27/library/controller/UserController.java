package com.grupo27.library.controller;

import com.grupo27.library.exception.BadRequestException;
import com.grupo27.library.model.Book;
import com.grupo27.library.model.User;
import com.grupo27.library.service.BookService;
import com.grupo27.library.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin
@ControllerAdvice
@RestController
@RequestMapping("/users")
@Data
public class UserController {

    /* Attributes */
    @Autowired
    private UserService userService;
    private final Logger LOGGER = Logger.getLogger(String.valueOf(UserController.class));


    /* Methods */
    /* GET */

    @ApiOperation(value = "Search by Id in Users entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = User.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("id/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        LOGGER.info("Search by Id in Users entity");
        return userService.findById(id);//.orElse(null);
    }

    @ApiOperation(value = "Search by name in Users entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = User.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping("name")
    public Optional<User> findUserByName(@RequestParam(required = true) String name, @RequestParam(required = true) String lastName) {
        LOGGER.info("Search by Id in Users entity");
        return userService.findUserByNamer(name, lastName);//.orElse(null);
    }

    @ApiOperation(value = "List of all Users"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = User.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    @GetMapping()
    public List<User> findAll() {
        LOGGER.info("List of all Users");
        return userService.findAll();
    }


    /* POST */

    @ApiOperation(value = "Insertion of a new registry in Users entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = User.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User u) {
        ResponseEntity<User> resp;
        if (userService.findById(u.getId()).isPresent()) {
            resp = new ResponseEntity("The user is already registered!", HttpStatus.CONFLICT);
            LOGGER.info("The user is already registered!");
        } else {
            resp = new ResponseEntity<User>(userService.save(u), HttpStatus.CREATED);
            LOGGER.info("User registered correctly");
        }
        return resp;
    }


    /* PUT */
    @ApiOperation(value = "Update by id of a record in Users entity"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = User.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<User> updateProduct(@RequestBody User newU) throws BadRequestException {
        ResponseEntity<User> resp = null;

        if(userService.findById(newU.getId()).isPresent()) {
            resp = new ResponseEntity(userService.update(newU), HttpStatus.OK);
            LOGGER.info("User updated successfully");
        }else{
            resp = new ResponseEntity("User not found!", HttpStatus.NOT_FOUND);
            LOGGER.info("User not found!");
        }
        return resp;
    }


    /* DELETE */
    @ApiOperation(value = "Deletion of a record in Users entity by id"
            ,notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. The resource is obtained correctly", response = User.class ),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Unexpected error") })
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        ResponseEntity resp;

        if (userService.findById(id).isPresent()) {
            userService.delete(id);
            resp = new ResponseEntity(HttpStatus.NO_CONTENT);
            LOGGER.info("User deleted successfully");
        } else {
            resp = new ResponseEntity("User not found!", HttpStatus.NOT_FOUND);
            LOGGER.info("User not found!");
        }
        return resp;
    }
}


