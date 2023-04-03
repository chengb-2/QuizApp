package com.bfs.andyb.domain;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quiz {
    private int id;
    private String quizname;
    private String category;
    private String username;
    private Timestamp time_start;
    private Timestamp time_end;
    private Integer score;

}
