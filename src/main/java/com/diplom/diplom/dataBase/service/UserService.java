//package com.diplom.diplom.dataBase.service;
//
//import com.diplom.diplom.dataBase.entity.User;
//import com.diplom.diplom.dataBase.enums.Role;
//import com.diplom.diplom.dataBase.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    @Autowired
//    public final UserRepository userRepository;
//
//    public boolean createUser(User user) {
//        if (userRepository.findByEmail(user.getEmail()) != null)
//            return false;
//
//        user.setActive(true);
//        user.getRoles().add(Role.ROLE_USER);
//        return true;
//    }
//}
