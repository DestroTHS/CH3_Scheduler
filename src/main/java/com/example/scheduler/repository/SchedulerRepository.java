package com.example.scheduler.repository;

import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.entity.Scheduler;

import java.util.List;
import java.util.Optional;

public interface SchedulerRepository {

    SchedulerResponseDto save(Scheduler scheduler); //Create
    Optional<Scheduler> findById(Long id); //Read 단건
    List<Scheduler> findAll(String updatedDate, String userName); //Read 전체
    Scheduler update(Scheduler scheduler); //Update
    void delete(Long id); //Delete
}
