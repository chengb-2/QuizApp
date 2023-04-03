package com.bfs.andyb.dao;

import com.bfs.andyb.domain.Quiz;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuizRowMapper implements RowMapper<Quiz> {
    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setId(rs.getInt("id"));
        quiz.setQuizname(rs.getString("quizname"));
        quiz.setCategory(rs.getString("category"));
        quiz.setUsername(rs.getString("username"));
        quiz.setTime_start(rs.getTimestamp("time_start"));
        quiz.setTime_end(rs.getTimestamp("time_end"));
        quiz.setScore(rs.getInt("score"));

        return quiz;
    }
}
