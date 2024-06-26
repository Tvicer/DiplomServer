package com.diplom.diplom.dataBase.repository;

import com.diplom.diplom.dataBase.entity.Child;
import org.springframework.data.repository.CrudRepository;

public interface ChildRepository extends CrudRepository<Child, Integer> {

    Iterable<Child> findByPsychologistOrderByGroupNumber(String psychologist);

    Iterable<Child> findByPsychologistOrderByResult(String psychologist);
}
