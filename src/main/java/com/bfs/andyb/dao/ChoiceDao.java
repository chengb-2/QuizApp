package com.bfs.andyb.dao;

import com.bfs.andyb.domain.Choice;
import com.bfs.andyb.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChoiceDao {
    JdbcTemplate jdbcTemplate;
    ChoiceRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ChoiceDao(JdbcTemplate jdbcTemplate, ChoiceRowMapper rowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Choice> getChoicesByQuestionId(int id){
        String query = "SELECT * FROM choice WHERE question_id = ?";
//        System.out.println("ChoiceDao: getChoicesByQuestionId");
        List<Choice> choices =  jdbcTemplate.query(query, rowMapper, id);
//        System.out.println("question id: " + id + ", \nchoices: " + choices);
        return choices;
    }


    public Choice getChoiceById(Integer id) {
        String query = "SELECT * FROM choice WHERE id = ?";
        List<Choice> choices =  jdbcTemplate.query(query, rowMapper, id);
        return choices.get(0);
    }

    public Choice getChoiceByQuizQuestionId(Integer id) {
        String query = "SELECT * FROM choice WHERE id = ?";
        List<Choice> choices =  jdbcTemplate.query(query, rowMapper, id);
        return choices.get(0);
    }

    public int updateChoice(Integer id, String statement) {
        String query = "UPDATE choice SET statement = ?, is_correct = 0 WHERE id = ?";
        return jdbcTemplate.update(query, statement, id);
    }

    public int setCorrectById(Integer id) {
        String query = "UPDATE choice SET is_correct = 1 WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

    public int createChoice(Integer question_id, String statement, Boolean is_correct){
        String query = "INSERT INTO choice (question_id, statement, is_correct) values (?, ?, ?)";
        return jdbcTemplate.update(query, question_id, statement, is_correct);
    }
}
