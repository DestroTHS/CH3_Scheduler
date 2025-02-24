package com.example.scheduler.service;

import com.example.scheduler.dto.SchedulerRequestDto;
import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.entity.Scheduler;
import com.example.scheduler.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    @Transactional
    public SchedulerResponseDto save(SchedulerRequestDto dto) {
        Scheduler scheduler = new Scheduler(
                dto.getTodo(),
                dto.getUserName(),
                dto.getPassword()
        );
        SchedulerResponseDto savedScheduler = schedulerRepository.save(scheduler);

        return new SchedulerResponseDto(
                savedScheduler.getId(),
                savedScheduler.getTodo(),
                savedScheduler.getUserName(),
                savedScheduler.getCreatedAt(),
                savedScheduler.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public SchedulerResponseDto findById(Long id) {
        Scheduler scheduler = schedulerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Schedule 없음"));

        return new SchedulerResponseDto(
                scheduler.getId(),
                scheduler.getTodo(),
                scheduler.getUserName(),
                scheduler.getCreatedAt(),
                scheduler.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<SchedulerResponseDto> findAll(String updatedDate, String userName) {
        List<Scheduler> schedulers = schedulerRepository.findAll(updatedDate, userName);

        List<SchedulerResponseDto> dtos = new ArrayList<>();
        for (Scheduler scheduler : schedulers) {
            SchedulerResponseDto dto = new SchedulerResponseDto(
                    scheduler.getId(),
                    scheduler.getTodo(),
                    scheduler.getUserName(),
                    scheduler.getCreatedAt(),
                    scheduler.getUpdatedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public SchedulerResponseDto update(Long id, SchedulerRequestDto dto) {
        Scheduler scheduler = schedulerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Schedule 없음"));

        scheduler.update(
                dto.getTodo(),
                dto.getUserName(),
                dto.getPassword()
        );

        Scheduler updatedScheduler = schedulerRepository.update(scheduler);
        return new SchedulerResponseDto(
                updatedScheduler.getId(),
                updatedScheduler.getTodo(),
                updatedScheduler.getUserName(),
                updatedScheduler.getCreatedAt(),
                updatedScheduler.getUpdatedAt()
        );
    }

    @Transactional
    public void deleteById(Long id) {
        Scheduler scheduler = schedulerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Schedule 없음"));

        schedulerRepository.delete(scheduler.getId());
    }
}
