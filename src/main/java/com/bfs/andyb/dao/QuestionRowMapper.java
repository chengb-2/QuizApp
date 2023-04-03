package com.bfs.andyb.dao;

import com.bfs.andyb.domain.Question;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("id"));
        question.setCategory(rs.getString("category"));
        question.setStatement(rs.getString("statement"));
        question.set_active(rs.getBoolean("is_active"));

        return question;
    }
}
