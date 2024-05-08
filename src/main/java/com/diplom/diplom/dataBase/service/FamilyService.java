package com.diplom.diplom.dataBase.service;

import com.diplom.diplom.dataBase.entity.Child;
import com.diplom.diplom.dataBase.repository.ChildRepository;
import com.diplom.diplom.dataBase.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class FamilyService {
    @Autowired
    ChildRepository childRepository;
    @Autowired
    ParentRepository parentRepository;

    public Iterable<Child> getAllChilds() {
        return childRepository.findAll();
    }

    public Optional<Child> getAllChilds(Integer id) {
        return childRepository.findById(id);
    }

}
