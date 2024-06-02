package com.diplom.diplom.dataBase.service;

import com.diplom.diplom.dataBase.Dto.ScheduleDto;
import com.diplom.diplom.dataBase.Dto.ScheduleToDbDto;
import com.diplom.diplom.dataBase.entity.Schedule;
import com.diplom.diplom.dataBase.entity.User;
import com.diplom.diplom.dataBase.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    UserService userService;

    public LinkedList<ScheduleDto> getScheduleByPsychologist() {
        Iterable<Schedule> schedules = scheduleRepository.findByPsychologistEmail(
                SecurityContextHolder.getContext().getAuthentication().getName());

        LinkedList<ScheduleDto> list = new LinkedList<>();

        for (Schedule schedule : schedules) {
            ScheduleDto scheduleDto = new ScheduleDto();

            scheduleDto.setId(schedule.getId());
            scheduleDto.setParentFio(schedule.getParentFio());
            scheduleDto.setParentEmail(schedule.getParentEmail());
            scheduleDto.setPsychologistEmail(schedule.getPsychologistEmail());
            scheduleDto.setDateTime(String.valueOf(schedule.getDateTime().getHour()) + ":" +
                    String.valueOf(schedule.getDateTime().getMinute()) + "   " +
                    String.valueOf(schedule.getDateTime().getDayOfMonth()) + "-" +
                    String.valueOf(schedule.getDateTime().getMonthValue()) + "-" +
                    String.valueOf(schedule.getDateTime().getYear()));

            if (schedule.getDateTime().isAfter(LocalDateTime.now()))
                list.add(scheduleDto);
        }
        return list;
    }

    public void sendSchedule(ScheduleToDbDto request) {
        Schedule schedule = new Schedule();
        User user = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        schedule.setParentFio(user.getFio());
        schedule.setParentEmail(user.getEmail());
        schedule.setPsychologistEmail(request.getPsychologistEmail());
        schedule.setDateTime(LocalDateTime.of(request.getYear(), request.getMonth(), request.getDay(), request.getHour(), request.getMinute()));
        scheduleRepository.save(schedule);
    }

}
