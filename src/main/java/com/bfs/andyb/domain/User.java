package com.bfs.andyb.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String username;
    private String password;
    private Boolean is_admin;
    private Boolean is_active;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;
    private String email;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
