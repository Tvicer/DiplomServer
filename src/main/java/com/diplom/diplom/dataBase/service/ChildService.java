package com.diplom.diplom.dataBase.service;

import com.diplom.diplom.dataBase.entity.Child;
import com.diplom.diplom.dataBase.repository.ChildRepository;
import com.diplom.diplom.nlp.dto.NlpClientToDbDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChildService {
    @Autowired
    ChildRepository childRepository;
    @Autowired

    public Iterable<Child> getAllChilds() {
        return childRepository.findAll();
    }

    public Optional<Child> getChildById(Integer id) {
        return childRepository.findById(id);
    }

    public void sendChild(NlpClientToDbDto request) {
        Child child = new Child();
        child.setFio(request.getFio());
        child.setChildAge(request.getChildAge());
        child.setParentAge(request.getParentAge());
        child.setTelephone(request.getTelephone());
        child.setAddress(request.getAddress());
        child.setResult(request.getResult());
        childRepository.save(child);
    }

}
