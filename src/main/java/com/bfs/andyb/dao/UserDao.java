package com.bfs.andyb.dao;


import com.bfs.andyb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    JdbcTemplate jdbcTemplate;
    UserRowMapper rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate, UserRowMapper rowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> getAllUsers(){
        String query = "SELECT * FROM user";
        List<User> users = jdbcTemplate.query(query, rowMapper);
        return users;
    }

    public int createNewUser(String username, String password, Boolean is_admin, Boolean is_active, String firstname, String lastname, String phone, String address, String email){
        String query = "INSERT INTO user (username, password, is_admin, is_active, firstname, lastname, phone, address, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, username, password, is_admin, is_active, firstname, lastname, phone, address, email);
    }


    public User getUserById(Integer id){
        String query = "SELECT * FROM user WHERE id = ?";
        List<User> users =  jdbcTemplate.query(query, rowMapper, id);
        return users.size() == 0 ? null : users.get(0);
    }

    public User getUserByUsername(String username){
        String query = "SELECT * FROM user WHERE username = ?";
        List<User> users =  jdbcTemplate.query(query, rowMapper, username);
        return users.size() == 0 ? null : users.get(0);
    }

    public int setIs_activeById(Integer id, Integer action){
        String query = "UPDATE user SET is_active = ? WHERE id = ?";
        return jdbcTemplate.update(query, action, id);
    }

}
