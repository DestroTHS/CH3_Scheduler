package com.example.scheduler.controller;

import com.example.scheduler.dto.SchedulerRequestDto;
import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.entity.Scheduler;
import com.example.scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping("/schedulers")
    public ResponseEntity<SchedulerResponseDto> save(@RequestBody SchedulerRequestDto dto) {
        return ResponseEntity.ok(schedulerService.save(dto));
    }

    @GetMapping("/schedulers")
    public ResponseEntity<List<SchedulerResponseDto>> findAll(
            @RequestParam(required = false) String updatedDate,
            @RequestParam(required = false) String userName
    ) {
        return ResponseEntity.ok(schedulerService.findAll(updatedDate, userName));
    }

    @GetMapping("/schedulers/{id}")
    public ResponseEntity<SchedulerResponseDto> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(schedulerService.findById(id));
    }

    @PutMapping("/schedulers/{id}")
    public ResponseEntity<SchedulerResponseDto> update(
            @PathVariable Long id,
            @RequestBody SchedulerRequestDto dto
    ) {
        return ResponseEntity.ok(schedulerService.update(id, dto));
    }

    @DeleteMapping("/schedulers/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        schedulerService.findById(id);
    }
}
