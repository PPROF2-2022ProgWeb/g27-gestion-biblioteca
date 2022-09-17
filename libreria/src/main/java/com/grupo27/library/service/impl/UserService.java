package com.grupo27.library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo27.library.model.User;
import com.grupo27.library.repository.IUserRepository;
import com.grupo27.library.service.IEntityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Data
@Service("userService")
public class UserService implements IEntityService<User> {
    @Autowired
    private IUserRepository userRepository;
    private final Logger LOGGER = Logger.getLogger((String.valueOf(UserService.class)));

    @Autowired
    private ObjectMapper mapper;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User save(User user)  {
        userRepository.save(mapper.convertValue(user, User.class));
        LOGGER.info("New user registered successfully");
        return user;
    }


    public Optional<User> findById(Long id) {
        LOGGER.info("Search by id in Users entity");
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent()) {
            LOGGER.info("User founded");
        } else {
            LOGGER.info("The id does not match with any existing user");
        }
        return u;
    }

    public Optional<User> findUserByName(String name, String lastName){
        LOGGER.info("Search by name in Users entity");
        return userRepository.findUserByName(name, lastName);
    }

    public Optional<User> findUserByEmail(String email){
        LOGGER.info("Search by email in Users entity");
        return userRepository.findUserByEmail(email);
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        LOGGER.info("List of all users");
        return users;
    }

    public User update(User newUser) {
        User user = userRepository.findById(newUser.getId()).get();
        user.setName(newUser.getName());
        user.setLastName(newUser.getLastName());
        user.setAddress(newUser.getAddress());
        user.setPhone(newUser.getPhone());
        user.setSanctions(newUser.getSanctions());
        user.setSanctionsAmount(newUser.getSanctionsAmount());

        LOGGER.info("User with ID: "+ user.getId() + " has been updated");
        userRepository.save(user);
        return user;
    }


    public void delete(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            LOGGER.info("User deleted correctly!");
        } else {
            LOGGER.info("User was not found!");
        }
    }




}
