package com.grupo27.libreria.repository;

import com.grupo27.libreria.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
