package com.bfs.andyb.dao;

import com.bfs.andyb.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setIs_admin(rs.getBoolean("is_admin"));
        user.setIs_active(rs.getBoolean("is_active"));
        user.setFirstname(rs.getString("firstName"));
        user.setLastname(rs.getString("lastName"));
        user.setAddress(rs.getString("address"));
        user.setPhone(rs.getString("phone"));
        user.setEmail(rs.getString("email"));

        return user;
    }
}
