package com.bfs.andyb.dao;

import com.bfs.andyb.domain.Choice;
import com.bfs.andyb.domain.Question;
import com.bfs.andyb.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionDao {
    JdbcTemplate jdbcTemplate;
    QuestionRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate, QuestionRowMapper rowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Question> getAllQuestions(){
        String query = "SELECT * FROM question";
        List<Question> questions =  jdbcTemplate.query(query, rowMapper);
        return questions;
    }

    public Question getQuestionById(int id){
        String query = "SELECT * FROM question WHERE id = ?";
        List<Question> questions =  jdbcTemplate.query(query, rowMapper, id);
        return questions.get(0);
    }

    public List<Question> getRandQuestions(String category, int size){
        String query = "select * from question where category = ? AND is_active = ? order by rand() limit 0,?";
//        System.out.println("QuestionDao - getRandQuestions");
        List<Question> questions =  jdbcTemplate.query(query, rowMapper, category, true, size);
//        System.out.println(questions);
        return questions;
    }

    public int setIs_activeById(Integer id, Integer action){
        String query = "UPDATE question SET is_active = ? WHERE id = ?";
        return jdbcTemplate.update(query, action, id);
    }

    public int updateQuestion(Integer id, String category, String statement) {
        String query = "UPDATE question SET category = ?, statement = ? WHERE id = ?";
        return jdbcTemplate.update(query, category, statement, id);
    }

    public int createQuestion(String category, String statement){
        String query = "INSERT INTO question (category, statement, is_active) values (?, ?, ?)";
        jdbcTemplate.update(query, category, statement, true);
        String getLastInsertedId = "SELECT max(question.id) from question";

        Integer lastInsertedId = jdbcTemplate.queryForObject(getLastInsertedId, Integer.class);
        System.out.println("lastInsertedId");
        System.out.println(lastInsertedId);


        return lastInsertedId;
    }

//    public int selectLastInsertedId() {
//        String query = "SELECT LAST_INSERT_ID();";
//        return jdbcTemplate.
//    }

}
