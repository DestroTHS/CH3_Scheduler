package com.example.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Scheduler {

    private Long id;
    private String todo;
    private String userName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Scheduler(String todo, String userName, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.todo = todo;
        this.userName = userName;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Scheduler(String todo, String userName, String password) {
        this.todo = todo;
        this.userName = userName;
        this.password = password;
    }

    public void update(String todo, String userName, String password) {
        this.todo = todo;
        this.userName = userName;
        this.password = password;
    }
}
