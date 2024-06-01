package com.diplom.diplom.dataBase.service;

import com.diplom.diplom.dataBase.entity.Child;
import com.diplom.diplom.dataBase.repository.ChildRepository;
import com.diplom.diplom.nlp.dto.NlpClientToDbDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public Iterable<Child> getChildsByPsychologist() {
        return childRepository.getByPsychologist(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public void sendChild(NlpClientToDbDto request) {
        Child child = new Child();
        child.setFio(request.getFio());
        child.setChildAge(request.getChildAge());
        child.setParentAge(request.getParentAge());
        child.setTelephone(request.getTelephone());
        child.setAddress(request.getAddress());
        child.setResult(request.getResult());
        child.setPsychologist(SecurityContextHolder.getContext().getAuthentication().getName());
        childRepository.save(child);
    }

    public void handleChilds() {
        Iterable<Child> childs = childRepository.findByPsychologistOrderByResult(SecurityContextHolder.getContext().getAuthentication().getName());
        int i = 0;
        Child lastChild = null;
        for(Child child : childs) {
            if(i != 0 && Math.abs(lastChild.getResult() - child.getResult()) > 30)
                lastChild.setBadGroup(true);
            child.setGroupNumber(i / 2); // отмаркировать, если сильный разрыв
            lastChild.setBadGroup(false);
            lastChild = child;
            i++;
        }
        childRepository.saveAll(childs);
    }

}
