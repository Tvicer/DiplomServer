package com.diplom.diplom.dataBase.service;

import com.diplom.diplom.dataBase.entity.User;
import com.diplom.diplom.dataBase.enums.Role;
import com.diplom.diplom.dataBase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    @Autowired
    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String userEmail = user.getEmail();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        System.out.println(user.getRole());
        userRepository.save(user);
        return true;
    }
}
