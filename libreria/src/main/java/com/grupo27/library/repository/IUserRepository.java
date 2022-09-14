package com.grupo27.library.repository;
import com.grupo27.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.name = ?1 AND u.lastName = ?2")
    Optional<User> findUserByName(String name, String lastName);

}
