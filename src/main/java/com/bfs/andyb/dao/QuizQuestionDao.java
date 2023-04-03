package com.bfs.andyb.dao;


import com.bfs.andyb.domain.Question;
import com.bfs.andyb.domain.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class QuizQuestionDao {

    JdbcTemplate jdbcTemplate;
    QuizQuestionRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public QuizQuestionDao(JdbcTemplate jdbcTemplate, QuizQuestionRowMapper rowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<QuizQuestion> getAllQuizQuestions(){
        String query = "SELECT * FROM quiz_question";
        List<QuizQuestion> quizQuestions = jdbcTemplate.query(query, rowMapper);
        return quizQuestions;
    }

    public int createQuizQuestion(Integer quiz_id, Integer question_id, Integer user_choice_id){
        String query = "INSERT INTO quiz_question (quiz_id, question_id, user_choice_id) values (?, ?, ?)";
        return jdbcTemplate.update(query, quiz_id, question_id, user_choice_id);
    }

    public List<QuizQuestion> getQuestionsByQuizId(Integer quiz_id){
        String query = "SELECT * FROM quiz_question WHERE quiz_id = ?";
        return jdbcTemplate.query(query, rowMapper, quiz_id);
    }

    public int setUserChoiceId(Integer quiz_id, Integer question_id, Integer user_choice_id){
        // 1. set user choice id into quiz_question table according to question_id and quiz_id
        String query = "UPDATE quiz_question SET user_choice_id = ? WHERE quiz_id = ? AND question_id = ?";

        return jdbcTemplate.update(query, user_choice_id, quiz_id, question_id);
    }

//    public int getQuizIdByQuestionId(int question_id) {
//        String query = "SELECT * FROM quiz_question WHERE question_id = ?";
//        List<QuizQuestion> quizQuestions = jdbcTemplate.query(query, rowMapper);
//        return quizQuestions.get(0);
//    }
}
