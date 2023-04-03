package com.bfs.andyb.dao;


import com.bfs.andyb.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class QuizDao {

    JdbcTemplate jdbcTemplate;
    QuizRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuizDao(JdbcTemplate jdbcTemplate, QuizRowMapper rowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Quiz> getFilteredQuizzes(String category, String username){
        String query = "SELECT * FROM quiz WHERE category LIKE ? AND username LIKE ?";
        List<Quiz> quizzes = jdbcTemplate.query(query, rowMapper, category, username);
        return quizzes;
    }

    public int saveQuiz(String quizname, String category, String username, Timestamp time_start, Timestamp time_end, Integer score){
        String query = "INSERT INTO quiz (quizname, category, username, time_start, time_end, score) values (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, quizname, category, username, time_start, time_end, score);
    }

    public List<Quiz> getQuizzesByUsername(String username){
        String query = "SELECT * FROM quiz WHERE username = ?";
        List<Quiz> quizzes =  jdbcTemplate.query(query, rowMapper, username);
        return quizzes;
    }

    public List<Quiz> getQuizzesByCategory(String category){
        String query = "SELECT * FROM quiz WHERE category = ?";
        List<Quiz> quizzes =  jdbcTemplate.query(query, rowMapper, category);
        return quizzes;
    }


    public Integer getQuizIdByQuizname(String quizname){
        String query = "SELECT * FROM quiz WHERE quizname = ?";
        List<Quiz> quizzes =  jdbcTemplate.query(query, rowMapper, quizname);
        return quizzes.get(0).getId();
    }

    public Quiz getQuizById(Integer id){
        String query = "SELECT * FROM quiz WHERE id = ?";
        List<Quiz> quizzes =  jdbcTemplate.query(query, rowMapper, id);
        return quizzes.get(0);
    }

    public int setScoreById(Integer score, Integer id){
        String query = "UPDATE quiz SET score = ? WHERE id = ?";
        return jdbcTemplate.update(query, score, id);
    }

    public Integer getScoreById(Integer id){
        String query = "SELECT * FROM quiz WHERE id = ?";
        List<Quiz> quizzes =  jdbcTemplate.query(query, rowMapper, id);
        return quizzes.get(0).getScore();
    }

    public int setTimeEndByQuizId(Timestamp time_end, Integer quiz_id){
        String query = "UPDATE quiz SET time_end = ? WHERE id = ?";
        return jdbcTemplate.update(query, time_end, quiz_id);
    }

}
