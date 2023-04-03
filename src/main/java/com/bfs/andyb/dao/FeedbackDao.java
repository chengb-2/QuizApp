package com.bfs.andyb.dao;

import com.bfs.andyb.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class FeedbackDao {
    JdbcTemplate jdbcTemplate;
    FeedbackRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public FeedbackDao(JdbcTemplate jdbcTemplate, FeedbackRowMapper rowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Feedback> getAllFeedbacks(){
        String query = "SELECT * FROM feedback";
        List<Feedback> feedbacks =  jdbcTemplate.query(query, rowMapper);
        return feedbacks;
    }

    public int createNewFeedback(String message, Integer rating, Timestamp timestamp){
        String query = "INSERT INTO feedback (message, rating, date) values (?, ?, ?)";
        return jdbcTemplate.update(query, message, rating, timestamp);
    }
}
