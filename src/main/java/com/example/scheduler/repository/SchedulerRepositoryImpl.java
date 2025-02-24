package com.example.scheduler.repository;

import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.entity.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class SchedulerRepositoryImpl implements SchedulerRepository {

    private final JdbcTemplate jdbcTemplate;

    public SchedulerRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Create
    @Override
    public SchedulerResponseDto save(Scheduler scheduler) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("scheduler").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("todo", scheduler.getTodo());
        parameters.put("userName", scheduler.getUserName());
        parameters.put("password", scheduler.getPassword());
        parameters.put("createdAt", scheduler.getCreatedAt());
        parameters.put("updatedAt", scheduler.getUpdatedAt());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new SchedulerResponseDto(key.longValue(), scheduler.getTodo(), scheduler.getUserName(), scheduler.getCreatedAt(), scheduler.getUpdatedAt());
    }

    // Read select
    @Override
    public Optional<Scheduler> findById(Long id) {
        return Optional.empty();
    }

    // Read all
    @Override
    public List<Scheduler> findAll(String updatedDate, String userName) {
        return null;
    }

    // Update
    @Override
    public Scheduler update(Scheduler scheduler) {
        return null;
    }

    // Delete
    @Override
    public void delete(Long id) {

    }
}
