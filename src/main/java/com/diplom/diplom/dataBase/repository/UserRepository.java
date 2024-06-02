package com.diplom.diplom.dataBase.repository;

import com.diplom.diplom.dataBase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Iterable<User> findByRole(String role);
    User getUserByEmail(String email);
}
