package com.diplom.diplom.dataBase.repository;

import com.diplom.diplom.dataBase.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Iterable<Schedule> findByPsychologistEmail(String psychologist);
}
