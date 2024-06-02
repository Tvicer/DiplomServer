package com.diplom.diplom.dataBase.service;

import com.diplom.diplom.dataBase.Dto.UserDto;
import com.diplom.diplom.dataBase.entity.User;
import com.diplom.diplom.dataBase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    @Autowired
    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LinkedList<UserDto> getPsychologist() {
        Iterable<User> users = userRepository.findByRole("ROLE_PSYCHOLOGIST");
        LinkedList<UserDto> userDtos = new LinkedList<>();
        for (User user : users) {
            UserDto userDto = UserDto.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .fio(user.getFio())
                    .role(user.getRole())
                    .build();
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public boolean createUser(User user) {
        String userEmail = user.getEmail();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        System.out.println(user.getRole());
        userRepository.save(user);
        return true;
    }

    public boolean createPsychologist(User user) {
        String userEmail = user.getEmail();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_PSYCHOLOGIST");
        System.out.println(user.getRole());
        userRepository.save(user);
        return true;
    }
}
