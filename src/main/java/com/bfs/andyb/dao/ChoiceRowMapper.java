package com.bfs.andyb.dao;

import com.bfs.andyb.domain.Choice;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ChoiceRowMapper implements RowMapper<Choice> {
    @Override
    public Choice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Choice choice = new Choice();
        choice.setId(rs.getInt("id"));
        choice.setQuestion_id(rs.getInt("question_id"));
        choice.setStatement(rs.getString("statement"));
        choice.set_correct(rs.getBoolean("is_correct"));

        return choice;
    }
}

