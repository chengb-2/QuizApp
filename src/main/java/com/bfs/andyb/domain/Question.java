package com.bfs.andyb.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question {
    private int id;
    private String category;
    private String statement;
    private boolean is_active;
}
